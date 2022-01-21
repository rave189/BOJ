package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ���ο� ��� AC�� ����� ����
 * AC���� R(������)�� D(������)�� �ִ�.
 * R�� �迭�� ������ ������ �Լ��̰� D�� ù ��°�� ������ �Լ��̴�.
 * �迭�� ����ִµ� D�� ����ϸ� ������ �߻��Ѵ�.
 * �Լ��� �����ؼ� �ѹ��� RDD�� ���� ����� �� �ִ�.
 * �迭�� �ʱⰪ�� �Լ��� �־����� ��, ���� ����� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���� ����Ͽ� Ǫ�� ����
	 * ������ ������ boolean�� ����Ͽ� true�� head���� Ž��, false�� tail���� Ž������ �Ѵ�.
	 * ������� true�̸� �տ��� ����, false�̸� �ڿ��� ����.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		Deque dq;
		int n = Integer.parseInt(br.readLine());
		start: for (int i = 0; i < n; i++) {
			dq = new Deque();
			String command = br.readLine();
			int num = Integer.parseInt(br.readLine());
			String item = br.readLine();
			String[] arr = item.substring(1, item.length() - 1).split(",");
			for (int j = 0; j < num; j++)
				dq.addLast(Integer.parseInt(arr[j]));
			boolean direction = true;
			for (int j = 0; j < command.length(); j++) {
				if (command.charAt(j) == 'R') {
					direction = direction ? false : true;
				} else {
					int check = direction ? dq.removeFirst() : dq.removeLast();
					if (check < 0) {
						answer.append("error").append('\n');
						continue start;
					}
				}
			}
			answer.append(dq.toString(direction)).append('\n');
		}
		System.out.print(answer);
	}
}

class Deque {
	private Node head;
	private Node tail;
	private int size;

	public Deque() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addFirst(int item) {
		if (head == null) {
			head = new Node(item);
			tail = head;
		} else {
			Node newNode = new Node(item);
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}

	public void addLast(int item) {
		if (head == null) {
			head = new Node(item);
			tail = head;
		} else {
			Node newNode = new Node(item);
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}

	public int removeFirst() {
		int value;
		if (head == null)
			value = -1;
		else {
			value = head.item;
			head = head.next;
			if (head == null)
				tail = null;
			else
				head.prev = null;
		}
		size--;
		return value;
	}

	public int removeLast() {
		int value;
		if (tail == null)
			value = -1;
		else {
			value = tail.item;
			tail = tail.prev;
			if (tail == null)
				head = null;
			else
				tail.next = null;
		}
		size--;
		return value;
	}

	public int getFirst() {
		return size == 0 ? -1 : head.item;
	}

	public int getLast() {
		return size == 0 ? -1 : tail.item;
	}

	public int size() {
		return size;
	}

	public String toString(boolean direction) {
		Node it = direction ? head : tail;
		StringBuilder result = new StringBuilder("[");
		while (it != null) {
			if (direction) {
				result.append(it.item);
				if (it.next != null)
					result.append(',');
				it = it.next;
			} else {
				result.append(it.item);
				if (it.prev != null)
					result.append(',');
				it = it.prev;
			}
		}
		return result.append(']').toString();
	}
}

class Node {
	Node next;
	Node prev;
	int item;

	public Node(int item) {
		next = null;
		prev = null;
		this.item = item;
	}
}