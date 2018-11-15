package com.klezovich.small_problems.olympiad;


/**
 * Task. Given two non-negative integers n and m, where n ≤ m, find the sum of all Fibonacci numbers from F_n to F_m  *
 *
 * Input Format. The input consists of two non-negative integers n and m separated by a space.
 *
 * Constraints. * 0 ≤ n ≤ m ≤ 10^18.
 *
 * Output Format. The last digit of the sum of the Fibonacci numbers between n and m
 */
import java.util.*;

public class FibonacciPartialSum {

    static private long[] fibonacci_nums = new long[1000 * 1000];
    static private long[] fibonacci_nums_mod_m = new long[1000 * 1000];
    static int lastComputedInd = 0;
    static int lastComputedIndModM = 0;

    static long calcFibFast(int n) {
        /* The iterative method is faster than the recursive method for larger F_n */

        fibonacci_nums[0] = 0;
        fibonacci_nums[1] = 1;
        lastComputedInd = 1;

        if (n <= lastComputedInd) {
            return fibonacci_nums[n];
        }

        if (n <= 1) {
            return fibonacci_nums[n];
        }

        for (int ii = 2; ii <= n; ii++) {
            fibonacci_nums[ii] = fibonacci_nums[ii - 1] + fibonacci_nums[ii - 2];
            if (ii > lastComputedInd) {
                lastComputedInd = ii;
            }
        }

        return fibonacci_nums[n];

    }

    static long calcFibFastModM(int n, int m) {
        /* The iterative method is faster than the recursive method for larger F_n */

        fibonacci_nums_mod_m[0] = 0 % m;
        fibonacci_nums_mod_m[1] = 1 % m;
        lastComputedIndModM = 1;

        if (n <= lastComputedIndModM) {
            return fibonacci_nums_mod_m[n];
        }

        if (n <= 1) {
            return fibonacci_nums_mod_m[n];
        }

        for (int ii = 2; ii <= n; ii++) {
            fibonacci_nums_mod_m[ii] = (fibonacci_nums_mod_m[ii - 1] + fibonacci_nums_mod_m[ii - 2]) % m;
            if (ii > lastComputedIndModM) {
                lastComputedIndModM = ii;
            }
        }

        return fibonacci_nums_mod_m[n];

    }

    private static LinkedList<Long> getPisanoPeriod(long m) {
        LinkedList<Long> pisanoPeriod = new LinkedList<>();
        pisanoPeriod.add(calcFibFast(0) % m);
        pisanoPeriod.add(calcFibFast(1) % m);
        pisanoPeriod.add(calcFibFast(2) % m);

        int curFibNumInd = 3;
        while (true) {
           

            //The Pesano period always starts with 01.
            // If this if is true - we have calculated the full period
            int lastIndex = pisanoPeriod.size() - 1;
            int secondLastIndex = lastIndex - 1;
            if (pisanoPeriod.get(lastIndex) == 1
                    && pisanoPeriod.get(secondLastIndex) == 0) {
                break;
            }

            long nextRemainder = calcFibFastModM(curFibNumInd, (int) m) % m;
           
            pisanoPeriod.add(nextRemainder);
            curFibNumInd++;
          

        }

        pisanoPeriod.removeLast(); // Removing the last 1 from the end
        pisanoPeriod.removeLast(); // Removing the last 0 from the end
        //System.out.println(pisanoPeriod);
        return pisanoPeriod;
    }

    private static long getFibonacciHugeModM(long n, long m) {
        long Res = 0;
        //For any integer m ≥ 2, the sequence F_n mod n is periodic.
        // Its period is called the Pesano period. Therefore, we can compute the Pesano 
        // period for our m and then find where F_n is in that period by finding m % d
        LinkedList<Long> pesanoPeriod = getPisanoPeriod(m);
        long periodLen = pesanoPeriod.size();
        long fibNumPosInPeriod = n % periodLen;
        Res = pesanoPeriod.get((int) fibNumPosInPeriod);

    
        return Res;
    }

    private static int getFibonacciSumLastDigit(long n) {
        int Res = 0;
        // We can use the fact that the partial sum of the first n fibonacci numbers is
        // F_(n+2) - 1. Then since we need only the last number - we can get it by computing the 
        // big F_(n+2) mod 10 and then decrimenting it by one.

        int lastDigitFibNPlusTwo = (int) getFibonacciHugeModM(n + 2, 10);
        if (lastDigitFibNPlusTwo == 0) {
            Res = 9;
        } else {
            Res = lastDigitFibNPlusTwo - 1;
        }

        return Res;
    }

    private static long getFibonacciPartialSum(long from, long to) {

        // summing up ALL the fibonacci numbers up from 0 up to and including the last one in the initial partial sum
        int lastDigitSumTo = getFibonacciSumLastDigit(to); 
        
        // summing up all the fibonacci numbers from 0 up to and including the one just before the first one in the initial partial sum
        int lastDigitSumFromMinusOne = getFibonacciSumLastDigit(from - 1); 

        if (lastDigitSumTo >= lastDigitSumFromMinusOne) {
            return lastDigitSumTo - lastDigitSumFromMinusOne;
        } else {
            return 10 - lastDigitSumFromMinusOne + lastDigitSumTo;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}
