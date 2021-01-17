import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Trie trie = new Trie();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String[] line = new String[num];
			for (int j = 0; j < num; j++)
				line[j] = st.nextToken();
			trie.Add(line);
		}
		Set<Entry<String, Node>> entry = trie.head.childNode.entrySet();
		Search(entry, 0);
		System.out.print(sb);
	}

	public static void Search(Set<Entry<String, Node>> entry, int repeat) {
		PriorityQueue<Entry<String, Node>> pq = new PriorityQueue<Entry<String, Node>>(
				(arg0, arg1) -> arg0.getKey().compareTo(arg1.getKey()));
		pq.addAll(entry);
		while (!pq.isEmpty()) {
			Entry<String, Node> value = pq.poll();
			for (int i = 0; i < repeat; i++)
				sb.append("--");
			sb.append(value.getKey() + "\n");
			Search(value.getValue().childNode.entrySet(), repeat + 1);
		}
	}
}

class Trie {
	Node head;

	public Trie() {
		head = new Node();
	}

	public void Add(String[] str) {
		Node cur = head;
		for (int i = 0; i < str.length; i++)
			cur = cur.childNode.computeIfAbsent(str[i], c -> new Node());
	}
}

class Node {
	HashMap<String, Node> childNode = new HashMap<String, Node>();

	public Node() {
	}

	public String toString() {
		return childNode.toString();
	}
}
