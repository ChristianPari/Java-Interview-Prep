import java.util.*;

public class queues_tale_of_two_stacks {
  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();
      if (operation == 1) { // enqueue
        queue.enqueue(scan.nextInt());
      } else if (operation == 2) { // dequeue
        queue.dequeue();
      } else if (operation == 3) { // print/peek
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }
}

class MyQueue<T> {
  List<T> q = new ArrayList<>();

  public void enqueue(T param) { q.add(param); }

  public T dequeue() { return q.remove(0); }

  public T peek() { return q.get(0); }
}