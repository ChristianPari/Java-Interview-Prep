/*
There is a large pile of socks that must be paired by color.
Given an array of integers representing the color of each sock,
  determine how many pairs of socks with matching colors there are.
 */
import java.io.*;
import java.util.*;

public class sales_by_match {
  // Complete the sockMerchant function below.
  static int sockMerchant(
    int n
    , int[] ar
  ) {
    int counter = 0;
    List<Integer> arr = new ArrayList<>();
    for ( int num : ar ) {
      arr.add(num);
    }

    for ( int sock = 0; sock < arr.size(); sock++ ) {
      for ( int comparing = 0; comparing < arr.size(); comparing++ ) {
        int sock_val = arr.get(sock);
        int comparing_val = arr.get(comparing);
        if (( sock != comparing ) && ( sock_val == comparing_val )) {
          counter += 1;
          arr.remove(sock);
          arr.remove(comparing - 1);
          sock -= 1;
          break;
        }
      }
    }

    return counter;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    // MY TESTING
//    int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
//    int result = sockMerchant(9, ar);
//    System.out.println(result);

    // HACKERRANK CODE
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] ar = new int[n];

    String[] arItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arItem = Integer.parseInt(arItems[i]);
      ar[i] = arItem;
    }

    int result = sockMerchant(n, ar);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
