package com.klezovich.small_problems;


// Compares which of the two cycles implemented in the first() and second() methods is
// faster. 

public class WhichCycleIsFaster {

	static int numIter = 1000;
    static int arrLen = 1000;
	
	static void first() {

		int arrLen = 1000;
		int[] a = new int[arrLen];
		for (int ii = 0; ii < numIter; ii++) {
			a[ii] = ii;
		}

	}

	static void second() {

		int arrLen = 1000;
		int[] a = new int[arrLen];
		for (int ii = 0; ii < numIter; ii++) {
			a[ii] = ii;
			ii++;
			a[ii] = ii;
		}
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		first();
		long endTime = System.nanoTime();

		long duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
		System.out.println("First duration(ms):" + (double) duration / (double) 1000000);
		
		startTime = System.nanoTime();
		second();
		endTime = System.nanoTime();

		duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
		System.out.println("Second duration(ms):" + (double) duration / (double) 1000000);
		
		
		
	}
}
