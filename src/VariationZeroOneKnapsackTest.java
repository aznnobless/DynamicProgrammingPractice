/**
 * Created by aznnobless on 11/23/14.
 */
public class VariationZeroOneKnapsackTest {

    public static void main(String[] args) {

        int[] weights = {1, 2, 4, 5, 6};
        int maxWeight = 10;

        System.out.println(knapsack(weights.length, maxWeight, weights));

    }

    public static int knapsack(int numberOfItems, int maxWeight, int[] weights) {

        int dpRow = numberOfItems + 1;
        int dpColumn = maxWeight + 1;

        int[][] dp = new int[dpRow][dpColumn];

        for (int i = 0; i < dpRow; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dpColumn; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= numberOfItems; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - weights[i - 1] >= 0) {
                    //dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weights[i - 1]] + weights[i - 1]);
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weights[i - 1]] + weights[i - 1]);

                       if(dp[i][j] >= maxWeight)
                            dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);

                }
                System.out.print("[" + i + "," + j + "] = " + dp[i][j] + " ");

            }
            System.out.println();
        }

        int goal = dp[numberOfItems][maxWeight]; // 9

        for(int i = 0; i < dpRow; i++) {
           // System.out.println("Current value: " + dp[i][maxWeight]);
            if(dp[i][maxWeight] == goal) {
                System.out.println("Possibility :" + i);



            }
        }

        return dp[numberOfItems][maxWeight];
    }
}

