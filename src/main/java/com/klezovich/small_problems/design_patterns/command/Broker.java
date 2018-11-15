package com.klezovich.small_problems.design_patterns.command;

import java.util.ArrayList;
import java.util.List;

public class Broker {

	private List<Order> orderList = new ArrayList<Order>();
	
	public void takeOrder(  Order order ){
		orderList.add(order);
	}
	
	
	public void placeOrders(){
		
		for( Order o : orderList ){
			o.execute();
		}
		
		orderList.clear();
	}
	
}
