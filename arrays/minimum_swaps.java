/*
You are given an unordered array consisting of consecutive integers [1, 2, 3, ..., n] without any duplicates.
You are allowed to swap any two elements.
Find the minimum number of swaps required to sort the array in ascending order.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class minimum_swaps {
  // Complete the minimumSwaps function below.
  static int minimumSwaps(int[] arr) {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    for (int index = 0; index < arr.length; index++) {
      treeMap.put(arr[index], index);
      /*
      arr = [2,3,1,4,5]
      k = array index value, v = index of num
      { {2,0}, {3,1}, {1,2}, {4,3}, {5,4} }
       */
    }

    int index = 0;
    int swaps = 0;
    while (index < arr.length) {
      int smallestNum = treeMap.firstKey(); // smallest num becomes (1)
      if (arr[index] != smallestNum) {
        swaps++;

        int targetIndex = treeMap.get(smallestNum); // gets index referenced to smallest num within the tree
        int temp = arr[index]; // gets the number that is currently in the wrong location of the current index
        arr[index] = smallestNum; // assigns the correct number
        arr[targetIndex] = temp; // assigns the numbered remove from the index to the previous index

        treeMap.put(temp, targetIndex); // reassigns the wrong located number with updated index
      }

      index++;
      treeMap.remove(smallestNum); // removes the key/value of the smallest num bc it is now in the correct position
      // loop continues until all is reordered
    }

      // STILL TOO SLOW
//    List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
//    for (int index = arrList.size() - 1; index >= 0; index--) {
//      if (arrList.get(index) != (index + 1)) {
//        int shouldBe = index + 1;
//        int foundIndex = arrList.indexOf(shouldBe);
//        int temp = arrList.get(index);
//        arrList.set(index, arrList.get(foundIndex));
//        arrList.set(foundIndex, temp);
//        swaps++;
//    }
//  }

        // TOO SLOW
//        for (int id = arrList.size() - 1; id >= 0; id--) {
//          if (arr[id] == shouldBe) {
//            int temp = arr[index];
//            arr[index] = arr[id];
//            arr[id] = temp;
//            swaps++;
//          }
//        }

    return swaps;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    // MY TESTING
//    int[] arr = {2, 3, 4, 1, 5};
//    int result = minimumSwaps(arr);
//    System.out.println(result);

    // HACKERRANK CODE
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int res = minimumSwaps(arr);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
