package com.klezovich.small_problems.olympiad.greedy;


import java.util.*;


/*
Task. Given a set of n segments {[a_0, b_0], ... , [a_(n−1), b_(n−1)]} with integer coordinates on a line, find
the minimum number m of points such that each segment contains at least one point. That is, find a
set of integers X of the minimum size such that for any segment [a_i, b_i] there is a point x ∈ X such
that a_i ≤ x ≤ b_i.

Input Format. The first line of the input contains the number n of segments. Each of the following n lines
contains two integers a_i and b_i (separated by a space) defining the coordinates of endpoints of the i-th
segment.

Constraints. 1 ≤ n ≤ 100; 0 ≤ a_i ≤ b_i ≤ 10^9 for all 0 ≤ i < n.

Output Format. Output the minimum number m of points on the first line and the integer coordinates of
m points (separated by spaces) on the second line. You can output the points in any order. If there
are many such sets of points, you can output any set. (It is not difficult to see that there always exist
a set of points of the minimum size such that all the coordinates of the points are integers.)

 */
public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }
        return points;
    }

    private static class Segment {

        int start, end;
        boolean isCovered=false;
       
        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "[" + start + "," + end + "]";
        }
        
        
        
        public boolean contains(  int dot  )
        {
            if( start <= dot && end >= dot  )
                return true;
            
            return false;
        }
         
       

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }

       
        LinkedList<Integer> optimalPoints = new LinkedList<>(); 
        while(!allSegmentsCovered(segments))
        {
            int point = findLeftMostUncoveredEndPoint(segments);
            optimalPoints.add(point);
            markSegmentsContainingPointCovered(segments,point);
        }
        
        System.out.println(optimalPoints.size());
        for (int point : optimalPoints) {
            System.out.print(point + " ");
        }
    }

    static int findLeftMostUncoveredEndPoint( Segment[]  segments )
    {
        int point = Integer.MAX_VALUE;
        for( Segment s : segments )
          if(!s.isCovered && s.end < point )
          {
             point = s.end;
          }
        
        return point;
    }
    
    static boolean allSegmentsCovered( Segment[] segments )
    {
        for( Segment s : segments )
          if(!s.isCovered)
              return false;
        
        return true;
    }
    
    static int markSegmentsContainingPointCovered( Segment[] segments, int point )
    {
        int numCovered = 0 ;
        for (int i = 0; i < segments.length; i++) {
            if( segments[i].contains(point) )
            {
                segments[i].isCovered = true;
                numCovered++;
            }
        }
        
        return numCovered;
    }
    
    static int findSegmentIndForEndpoint( Segment[] segments, int endPoint )
    {
        int index = -1;
        for( int i=0; i<segments.length; i++ )
        {
            if( segments[i].end == endPoint )
            {
               index=i;
               break;
            }
                
        }
        
        return index;
    }
    
    
    static int[] getSortedEndPointArray(Segment[] segments) {
        int sortedPointArray[] = new int[segments.length];
        for (int i = 0; i < segments.length; i++) {
            sortedPointArray[i] = segments[i].end;
        }
        Arrays.sort(sortedPointArray);
        return sortedPointArray;
    }
}
