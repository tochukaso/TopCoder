package old;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class TaroFriends
{
	public int getNumber(int[] coordinates, int X)
	{
	    int N = coordinates.length;
	    if (N == 1) return 0;
        TreeMap<Integer,Long> sortMap = new TreeMap<Integer, Long>();
        
        int left = 0;
        
        int[] leftPos = new int[N * 2];
        
	    for (int i = 0; i < coordinates.length; i++) {
	        int catPos = coordinates[i];

	        {
	            Long work = sortMap.get(catPos + X);
	            if (work == null) work = 0L;
	            work = work | 1 << i;
    	        sortMap.put(catPos + X, work);
	        }
	        
            {
               Long work = sortMap.get(catPos - X);
               if (work == null) work = 0L;

               work = work | 1 << i;
               sortMap.put(catPos - X, work);
               left = Math.min(left, catPos - X);
            }
	        leftPos[i]=catPos + X;
            leftPos[i+N]=catPos - X;
	    }

	    Arrays.sort(leftPos);
        int leftIndex = 0;
	    int[] dp = new int[N];
	    int distance = Integer.MAX_VALUE;
	    int right = 0;
	    for (Map.Entry<Integer, Long> entry : sortMap.entrySet()) {
	        right = entry.getKey();
	        long cats = entry.getValue();
            for (int i = N - 1; i >= 0; i--) {
                if ((cats & 1 << i) > 0) {
                    dp[i]++;
                }
            }
	        
	        boolean isOk = true;
	        while (isOk) {
    	        for (int i = 0; i < N; i++) {
    	            if (dp[i] == 0) {
    	                isOk = false;
    	                break;
    	            }
    	        }
    	        
    	        if (isOk) {
    	            distance = Math.min(distance, right - left);
    	            long catIndex = sortMap.get(leftPos[leftIndex]);
    	            for (int i = N - 1; i >= 0; i--) {
    	                if ((catIndex & 1 << i) > 0) {
    	                    dp[i]--;
    	                }
    	            }
    	            leftIndex++;
    	            left = leftPos[leftIndex];
    	        }
	        }
	        
	    }
	    return distance;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		TaroFriends obj;
		int answer;
		obj = new TaroFriends();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumber(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			res = answer == p2;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
			if (hasAnswer) {
				System.out.println("Desired answer:");
				System.out.println("\t" + p2);
			}
			System.out.println("Your answer:");
			System.out.println("\t" + answer);
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		boolean disabled;
		boolean tests_disabled;
		all_right = true;
		tests_disabled = false;
		
		int[] p0;
		int p1;
		int p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new int[]{-3,0,1};
		p1 = 3;
		p2 = 3;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{4,7,-7};
		p1 = 5;
		p2 = 4;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{-100000000,100000000};
		p1 = 100000000;
		p2 = 0;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{3,7,4,6,-10,7,10,9,-5};
		p1 = 7;
		p2 = 7;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new int[]{-4,0,4,0};
		p1 = 4;
		p2 = 4;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 5 -----
		disabled = false;
		p0 = new int[]{7};
		p1 = 0;
		p2 = 0;
		all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		if (all_right) {
			if (tests_disabled) {
				System.out.println("You're a stud (but some test cases were disabled)!");
			} else {
				System.out.println("You're a stud (at least on given cases)!");
			}
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// 
	// Cat Taro likes to play with his cat friends.
	// Each of his friends currently sits on some coordinate on a straight line that goes from the left to the right.
	// When Taro gives a signal, each of his friends must move exactly X units to the left or to the right.
	// 
	// 
	// 
	// 
	// You are given an int[] coordinates and the int X.
	// For each i, the element coordinates[i] represents the coordinate of the i-th cat before the movement.
	// Return the smallest possible difference between the positions of the leftmost cat and the rightmost cat after the movement.
	// 
	// 
	// DEFINITION
	// Class:TaroFriends
	// Method:getNumber
	// Parameters:int[], int
	// Returns:int
	// Method signature:int getNumber(int[] coordinates, int X)
	// 
	// 
	// CONSTRAINTS
	// -coordinates will contain between 1 and 50 elements, inclusive.
	// -Each element of coordinates will be between -100,000,000 and 100,000,000, inclusive.
	// -X will be between 0 and 100,000,000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {-3, 0, 1}
	// 3
	// 
	// Returns: 3
	// 
	// The difference 3 is obtained if the cats move from {-3,0,1} to {0,-3,-2}.
	// 
	// 
	// 
	// 
	// 1)
	// {4, 7, -7}
	// 5
	// 
	// Returns: 4
	// 
	// The difference 4 is obtained if the cats move from {4,7,-7} to {-1,2,-2}.
	// 
	// 
	// 
	// 
	// 2)
	// {-100000000, 100000000}
	// 100000000
	// 
	// Returns: 0
	// 
	// 
	// 
	// 3)
	// {3, 7, 4, 6, -10, 7, 10, 9, -5}
	// 7
	// 
	// Returns: 7
	// 
	// 
	// 
	// 4)
	// {-4, 0, 4, 0}
	// 4
	// 
	// Returns: 4
	// 
	// 
	// 
	// 5)
	// {7}
	// 0
	// 
	// Returns: 0
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
