package com.klezovich.small_problems.design_patterns.facade;

public class Commander implements SquadMember {

	@Override
	public void act() {
		System.out.println("Commander: Making a plan");
	}

	
}
