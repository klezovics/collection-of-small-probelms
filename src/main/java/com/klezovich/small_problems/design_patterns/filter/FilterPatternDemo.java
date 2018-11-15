package com.klezovich.small_problems.design_patterns.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterPatternDemo {

	public static void main(String[] args) {
		List<Computer> computers = new ArrayList<>();
		
		computers.add( new Computer(20, 1, "red") );
		computers.add( new Computer(1,20000,"blue"));
		computers.add( new Computer(0, 0, "orange"));
		computers.add( new Computer(1000,20000,"gold"));
		
		List<Computer> bigHddComps= ( new HasBigHddCriteria().confirmsTo(computers) ); 
		List<Computer> bigRamComps= ( new FastEnoughCriteria().confirmsTo(computers) ); 
		
		System.out.println("Big HDD computers:");
		for( Computer c : bigHddComps )
			System.out.println(c);
		
		System.out.println("");

		
		System.out.println("Big RAM computers");
		for( Computer c : bigRamComps )
			System.out.println(c);
		
		
	}
}
