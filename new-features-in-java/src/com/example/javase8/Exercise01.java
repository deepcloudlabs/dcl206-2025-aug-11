package com.example.javase8;

public class Exercise01 {

	public static void main(String[] args) {
		AAA ref1 = new BBB();
		AAA ref2 = new CCC();
		AAA ref3 = new DDD();
        // AAA ref4 = (AAA) new EEE(); // Compile-time Error: Type mismatch!
		III ref4 = (III) new BBB();
		JJJ ref5 = (JJJ) new BBB(); // Runtime Error: Class cast exception!
	}

}

interface III {
	static final int x=42;
}
interface JJJ {}
interface KKK {}

// (1)
interface MMM extends III,JJJ,KKK {} // multiple inheritance

// (2)
abstract class ZZZ implements III, KKK {}

abstract class AAA implements III {}
class BBB extends AAA {}
class CCC extends AAA {}
class DDD extends CCC {}
class EEE {}
class FFF implements III,KKK {}
