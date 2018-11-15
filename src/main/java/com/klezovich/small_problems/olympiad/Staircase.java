package com.klezovich.small_problems.olympiad;

import java.util.Scanner;

/**
Consider a staircase of size :

   #
  ##
 ###
####
Observe that its base and height are both equal to , and the image is drawn using # symbols and spaces. The last line is not preceded by any spaces.

Write a program that prints a staircase of size .

Input Format

A single integer, , denoting the size of the staircase.

Output Format

Print a staircase of size  using # symbols and spaces.

Note: The last line must have  spaces in it.
 */
public class Staircase {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int staircaseHeight = in.nextInt();
        printStaircase(staircaseHeight);
        
        
    }

    private static void printStaircase(int staircaseHeight ){
       
        // Stairs are numbered top to bottom. 
        for( int stair = 1; stair <= staircaseHeight; stair++ )
            printStair(stair, staircaseHeight);
        
    }

    private static void printStair(int stair, int staircaseHeight) {
        
        
        for (int i = 1; i <= staircaseHeight - stair; i++) {
            System.out.print(" ");
        }
       
        for (int i = 1; i <= stair; i++) {
            System.out.print("#");
        }
        
        System.out.print("\n");
    }
    
    
    
}
