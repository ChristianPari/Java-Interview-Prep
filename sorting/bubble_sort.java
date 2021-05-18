/*
Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm above. Once sorted, print the following three lines:

   1) Array is sorted in numSwaps swaps., where (numSwaps) is the number of swaps that took place.

   2) First Element: firstElement, where (firstElement) is the first element in the sorted array.

   3) Last Element: lastElement, where (lastElement) is the last element in the sorted array.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'countSwaps' function below.
   *
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static void countSwaps(List<Integer> a) {
    // Write your code here
    int swaps = 0;
    int length = a.size();
    int counter = 0;
    while (counter++ < length) {
      for (int index = 0; index < length - 1; index++) {
        int current = a.get(index);
        int next = a.get(index + 1);
        if (current > next) {
          a.set(index, next);
          a.set(index + 1, current);
          swaps++;
        }
      }
    }
    System.out.println("Array is sorted in " + swaps + " swaps.");
    System.out.println("First Element: " + a.get(0));
    System.out.println("Last Element: " + a.get(length - 1));
  }
}

public class bubble_sort {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    Result.countSwaps(a);

    bufferedReader.close();
  }
}
