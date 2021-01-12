import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			boolean check = true;
			for (int j = 0; j < n; j++) {
				String phone = br.readLine();
				if (check && !trie.Add(phone))
					check = false;
			}
			sb.append(check ? "YES\n" : "NO\n");
		}
		System.out.println(sb);
	}
}

class Trie {
	Node head;

	public Trie() {
		head = new Node();
	}

	public boolean Add(String str) {
		Node cur = head;
		for (int i = 0; i < str.length(); i++) {
			int n = str.charAt(i);
			if(cur.is_end)
				return false;
			cur = cur.childNode.computeIfAbsent(n, c -> new Node());
		}
		if(cur.childNode.size() != 0)
			return false;
		return cur.is_end = true;
	}
}

class Node {
	HashMap<Integer, Node> childNode = new HashMap<Integer, Node>();
	boolean is_end;

	public Node() {
		this.is_end = false;
	}
}
