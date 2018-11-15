package com.klezovich.small_problems.design_patterns.facade;

public class FacadePatternDemo {

	public static void main(String[] args) {
		
		// The Squad class here is a facade, which allows us to 
		// quickly perform the desired mission
		Squad s = new Squad();
	    s.sendOnMission();
	}
}
