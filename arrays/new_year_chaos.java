/*
It is New Year's Day and people are in line for the Wonderland roller coaster ride.
Each person wears a sticker indicating their initial position in the queue from (1) to (n).
Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker.
One person can bribe at most two others.

Determine the minimum number of bribes that took place to get to a given queue order.
Print the number of bribes, or, if anyone has bribed more than two people, print "Too chaotic".
 */
import java.util.*;

public class new_year_chaos {
  // Complete the minimumBribes function below.
  static void minimumBribes(int[] q) {
    int swaps = 0;
    for (int index = q.length - 1; index >= 0; index--) {
      if (q[index] != (index + 1)) { // if the number in the 'index' location isn't whats supposed to be there
        if ((index - 1) >= 0 && q[index - 1] == (index + 1)) {
          // making sure not 'out of bounds' and...
          // that the preceding number is what belongs here
          int temp = q[index - 1];
          q[index - 1] = q[index];
          q[index] = temp;
          swaps++;
        } else if ((index - 2) >= 0 && q[index - 2] == (index + 1)) {
          // making sure not 'out of bounds' and...
          // that the second preceding number is what belongs here
          int temp = q[index - 2];
          q[index - 2] = q[index - 1];
          q[index - 1] = q[index];
          q[index] = temp;
          swaps += 2;
        } else {
          System.out.println("Too chaotic");
          return;
        }
      }
    }
    System.out.println(swaps);
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    // MY TESTING
//    int[] q = {1,2,3,5,4,6,7,8}; // 1
//    int[] q = {4,1,2,3}; // Too chaotic
//    minimumBribes(q);

    // HACKERRANK CODE
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] q = new int[n];

      String[] qItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int qItem = Integer.parseInt(qItems[i]);
        q[i] = qItem;
      }

      minimumBribes(q);
    }

    scanner.close();
  }
}
