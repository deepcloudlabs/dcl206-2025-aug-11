package com.example.javase11;

public class Exercise01 {

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {
		Fun fun1 = (u,v) -> u + v;
		Fun fun2 = (double u,double v) -> u * v;
		Fun fun3 = (@positive double u,final @negative double v) -> u + v;
		Fun fun4 = (final @positive var u,@negative var v) -> u * v;

	}

}

@FunctionalInterface
interface Fun {
	double math(double x,double y);
}

@interface positive{}
@interface negative{}