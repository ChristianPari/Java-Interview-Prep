import java.util.*;

public class hash_tables_ice_cream_parlor {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int trips = sc.nextInt();
    int counter = 0;
    while (counter++ < trips) {
      int money = sc.nextInt();
      sc.nextLine();
      String[] input = sc.nextLine().split(" ");
      List<Integer> cost = new ArrayList<>();
      for (String i : input) {
        cost.add(Integer.parseInt(i));
      }
      whatFlavors(cost, money);
    }
  }

  private static void whatFlavors(List<Integer> cost, int money) {
    HashMap<Integer, Integer> pairs = new HashMap<>();

    for (int index = 0; index < cost.size(); index++) {
      int price = cost.get(index);
      int needed =  money - price;
      if (needed > 0 && pairs.containsKey(needed)) {
        int comparingID = pairs.get(needed);
        int smaller = Math.min(index, comparingID);
        int larger = Math.max(index, comparingID);
        System.out.println((smaller + 1) + " " + (larger + 1));
        return;
      }
      pairs.put(price, index);
    }
  }
}
