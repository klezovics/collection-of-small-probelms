package com.klezovich.small_problems.design_patterns.composite;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class OrganizationHierarchy {

	
	static void printSubordinatesWithLevel( Employee e ){
		ArrayList<Integer> al = new ArrayList<>();
		
		// We process the 0-th level containing the boss only manually
	
				
		Queue<Employee> q = new ArrayDeque<>();
		q.add(e);
		System.out.println("Level:" + 0 +" " + e );
		System.out.println("");
		
		// Initial conditions are necessary to make the loop below work
		int currentLevel = 1;               // initial condition - starting to add employees from level 1 (boss is at level 0)
		int empSeenFromPreviousLevel = 0;   // initial condition	
		al.add(1);                          // initial condition - adding the boss to level 0 
		al.add(0);                          // initial condition - 0 employees at level 1 so far       
		
		
		// Emplements breadth first traversal of the employee company
		while(!q.isEmpty()){
		   
		   // Employee to process
		   Employee queueHeadEmployee = q.poll();	
		   
		   for(Employee subordinate : queueHeadEmployee.getSubordinates() ){
			 System.out.println("Level:" + (currentLevel) + " " + subordinate );      			 
			 q.add(subordinate);
			 al.set(currentLevel, al.get(currentLevel) + 1);		     
		   }
		   
		   empSeenFromPreviousLevel++;
		   if( empSeenFromPreviousLevel == al.get(currentLevel - 1) )
		   {
			   // If we've "processed" all of the employees, which have been added at the previous level of 
			   // the hierarchy - this means we'll now be processing employees from the level below 
			   currentLevel++;
			   empSeenFromPreviousLevel=0;
			   al.add(0);
			   System.out.println("");
		   }
		}
		
	}
	
	static void printSubordinates( Employee e ){
		
		Queue<Employee> q = new ArrayDeque<>();
		q.add(e);
		
		while(!q.isEmpty()){
			
		   Employee queueHeadEmployee = q.poll();
		   
		   for(Employee subordinate : queueHeadEmployee.getSubordinates() ){
			 System.out.println(subordinate);
		     q.add(subordinate);
		   }
		}
		
	}
}
