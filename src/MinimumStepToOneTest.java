/**
 * Created by aznnobless on 11/17/14.
 */

/**
 * Dynamic Programing Practice
 *
 * Problem : Minimum Steps to One
 *
 * On a positive integer, you can perform any one of the following 3 steps:
 *  1) Subtract 1 from it.
 *  2) If it is divisible by 2, divide by 2.
 *  3) If it is divisiebl by 3, divide by 3.
 *
 *  Find the minimum number of steps that takes n to 1.
 */

public class MinimumStepToOneTest {

    public static void main(String[] args ) {

        System.out.println(getMinimumSteps(10)); // 10 - 9 - 3 - 1 so total 3 steps. EXPECTED 3

    }

    // PRECONDITION : n > 1
    public static int getMinimumSteps(int n) {

        int[] dp = new int[n+1];

        dp[1] = 0;

        for(int i = 2; i <= n; i++) {

            dp[i] = 1 + dp[i-1];

            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], 1 + getMinimumSteps(i/2) );
            }

            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], 1 + getMinimumSteps(i/3));
            }
        }

        return dp[n];

    }
}
