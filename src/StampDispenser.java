/**
 * Created by aznnobless on 11/18/14.
 */

import java.util.Arrays;
import java.util.Collections;

/**
 * Laserfiche Warming up Interview Problem.
 *
 * The StampDispenser class represents a postage stamp vending machine.
 * The machine contains stamps of different values.
 * The machine will always have a stamp with a value of 1 cent and the machine will never run out of any type of stamp.
 * The machine should allow a consumer of the class to calculate the minimum number of stamps that
 * the machine can dispense to fill a given request.
 * Your task is to complete one of the provided implementations of the StampDispenser class: C++, C#, or Java.
 *
 * As an example, suppose an instance of StampDispenser was created with stampDenominations, {90, 30, 24, 10, 6, 2, 1},
 * and calcMinNumStampsToFillRequest(int) was called with request, 34.
 * The call should return 2, as 34 cents can best be filled by one 24 cent stamp and one 10 cent stamp.
 *
 * Things to keep in mind:
 * Assume that a junior programmer is going to read your code.
 * You should include comments and any other aides that you use to communicate your code to other developers.
 * Optimize the code for speed.
 * The code should compile and work.
 * The code should work for countries with high denomination values where stamp values of 1000 or 9000 are common.
 *
 */

public class StampDispenser {

    private int[] availableStamps;
    private int[][] dp;

    private boolean debugMode = false;

    public StampDispenser() {

    }

    /**
    * Constructs a new StampDispenser that will be able to dispense the given
    * types of stamps.
    *
    * @param stampDenominations The values of the types of stamps that the
    * machine should have.  Should be sorted in descending order and
    * contain at least a 1.
    */

    public StampDispenser(int[] stampDenominations) {

        this.availableStamps = stampDenominations;
        Arrays.sort(availableStamps); // O(n log n)

    }

    /**
     * Returns the minimum number of stamps that the machine can dispense to
     * fill the given request.
     *
     * @param request The total value of the stamps to be dispensed.
     */
    public int calcMinNumStampsToFillRequest(int request)
    {
        int dpRow = availableStamps.length+1;
        int dpColumn = request+1;

        int[][] dp = new int[dpRow][dpColumn];

        for(int i=0; i < dpRow; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < dpColumn; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= availableStamps.length; i++) {
            for (int j = 1; j <= request; j++) {

                dp[i][j] = dp[i - 1][j];
                if (j % availableStamps[i - 1] == 0)
                    dp[i][j] = j / availableStamps[i - 1];
                else
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1) ;

            }
        }

        // Display Matrix when debugMode is true.
        if(debugMode) {
            for (int i = 0; i < dpRow; i++) {
                for (int j = 0; j < dpColumn; j++) {
                    System.out.print("[" + i + "][" + j + "] = " + dp[i][j] + " ");
                }
                System.out.println();
            }
        }


        return dp[dpRow-1][dpColumn-1];
    }

    public static void main(String[] args) {

        int[] denominations = { 90, 30, 24, 10 , 6, 2, 1 };
        StampDispenser stampDispenser = new StampDispenser(denominations);
        assert stampDispenser.calcMinNumStampsToFillRequest(18) == 3;
        System.out.println(stampDispenser.calcMinNumStampsToFillRequest(18));
    }

}
