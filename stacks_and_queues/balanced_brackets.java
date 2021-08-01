import java.util.*;

public class balanced_brackets {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int runTimes = sc.nextInt();
    List<String> qs = new ArrayList<>();
    int count = 0;
    while (count++ < runTimes) {
      String str = sc.next();
      qs.add(str);
    }
    sc.close();
    count = 0;
    while (count < runTimes) {
      System.out.println(isBalanced(qs.get(count++)));
    }
  }

  private static String isBalanced(String s) {
    HashMap<Character, Character> pairs = new HashMap<>();
    pairs.put('(', ')');
    pairs.put('[', ']');
    pairs.put('{', '}');

    char bracket = s.charAt(0);
    if (pairs.containsValue(bracket)) {
      return "NO";
    }

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char curB = s.charAt(i);
      if (pairs.containsKey(curB)) {
        stack.add(curB);
      } else {
        if (stack.empty()) {
          return "NO";
        }
        char top = stack.peek();
        char mustBe = pairs.get(top);
        if (curB != mustBe) {
          return "NO";
        } else {
          stack.pop();
        }
      }
    }

    if (!stack.empty())
      return "NO";

    return "YES";
  }
}
