package com.klezovich.small_problems.design_patterns.bridge;

public class BridgePatternDemo {

	public static void main(String[] args) {
		
		// Now note that we have the same .compute() method in Computer (abstraction) and Processor(implementation)
		// However, now we can change these two independently of each other
		// We can also swap different implementations of Processor in Computer with ease -> Strategy pattern
		
		Laptop l1 = new Laptop( new AmdProcessor() );
		Laptop l2 = new Laptop( new IntelProcessor() );
		
		l1.compute();
		l2.compute();
	}

}
