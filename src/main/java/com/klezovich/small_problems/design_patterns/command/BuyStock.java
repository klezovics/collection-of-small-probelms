package com.klezovich.small_problems.design_patterns.command;

public class BuyStock implements Order {

	Stock s;
	
	BuyStock( Stock s ){
		this.s = s;
	}
	
	@Override
	public void execute() {
		s.buy();
	}

}
