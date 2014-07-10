import java.util.HashMap;
import java.util.Map;


public class ManySquares
{
	public int howManySquares(int[] sticks)
	{
	    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	    
	    for (int i = 0; i < sticks.length; i++) {
	        int cnt = 0;
	        if(map.containsKey(sticks[i])) {
	            cnt = map.get(sticks[i]);
	        }
	        cnt ++;
            
	        map.put(sticks[i], cnt);
	            
        }
	    
	    int res = 0;
	    for (int i : map.values()) {
	        res += i / 4;
        }
		
	    return res;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		ManySquares obj;
		int answer;
		obj = new ManySquares();
		long startTime = System.currentTimeMillis();
		answer = obj.howManySquares(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			res = answer == p1;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
			if (hasAnswer) {
				System.out.println("Desired answer:");
				System.out.println("\t" + p1);
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
		
		// ----- test 0 -----
		disabled = false;
		p0 = new int[]{1,1,2,2,1,1,2};
		p1 = 1;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{3,1,4,4,4,10,10,10,10};
		p1 = 1;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{1,2,3,4,1,2,3,4,1,2,3,1,2,3,4,1,2,3,3,3};
		p1 = 3;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{1,1,1,2,2,2,3,3,3,4,4,4};
		p1 = 0;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new int[]{1,1,1,2,1,1,1,3,1,1,1};
		p1 = 2;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 5 -----
		disabled = false;
		p0 = new int[]{2,2,4,4,8,8};
		p1 = 0;
		all_right = (disabled || KawigiEdit_RunTest(5, p0, true, p1) ) && all_right;
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
	// You found a box from an old game.
	// The box contains a lot of sticks and a manual.
	// Frustrated by the fact the manual was unreadable, you decided to invent your own game with the sticks.
	// In your game, the goal is to use the sticks to build as many squares as possible.
	// There are only two rules:
	// 
	// Each stick can only be used in one square.
	// Each square must consist of exactly 4 sticks. That is, you cannot combine two or more sticks to create one side of the square.
	// 
	// 
	// You are given a int[] sticks.
	// The elements of sticks are the lengths of the sticks you have.
	// Return the maximum number of squares you can make.
	// 
	// 
	// DEFINITION
	// Class:ManySquares
	// Method:howManySquares
	// Parameters:int[]
	// Returns:int
	// Method signature:int howManySquares(int[] sticks)
	// 
	// 
	// NOTES
	// -If you can't make any square, return 0.
	// 
	// 
	// CONSTRAINTS
	// -sticks will contain between 1 and 50 elements.
	// -Each element of sticks will be between 1 and 1000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {1,1,2,2,1,1,2}
	// 
	// Returns: 1
	// 
	// You can build a square with side 1.
	// 
	// 
	// 1)
	// {3, 1, 4, 4, 4, 10, 10, 10, 10}
	// 
	// 
	// Returns: 1
	// 
	// You can build a square with side 10. You cannot build a square with side 4. (Note that you are not allowed to use 3+1 instead of a 4.)
	// 
	// 
	// 2)
	// {1,2,3,4,1,2,3,4,1,2,3,1,2,3,4,1,2,3,3,3}
	// 
	// Returns: 3
	// 
	// 
	// 
	// 3)
	// {1,1,1,2,2,2,3,3,3,4,4,4}
	// 
	// Returns: 0
	// 
	// Sometimes you can't make any square.
	// 
	// 
	// 4)
	// {1,1,1,2,1,1,1,3,1,1,1}
	// 
	// Returns: 2
	// 
	// 
	// 
	// 5)
	// {2,2,4,4,8,8}
	// 
	// Returns: 0
	// 
	// You are also not allowed to break the sticks.
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
