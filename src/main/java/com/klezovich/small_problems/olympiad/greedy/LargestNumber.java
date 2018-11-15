package com.klezovich.small_problems.olympiad.greedy;


import java.util.*;

/*
Task. Compose the largest number out of a set of integers of arbitary lenght.

Input Format. The first line of the input contains an integer n. The second line contains integers
a_1, a_2, . . . , a_n.

Constraints. 1 ≤ n ≤ 100; 1 ≤ a_i ≤ 10^3 for all 1 ≤ i ≤ n.

Output Format. Output the largest number that can be composed out of a_i.

 */
public class LargestNumber {

    private static String largestNumber(String[] a) {
     
        String result = "";
        LinkedList<String> l = new LinkedList<>(Arrays.asList(a));

       
        sortStrList(l);
        for( String s : l )
            result+=s;

        return result;
    }

    private static void sortStrList(LinkedList<String> list ) {
        
        // It can be proven via induction that if we order the digits 
        // in exactly this way - we'll reach the maximum number
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String s1s2 = s1 + s2;
                String s2s1 = s2 + s1;
                
                Integer s1s2Int = Integer.parseInt(s1s2);
                Integer s2s1Int = Integer.parseInt(s2s1);
                
                if (s1s2Int > s2s1Int) {
                    return -1;
                }

                if (s2s1Int > s1s2Int) {
                    return 1;
                }

                return 0;

            }
        });

    }

    public static void test() {

        String ln;
        String expRes;

        String nums1[] = {"1", "2"};
        expRes = "21";
        ln = largestNumber(nums1);
        if (!ln.equals(expRes)) {
            System.out.println("Test 1 - FAIL. Res:" + ln + " Exp:" + expRes);
        }

        String nums2[] = {"2", "1", "3"};
        expRes = "321";
        ln = largestNumber(nums2);
        if (!ln.equals(expRes)) {
            System.out.println("Test 2 - FAIL. Res:" + ln + " Exp:" + expRes);
        }

        String nums3[] = {"23", "9", "7"};
        expRes = "9723";
        ln = largestNumber(nums3);
        if (!ln.equals(expRes)) {
            System.out.println("Test 3 - FAIL. Res:" + ln + " Exp:" + expRes);
        }

        String nums4[] = {"100", "200", "300"};
        expRes = "300200100";
        ln = largestNumber(nums4);
        if (!ln.equals(expRes)) {
            System.out.println("Test 4 - FAIL. Res:" + ln + " Exp:" + expRes);
        }

        String nums5[] = {"1000", "17", "55", "66"};
        expRes = "6655171000";
        ln = largestNumber(nums5);
        if (!ln.equals(expRes)) {
            System.out.println("Test 5 - FAIL. Res:" + ln + " Exp:" + expRes);
        }

        String nums6[] = {"98", "99"};
        expRes = "9998";
        ln = largestNumber(nums6);
        if (!ln.equals(expRes)) {
            System.out.println("Test 6 - FAIL. Res:" + ln + " Exp:" + expRes);
        }

    }

    public static void main(String[] args) {
        test();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
