package SRM490_495;

public class SumOfPower
{
	public int findSum(int[] array)
	{
	    int sum = 0;
	    int N = array.length;
	    for (int i = 1; i <= N; i++) {
	        for (int j = 0; j + i<= N; j++) {
	            for(int k = 0; k < i; k++) {
	                sum += array[j+k];
	            }
	        }
	    }
	    return sum;
	}
     
}

//Powered by KawigiEdit-pf 2.3.0!
