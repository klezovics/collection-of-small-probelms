package com.klezovich.small_problems.design_patterns.proxy;

public class Boss implements Worker {

	Employee e;
	
	@Override
	public void work() {
		
		if( e == null ){
			System.out.println("Boss: Hiring emloyess ...");
			e = new Employee();
		}
		
		System.out.println("Boss: Telling an employee to get to work ...");
		
		e.work();
	}

}
