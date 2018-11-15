package com.klezovich.small_problems.design_patterns.proxy;

public class ProxyPatternDemo {

	
	public static void main(String[] args) {
		// In this case the Boss class is a proxy for the Emloyee class.
		Boss b = new Boss();
		b.work();
		b.work();
	}
}
