package com.klezovich.small_problems.design_patterns.decorator;

public class Laptop implements Computer {

	Processor p;
	
	Laptop(Processor p){
		this.p = p;
	}
	
	@Override
	public void compute() {
		
		p.compute();
		
		// The processor compute method is decorated by additional functionality ... 
		System.out.println("Computation done - printing result...");
	}
	
	

}
