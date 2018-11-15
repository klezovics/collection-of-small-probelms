package com.klezovich.small_problems.olympiad;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * Task. Given an integer n, find the last digit of the sum of the first n
 * fibonacci numbers Input Format. The input consists of a single integer �?��.
 * Constraints. 0 ≤ n ≤ 10^14. Output Format. Output the last digit of the sum
 * of the first n fibonacci numbers
 */
public class FibonacciSumLastDigit {

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
            int lastIndex = pisanoPeriod.size() - 1;
            int secondLastIndex = lastIndex - 1;

            //The Pesano period always starts with 01.
            // If this if is true - we have calculated the full period
            if (pisanoPeriod.get(lastIndex) == 1
                    && pisanoPeriod.get(secondLastIndex) == 0) {
                break;
            }

            long nextRemainder = calcFibFastModM(curFibNumInd, (int) m) % m;
            //if( nextRemainder < 0 )
            //{
            //System.out.println( "ind:"+curFibNumInd+" value:"+calcFibFast(curFibNumInd) + "remainder" + nextRemainder );
            //exit();
            //}
            pisanoPeriod.add(nextRemainder);
            curFibNumInd++;
            //System.out.println("FibNumInd:" + curFibNumInd);

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

        //System.out.println("Period:" + pesanoPeriod);
        //System.out.println("Periond Len:"+pesanoPeriod.size());
        //System.out.println("Position in period:"+fibNumPosInPeriod);
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int Res = getFibonacciSumLastDigit(n);
        System.out.println(Res);
    }
}
