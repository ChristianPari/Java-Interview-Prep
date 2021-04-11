/*
There is a string, (s), of lowercase English letters that is repeated infinitely many times.
Given an integer, (n), find and print the number of letter a's in the first letters of the infinite string.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class repeated_string {
  // Complete the repeatedString function below.
  static long repeatedString(
    String s
    , long n
  ) {
    if (s.matches("^[a]*$")) return n; // string is only [a]'s
    long divisibleBy = n / s.length();
    int leftover = (int) (n % s.length());
    int onlyA = s.replaceAll("[^a]", "").length();
    long totalA = onlyA * divisibleBy;
    int aLeftover = s.substring(0, leftover).replaceAll("[^a]", "").length();
    return totalA + aLeftover;

    // NOT THE BEST SOLUTION, WORKS BUT TO SLOW
//    String repeated = "";
//    while (repeated.length() < n) {
//      repeated += s;
//    }
//    if (repeated.length() > n) {
//      repeated = repeated.substring(0, (int) n);
//    }
//
//    return repeated.replaceAll("[^a]", "").length();
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    // MY TESTING
    System.out.println(repeatedString("aba", 10));

    // HACKERRANK CODE
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//    String s = scanner.nextLine();
//
//    long n = scanner.nextLong();
//    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    long result = repeatedString(s, n);
//
//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();
//
//    bufferedWriter.close();
//
//    scanner.close();
  }
}
