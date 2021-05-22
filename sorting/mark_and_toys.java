/*
Mark and Jane are very happy after having their first child.
Their son loves toys, so Mark wants to buy some.
There are a number of different toys lying in front of him,
  tagged with their prices.
Mark has only a certain amount to spend,
  and he wants to maximize the number of toys he buys with this money.
Given a list of toy prices and an amount to spend,
  determine the maximum number of gifts he can buy.
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

class Result2 {

  /*
   * Complete the 'maximumToys' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY prices
   *  2. INTEGER k
   */

  public static int maximumToys(List<Integer> prices, int k) {
    // Write your code here
    Collections.sort(prices);
    int total = 0;
    int index = 0;
    while (total <= k) {
      total += prices.get(index);
      index++;
    }
    return index;
  }

}

public class mark_and_toys {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    int result = Result2.maximumToys(prices, k);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
