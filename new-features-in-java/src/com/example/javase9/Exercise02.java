package com.example.javase9;

public class Exercise02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

sealed abstract class Animal permits Spider, Cat, Fish{}
abstract interface Pet {}

final class Spider extends Animal {}
sealed class Cat extends Animal implements Pet permits VanCat{}
final class VanCat extends Cat {}
non-sealed class Fish extends Animal implements Pet {}
