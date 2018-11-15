package com.klezovich.small_problems.design_patterns.bridge;

public abstract class Computer {

	Processor proc;
	
	
	
	Computer(Processor proc ){
		this.proc = proc;
	}
}
