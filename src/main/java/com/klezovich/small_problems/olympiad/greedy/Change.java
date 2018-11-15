package com.klezovich.small_problems.olympiad.greedy;


import java.util.Scanner;

/*
Task. The goal in this problem is to find the minimum number of coins needed to change the input value
(an integer) into coins with denominations 1, 5, and 10.

Input Format. The input consists of a single integer m.

Constraints. 1 ≤ m ≤ 10^3.

Output Format. Output the minimum number of coins with denominations 1, 5, 10 that changes m.
 */
public class Change {

    private static int getChange(int m) {
        // Let's go for a recursive greedy algorithm    
        // The greedy move for this algorithm will be - take the biggest coin from our set
        // add it to the total amount. This is obviously a safe move.    

        // Base case.
        if (m == 0) {
            return 0;
        }

        if (m == 1) {
            return 1;
        }

        if (m >= 10) {
            return 1 + getChange(m - 10); // if we can "fit in" a 10 - do it
        } else if (m < 10 && m >= 5) {
            return 1 + getChange(m - 5);  // if we can't "fit in" a 10, but can fit in a 5 - do it.
        } else {
            return 1 + getChange(m - 1); // if we cannot "fit in" 10 and 5 - we'll return 1s
        }

    }

    public static void main(String[] args) {
        //test();
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }

    private static void test() {
        if (getChange(0) != 0) {
            System.out.println("FAIL! getChange(0) should be 0");
        }

        if (getChange(1) != 1) {
            System.out.println("FAIL! getChange(1) should be 1");
        }

        if (getChange(2) != 2) {
            System.out.println("FAIL! getChange(2) should be 2");
        }

        if (getChange(4) != 4) {
            System.out.println("FAIL! getChange(4) should be 4");
        }

        if (getChange(5) != 1) {
            System.out.println("FAIL! getChange(5) should be 1");
        }

        if (getChange(7) != 3) {
            System.out.println("FAIL! getChange(7) should be 3");
        }

        if (getChange(9) != 5) {
            System.out.println("FAIL! getChange(9) should be 5");
        }

        if (getChange(10) != 1) {
            System.out.println("FAIL! getChange(10) should be 1");
        }

        if (getChange(100) != 10) {
            System.out.println("FAIL! getChange(100) should be 10");
        }

        if (getChange(1000) != 100) {
            System.out.println("FAIL! getChange(1000) should be 100");
        }

        if (getChange(995) != 100) {
            System.out.println("FAIL! getChange(995) should be 100");
        }
    }
}
