package SRM490_495;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class Painting
{
	public int largestBrush(String[] picture)
	{
		char[][] map = new char[picture.length][];
		
		for (int i = 0; i < map.length; i++) {
		    map[i] = picture[i].toCharArray();
		}
		
		int length = Math.min(map.length, map[0].length);
		
		int[][] dp = new int[map.length][map[0].length];
		for (int i = map.length - 1; i >= 0; i --) {
		    int len = 0;
		    for (int j = map[i].length - 1; j >= 0; j--) {
		        if (map[i][j] == 'B') {
		            len++;
		        } else {
		            if (len > 0) {
		                for (int k = 0; k < len; k++) {
		                    dp[i][j + k] = len - k;
		                }
		                len = 0;
		            }
		        }
		    }
		    if (len > 0) {
		        for (int k = 0; k < len; k++) {
		            dp[i][k] = len - k;
		        }
		    }
		}
		
//		for (int i = map[0].length - 1; i >= 0; i--) {
//		    int len = 0;
//		    for (int j = map.length - 1; j >= 0; j--) {
//		        if (map[j][i] == 'B') {
//		            len++;
//		        } else {
//		            if (len > 0) {
//		                for (int k = 0; k < len; k++) {
//		                    dp[j + k][i] = Math.min(dp[j + k][i], len - k);
//		                }
//		                len = 0;
//		            }
//		        }
//		    }
//		    if (len > 0) {
//		        for (int k = 0; k < len; k++) {
//		            dp[k][i] = Math.min(dp[k][i],len - k);
//		        }
//		    }
//		}
	    printMatrix(dp);
//		int[][] painted = new int[map.length][map[0].length];
//		for (int i = 0; i < map.length; i++) {
//		    for (int j = 0; j < map[i].length; j++) {
//		        if (dp[i][j] == 0) continue;
//		        for (int k = 0; k < dp[i][j]; k++) {
//		            for (int l = 0; l < dp[i][j]; l++) {
//		                System.out.println(i + " " + j + " " + dp[i][j]);
//		                painted[i+k][j+l] = Math.max(painted[i + k][j + l], dp[i][j]);
//		            }
//		        }
//		    }
//		}
		
		for (int i = 0; i < map.length; i++) {
		    for (int j = 0; j < map[i].length; j ++) {
		        if (dp[i][j] == 0) continue;
		        length = Math.min(length, dp[i][j]);
//		        length = Math.min(painted[i][j], length);
		    }
		}
		
		return length;
	}
	
    final void printMatrix(int[][] p) {
        for (int[] i : p) printArray(i);
    }
    
    final void printArray(int[] p) {
        for (int i : p) System.out.print(i + " ");
        System.out.println();
    }
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		Painting obj;
		int answer;
		obj = new Painting();
		long startTime = System.currentTimeMillis();
		answer = obj.largestBrush(p0);
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
		
		String[] p0;
		int p1;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new String[]{"BBWW","BBWW","WBBW","WWBB", "WWBB"};
		p1 = 4;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new String[]{"BBBB","BWWB","BWWB","BBBB"};
		p1 = 1;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new String[]{"WBBBBB","BBBBBB","BBBBBB","BBBBBB"};
		p1 = 3;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new String[]{"BBBB","BBBB","WBBB","BBBB","BBBB","BBBB"};
		p1 = 2;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new String[]{"WBBBBBWWWWWWWWW","WBBBBBBWWWWWWWW","WBBBBBBBBBBBWWW","WBBBBBBBBBBBWWW","BBBBBBBBBBBBBBB","BBBBBBBBBBBBBBB","BBBBBBBBBBBBBBB","BBBBBBBBWWBBBBB","BBBBBBBBWBBBBBB","WBBBBBBBWBBBBBW","BBBBBBBWWBBBBBW","BBBBBBBWWBBBBBW","BBBBBBWWWBBBBBW","BBBBBWWWWWWWWWW","BBBBBWWWWWWWWWW"};
		p1 = 5;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1) ) && all_right;
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
	// Normally Mr. Grey is not a painter, but he recently had an absolutely brilliant idea for a picture. He thinks that once drawn, it will bring him world-wide fame.
	// 
	// The picture will be painted on an NxM sheet of white paper consisting of 1x1 squares. Its rows are numbered from 0 to N-1 and the columns are numbered from 0 to M-1. The cell in row i, column j is denoted as (i, j).
	// 
	// Of course, Mr. Grey already has a picture plan in his mind. It is given in a String[] picture, which contains exactly N elements, where each element contains exactly M characters. Сharacter j in element i of picture will be 'B' if the cell (i, j) must be painted black, and it will be 'W' if this cell must be left white.
	// 
	// Mr. Grey has a lot of black paint, but unfortunately he doesn't have a brush, so he went to a local shop to buy one. The shop offers square brushes of different sizes. More exactly, for each positive integer S, one can buy an SxS brush in the shop. Using an SxS brush, Mr. Grey will be able to paint entirely black SxS squares on the sheet of paper. In other words, he can choose row R and column C such that 0 <= R <= N - S, 0 <= C <= M - S, and then paint all cells (r, c) such that R <= r < R + S and C <= c < C + S in black paint. He can repeat this operation infinitely many times. If a cell must be black according to picture, it may be painted black several times. However, if a cell must be white, then it must never be painted black.
	// 
	// It's easy to see that every picture can be drawn using a 1x1 brush, but it will be impossible to draw some pictures using larger brushes. Buying a 1x1 brush seems to be the most practical choice. However, Mr. Grey is sure that big masters must use big brushes. Therefore, he would like to buy the largest possible brush that will still allow him to draw the picture that he has in mind.
	// 
	// Return the maximum value of S such that it's possible to draw picture using a brush of size SxS.
	// 
	// DEFINITION
	// Class:Painting
	// Method:largestBrush
	// Parameters:String[]
	// Returns:int
	// Method signature:int largestBrush(String[] picture)
	// 
	// 
	// CONSTRAINTS
	// -picture will contain between 1 and 50 elements, inclusive.
	// -Each element of picture will contain between 1 and 50 characters, inclusive.
	// -All elements of picture will contain the same number of characters.
	// -Each character in picture will be 'B' or 'W'.
	// -There will be at least one 'B' character in picture.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {"BBBB",
	//  "BBBB",
	//  "BBBB",
	//  "BBBB"}
	// 
	// Returns: 4
	// 
	// It's easy to see that a solid 4x4 black square can be drawn using a 4x4 brush.
	// 
	// 1)
	// {"BBBB",
	//  "BWWB",
	//  "BWWB",
	//  "BBBB"}
	// 
	// Returns: 1
	// 
	// This time we have only a border of a 4x4 square and it's necessary to have a 1x1 brush in order to draw it.
	// 
	// 2)
	// {"WBBBBB",
	//  "BBBBBB",
	//  "BBBBBB",
	//  "BBBBBB"}
	// 
	// 
	// Returns: 3
	// 
	// A completely black 4x6 rectangle can be drawn using a 4x4 brush. However, if we want just one cell within it to remain white, the size of the brush will have to be reduced. In this example, a 3x3 brush would work.
	// 
	// 3)
	// {"BBBB",
	//  "BBBB",
	//  "WBBB",
	//  "BBBB",
	//  "BBBB",
	//  "BBBB"}
	// 
	// 
	// Returns: 2
	// 
	// This is very similar to the previous example, but the white cell is in a different location. Mr. Grey will have to buy a 2x2 brush in this case.
	// 
	// 4)
	// {"WBBBBBWWWWWWWWW",
	//  "WBBBBBBWWWWWWWW",
	//  "WBBBBBBBBBBBWWW",
	//  "WBBBBBBBBBBBWWW",
	//  "BBBBBBBBBBBBBBB",
	//  "BBBBBBBBBBBBBBB",
	//  "BBBBBBBBBBBBBBB",
	//  "BBBBBBBBWWBBBBB",
	//  "BBBBBBBBWBBBBBB",
	//  "WBBBBBBBWBBBBBW",
	//  "BBBBBBBWWBBBBBW",
	//  "BBBBBBBWWBBBBBW",
	//  "BBBBBBWWWBBBBBW",
	//  "BBBBBWWWWWWWWWW",
	//  "BBBBBWWWWWWWWWW"}
	// 
	// 
	// Returns: 5
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
