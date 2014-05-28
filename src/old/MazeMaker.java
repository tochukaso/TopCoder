package old;


import static java.util.Arrays.*;

public class MazeMaker {


    public double expectedCellsCopy(int N) {
        
        N = 3;
        double[][] way = new double[N + 1][N + 1];
        
        way[0][0] = 1d;

//        double[][] np = new double[N + 1][N + 1];

        for (int step = 0; step < N; step++) {

            double[][] np = new double[N + 1][N + 1];
/**
            for (int i = 0; i < N; i++) {
                fill(np[i], 0d);
            }
**/         
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    
                    if (way[i][j] < 1e-50) continue;

                    int ni = Math.max(i - 1, 0);
                    int nj = Math.max(j - 1, 0);

                    np[ni][j + 1] += 0.5 * way[i][j];
                    np[i + 1][nj] += 0.5 * way[i][j];
                    
                }
            }
            way = np;

        }
        
        double ans = 0;
        
        for (int i = 0; i <=N; i++) {
            for (int j = 0; j <=N; j++) {
                ans += way[i][j] * (i + j + 1);
            }
        }
        
        return ans;
        
    }
    
    public double expectedCells(int N)
    {
        double res = 0d;
        if (N == 0) return 1.0d;

        /**
        for (int i = 1; i <= N; i++) {
            res += Math.pow(0.5d, i) * 2d;
        }
        
        if (true) return res;
        **/
        
        
        
        
        
        
        double[] dp = new double[1004];
        double[] dp2 = new double[1004];

        dp2[500] = 1d;
        dp[500] = 1d;
        double used = 0d;
        
        for (int i = 0; i < N; i++) {
            double[] nDp = new double[1004];
            double[] nDp2 = new double[1004];

            for (int j = 1; j < 1002; j++) {
                if (dp2[j] > 0) {
                    double b = Math.min(1.0d, dp2[j]);
                    used += b * dp[j - 1] * 0.5d + b * dp[j + 1] * 0.5d;
                }

                nDp2[j] = dp2[j] + dp[j + 1] * 0.5d + dp[j - 1] * 0.5d;
                nDp[j] = dp[j - 1] * 0.5d + dp[j + 1] * 0.5d;
            }
            dp = nDp;
            dp2 = nDp2;
        }

        for (int j = 1; j < 1002; j++) {
            res += Math.min(1.0d, dp2[j]);
            if (dp2[j] > 0) {
                System.out.print(dp2[j] + ",");
            }
        }

        
        System.out.println();
        
//        System.out.println(res);
        
        return N + 1 - used;
    }

    
    public static void main(String[]a) {
        
        MazeMaker m = new MazeMaker();
        

        for (int i = 0; i < 10; i++) {
            double d = m.expectedCellsCopy(i);
            System.out.println(d);
        }
        
    }
    
}
