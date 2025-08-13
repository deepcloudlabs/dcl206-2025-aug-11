package com.example;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

public class CpuAffinityWindows {
	public static void main(String[] args) throws Throwable {
        try (Arena arena = Arena.ofConfined()) {

            Linker linker = Linker.nativeLinker();
            SymbolLookup kernel32 = SymbolLookup.libraryLookup("Kernel32.dll", arena);

            // HANDLE GetCurrentThread(void)
            MethodHandle getCurrentThread = linker.downcallHandle(
                kernel32.find("GetCurrentThread").orElseThrow(),
                FunctionDescriptor.of(ValueLayout.ADDRESS)
            );

            // DWORD_PTR SetThreadAffinityMask(HANDLE hThread, DWORD_PTR dwThreadAffinityMask)
            MethodHandle setThreadAffinityMask = linker.downcallHandle(
                kernel32.find("SetThreadAffinityMask").orElseThrow(),
                FunctionDescriptor.of(ValueLayout.JAVA_LONG, // DWORD_PTR return
                        ValueLayout.ADDRESS,               // HANDLE hThread
                        ValueLayout.JAVA_LONG)              // DWORD_PTR mask
            );

            // Get current thread handle
            MemorySegment hThread = (MemorySegment) getCurrentThread.invoke();

            long mask = 1L << 11; // CPU 11

            long prevMask = (long) setThreadAffinityMask.invoke(hThread, mask);
            if (prevMask == 0) {
                throw new RuntimeException("Failed to set thread affinity");
            }
            System.out.println(ProcessHandle.current().pid());
            System.out.println("Thread [%d] pinned to CPU %d".formatted(Thread.currentThread().threadId(),mask));

			while (true) {
				Thread.sleep(10);
			}
		}
	}
}