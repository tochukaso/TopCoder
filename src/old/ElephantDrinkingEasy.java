package old;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ElephantDrinkingEasy
{
	int n = 0;
	boolean[][] m = null;
	boolean[][] c = null;

	public int maxElephants(String[] map)
	{
		n = map.length;
		m = new boolean[n][n];
		c = new boolean[n][n];

		int count = 0;
		for(int i = 0; i < n; i++) {
			char[] cMap = map[i].toCharArray();
			for (int j = 0; j < n; j++) {
				m[i][j] = cMap[j] == 'Y';
				if (m[i][j]) count ++;
			}
		}	
		if( n <= 2) return count;
		
		return solve(0, 0);
	}

	int solve(int i, int j) {
		if(j == n) {
			return solve(i + 1, 0);
		}
		
		if (i == n) {
			return 0;
		}
		int count = 0;
		if (m[i][j]) {
			{
				boolean u = true;
				for (int y = 0; y < i; y++) {
					if (m[y][j] || c[y][j]) {
						u = false;
						break;
					}
				}
				if (u) {
					for (int y = 0; y < i; y++) {
						c[y][j] = true;
					}
					count = Math.max(count, 1 + solve(i, j + 1));
					for (int y = 0; y < i; y++) {
						c[y][j] = false;
					}
				}
			}

			{
				boolean u = true;
				for (int y = i + 1; y < n; y++) {
					if (m[y][j] || c[y][j]) {
						u = false;
						break;
					}
				}
				if (u) {
					for (int y = i + 1; y < n; y++) {
						c[y][j] = true;
					}
					count = Math.max(count, 1 + solve(i, j + 1));
					for (int y = i + 1; y < n; y++) {
						c[y][j] = false;
					}
				}
			}

			{
				boolean u = true;
				for (int x = 0; x < j; x++) {
					if (m[i][x] || c[i][x]) {
						u = false;
						break;
					}
				}
				if (u) {
					for (int x = 0; x < j; x++) {
						c[i][x] = true;
					}
					count = Math.max(count, 1 + solve(i, j + 1));
					for (int x = 0; x < j; x++) {
						c[i][x] = false;
					}
				}
			}
		
			{
				boolean u = true;
				for (int x = j + 1; x < n; x++) {
					if (m[i][x] || c[i][x]) {
						u = false;
						break;
					}
				}
				if (u) {
					for (int x = j + 1; x < n; x++) {
						c[i][x] = true;
					}
					count = Math.max(count, 1 + solve(i, j + 1));
					for (int x = j + 1; x < n; x++) {
						c[i][x] = false;
					}
				}
			}
		
		}
		
		count = Math.max(count, solve(i, j + 1));
		return count;		
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
		ElephantDrinkingEasy obj;
		int answer;
		obj = new ElephantDrinkingEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.maxElephants(p0);
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
		p0 = new String[]{"NNNNN","NNYYN","NYNNN","NNYNN","NNNNN"};
		p1 = 4;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new String[]{"YYY","YYY","YYY"};
		p1 = 8;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new String[]{"YNYN","NNYY","YYNN","YYYY"};
		p1 = 10;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new String[]{"YNYN","YNYY","YYNN","YYYY"};
		p1 = 10;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new String[]{"YYNYN","NYNNY","YNYNN","YYNYY","YYNNN"};
		p1 = 12;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 5 -----
		disabled = false;
		p0 = new String[]{"YYNYN","NYNYY","YNYYN","YYNYY","YYNNN"};
		p1 = 13;
		all_right = (disabled || KawigiEdit_RunTest(5, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 6 -----
		disabled = false;
		p0 = new String[]{"NN","NN"};
		p1 = 0;
		all_right = (disabled || KawigiEdit_RunTest(6, p0, true, p1) ) && all_right;
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
	// There is an n times n field.
	// Some of the cells of the field contain water.
	// You are given a map of the field encoded as a String[] field.
	// There are n elements in field and each of them has n characters.
	// The character field[i][j] is 'Y' if there is water in the cell (i,j).
	// Otherwise, the corresponding character is 'N'.
	// 
	// 
	// There are 4n elephants around the field: one per each cell boundary, as shown in the pictures below.
	// The elephants can use their trunks to drink water.
	// Each elephant can only extend its trunk straight into the field.
	// So, for example, the elephants that are on the left side of the field can only extend their noses towards the right.
	// The trunks are long enough to reach the opposite end of the field.
	// 
	// 
	// 
	// 
	// 
	// There are two additional restrictions:
	// The trunks of elephants are not allowed to intersect.
	// For each cell with water, there can be at most one elephant drinking from that cell.
	// 
	// 
	// For example, figure (a) below shows a valid configuration.
	// Cells with water are blue, elephants are green, and their trunks are red.
	// In the figure there are four elephants that drink.
	// Figures (b) and (c) show invalid configurations. In both of them the trunks intersect.
	// 
	// 
	// Your task is to return the maximal number of elephants who can drink at the same time.
	// 
	// DEFINITION
	// Class:ElephantDrinkingEasy
	// Method:maxElephants
	// Parameters:String[]
	// Returns:int
	// Method signature:int maxElephants(String[] map)
	// 
	// 
	// CONSTRAINTS
	// -n will be between 2 and 5, inclusive.
	// -field will contain exactly n elements, inclusive.
	// -Each element in field will contain exactly n characters, inclusive.
	// -Each character in field will be 'Y' or 'N'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {"NNNNN",
	//  "NNYYN",
	//  "NYNNN",
	//  "NNYNN",
	//  "NNNNN"}
	// 
	// Returns: 4
	// 
	// This is the field shown in the figure in the problem statement. As shown in figure (a), four elephants can drink at the same time. And as we only have four cells with water, this is clearly optimal.
	// 
	// 1)
	// {"YYY",
	//  "YYY",
	//  "YYY"}
	// 
	// 
	// Returns: 8
	// 
	// It is possible for the elephants to drink from 8 cells at the same time. For example, a suitable set of 8 elephants can drink from all cells except for the one in the center. It is not possible for the elephants to drink from all 9 cells at the same time.
	// 
	// 2)
	//  {"YNYN",
	//   "NNYY",
	//   "YYNN",
	//   "YYYY"}
	// 
	// Returns: 10
	// 
	// 
	// 
	// 3)
	//  {"YNYN",
	//   "YNYY",
	//   "YYNN",
	//   "YYYY"}
	// 
	// Returns: 10
	// 
	// 
	// 
	// 4)
	// {"YYNYN",
	//  "NYNNY",
	//  "YNYNN",
	//  "YYNYY",
	//  "YYNNN"}
	// 
	// Returns: 12
	// 
	// 
	// 
	// 5)
	// {"YYNYN",
	//  "NYNYY",
	//  "YNYYN",
	//  "YYNYY",
	//  "YYNNN"}
	// 
	// Returns: 13
	// 
	// 
	// 
	// 6)
	// {"NN",
	//  "NN"}
	// 
	// Returns: 0
	// 
	// There can be no water at all.
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!