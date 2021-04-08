import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int testNum = input.nextInt();
		Stack st;
		for (int i = 0; i < testNum; i++) {
			st = new Stack();
			String s = input.next();
			String[] splPS = s.split("");
			boolean done = true;
			for(int j=0; j<s.length(); j++) {
				if(splPS[j].equals("("))
					st.push(splPS[j]);
				else if(splPS[j].equals(")")) {
					if(st.empty()) {
						done = false;
						break;
					}
					else
						st.pop();
				}
			}
			if(!st.empty())
				done = false;
			if(done)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}

class Stack {
	int size = 0;
	Node head;

	class Node {
		String ps;
		Node next = null;

		public Node(String s) {
			ps = s;
		}
	}

	public void push(String s) {
		if (head == null)
			head = new Node(s);
		else {
			Node nxtNode = new Node(s);
			nxtNode.next = head;
			head = nxtNode;
		}
		size++;
	}

	public void pop() {
		if (head != null) {
			head = head.next;
			size--;
		}
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		if (size == 0)
			return true;
		else
			return false;
	}
}
