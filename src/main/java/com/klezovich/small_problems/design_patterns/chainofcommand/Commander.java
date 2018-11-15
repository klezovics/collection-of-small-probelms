package com.klezovich.small_problems.design_patterns.chainofcommand;

public abstract class Commander {

	public static int LEUTENANT = 1;
	public static int COLONEL = 2;
	public static int GENERAL = 3;

	protected int level;

	protected Commander nextCommander;

	public void setNextCommander(Commander commander) {
		nextCommander = commander;
	}

	public void executeOrder(int level, String order) {
		
		// This is the essence of the pattern - if it possible to execute the command - do it, 
		// if not - pass it on to the next object in the chain of command.
		if (level <= this.level) {
			System.out.println(getClass().getName() + ":executing order:"
					+ order);
			return;
		}

		if (nextCommander != null) {
           nextCommander.executeOrder(level, order);
		} else {
			System.out.println(getClass().getName()
					+ ":can't execute or pass command");
		}
	}

}
