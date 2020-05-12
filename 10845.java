import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		Queue q = new Queue();
		for (int i = 0; i < number; i++) {
			String s = input.next();
			if (s.equals("push"))
				q.push(input.nextInt());
			else if (s.equals("pop"))
				System.out.println(q.pop());
			else if (s.equals("size"))
				System.out.println(q.size());
			else if (s.equals("empty"))
				System.out.println(q.empty());
			else if (s.equals("front"))
				System.out.println(q.front());
			else if (s.equals("back"))
				System.out.println(q.back());
		}
	}
}

class Queue {
	class Node {
		int item;
		Node next;

		public Node(int n) {
			item = n;
			next = null;
		}
	}

	private int size = 0;
	private Node head;
	private Node back;

	public void push(int n) {
		if (head == null) {
			head = new Node(n);
			back = head;
		} else {
			Node nxt = new Node(n);
			back.next = nxt;
			back = nxt;
		}
		size++;
	}

	public int pop() {
		if (head == null)
			return -1;
		else {
			int temp = head.item;
			head = head.next;
			size--;
			return temp;
		}
	}

	public int size() {
		return size;
	}

	public int empty() {
		if (size == 0)
			return 1;
		else
			return 0;
	}

	public int front() {
		if (size != 0)
			return head.item;
		else
			return -1;
	}

	public int back() {
		if (size != 0)
			return back.item;
		else
			return -1;
	}
}
