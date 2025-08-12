package com.example.javase17;

import java.util.List;

public class Exercise01 {

	public static void main(String[] args) {
		var animals = List.of(new Cat(), new Spider(), new Cat(), new Spider());
		for (var animal : animals) {
			if (animal instanceof Pet pet) {
				// var pet = (Pet) animal;
				pet.play();
			}
			if (animal instanceof Cat cat) {

			} else if (animal instanceof Fish fish) {

			} else if (animal instanceof Spider spider) {

			}
			switch (animal) {
			case null -> {
				System.out.println("No animal");
			}
			case Cat cat when (cat.legs == 4) -> {

			}
			case Fish fish when (fish.legs == 0) -> {

			}
			case Spider spider when (spider.legs >= 8) -> {

			}
			default -> {

			}
			}
		}
	}

}

class Animal {
	public int legs;
}

interface Pet {
	default void play() {
	}
}

class Spider extends Animal {
	public void bite() {
	}
}

class Cat extends Animal implements Pet {
	public void walk() {
	}
}

class Fish extends Animal implements Pet {
	public void swim() {
	}
}