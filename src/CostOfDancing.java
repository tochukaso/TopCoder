import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class CostOfDancing
{
	public int minimum(int K, int[] danceCost)
	{
	    int sum = 0;
	    Arrays.sort(danceCost);
	    for (int i = 0 ;i < K; i++) {
	        sum+=danceCost[i];
	        if (i == danceCost.length - 1) {
	            break;
	        }
	    }
	    
	    return sum;
	    
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
		CostOfDancing obj;
		int answer;
		obj = new CostOfDancing();
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
		p1 = new int[]{1,5,3,4};
		p2 = 4;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = 3;
		p1 = new int[]{1,5,4};
		p2 = 10;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = 1;
		p1 = new int[]{2,2,4,5,3};
		p2 = 2;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = 39;
		p1 = new int[]{973,793,722,573,521,568,845,674,595,310,284,794,913,93,129,758,108,433,181,163,96,932,703,989,884,420,615,991,364,657,421,336,801,142,908,321,709,752,346,656,413,629,801};
		p2 = 20431;
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
	// Gustavo studies at the Byteversity (one of the best universities in Byteland). He's also very keen on dancing, so he decided to enroll at a dance school.
	// 
	// The school offers many different courses, each teaching one dance. Different courses may have different costs. You are given a int[] danceCost. The elements of danceCost are the costs of all courses offered at the dance school.
	// 
	// Gustavo would like to learn exactly K of those dances. He is a poor student, so his only priority is to pay as little as possible for the courses.
	// 
	// You are given the int K and the int[] danceCost. Compute and return the smallest possible total cost of learning K dances.
	// 
	// DEFINITION
	// Class:CostOfDancing
	// Method:minimum
	// Parameters:int, int[]
	// Returns:int
	// Method signature:int minimum(int K, int[] danceCost)
	// 
	// 
	// CONSTRAINTS
	// -danceCost will contain between 1 and 1,000 elements, inclusive.
	// -Each element of danceCost will be between 1 and 1,000, inclusive.
	// -K will be between 1 and the number of elements in danceCost, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 2
	// {1, 5, 3, 4}
	// 
	// Returns: 4
	// 
	// Gustavo must pay for exactly two out of the four given courses. The cheapest possibility is to pay 1 for one course and then 3 for another course. The total cost is 1+3 = 4.
	// 
	// 1)
	// 3
	// {1, 5, 4}
	// 
	// Returns: 10
	// 
	// Gustavo has no choice here. He has to pay for all three courses, which costs 1+5+4 = 10.
	// 
	// 2)
	// 1
	// {2, 2, 4, 5, 3}
	// 
	// Returns: 2
	// 
	// Among all 5 possible courses he can take, the cheapest one is either the course #0 or course #1 (0-based).
	// 
	// 3)
	// 39
	// {973, 793, 722, 573, 521, 568, 845, 674, 595, 310, 284, 794, 913, 93, 129, 758, 108, 433, 181, 163, 96, 932,
	//  703, 989, 884, 420, 615, 991, 364, 657, 421, 336, 801, 142, 908, 321, 709, 752, 346, 656, 413, 629, 801}
	// 
	// Returns: 20431
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
