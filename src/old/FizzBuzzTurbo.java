package old;


import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class FizzBuzzTurbo
{
	public long[] counts(long A, long B)
	{
		long[] res = new long[3];
		long f = A / 3;
		if ( A % 3 == 0) f --;
		long f2 = B / 3;

		long b = A / 5;
		if ( A % 5 == 0) b --;
		long b2 = B / 5;

		long fb = A / 15;
		if ( A % 15 == 0) fb --;
		long fb2 = B / 15;

		res[2] = fb2 - fb;
		res[0] = f2 - f - res[2];
		res[1] = b2 - b - res[2];
		
		return res;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, long p0, long p1, boolean hasAnswer, long[] p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		FizzBuzzTurbo obj;
		long[] answer;
		obj = new FizzBuzzTurbo();
		long startTime = System.currentTimeMillis();
		answer = obj.counts(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			if (answer.length != p2.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p2[i]) {
						res = false;
					}
				}
			}
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
			if (hasAnswer) {
				System.out.println("Desired answer:");
				System.out.print("\t" + "{");
				for (int i = 0; p2.length > i; ++i) {
					if (i > 0) {
						System.out.print(",");
					}
					System.out.print(p2[i]);
				}
				System.out.println("}");
			}
			System.out.println("Your answer:");
			System.out.print("\t" + "{");
			for (int i = 0; answer.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(answer[i]);
			}
			System.out.println("}");
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
		
		long p0;
		long p1;
		long[] p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = 1L;
		p1 = 4L;
		p2 = new long[]{1L,0L,0L};
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = 2L;
		p1 = 6L;
		p2 = new long[]{2L,1L,0L};
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = 150L;
		p1 = 165L;
		p2 = new long[]{4L,2L,2L};
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = 474747L;
		p1 = 747474L;
		p2 = new long[]{72728L,36363L,18182L};
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
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
	// Fizz Buzz is a simple game used to teach kids about divisibility.
	// The goal of the game is to say positive integers in increasing order, with a twist:
	// You don't say the numbers divisible by 3 and 5.
	// Instead, whenever a number was divisible by 3 you say "fizz" and for a number divisible by 5 you say "buzz".
	// (Thus, if a number was divisible by 15, you say "fizzbuzz".)
	// 
	// 
	// 
	// Here is how the game starts: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz, 16, 17, fizz, 19, buzz, fizz, 22, 23, fizz, buzz, 26, fizz, 28, 29, fizzbuzz, 31, 32, fizz, 34, buzz, fizz, ...
	// 
	// 
	// 
	// Fizz Buzz has also become a traditional programming interview question.
	// However, in this problem we have a more tricky assignment for you.
	// 
	// 
	// 
	// You are given longs A and B.
	// Consider the part of the game that corresponds to integers from A to B, inclusive.
	// During this part of the game, you will say "fizz" X times, "buzz" Y times, and "fizzbuzz" Z times.
	// Return a long[] with three elements: {X,Y,Z}.
	// 
	// 
	// DEFINITION
	// Class:FizzBuzzTurbo
	// Method:counts
	// Parameters:long, long
	// Returns:long[]
	// Method signature:long[] counts(long A, long B)
	// 
	// 
	// NOTES
	// -The return value can be quite large. Make sure to use the appropriate data type.
	// 
	// 
	// CONSTRAINTS
	// -A will be between 1 and 10^18, inclusive.
	// -B will be between A and 10^18, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 1
	// 4
	// 
	// Returns: {1, 0, 0 }
	// 
	// This is the sequence "1, 2, fizz, 4".
	// 
	// 1)
	// 2
	// 6
	// 
	// Returns: {2, 1, 0 }
	// 
	// This is the sequence "2, fizz, 4, buzz, fizz".
	// 
	// 2)
	// 150
	// 165
	// 
	// Returns: {4, 2, 2 }
	// 
	// This sequence begins and ends with a "fizzbuzz". There are some "fizz"es and some "buzz"es inbetween.
	// 
	// 3)
	// 474747
	// 747474
	// 
	// Returns: {72728, 36363, 18182 }
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!