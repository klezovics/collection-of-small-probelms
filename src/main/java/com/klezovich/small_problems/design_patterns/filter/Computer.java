package com.klezovich.small_problems.design_patterns.filter;

public class Computer {

	int Ram;
	int HddSize;
	String color;
	
	
	
	@Override
	public String toString() {
		return "Computer [Ram=" + Ram + ", HddSize=" + HddSize + ", color="
				+ color + "]";
	}


	public Computer(int ram, int hddSize, String color) {
		super();
		Ram = ram;
		HddSize = hddSize;
		this.color = color;
	}


	public int getRam() {
		return Ram;
	}


	public void setRam(int ram) {
		Ram = ram;
	}


	public int getHddSize() {
		return HddSize;
	}
		
}
