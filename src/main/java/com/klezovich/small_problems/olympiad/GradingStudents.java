package com.klezovich.small_problems.olympiad;

import java.util.Scanner;

/**
 *
 * Conditions - https://www.hackerrank.com/challenges/grading
 * 
 */
public class GradingStudents {
    
    static int round( int grade ){
        if( grade < 38 )
            return grade;
        
        int nextMultOfFive = grade;
        while( nextMultOfFive % 5 != 0 )
            nextMultOfFive++;
        
        if( nextMultOfFive - grade < 3 )
            return nextMultOfFive;
        
        return grade;
        
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner( System.in );
        
        int numGrades = in.nextInt();
        
        for (int i = 0; i < numGrades; i++) {
            int grade = in.nextInt();
            System.out.printf("%d\n", round(grade) );    
        }
        
        
    }
}
