import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = "";
		while ((line = br.readLine()) != null) {
			int t = Integer.parseInt(line);
			Trie trie = new Trie();
			String[] keySet = new String[t];
			for (int i = 0; i < t; i++) {
				keySet[i] = br.readLine();
				trie.add(keySet[i]);
			}
			long answer = 0;
			for (String item : keySet)
				answer += trie.findAnswer(item);
			sb.append(String.format("%.2f", Math.round((answer / (double) t) * 100.0) / 100.0) + "\n");
		}
		System.out.print(sb);
	}
}

class Trie {
	HashMap<Character, Trie> hash = new HashMap<>();
	boolean isEnd = false;

	public void add(String str) {
		Trie cur = this;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			cur.hash.putIfAbsent(ch, new Trie());
			cur = cur.hash.get(ch);
		}
		cur.isEnd = true;
	}

	public int findAnswer(String str) {
		int cnt = 1;
		Trie cur = hash.get(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			if (cur.hash.size() > 1 || (cur.isEnd && cur.hash.size() != 0))
				cnt++;
			char ch = str.charAt(i);
			cur = cur.hash.get(ch);
		}
		return cnt;
	}
}
