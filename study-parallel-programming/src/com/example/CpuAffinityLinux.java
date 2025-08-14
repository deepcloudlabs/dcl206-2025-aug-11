package com.example;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

public class CpuAffinityLinux {
	public static void main(String[] args) throws Throwable {
		try (Arena arena = Arena.ofConfined()) {

			Linker linker = Linker.nativeLinker();
			SymbolLookup libc = SymbolLookup.libraryLookup("libc.so.6", arena);

			// sched_setaffinity signature: int sched_setaffinity(pid_t pid, size_t
			// cpusetsize, cpu_set_t *mask)
			MethodHandle schedSetAffinity = linker.downcallHandle(libc.find("sched_setaffinity").orElseThrow(),
					FunctionDescriptor.of(ValueLayout.JAVA_INT, // return int
							ValueLayout.JAVA_INT, // pid
							ValueLayout.JAVA_LONG, // cpusetsize
							ValueLayout.ADDRESS) // cpu_set_t*
			);

			int CPU_SETSIZE = 1024;
			int CPU_SET_BYTES = CPU_SETSIZE / 8;
			MemorySegment cpuset = arena.allocate(CPU_SET_BYTES);
			cpuset.fill((byte) 0);

			int cpu = 11; // bind to CPU 11
			cpuset.set(ValueLayout.JAVA_BYTE, cpu / 8,
					(byte) (cpuset.get(ValueLayout.JAVA_BYTE, cpu / 8) | (1 << (cpu % 8))));

			int pid = 0;
			int result = (int) schedSetAffinity.invoke(pid, CPU_SET_BYTES, cpuset);

			if (result != 0) {
				throw new RuntimeException("sched_setaffinity failed with code " + result);
			}

			System.out.println("Thread pinned to CPU " + cpu);

			while (true) {
				Thread.sleep(10);
			}
		}
	}
}