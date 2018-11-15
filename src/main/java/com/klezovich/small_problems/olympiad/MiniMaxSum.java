package com.klezovich.small_problems.olympiad;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Given five positive integers, find the minimum and maximum values that can be
 * calculated by summing exactly four of the five integers. Then print the
 * respective minimum and maximum values as a single line of two space-separated
 * long integers.
 *
 * Input Format A single line of five space-separated integers. Constraints Each
 * integer is in the inclusive range 1 .. 10^9
 *
 *
 * Output Format Print two space-separated long integers denoting the respective
 * minimum and maximum values that can be calculated by summing exactly four of
 * the five integers. (The output can be greater than 32 bit integer.)
 */
public class MiniMaxSum {

    static int intNum = 5;

    public static void main(String[] args) {

        int[] nums = new int[intNum];
        Scanner in = new Scanner(System.in);

        for (int ii = 0; ii < 5; ii++) {
            nums[ii] = in.nextInt();
        }

        Arrays.sort(nums);

        long maxSum = 0;
        long minSum = 0;

        for (int i = 1; i <= intNum - 1; i++) {
            maxSum += nums[i];
        }

        for (int i = 0; i <= intNum - 2; i++) {
            minSum += nums[i];
        }

        System.out.printf("%d %d", minSum, maxSum);

    }

}
