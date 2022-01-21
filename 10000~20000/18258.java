package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 앞 뒤의 정수를 출력할 수 있는 큐를 만드는 문제
 */
public class Main {

	/**
	 * 구현을 간단하게 하기 위해 배열을 사용하여 구현한다.
	 * 입력값이 작아 가능한 경우
	 * 입력값이 크면 LinkedList방식으로 구현해야 한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Queue q = new Queue(n);
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("push")) {
				q.add(Integer.parseInt(st.nextToken()));
			} else {
				if (command.equals("pop"))
					sb.append(q.pop());
				else if (command.equals("size"))
					sb.append(q.size());
				else if (command.equals("empty"))
					sb.append(q.isEmpty() ? 1 : 0);
				else if (command.equals("front"))
					sb.append(q.front());
				else if (command.equals("back"))
					sb.append(q.back());
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}

class Queue {
	int[] arr;
	int first = 0;
	int last = 0;

	public Queue(int n) {
		arr = new int[n];
	}

	void add(int n) {
		arr[last++] = n;
	}

	int pop() {
		if (first < last)
			return arr[first++];
		return -1;
	}

	boolean isEmpty() {
		return first == last;
	}

	int size() {
		return last - first;
	}

	int front() {
		if (isEmpty())
			return -1;
		return arr[first];
	}

	int back() {
		if (isEmpty())
			return -1;
		return arr[last - 1];
	}
}