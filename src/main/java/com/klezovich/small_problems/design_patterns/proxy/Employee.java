package com.klezovich.small_problems.design_patterns.proxy;

public class Employee implements Worker {

	@Override
	public void work() {
		System.out.println("Employee: Working ...");

	}

}
