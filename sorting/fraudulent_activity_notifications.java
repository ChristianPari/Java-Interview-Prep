/*
HackerLand National Bank has a simple policy for warning clients about possible
  fraudulent account activity.
If the amount spent by a client on a particular day is greater than or equal to 2x
  the client's median spending for a trailing number of days,
  they send the client a notification about potential fraud.
The bank doesn't send the client any notifications until they have at least that
  trailing number of prior days' transaction data.
Given the number of trailing days (d) and a client's total daily expenditures for
  a period of (n) days,
  determine the number of times the client will receive a notification over all
  days.
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


class Result3 {

  /*
   * Complete the 'activityNotifications' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY expenditure
   *  2. INTEGER d
   */

  public static int activityNotifications(List<Integer> expenditure, int d) {
    // THIRD ATTEMPT, TIME LIMIT EXCEEDED
    int expenditureSize = expenditure.size();
    if (d == expenditureSize)
      return 0;

    List<Integer> trailing = new ArrayList<>();
    double trailingAmount = 0;
    int notifs = 0;

    int target = expenditureSize - d;
    while (expenditureSize > target) {
      int dayAmount = expenditure.get(0);
      trailing.add(dayAmount);
      trailingAmount += dayAmount;
      expenditure.remove(0);
      expenditureSize = expenditure.size();
    }

    double median = trailingAmount / d;
    double max = median * 2;

    while (expenditureSize > 0) {
      if (expenditure.get(0) >= max) {
        notifs++;
      }
      trailingAmount -= trailing.get(0);
      trailing.remove(0);
      trailingAmount += expenditure.get(0);
      trailing.add(expenditure.get(0));
      expenditure.remove(0);
      expenditureSize = expenditure.size();
      median = trailingAmount / d;
      max = median * 2;
    }

    return notifs;

    // FIRST ATTEMPT, TERMINATED DUE TO TIMEOUTS
//    if (d == expenditure.size())
//      return 0;
//
//    int notifs = 0;
//    double median = 0;
//    for (int index = 0; index < d; index++) {
//      median += expenditure.get(index);
//    }
//    median /= d;
//
//    while (d < expenditure.size()) {
//      int day_amt = expenditure.get(d);
//      System.out.println("day: " + day_amt + ", median: " + (median * 2));
//      expenditure.remove(0);
//      if (day_amt >= (median * 2)) {
//        notifs += 1;
//        notifs += activityNotifications(expenditure, d);
//      }
//    }
//
//    return notifs;

    // SECOND ATTEMPT, DIDNT PASS ALL TEST CASES
//    int notifs = 0;
//    double median = 0;
//    for (int index = 0; index < d; index++) {
//      median += expenditure.get(index);
//    }
//    median /= d;
//
//    if (d > expenditure.size()) {
//      return notifs;
//    }
//
//    int day_amt = expenditure.get(d);
//    expenditure.remove(0);
//    if (day_amt >= (median * 2)) {
//      notifs += 1;
//      notifs += activityNotifications(expenditure, d);
//    }
//
//    return notifs;
  }

}

public class fraudulent_activity_notifications {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int d = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    int result = Result3.activityNotifications(expenditure, d);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
