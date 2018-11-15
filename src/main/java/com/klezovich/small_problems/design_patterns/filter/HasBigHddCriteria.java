package com.klezovich.small_problems.design_patterns.filter;

import java.util.ArrayList;
import java.util.List;

public class HasBigHddCriteria implements Criteria {

	
	@Override
	public List<Computer> confirmsTo(List<Computer> computers) {
		List<Computer> result = new ArrayList<>();

		for (Computer c : computers) {
           if( c.getHddSize() > 2 )
        	   result.add(c);
		}
		
		return result;

	}

}
