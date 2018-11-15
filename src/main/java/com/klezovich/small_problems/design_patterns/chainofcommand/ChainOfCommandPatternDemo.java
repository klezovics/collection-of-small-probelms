package com.klezovich.small_problems.design_patterns.chainofcommand;

public class ChainOfCommandPatternDemo {

	public static Commander getChainOfCommand(){
		Commander l = new Lieutenant();
		Commander c = new Colonel();
		Commander g = new General();
		
		l.setNextCommander(c);
		c.setNextCommander(g);
		
		return l;
	}
	
	public static void main(String[] args) {
		
		Commander commander = getChainOfCommand();
		
		commander.executeOrder( Commander.COLONEL, "March to the mountain" );
		
	}
}
