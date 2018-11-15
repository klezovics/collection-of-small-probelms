package com.klezovich.small_problems.design_patterns.bridge;

public class IntelProcessor implements Processor {

	@Override
	public void compute() {
		System.out.println("Calculating with Intel processor ... ");

	}

}
