/**
 * Created by aznnobless on 11/15/14.
 */

/**
 * Fibonacci with Dynamic Programming.
 *
 * Never use recursion to solve Fibonacci!! Inefficient!
 */
public class FibonacciTest {

    public static void main(String[] args) {

        System.out.println(fib(5));
    }

    public static int fib(int n) {

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            System.out.print(i);
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }


}
