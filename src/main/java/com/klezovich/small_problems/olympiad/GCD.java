package com.klezovich.small_problems.olympiad;


/*
Task. Given two integers a and b, find their greatest common divisor.

Input Format. The two integers a, b are given in the same line separated by space.

Constraints. 1 ≤ a, b ≤ 2 · 10^9.

Output Format. Output GCD(a, b)
 */
import java.util.*;

public class GCD {
  private static int gcd(int a, int b) {
      
    // Implementation of Euclid's algorithm  
    int max;
    int min;
    
    if( a >= b )
    {
        max = a; min = b;
    }else
    {
        max = b; min = a;
    }
    
    // The GCD of one with anything is one
    if( max == 1 || min == 1 )
        return 1;
    
    // If one integer divides the other - the lesser is the GCD
    if( max % min == 0 )
        return min;
    
    return gcd( min, max % min );
    
    
      
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}

