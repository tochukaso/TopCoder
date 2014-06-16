import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class SwitchingGame
{
	public int timeToWin(String[] states)
	{
		int sum = 0;
	    
		boolean[] lampOn = new boolean[states[0].length()];
		

		char[][] gameStates = new char[states.length][];
        for (int i = 0; i < states.length; i++) {
            gameStates[i] = states[i].toCharArray();
        }

        for (int i = 0; i < states.length; i++) {
		    char[] chars = gameStates[i];
		    boolean isOnUpdate = false;
            boolean isOffUpdate = false;
            
            List<Integer> hatenaIndexList = new ArrayList<Integer>();
		    for (int j = 0; j < chars.length; j++) {
		        char c = chars[j];
		        
		        if (c == '+') {
		            if (!lampOn[j]) {
		                isOnUpdate = true;
		            }
		            
                    lampOn[j] = true;
		        } else if (c == '-') {
                    if (lampOn[j]) {
                        isOffUpdate = true;
                    }
                    lampOn[j] = false;
		        } else if (c == '?') {
		            hatenaIndexList.add(j);
                } 
		    }
		    
		    for (int j = 0; j < hatenaIndexList.size(); j++) {
		        int index = hatenaIndexList.get(j);
		        for (int hatena = i + 1; hatena < states.length; hatena++) {
		            char next = gameStates[hatena][index];
		            if (next == '+') {
		                if (isOnUpdate) {
		                    lampOn[index] = true;
		                }
                        break;
		            } else if (next == '-') {
                        if (isOffUpdate) {
                            lampOn[index] = false;
                        }
                        break;
		            }
		        }
		    }
		    if (isOnUpdate) sum++;
            if (isOffUpdate) sum++;
            sum++;
		}
		
		return sum;
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
		SwitchingGame obj;
		int answer;
		obj = new SwitchingGame();
		long startTime = System.currentTimeMillis();
		answer = obj.timeToWin(p0);
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
		p0 = new String[]{"?????-", "+++++-"};
		p1 = 5;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new String[]{"+-++","+-++"};
		p1 = 3;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new String[]{"++","+?","?+","++"};
		p1 = 5;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new String[]{"+","?","?","?","-"};
		p1 = 7;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new String[]{"+??+++","++??+-","?++??+","?-+-??","??+?++","++-?+?","?++?-+","?--+++","-??-?+"};
		p1 = 20;
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
	// You're playing a game with lamps.
	// There are M lamps in a row.
	// The lamps are numbered 0 through M-1.
	// Initially, all lamps are turned off.
	// 
	// The game consists of N levels.
	// The levels are numbered 0 through N-1.
	// Each level is described by a string of M characters.
	// For each i, character i of that string gives the required state of lamp i.
	// Each of these characters will be either '+', '-', or '?'.
	// Here, '+' means that the lamp must be on, '-' means that the lamp must be off, and '?' means that the lamp may be in either state.
	// 
	// The game is played in turns.
	// Each turn takes one second.
	// In each turn, you may do one of three things:
	// 
	// You may choose any subset of lamps that are all turned off, and turn all of them on.
	// You may choose any subset of lamps that are all turned on, and turn all of them off.
	// You may press the big red button that says "Check!".
	// 
	// Whenever you press the button, the current states of all lamps are checked against the requirements of the current level.
	// If all lamps satisfy the requirements, you solved the current level.
	// You win the game by solving all N levels.
	// You must solve the levels in the given order, starting with level 0.
	// Note that the lamps do not reset between levels: you continue playing the next level from the state you had when you solved the previous level.
	// 
	// Return the smallest number of seconds it takes to win the game if you play optimally.
	// 
	// 
	// DEFINITION
	// Class:SwitchingGame
	// Method:timeToWin
	// Parameters:String[]
	// Returns:int
	// Method signature:int timeToWin(String[] states)
	// 
	// 
	// CONSTRAINTS
	// -states will contain exactly N elements.
	// -N will be between 1 and 50, inclusive.
	// -Each element of states will contain exactly M characters.
	// -M will be between 1 and 50, inclusive.
	// -Each character of states will be '+', '-' or '?'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {"++--",
	//  "--++"}
	// 
	// Returns: 5
	// 
	// The following sequence of actions wins the game in five seconds:
	// 
	// Turn lamps 0 and 1 on.
	// Press the button to win level 0.
	// Turn lamps 0 and 1 off.
	// Turn lamps 2 and 3 on.
	// Press the button to win level 1 and thus win the game.
	// 
	// 
	// 1)
	// {"+-++",
	//  "+-++"}
	// 
	// Returns: 3
	// 
	// Each time you press the button you can only win a single level.
	// Even though levels 0 and 1 are identical, you have to press the button twice in a row to win both of them.
	// 
	// 
	// 2)
	// {"++",
	//  "+?",
	//  "?+",
	//  "++"}
	// 
	// Returns: 5
	// 
	// Here we can simply turn both lamps on, and then use that configuration to win all four levels.
	// 
	// 3)
	// {"+", 
	//  "?",
	//  "?",
	//  "?",
	//  "-"}
	// 
	// Returns: 7
	// 
	// At some point between winning level 0 and winning level 4 we have to turn the lamp off.
	// 
	// 4)
	// {"+??+++",
	//  "++??+-",
	//  "?++??+",
	//  "?-+-??",
	//  "??+?++",
	//  "++-?+?",
	//  "?++?-+",
	//  "?--+++",
	//  "-??-?+"}
	// 
	// 
	// Returns: 20
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
