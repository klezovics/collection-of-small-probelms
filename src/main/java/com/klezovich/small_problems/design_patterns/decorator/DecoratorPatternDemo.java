package com.klezovich.small_problems.design_patterns.decorator;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
		
		// The computer is no more than a decorator for the processor class
		Laptop l = new Laptop( new IntelProcessor() );
		l.compute();
	}
}
