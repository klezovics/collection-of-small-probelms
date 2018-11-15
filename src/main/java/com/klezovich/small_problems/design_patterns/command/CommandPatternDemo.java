package com.klezovich.small_problems.design_patterns.command;

public class CommandPatternDemo {

	public static void main(String[] args) {
		
		Broker b = new Broker();
		
		Stock s = new Stock();
		Order o1 = new BuyStock(s);
		Order o2 = new SellStock(s);
		
		b.takeOrder(o1);
		b.takeOrder(o2);
		
		b.placeOrders();
	}
	
	
	
}
