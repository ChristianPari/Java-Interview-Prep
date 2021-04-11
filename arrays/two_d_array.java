/*
Given a 6x6 2d array, find the sum of each hourglass aka A shape within the 2d array and output the highest sum
1 1 1 0 0 0     a b c
0 1 0 0 0 0       d     this is an hourglass
1 1 1 0 0 0     e f g
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
 */
import java.io.*;
import java.util.*;

public class two_d_array {
  // Complete the hourglassSum function below.
  static int hourglassSum(int[][] arr) {
    List<Integer> results = new ArrayList<>(); // to add results of each hourglass to
    for (int row = 0; row < 4; row++) { // top most row can only be top to 3 from bottom row
      int[] topRow = arr[row];
      int[] middleRow = arr[row + 1];
      int[] bottomRow = arr[row + 2];

      for (int id = 0; id < 4; id++) {
        int topRowResult = topRow[id] + topRow[id + 1] + topRow[id + 2];
        int middleRowResult = middleRow[id + 1];
        int bottomRowResult = bottomRow[id] + bottomRow[id + 1] + bottomRow[id + 2];
        int total = topRowResult + middleRowResult + bottomRowResult;
        results.add(total);
      }
    }

    Collections.sort(results);
    Collections.reverse(results);
    int highest_sum = results.get(0);
    return highest_sum;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    // MY TESTING
//    int[][] arr = {
//      {-9, -9, -9,  1, 1, 1},
//      { 0, -9,  0,  4, 3, 2},
//      {-9, -9, -9,  1, 2, 3},
//      { 0,  0,  8,  6, 6, 0},
//      { 0,  0,  0, -2, 0, 0},
//      { 0,  0,  1,  2, 4, 0}
//    };
//    int result = hourglassSum(arr);
//    System.out.println(result);

    // HACKERRANK CODE
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int[][] arr = new int[6][6];

    for (int i = 0; i < 6; i++) {
      String[] arrRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 6; j++) {
        int arrItem = Integer.parseInt(arrRowItems[j]);
        arr[i][j] = arrItem;
      }
    }

    int result = hourglassSum(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
