/**
 * Created by aznnobless on 11/17/14.
 */
public class LongestCommonSubStringTest {

    public static void main(String[] args) {

        System.out.println(LCS("string", "nstg"));
    }

    public static int LCS(String str1, String str2) {

        int[][] dp = new int[(str1.length()+1)][(str2.length()+1)];

        for(int i = 0; i < (str1.length() + 1); i++) {
            for(int j = 0; j < (str2.length() + 1); j++) {
                dp[i][j] = 0;

            }
        }

        for(int i = 0; i < str1.length(); i++) {
            for(int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    dp[i+1][j+1] = 1 + dp[i][j];
                }
                else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

}
