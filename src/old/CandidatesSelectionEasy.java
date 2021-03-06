package old;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class CandidatesSelectionEasy
{
	public int[] sort(String[] score, int x)
	{
		int [] res = new int[score.length];
		
		
		Set<Integer> used = new HashSet<Integer>();
		
		for (int j = 0; j < score.length; j++) {
		      char min = 10000;
	        int pos = 0;

		    for (int i = 0; i < score.length; i++) {
		        if (used.contains(i)) continue;
		          char now = score[i].charAt(x);

		          if (min > now) {
		              pos = i;
		              min = now;
		          }
		    }
		    
		    res[j] = pos;
		    used.add(pos);
		}
	    
	    return res;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, int[] p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		CandidatesSelectionEasy obj;
		int[] answer;
		obj = new CandidatesSelectionEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.sort(p0, p1);
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
		
		String[] p0;
		int p1;
		int[] p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new String[]{"ACB","BAC","CBA"};
		p1 = 1;
		p2 = new int[]{1,2,0};
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new String[]{"A","C","B","C","A"};
		p1 = 0;
		p2 = new int[]{0,4,2,1,3};
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new String[]{"LAX","BUR","ONT","LGB","SAN","SNA","SFO","OAK","SJC"};
		p1 = 2;
		p2 = new int[]{5,3,8,7,4,6,1,2,0};
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new String[]{"BBCBABAC","BCBACABA","CCCBAACB","CACABABB","AABBBBCC"};
		p1 = 6;
		p2 = new int[]{0,1,3,2,4};
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new String[]{"XXYWZWWYXZ","YZZZYWYZYW","ZYZZWZYYWW","ZWZWZWZXYW","ZYXWZXWYXY","YXXXZWXWXW","XWWYZWXYXY","XYYXYWYXWY","ZZYXZYZXYY","WXZXWYZWYY"};
		p1 = 3;
		p2 = new int[]{0,3,4,5,7,8,9,6,1,2};
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 5 -----
		disabled = false;
		p0 = new String[]{"X"};
		p1 = 0;
		p2 = new int[]{0};
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
	// Fox Ciel wants to hire a new maid.
	// There are n candidates for the position.
	// There are m different skills a maid should have, such as cooking, cleaning, or discreetness.
	// Ciel numbered the candidates 0 through n-1 and the skills 0 through m-1.
	// 
	// 
	// 
	// Ciel evaluated the level each candidate has in each of the skills.
	// You are given this information encoded in a String[] score with n elements, each consisting of m characters.
	// For each i and j, the character score[i][j] represents the level candidate i has in skill j.
	// Said character will always be between 'A' and 'Z', inclusive, where 'A' means the best possible and 'Z' the worst possible candidate.
	// 
	// 
	// 
	// You are also given an int x.
	// Ciel thinks that skill x is the most important skill a maid should have.
	// 
	// 
	// 
	// Return a int[] with n elements: the numbers of all candidates, ordered according to their level in skill x from the best to the worst.
	// Candidates who have the same level in skill x should be ordered by their number in ascending order.
	// 
	// DEFINITION
	// Class:CandidatesSelectionEasy
	// Method:sort
	// Parameters:String[], int
	// Returns:int[]
	// Method signature:int[] sort(String[] score, int x)
	// 
	// 
	// CONSTRAINTS
	// -n will be between 1 and 50, inclusive.
	// -m will be between 1 and 50, inclusive.
	// -score will contain exactly n elements.
	// -Each element of score will contain exactly m characters.
	// -Each character in each element of score will be an uppercase English letter ('A'-'Z').
	// -x will be between 0 and m-1, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {"ACB", "BAC", "CBA"}
	// 1
	// 
	// Returns: {1, 2, 0 }
	// 
	// The output should be {1, 2, 0}, because the level of candidate 1 in skill 1 is 'A', the level of candidate 2 in this skill is 'B', and the level of candidate 0 is 'C'.
	// 
	// 1)
	// {"A", "C", "B", "C", "A"}
	// 0
	// 
	// Returns: {0, 4, 2, 1, 3 }
	// 
	// Note that when 2 candidates have same level, they will remain in the original order.
	// 
	// 2)
	// {"LAX","BUR","ONT","LGB","SAN","SNA","SFO","OAK","SJC"}
	// 2
	// 
	// Returns: {5, 3, 8, 7, 4, 6, 1, 2, 0 }
	// 
	// 
	// 
	// 3)
	// {"BBCBABAC","BCBACABA","CCCBAACB","CACABABB","AABBBBCC"}
	// 6
	// 
	// Returns: {0, 1, 3, 2, 4 }
	// 
	// 
	// 
	// 4)
	// {"XXYWZWWYXZ","YZZZYWYZYW","ZYZZWZYYWW","ZWZWZWZXYW","ZYXWZXWYXY","YXXXZWXWXW","XWWYZWXYXY","XYYXYWYXWY","ZZYXZYZXYY","WXZXWYZWYY"}
	// 3
	// 
	// Returns: {0, 3, 4, 5, 7, 8, 9, 6, 1, 2 }
	// 
	// 
	// 
	// 5)
	// {"X"}
	// 0
	// 
	// Returns: {0 }
	// 
	// Note that we may have only one candidate as well as only 1 skill.
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
