/*
You are given an array and you need to find number of tripets of indices (i, j, k)
  such that the elements at those indices are in geometric progression for a given common ratio (r) and (i < j < k).
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class count_triplets {
  // have to be able to search through the array until a member of the triplet is found

  // create a total int var that will numerate each time a triplet is found
  // create a for loop for arr
    // each iteration will search for triplets
      // create 3 variables for each triplet
      // first, grabs num at current index -> stores in first triplet var
      // second, using indexOf -> find the multiplied sequential number, either index or -1
        // if index -> store in second triplet var
        // if -1 -> then there wont be a triplet, continue to next index in arr
      // third (only reached if second isnt -1), repeat second but with the second triplet var as the num being multiplied by r
        //
      // check if any other instances of first before second, second before third

  // Complete the countTriplets function below.
  static long countTriplets(List<Long> arr, long r) {
    int arrSize = arr.size();
    if (arrSize < 3) return 0;

    HashMap<Long, Integer> freqs = new HashMap<>();
    for (Long num : arr) {
      freqs.put(num, freqs.get(num) == null ? 1 : freqs.get(num) + 1);
    }

    int freqSize = freqs.size();

    int triplets = 0;

    if (freqSize == 1) {
      int top = arrSize;
      int next = arrSize - 1;
      int third = arrSize - 2;

      while (top > 2) {
        triplets++;
        if (third > 1) {
          third--;
        } else {
          if (next > 2) {
            next--;
            third = next - 1;
          } else {
            top--;
            next = top - 1;
            third = top - 2;
          }
        }
      }
      return triplets;
    }

    NavigableSet<Long> tree = new TreeSet<>(arr).descendingSet();
    Iterator<Long> iterator = tree.iterator();
    while (iterator.hasNext()) {
      long current = iterator.next();
      long second = current / r;
      long third = second / r;

      if (
        (freqs.containsKey(second) && freqs.get(second) >= 1)
          &&
          (freqs.containsKey(third) && freqs.get(third) >= 1)
      ) {
        triplets++;
        int currents = freqs.get(current) - 1;
        int seconds = freqs.get(second) - 1;
        int thirds = freqs.get(third) - 1;
        triplets += (currents + seconds + thirds);
      }
    }

    return triplets;
//    int total = 0;
//    int arr_size = arr.size();
//    List<Long> dup = new ArrayList<>(arr);
//    for (int index = 0; index < arr_size; index++) {
//      long cur = arr.get(index);
//      long second = 0;
//      long third = 0;
//      int seconds = 0;
//      int thirds = 0;
//      int counter = index += 1;
//      while (counter < arr_size - 1) {
//        long next = arr.get(counter);
//        if ((cur * r) != next) {
//          counter++;
//        } else {
//          second = next;
//          break;
//        }
//      }
//      if (second == 0) {
//        continue;
//      }
//      counter = arr.indexOf(second) + 1;
//      while (counter < arr_size) {
//        long next = arr.get(counter);
//        if ((second * r) != next) {
//          counter++;
//        } else {
//          third = next;
//          break;
//        }
//      }
//      if (third == 0) {
//        continue;
//      }
//      int index_of_third = dup.indexOf(third);
//      dup.remove(index_of_third);
//      thirds += 1;
//      while (dup.contains(third)) {
//        index_of_third = dup.indexOf(third) + thirds;
//        thirds += 1;
//        dup.remove(third);
//      }
//      int index_of_second = dup.indexOf(second);
//      dup.remove(index_of_second);
//      seconds += 1;
//      while (dup.contains(second) && (index_of_second < index_of_third)) {
//        index_of_second = dup.indexOf(second) + seconds;
//        seconds += 1;
//        dup.remove(second);
//      }
//
//      total += (seconds * thirds);
//    }
//
//    return total;

//    long totalTriplets = 0;
//    for (int index = 0; index < arr.size() - 2; index++) {
//      long firstTrip = arr.get(index);
//      System.out.println("first: " + firstTrip);
//      long secondTripIndex = indexOf(firstTrip * r, arr, index);
//      long secondTripNum = arr.get((int) secondTripIndex);
//      System.out.println("second: " + secondTripIndex);
//      long thirdTripIndex = -1;
//
//      if (secondTripIndex != -1)
//        thirdTripIndex = indexOf(secondTripNum * r, arr, index);
//      else
//        continue;
//
//      System.out.println("third: " + thirdTripIndex);
//
//      if (thirdTripIndex != -1)
//        totalTriplets += 1;
//      else
//        continue;
//
//      long thirdTripNum = arr.get((int) thirdTripIndex);
//
//      System.out.println("total: " + totalTriplets);
//
//      // CHECKING FOR POSSIBLE MORE TRIPLETS IN FUTURE
//      long extraThirds = indexOf(thirdTripNum, arr, (int) thirdTripIndex + 1);
//      System.out.println("extra third index: " + extraThirds);
//      while (extraThirds < arr.size() && extraThirds != -1) {
//        totalTriplets += 1;
//        long newIndex = indexOf(arr.get((int) extraThirds), arr, (int) extraThirds + 1);
//        if (newIndex == -1) {
//          break;
//        } else {
//          extraThirds = newIndex;
//        }
//      }
//
//      long extraSeconds = indexOf(secondTripNum, arr, (int) secondTripIndex + 1);
//      System.out.println("extra second index: " + extraSeconds);
//        while (extraSeconds < (Math.max(extraThirds, thirdTripIndex)) && extraSeconds != -1) {
//          totalTriplets += 1;
//          extraSeconds = indexOf(arr.get((int) extraSeconds), arr, (int) extraSeconds + 1);
//        }
//
//      System.out.println("\n##### FINISHED ITERATION #####\n");
//    }
//
//    return totalTriplets;
  }

  // SELF CREATED METHODS
//  static long indexOf(Long o, List<Long> arr, int fromIndex) {
//    return indexOfRange(o, arr.size(), arr, fromIndex);
//  }
//
//  static int indexOfRange(Long o, int end, List<Long> arr, int fromIndex) {
//    if (fromIndex < 0)
//      fromIndex = 0;
//    if (fromIndex >= end)
//      return -1;
//
//    if (o == null) {
//      for (int i = fromIndex; i < end; i++) {
//        if (arr.get(i) == null) {
//          return i;
//        }
//      }
//    } else {
//      for (int i = fromIndex; i < end; i++) {
//        if (o.equals((arr.get(i)))) {
//          return i;
//        }
//      }
//    }
//
//    return -1;
//  }


  public static void main(String[] args) throws IOException {
//    List<Long> arr = Arrays.asList(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L
//      , 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
//      1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);
//    long r = 1;
//    long ans = countTriplets(arr, r);
//    System.out.println(ans);
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//    String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//    int n = Integer.parseInt(nr[0]);
//
//    long r = Long.parseLong(nr[1]);
//
//    List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//      .map(Long::parseLong)
//      .collect(toList());
//
//    long ans = countTriplets(arr, r);
//
//    bufferedWriter.write(String.valueOf(ans));
//    bufferedWriter.newLine();
//
//    bufferedReader.close();
//    bufferedWriter.close();
  }
}
