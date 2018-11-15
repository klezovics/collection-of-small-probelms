package com.klezovich.small_problems.olympiad;

import java.util.Scanner;

/**
 * Task. Given two integers a and b, find their least common multiple. 
 * 
 * Input Format: The two integers a and b are given in the same line separated by
 * space. 
 * 
 * Constraints. 1 ≤ a, b ≤ 2 · 10^9. Output Format. Output the least common multiple of a and b.
 */
public class LCM {

    private static int gcd(int a, int b) {

        // Implementation of Euclid's algorithm  
        int max;
        int min;

        if (a >= b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }

        // The GCD of one with anything is one
        if (max == 1 || min == 1) {
            return 1;
        }

        // If one integer divides the other - the lesser is the GCD
        if (max % min == 0) {
            return min;
        }

        return gcd(min, max % min);

    }

    private static long lcm(int a, int b) {
        /* From the fundamental theorem of arithmetic it can be shown that 
           the product of two integers is equal to product of their gretest common
           divisors and their least common multiple 
        */
        
        long ab = (long)a*(long)b;
        return ab/(long)gcd(a,b);
        
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm(a, b));
    }
}
