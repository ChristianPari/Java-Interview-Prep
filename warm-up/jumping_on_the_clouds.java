/*
There is a new mobile game that starts with consecutively numbered clouds.
Some of the clouds are thunderheads and others are cumulus.
The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus (1) or (2).
The player must avoid the thunderheads.
Determine the minimum number of jumps it will take to jump from the starting postion to the last cloud.
It is always possible to win the game.

For each game, you will get an array of clouds numbered (0) if they are safe or (1) if they must be avoided.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class jumping_on_the_clouds {

  // Complete the jumpingOnClouds function below.
  static int jumpingOnClouds(int[] clouds) {
    // can jump from current cloud to +1 or +2 clouds, c1 c2 c3 c4 -> jump from c1 to c2 or c3, c4 is too far
    int jumps = 0;
    for (int id = 0; id < clouds.length; id++) {
      int curCloud = clouds[id];
      int nextCloud = id < clouds.length - 1 ? clouds[id + 1] : -1;
      int nextNextCloud = id < clouds.length - 2 ? clouds[id + 2] : -1;

      if (curCloud == 1) continue; // skip thunder clouds
      if (nextCloud == -1) break; // ends loop bc nextCloud would be out of range

      if (nextCloud == curCloud && nextNextCloud == curCloud) {
        jumps += 1;
        id += 1;
      }
      if (nextCloud != curCloud) {
        jumps += 1;
        id += 1;
      }
      if (nextCloud == curCloud && nextNextCloud != curCloud) {
        jumps += 1;
      }
    }

    return jumps;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    // MY TESTING
//    int[] clouds = {0, 1, 0, 0, 0, 1, 0};
//    int result = jumpingOnClouds(clouds);
//    System.out.println(result);

    // HACKERRANK CODE
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] c = new int[n];

    String[] cItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int cItem = Integer.parseInt(cItems[i]);
      c[i] = cItem;
    }

    int result = jumpingOnClouds(c);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
