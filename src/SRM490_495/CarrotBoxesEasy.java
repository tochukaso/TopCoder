package SRM490_495;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class CarrotBoxesEasy
{
	public int theIndex(int[] carrots, int K)
	{
        int maxIndex = 0;
        while(K > 0) {
            int max = -1;
            for (int j = 0; j < carrots.length; j++) {
                if (carrots[j] >= 1 && max < carrots[j]) {
                    max = carrots[j];
                    maxIndex = j;
                }
            }
            carrots[maxIndex] --;
            K--;
        } 

	    
	    
	    return maxIndex;
		
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
		CarrotBoxesEasy obj;
		int answer;
		obj = new CarrotBoxesEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.theIndex(p0, p1);
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
		p0 = new int[]{5,8};
		p1 = 3;
		p2 = 1;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{5,8};
		p1 = 4;
		p2 = 0;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{4,9,5};
		p1 = 18;
		p2 = 2;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{13,75,24,55};
		p1 = 140;
		p2 = 0;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new int[]{14,36,52,86,27,97,3,67};
		p1 = 300;
		p2 = 4;
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
	// Rabbit Hanako has N boxes of carrots numbered 0 through N-1. The i-th box contains carrots[i] carrots.
	// 
	// 
	// She decides to eat K carrots from these boxes. She will eat the carrots one at a time, each time choosing a carrot from the box with the greatest number of carrots. If there are multiple such boxes, she will choose the lowest numbered box among them.
	// 
	// 
	// Return the number of the box from which she will eat her last carrot.
	// 
	// DEFINITION
	// Class:CarrotBoxesEasy
	// Method:theIndex
	// Parameters:int[], int
	// Returns:int
	// Method signature:int theIndex(int[] carrots, int K)
	// 
	// 
	// CONSTRAINTS
	// -carrots will contain between 1 and 50 elements, inclusive.
	// -Each element of carrots will be between 1 and 100, inclusive.
	// -K will be between 1 and the sum of all elements of carrots, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {5, 8}
	// 3
	// 
	// Returns: 1
	// 
	// She will choose three carrots from box 1.
	// 
	// 1)
	// {5, 8}
	// 4
	// 
	// Returns: 0
	// 
	// After she chooses three carrots from box 1, both boxes contain 5 carrots. She will choose the 4th carrot from the lowest indexed box.
	// 
	// 2)
	// {4, 9, 5}
	// 18
	// 
	// Returns: 2
	// 
	// 
	// 
	// 3)
	// {13, 75, 24, 55}
	// 140
	// 
	// Returns: 0
	// 
	// 
	// 
	// 4)
	// {14, 36, 52, 86, 27, 97, 3, 67}
	// 300
	// 
	// Returns: 4
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
