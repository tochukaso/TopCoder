import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class Unique
{
	public String removeDuplicates(String S)
	{
		char[] x = S.toCharArray();
		boolean[] used = new boolean[30];
		
		String res = "";
		for (char c : x) {
			if (!used[c - 'a']) {
				res +=c;
				used[c - 'a'] = true;
			}
		}
		return res;
						
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		Unique obj;
		String answer;
		obj = new Unique();
		long startTime = System.currentTimeMillis();
		answer = obj.removeDuplicates(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			res = answer.equals(p1);
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
			if (hasAnswer) {
				System.out.println("Desired answer:");
				System.out.println("\t" + "\"" + p1 + "\"");
			}
			System.out.println("Your answer:");
			System.out.println("\t" + "\"" + answer + "\"");
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
		
		String p0;
		String p1;
		
		// ----- test 0 -----
		disabled = false;
		p0 = "banana";
		p1 = "ban";
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = "aardvark";
		p1 = "ardvk";
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = "xxxxx";
		p1 = "x";
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = "topcoder";
		p1 = "topcder";
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1) ) && all_right;
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
	// You are given a String S of lowercase English letters.
	// 
	// 
	// 
	// Some of the letters may occur multiple times in S.
	// For example, there are three 'a's and two 'n's in "banana".
	// 
	// 
	// 
	// You dislike duplicates.
	// For each letter, you want to keep only its first occurrence and delete all the others.
	// Return the String obtained from S by deleting the duplicates of each letter, as described above.
	// 
	// 
	// DEFINITION
	// Class:Unique
	// Method:removeDuplicates
	// Parameters:String
	// Returns:String
	// Method signature:String removeDuplicates(String S)
	// 
	// 
	// CONSTRAINTS
	// -S will contain between 1 and 1000 characters, inclusive.
	// -Each character of S will be a lowercase English letter ('a'-'z').
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "banana"
	// 
	// Returns: "ban"
	// 
	// 
	// 
	// 1)
	// "aardvark"
	// 
	// Returns: "ardvk"
	// 
	// 
	// 
	// 2)
	// "xxxxx"
	// 
	// Returns: "x"
	// 
	// 
	// 
	// 3)
	// "topcoder"
	// 
	// Returns: "topcder"
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
