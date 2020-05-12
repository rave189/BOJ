import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		Deck d = new Deck();
		for (int i = 0; i < number; i++) {
			String s = input.next();
			if (s.equals("push_front"))
				d.push_front(input.nextInt());
			else if (s.equals("push_back"))
				d.push_back(input.nextInt());
			else if (s.equals("pop_front"))
				System.out.println(d.pop_front());
			else if (s.equals("pop_back"))
				System.out.println(d.pop_back());
			else if (s.equals("size"))
				System.out.println(d.size());
			else if (s.equals("empty"))
				System.out.println(d.empty());
			else if (s.equals("front"))
				System.out.println(d.front());
			else if (s.equals("back"))
				System.out.println(d.back());
		}
	}
}

class Deck {
	public class Node {
		int item;
		Node prev;
		Node next;

		public Node(int n) {
			item = n;
			prev = null;
			next = null;
		}
	}

	int size = 0;
	Node head;
	Node back;

	public void push_front(int n) {
		if (head == null) {
			head = new Node(n);
			back = head;
		} else {
			Node nxt = new Node(n);
			nxt.next = head;
			head.prev = nxt;
			head = nxt;
		}
		size++;
	}

	public void push_back(int n) {
		if (back == null) {
			head = new Node(n);
			back = head;
		} else {
			Node nxt = new Node(n);
			back.next = nxt;
			nxt.prev = back;
			back = nxt;
		}
		size++;
	}

	public int pop_front() {
		if (size != 0) {
			int num = head.item;
			if(head.next == null) {
				head = null;
				back = null;
			} else {
				head = head.next;
				head.prev = null;
			}
			size--;
			return num;
		} else
			return -1;
	}

	public int pop_back() {
		if (size != 0) {
			int num = back.item;
			if(back.prev == null) {
				head = null;
				back = null;
			} else {
				back = back.prev;
				back.next = null;
			}
			size--;
			return num;
		} else
			return -1;
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
