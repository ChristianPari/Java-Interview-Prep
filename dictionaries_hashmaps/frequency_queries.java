/*
You are given queries. Each query is of the form two integers described below:
- 1:x Insert x in your data structure.
- 2:y Delete one occurence of y from your data structure, if present.
- 3:z Check if any integer is present whose frequency is exactly (z). If yes, print 1 else 0.

The queries are given in the form of a 2-D array (queries) of size (q) where (queries[i][0]) contains the operation,
  and (queries[i][1]) contains the data element.
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

public class frequency_queries {

  // Complete the freqQuery function below.
  static List<Integer> freqQuery(List<List<Integer>> queries) {
    HashMap<Integer, Integer> freqs = new HashMap<>();
    List<Integer> output = new ArrayList<>();

    for (List<Integer> query : queries) {
      int task = query.get(0);
      int index1 = query.get(1);

      switch (task) {
        case 1:
          if (freqs.containsKey(index1))
            freqs.replace(index1, freqs.get(index1) + 1);
          else
            freqs.put(index1, 1);
          break;

        case 2:
          if (freqs.containsKey(index1))
            freqs.replace(index1, freqs.get(index1) - 1);
          break;

        case 3:
          int response = freqs.containsValue(index1) == true ? 1 : 0;
          output.add(response);
          break;
      }
    }

    return output;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, q).forEach(i -> {
      try {
        queries.add(
          Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    List<Integer> ans = freqQuery(queries);

    bufferedWriter.write(
      ans.stream()
        .map(Object::toString)
        .collect(joining("\n"))
        + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
