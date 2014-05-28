import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class SixteenBricks
{
	public int maximumSurface(int[] height)
	{
	    
	    
		Arrays.sort(height);
		
		int[][] map = new int[4 + 2][4 + 2];
		
        map[1][1]=height[6];
        map[1][2]=height[13];
        map[1][3]=height[2];
        map[1][4]=height[15];
        map[2][1]=height[12];
        map[2][2]=height[0];
        map[2][3]=height[9];
        map[2][4]=height[3];
        map[3][1]=height[4];
        map[3][2]=height[8];
        map[3][3]=height[1];
        map[3][4]=height[11];
        map[4][1]=height[14];
        map[4][2]=height[5];
        map[4][3]=height[10];
        map[4][4]=height[7];
		int sum = 16;
		
		int[] dmX = {0,0,1,-1};
        int[] dmY = {1,-1,0,0};
		
        for (int i =1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 0; k < 4; k++) {
                    sum+=(Math.max(0, map[i][j] - map[i+dmY[k]][j+dmX[k]]));
                }
            }
        }

        return sum;
	    
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
		SixteenBricks obj;
		int answer;
		obj = new SixteenBricks();
		long startTime = System.currentTimeMillis();
		answer = obj.maximumSurface(p0);
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
		p0 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		p1 = 32;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2};
		p1 = 64;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{77,78,58,34,30,20,8,71,37,74,21,45,39,16,4,59};
		p1 = 1798;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
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
	// You have 16 bricks. Each brick has the shape of a rectangular box. You are given a int[] height. For each i, one of your bricks has dimensions 1 x 1 x height[i].
	// 
	// You also have an opaque table. You are going to place your 16 bricks onto the table in a specific way. You are not allowed to rotate the bricks while placing them: the dimension given in height must always be vertical. On the table, there is a 4 x 4 grid of squares. You have to place exactly one of your bricks onto each of the squares.
	// 
	// After you place all the bricks, we will look at the solid formed by them. We are interested in the visible surface area of the solid. Note that the bottom sides of your bricks are not a part of the visible surface, as they stand on the table. Also, adjacent bricks always touch each other and the parts where they touch are not visible.
	// 
	// Different arrangements of bricks may lead to different visible surfaces. Return the largest possible visible surface area.
	// 
	// 
	// DEFINITION
	// Class:SixteenBricks
	// Method:maximumSurface
	// Parameters:int[]
	// Returns:int
	// Method signature:int maximumSurface(int[] height)
	// 
	// 
	// CONSTRAINTS
	// -height will contain exactly 16 elements.
	// -Each element of height will be between 1 and 100, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
	// 
	// Returns: 32
	// 
	// All your bricks look the same.
	// The only solid you can construct is a 1 x 4 x 4 box.
	// The bottom side of the box is not visible, the other five sides are.
	// The total visible surface area is 4*4 + 4*(1*4) = 32.
	// 
	// 1)
	// {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}
	// 
	// Returns: 64
	// 
	// In order to maximize the visible surface area, you should produce a configuration in which no two bricks with height 2 share a common face.
	// 
	// 2)
	// {77, 78, 58, 34, 30, 20, 8, 71, 37, 74, 21, 45, 39, 16, 4, 59}
	// 
	// 
	// Returns: 1798
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
