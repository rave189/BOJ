import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	final static int INF = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int vertex = Integer.parseInt(s[0]);
		int edge = Integer.parseInt(s[1]);
		int start = Integer.parseInt(br.readLine());
		LinkedList ll = new LinkedList(vertex);
		int[] distance = new int[vertex];
		for (int i = 0; i < vertex; i++)
			distance[i] = INF;
		for (int i = 0; i < edge; i++) {
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]) - 1;
			int y = Integer.parseInt(s[1]) - 1;
			int weight = Integer.parseInt(s[2]);
			ll.insert(weight, x, y);
		}

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start - 1, 0));
		distance[start - 1] = 0;
		while (!pq.isEmpty()) {
			Node curVertex = pq.poll();
			Node it = ll.search(curVertex.vertex);
			while (it != null) {
				int sum = it.weight + curVertex.weight;
				if (sum < distance[it.vertex]) {
					distance[it.vertex] = sum;
					pq.add(new Node(it.vertex, sum));
				}
				it = it.next;
			}
		}

		for (int i = 0; i < vertex; i++)
			if (distance[i] == INF)
				bw.write("INF\n");
			else
				bw.write(Integer.toString(distance[i]) + "\n");
		bw.flush();
	}
}

class LinkedList {
	Node[] root;

	public LinkedList(int vertex) {
		root = new Node[vertex];
	}

	public void insert(int weight, int x, int y) {
		if (root[x] == null)
			root[x] = new Node(y, weight);
		else {
			Node prev = null;
			Node it = root[x];
			Node newNode = new Node(y, weight);
			while (it != null) {
				if (it.vertex > y) {
					newNode.next = it;
					if (prev == null)
						root[x] = newNode;
					else
						prev.next = newNode;
					break;
				} else if (it.vertex == y) {
					if (it.weight > weight)
						it.weight = weight;
					break;
				}
				prev = it;
				it = it.next;
			}
			if (it == null)
				prev.next = newNode;
		}
	}

	public Node search(int x) {
		if (root[x] == null)
			return null;
		else
			return root[x];
	}
}

class Node implements Comparable<Node> {
	int weight;
	int vertex;
	Node next;

	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
		next = null;
	}

	public int compareTo(Node obj) {
		if (this.weight == obj.weight)
			return 0;
		else if (this.weight < obj.weight)
			return -1;
		else
			return 1;
	}
}
