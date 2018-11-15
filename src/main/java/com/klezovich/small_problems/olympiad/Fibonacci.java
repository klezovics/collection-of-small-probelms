package com.klezovich.small_problems.olympiad;


/*
   Task:  Given an integer n, find the n-th Fibonacci number.

   Input: The input consists of a single integer - n

   Constraints: 0 ≤ n ≤ 45.

   Output: n-th fibonacci number.
 */
import java.util.Scanner;

public class Fibonacci {

    static private int[] fibonacci_nums = new int[46];

    private static long calc_fib(int n) {
        if (n <= 1) {
            return n;
        }

        return calc_fib(n - 1) + calc_fib(n - 2);
    }

    static long calcFibFast(int n) {
        /* The iterative method is faster than the recursive method for larger F_n */
        fibonacci_nums[0] = 0;
        fibonacci_nums[1] = 1;

        if (n <= 1) {
            return fibonacci_nums[n];
        }

        for (int ii = 2; ii <= n; ii++) {
            fibonacci_nums[ii] = fibonacci_nums[ii - 1] + fibonacci_nums[ii - 2];
        }

        return fibonacci_nums[n];

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calcFibFast(n));

    }

}
