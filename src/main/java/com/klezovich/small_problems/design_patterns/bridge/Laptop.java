package com.klezovich.small_problems.design_patterns.bridge;

public class Laptop extends Computer {

	Laptop( Processor proc ){
		super(proc);
	}
	
	void compute(){
		proc.compute();
	}
}
