package com.klezovich.small_problems.olympiad.greedy;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*

Task. The goal of this code problem is to implement an algorithm for the fractional knapsack problem.

Input Format. The first line of the input contains the number n of items and the capacity W of a knapsack.
The next n lines define the values and weights of the items. The i-th line contain integers v_i and w_i —
the value and the weight of i-th item, respectively.

Constraints. 1 ≤ n ≤ 10^3, 0 ≤ W ≤ 2*10^6; 0 ≤ v_i ≤ 2*10^6, 0 < w_i ≤ 2*10^6 for all 1 ≤ i ≤ n All the
numbers are integers.

Output Format. Output the maximal value of fractions of items that fit into the knapsack. The absolute
value of the difference between the answer of your program and the optimal value should be at most
10−3. To ensure this, output your answer with at least four digits after the decimal point (otherwise

 */
public class FractionalKnapsack {

    
    
    private static DecimalFormat df4 = new DecimalFormat(".0000");
    private static int capacity;
    private static int[] values;
    private static int[] weights;
    private static double[] unitVal;
    private static boolean[] available;
    private static int itemNum;


    private static double getOptimalValue() {

        double value = 0;

        // If we can fit all of the items in the bag - take all of them. 
        if (canFitAllItemsInBag()) {
            return getValueSum();
        }

        // If not - lets use a greedy strategy and take as much of the item with the biggest unit value as possible
        int remainingCapacity = capacity;
        while (remainingCapacity > 0 && itemsAvailable()) {

            //debugPrint( values, weights, itemAvailable, iterNum, remainingCapacity );
            int bestItemInd = getBestAvailableItemInd();
            if (remainingCapacity >= weights[bestItemInd]) {
                // Taking the while of the best item 
                value += values[bestItemInd];
                remainingCapacity -= weights[bestItemInd];
                available[bestItemInd] = false;
            } else {
                // If we cant fit in the whole item - take as much of it as possible
                double itemFractCanFitIn = ((double) remainingCapacity) / (double) weights[bestItemInd]; // what fraction of the item we can fit in
                value += values[bestItemInd] * itemFractCanFitIn; // how much value it will add
                remainingCapacity = 0; // we'll use up the whole capacity to take the item
                available[bestItemInd] = false;
            }
        }

        return value;
    }

    private static boolean canFitAllItemsInBag() {

        long weightSum = 0;
        for (int w : weights) {
            weightSum += w;
            if (weightSum > (long) capacity) {
                return false;
            }
        }

        return true;

    }

    private static long getValueSum() {
        long valueSum = 0;
        for (int val : values) {
            valueSum += (long) val;
        }

        return valueSum;
    }

    private static boolean itemsAvailable() {
        for (boolean b : available) {
            if (b == true) {
                return true;
            }
        }

        return false;
    }

    private static int getBestAvailableItemInd() {

        int bestItemInd = -1; 
        double bestItemUnitVal = -1;
        
        //If we call this routine - it is guaranteed that there will be at least 1 available item.
        for( int itemInd=0; itemInd < itemNum; itemInd++)
        {
           if( unitVal[itemInd] > bestItemUnitVal && available[itemInd] )
           {
               bestItemInd=itemInd;
               bestItemUnitVal=unitVal[itemInd];
           }
        }
        
        return bestItemInd;

    }

    private static void debugPrint(int values[], int weights[], boolean itemAvailable[], int iterNum, int remCap) {

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        itemNum = scanner.nextInt();
        capacity = scanner.nextInt();
        values = new int[itemNum];
        weights = new int[itemNum];
        available = new boolean[itemNum];
        unitVal = new double[itemNum];
        for (int i = 0; i < itemNum; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
            available[i] = true;
            unitVal[i] = (double) values[i] / (double) weights[i];
        }

        double value = getOptimalValue();
        System.out.println(df4.format(value));
    }
}
