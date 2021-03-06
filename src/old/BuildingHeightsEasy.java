package old;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BuildingHeightsEasy
{
	public int minimum(int M, int[] heights)
	{
		if (M == 1) return 0;
	    
		int N = heights.length;
		
		int min = Integer.MAX_VALUE;
		
		Arrays.sort(heights);
		for (int i = N - 1; i > 0 ; i--) {
		    for (int j = i; j - M + 1 >= 0; j--) {
		        int sum = 0;
		        int k = M - 1;
		        for (;k > 0 && j - k >= 0; k--) {
		            sum += heights[i] - heights[j - k];
		        }
		        if (k == 0) {
	                min = Math.min(min, sum);
		        }
 		    }
		}
		
	    return min;
	    
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}");
		System.out.println("]");
		BuildingHeightsEasy obj;
		int answer;
		obj = new BuildingHeightsEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.minimum(p0, p1);
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
		
		int p0;
		int[] p1;
		int p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = 2;
		p1 = new int[]{1,2,1,4,3};
		p2 = 0;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = 3;
		p1 = new int[]{1,3,5,2,1};
		p2 = 2;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = 1;
		p1 = new int[]{43,19,15};
		p2 = 0;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = 3;
		p1 = new int[]{19,23,9,12};
		p2 = 15;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = 12;
		p1 = new int[]{25,18,38,1,42,41,14,16,19,46,42,39,38,31,43,37,26,41,33,37,45,27,19,24,33,11,22,20,36,4,4};
		p2 = 47;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2) ) && all_right;
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
	// Byteland is a city with many skyscrapers, so it's a perfect venue for BASE jumping. Danilo is an enthusiastic BASE jumper. He plans to come to Byteland and to jump off some of its buildings.
	// 
	// Danilo wants to make M jumps in Byteland. However, he has some rules. First, he never jumps off the same building twice. Second, all buildings he selects for his jumps must have the same number of floors. (This is for safety reasons: It is hard to get the timing right if each jump starts at a different height.)
	// 
	// Philipe is the mayor of Byteland. He welcomes Danilo's visit as he would like to use it as a publicity stunt. However, Philipe knows that Danilo will only come to Byteland if there are at least M buildings that each have the same number of floors. To ensure that, the mayor is willing to build additional floors on some of the skyscrapers in Byteland.
	// 
	// You are given the int M and a int[] heights. Each element of heights is the number of floors in one of Byteland's skyscrapers. Compute and return the smallest number of additional floors the mayor has to build so that there will be at least M buildings with the same number of floors.
	// 
	// DEFINITION
	// Class:BuildingHeightsEasy
	// Method:minimum
	// Parameters:int, int[]
	// Returns:int
	// Method signature:int minimum(int M, int[] heights)
	// 
	// 
	// CONSTRAINTS
	// -heights will contain between 1 and 50 elements, inclusive.
	// -M will be between 1 and the number of elements in heights, inclusive.
	// -Each element in heights will be between 1 and 50, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 2
	// {1, 2, 1, 4, 3}
	// 
	// Returns: 0
	// 
	// Note that we already have two buildings that have the same number of floors. Hence, no additional floors need to be built.
	// 
	// 1)
	// 3
	// {1, 3, 5, 2, 1}
	// 
	// Returns: 2
	// 
	// We want to have at least three buildings with the same number of floors. The best way to reach this goal is to build one floor on building #0 and one floor on building #4 (0-based indices). After these changes, buildings #0, #3, and #4 will have two floors each.
	// 
	// 2)
	// 1
	// {43, 19, 15}
	// 
	// Returns: 0
	// 
	// 
	// 
	// 3)
	// 3
	// {19, 23, 9, 12}
	// 
	// Returns: 15
	// 
	// 
	// 
	// 4)
	// 12
	// {25, 18, 38, 1, 42, 41, 14, 16, 19, 46, 42, 39, 38, 31, 43, 37, 26, 41, 33, 37, 45, 27, 19, 24, 33, 11, 22, 20, 36, 4, 4}
	// 
	// Returns: 47
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
