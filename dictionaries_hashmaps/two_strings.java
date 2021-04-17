/*
Given two strings, determine if they share a common substring.
A substring may be as small as one character.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class two_strings {
  // Complete the twoStrings function below.
  static String twoStrings(String s1, String s2) {
    String[] alpha = "abcdefghijklmnopqrstuvwxyz".split("");
    for (String letter : alpha) {
      if (s1.contains(letter) && s2.contains(letter))
        return "YES";
    }
    return "NO";

    // TIME LIMIT EXCEEDED
//    for (String letter : s1.split("")) {
//      if (s2.contains(letter)) {
//        return "YES";
//      }
//    }
//
//    return "NO";

    // TIME LIMIT EXCEEDED
//    String[] s1Array = s1.split("");
//    int length = s1Array.length;
//
//    for (int index = 0; index < length; index++) {
//      if (index == length - 1 ) {
//        if (s2.contains(s1Array[index])) {
//          return "YES";
//        } else {
//          continue;
//        }
//      }
//
//      if (s2.contains(s1Array[index])) {
//          return "YES";
//        }
//      }
//    return "NO";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s1 = scanner.nextLine();

      String s2 = scanner.nextLine();

      String result = twoStrings(s1, s2);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
