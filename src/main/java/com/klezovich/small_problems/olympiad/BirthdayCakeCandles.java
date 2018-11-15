package com.klezovich.small_problems.olympiad;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles Colleen is
 * turning n years old! She has n candles of various heights on her cake, and
 * candle i has height h_i. Because the taller candles tower over the shorter
 * ones, Colleen can only blow out the tallest candles.
 *
 * Given the height_i for each individual candle, find and print the number of
 * candles she can successfully blow out.
 *
 * Input Format: The first line contains a single integer, , denoting the number
 * of candles on the cake. The second line contains space-separated integers,
 * where each integer describes the height of candle .
 *
 * Output Format:
 * Print the number of candles Colleen blows out on a new line.
 *
 */
public class BirthdayCakeCandles {

    public static void main(String[] args) {
        
        Scanner in = new Scanner( System.in );
        
        int numCandles = in.nextInt();
        int[] candles = new int[numCandles];
        
        for (int i = 0; i < numCandles; i++) {
            candles[i] = in.nextInt();
        }
        
        int maxHeight = candles[0];
        for (int candleHeight : candles ) {
            if( candleHeight > maxHeight )
                maxHeight = candleHeight;
        }
        
        int count=0;
        for (int candleHeight : candles ) {
            if( candleHeight == maxHeight )
                count++;
        }
        
        System.out.println(count);
        
    }
}
