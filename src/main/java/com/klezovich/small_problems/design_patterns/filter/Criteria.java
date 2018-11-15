package com.klezovich.small_problems.design_patterns.filter;

import java.util.List;

public interface Criteria {

	List<Computer> confirmsTo( List<Computer> computers );
}
