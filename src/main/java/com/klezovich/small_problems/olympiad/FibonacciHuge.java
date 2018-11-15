package com.klezovich.small_problems.olympiad;


/**
 * Task. Given two integers n and d, output F_n mod d (that is, the remainder of
 * F_n when divided by d).
 *
 * Input Format. The input consists of two integers n and d given on the same line (separated by a space).
 *
 * Constraints. 1 ≤ n ≤ 10^18, 2 ≤ d ≤ 10^5.
 *
 * Output Format. Output F_n mod d.
 */
import java.util.*;

public class FibonacciHuge {

    static private long[] fibonacci_nums_mod_m = new long[1000 * 1000];
    static int lastComputedIndModM = 1;

    static long calcFibFastModM(int n, int m) {
        /* The iterative method is faster than the recursive method for larger F_n */

        fibonacci_nums_mod_m[0] = 0 % m;
        fibonacci_nums_mod_m[1] = 1 % m;

        if (n <= lastComputedIndModM) {
            return fibonacci_nums_mod_m[n];
        }

        if (n <= 1) {
            return fibonacci_nums_mod_m[n];
        }

        for (int ii = lastComputedIndModM + 1; ii <= n; ii++) {
            fibonacci_nums_mod_m[ii] = (fibonacci_nums_mod_m[ii - 1] + fibonacci_nums_mod_m[ii - 2]) % m;
            if (ii > lastComputedIndModM) {
                lastComputedIndModM = ii;
            }
        }

        return fibonacci_nums_mod_m[n];

    }

    private static ArrayList<Long> getPisanoPeriod(long m, long lastNum) {
        ArrayList<Long> pisanoPeriod = new ArrayList<>();
        pisanoPeriod.add(calcFibFastModM(0, (int) m));
        pisanoPeriod.add(calcFibFastModM(1, (int) m));
        pisanoPeriod.add(calcFibFastModM(2, (int) m));

        int curFibNumInd = 3;
        boolean lastNumHit = false;
        while (!lastNumHit) {
            if (curFibNumInd == lastNum + 1) {
                lastNumHit = true;
            }

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

        if (!lastNumHit) {
            // We've calculated the full pisano period
            int numElem = pisanoPeriod.size();
            pisanoPeriod.remove(numElem - 1); // Removing the last 1 from the end
            pisanoPeriod.remove(numElem - 2); // Removing the last 0 from the end
        } else {
            // We've calculated just the part of the pesano period necessary to get the asnwer
        }

        //System.out.println(pisanoPeriod);
        return pisanoPeriod;
    }

    private static long getFibonacciHugeModM(long n, int m) {
        long Res = 0;
        //For any integer m ≥ 2, the sequence F_n mod n is periodic.
        // Its period is called the Pesano period. Therefore, we can compute the Pesano 
        // period for our m and then find where F_n is in that period by finding m % d
        ArrayList<Long> pesanoPeriod = getPisanoPeriod(m, n);
        long periodLen = pesanoPeriod.size();
        long fibNumPosInPeriod = n % periodLen;
        Res = pesanoPeriod.get((int) fibNumPosInPeriod);

        //System.out.println("Period:" + pesanoPeriod);
        //System.out.println("Periond Len:"+pesanoPeriod.size());
        //System.out.println("Position in period:"+fibNumPosInPeriod);
        return Res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHugeModM(n, m));

    }
}
