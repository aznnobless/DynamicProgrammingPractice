/**
 * Created by aznnobless on 11/25/14.
 */
public class MatrixChainTest {

    public static void matrixChainOrder(int[] dimensions) {

        int[][] cost = new int[dimensions.length][dimensions.length];
        int[][] s = new int[dimensions.length][dimensions.length];
        int matrixCounter = dimensions.length - 1;

        // Fills in matrix by diagonals
        for(int i = 1; i <= matrixCounter; i++) {
            cost[i][i] = 0;
        }

        for(int l = 2; l <= matrixCounter; l++) { // l is chain length

            for(int i = 1; i <= matrixCounter - l + 1; i++) {

                int j = i+l-1;

                cost[i][j] = Integer.MAX_VALUE;

                for(int k = i; k<=j-1; k++) {
                    int thisCost = cost[i][k] + cost[k+1][j] + dimensions[i-1]*dimensions[k]*dimensions[j];
                    if(thisCost < cost[i][j]) {
                        cost[i][j] = thisCost;
                        s[i][j] = k;
                    }
                }
            }

        }

        for(int i = 0; i < cost.length; i++) {
            for(int j = 0; j < cost[0].length; j++) {
                //System.out.print( "[" + i + "," + j + "] = \t" + cost[i][j] + " \t\t");

               System.out.printf("[ %d, %d ] = %d \t",i,j,cost[i][j]);
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        int[] list = {30,1,40,10,25};
        matrixChainOrder(list);
    }


}
