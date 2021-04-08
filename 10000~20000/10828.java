import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int testNum = input.nextInt();
		Stack st = new Stack();
		for (int i = 0; i < testNum; i++) {
			String s = input.next();
			if (s.equals("push")) {
				int num = input.nextInt();
				st.push(num);
			} else if (s.equals("pop")) {
				System.out.println(st.pop());
			} else if (s.equals("size")) {
				System.out.println(st.size());
			} else if (s.equals("empty")) {
				System.out.println(st.empty());
			} else if (s.equals("top")) {
				System.out.println(st.top());
			}
		}
	}
}

class Stack {
	int size = 0;
	Node head;

	class Node {
		int number;
		Node next = null;

		public Node(int n) {
			number = n;
		}
	}

	public void push(int n) {
		if (head == null)
			head = new Node(n);
		else {
			Node nxtNode = new Node(n);
			nxtNode.next = head;
			head = nxtNode;
		}
		size++;
	}

	public int pop() {
		if (head == null)
			return -1;
		else {
			int num = head.number;
			head = head.next;
			size--;
			return num;
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

	public int top() {
		if (head == null)
			return -1;
		else
			return head.number;
	}
}
