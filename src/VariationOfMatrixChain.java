/**
 * Created by aznnobless on 11/25/14.
 */

/**
 * Given expression 1-2-3-4-5-6-7-8-9-10
 * Problem: How to parenthesize to make this as large (or small) as possible?
 *
 * e.g) 1-2-3
 *      (1-2)-3 = -4 smallest
 *      1-(2-3) = +2 largest
 */

public class VariationOfMatrixChain {

    public static int findLargest(int[] numbers) {

        int[][] largestTable = new int[numbers.length+1][numbers.length+1];
        int[][] smallestTable = new int[numbers.length+1][numbers.length+1];

        int listCounter = numbers.length-1;

        // Fills in matrix by diagonals
        for(int i = 1; i <= listCounter ; i++) {
           largestTable[i][i] = smallestTable[i][i] = numbers[i-1];
        }

//        for(int j = 1; j <= listCounter; j++) {
//           for(int i = 1; i <= j+1 ; i++ ) {
//                if(i==j)
//                    largestTable[i][i] = smallestTable[i][i] = numbers[i-1];
//                else {
//                    for(int k = i; )
//                }
//
//           }
//        }


        for(int i = 0; i <= listCounter +1; i++) {
            for(int j = 0; j <= listCounter + 1; j++) {
                System.out.print("[" + i + "][" + j + "] = " + largestTable[i][j] + " = \t");
            }
            System.out.println();
        }

        return 0;
    }


    public static void main(String[] args) {

        int[] list = {1,2,3,4,5};

        int result = findLargest(list);

    }


}
