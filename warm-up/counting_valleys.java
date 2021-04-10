/*
An avid hiker keeps meticulous records of their hikes.
During the last hike that took exactly (steps) steps, for every step it was noted if it was an uphill, (U), or a downhill, (D) step.
Hikes always start and end at sea level, and each step up or down represents a (1) unit change in altitude.

We define the following terms:

    A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
    A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.

Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class counting_valleys {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int Solution(
      int steps
      , String path
    ) {
      // example: path = [DDUUUUDD]
      // starts with D -> entered valley, U -> climbing hill
      // have 2 variables: aboveSea, belowSea
      // depending on start begin increasing a variable and then decrease with opposite until reach sea level / 0
      // have valleys variable to count each time a valley is exited
      int valleys = 0;
      int counter = 0;
      String[] path_arr = path.split("");

      for (String dir : path_arr) {
        int cur_level = counter;

        if (dir.equals("U")) {
          counter += 1;
        } else {
          counter -= 1;
        }

        if (counter == 0 && cur_level < 0) {
          valleys += 1;
        }
      }

      return valleys;
    }

    public static void main(String[] args) throws IOException {
      // MY TESTING
//      int result = Solution(8, "UDDDUDUU");
//      System.out.println(result);

      // HACKERRANK CODE
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int steps = Integer.parseInt(bufferedReader.readLine().trim());

      String path = bufferedReader.readLine();

      int result = counting_valleys.Solution(steps, path);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedReader.close();
//      bufferedWriter.close();
    }

}
