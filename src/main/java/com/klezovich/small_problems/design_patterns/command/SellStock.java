package com.klezovich.small_problems.design_patterns.command;

public class SellStock implements Order {

	Stock s;
	
	public SellStock( Stock s) {
	  this.s = s;
	}
	
	@Override
	public void execute() {
		s.sell();
	}

	
}
