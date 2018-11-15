package com.klezovich.small_problems.olympiad;


/* 
Task:Given an integer n, find the last digit of the nth Fibonacci number (that is, n mod 10).

Input: The input consists of a single integer n.

Constraints: 0 ≤ n ≤ 10^7.

Output: The last digit of the nth fibonacci number
 */
import java.util.*;

public class FibonacciLastDigit {

    private static int getFibonacciLastDigit(int n) {
        if (n <= 1) {
            return n;
        }

        int previous = 0;
        int current = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous % 10 + current % 10;// we're only interested in summ of the last digits
        }

        return current % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}
