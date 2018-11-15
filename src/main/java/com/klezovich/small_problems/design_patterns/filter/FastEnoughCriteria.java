package com.klezovich.small_problems.design_patterns.filter;

import java.util.ArrayList;
import java.util.List;

public class FastEnoughCriteria implements Criteria {

	@Override
	public List<Computer> confirmsTo(List<Computer> computers) {
		List<Computer> result = new ArrayList<>();

		for (Computer c : computers) {
           if( c.getRam() > 2 )
        	   result.add(c);
		}
		
		return result;

	}

}
