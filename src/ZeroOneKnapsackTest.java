/**
 * Created by aznnobless on 11/18/14.
 */
public class ZeroOneKnapsackTest {

    public static void main(String[] args) {

        int[] values = {20, 3, 6, 25, 80};
        int[] weights = {4, 2, 2, 6, 2};
        int maxWeight = 9;

        System.out.println( knapsack(values.length, maxWeight, weights, values) );
    }

    public static int knapsack(int numberOfItems, int maxWeight, int[] weights, int[] values) {

        int dpRow = numberOfItems+1;
        int dpColumn = maxWeight+1;

        int[][] dp = new int[dpRow][dpColumn];

        for(int i=0; i < dpRow; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < dpColumn; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= numberOfItems; i++) {
            for(int j = 0; j<= maxWeight;j++) {
                dp[i][j] = dp[i-1][j];
                if(j - weights[i-1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weights[i-1]] + values[i-1]);

                }
                System.out.print("[" + i + "," +  j + "] = " + dp[i][j]);

            }
            System.out.println();
        }

        return dp[numberOfItems][maxWeight];
    }


}
