package com.klezovich.small_problems.design_patterns.command;

public class Stock {

	String name = "ABC";
	int    qty  = 10;
	
	public void buy(){
	      System.out.println("Stock [ Name: "+name+", Quantity: " + qty +" ] bought");
	   }
	
	   public void sell(){
	      System.out.println("Stock [ Name: "+name+", Quantity: " + qty +" ] sold" );
	   }
}
