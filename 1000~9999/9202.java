package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * N개의 단어가 주어진다.
 * 4x4 크기의 알파벳 대문자가 쓰여진 보드가 있다.
 * 이 보드에서 가로, 세로, 대각선의 알파벳을 이어 단어를 만들 수 있다.
 * 이 단어가 사전에 주어진 단어인 경우만 올바른 단어로 인정한다.
 * 각 단어의 길이마다 점수가 다른데 1 = 0, 2 = 0, 3 = 1, 4 = 1, 5 = 2, 6 = 3, 7 = 5, 8 = 11점이다.
 * 사전의 단어들과 보드가 주어질 때, 얻을 수 있는 최대 점수, 가장 긴 단어, 찾은 단어의 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 트라이를 사용하여 단어를 사전에 등록해둔다.
	 * 이후 배열에서 단어에 등록된 알파벳들을 순서대로 따라가본다.
	 * 사전에 주어진 단어이고, 아직 찾지 못한 단어이면 점수를 추가하고, 개수를 증가시키고, 가장 긴 단어이면서 사전 순으로 빠른 단어인지 확인한다.
	 * 
	 * visited를 안하고 dfs 돌아가지고 왔던데 또 갔던 것 같음..(이런 초보적인 실수를..)
	 * 하고 돌리니 거의 동일한 로직에서 잘 돌아감
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int w = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		while (w-- > 0)
			trie.add(br.readLine());
		br.readLine();
		int b = Integer.parseInt(br.readLine());
		while (b-- > 0) {
			char[][] map = new char[4][4];
			for (int i = 0; i < map.length; i++) {
				String line = br.readLine();
				for (int j = 0; j < map.length; j++)
					map[i][j] = line.charAt(j);
			}
			if (b > 0)
				br.readLine();
			trie.init(map);
			answer.append(trie.solution());
			trie.clearHit();
		}
		System.out.print(answer);
	}
}

class Trie {
	private Node root = new Node();
	private int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	private int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
	private int[] scoreBoard = { 0, 0, 0, 1, 1, 2, 3, 5, 11 };
	private char[][] map;
	private boolean[][] visited;
	private int score, count;
	private String maxWord;
	private HashSet<String> selected = new HashSet<>();

	void add(String str) {
		Node cur = root;
		for (char ch : str.toCharArray())
			cur = cur.hash.computeIfAbsent(ch, k -> new Node());
		cur.isEnd = true;
	}

	void init(char[][] map) {
		this.map = map;
		visited = new boolean[map.length][map[0].length];
		score = 0;
		count = 0;
		maxWord = "";
	}

	String solution() {
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[i].length; j++)
				if (root.hasChild(map[i][j]))
					dfs(i, j, root.getChild(map[i][j]), map[i][j] + "");
		return String.format("%d %s %d\n", score, maxWord, count);
	}

	void dfs(int x, int y, Node cur, String result) {
		visited[x][y] = true;
		if (cur.isEnd && !cur.isHit) {
			cur.isHit = true;
			score += scoreBoard[result.length()];
			count++;
			if (compare(result, maxWord) < 0)
				maxWord = result;
		}

		for (int i = 0; i < dx.length; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			try {
				if (visited[nextX][nextY] || !cur.hasChild(map[nextX][nextY]))
					continue;
				dfs(nextX, nextY, cur.getChild(map[nextX][nextY]), result + map[nextX][nextY]);
			} catch (ArrayIndexOutOfBoundsException e) {

			}
		}
		visited[x][y] = false;
	}

	void clearHit() {
		root.clearHit();
	}

	int compare(String s1, String s2) {
		if (s1.length() == s2.length())
			return s1.compareTo(s2);
		return Integer.compare(s2.length(), s1.length());
	}
}

class Node {
	boolean isEnd = false, isHit = false;
	Map<Character, Node> hash = new HashMap<>();

	boolean hasChild(char c) {
		return hash.containsKey(c);
	}

	Node getChild(char c) {
		return hash.get(c);
	}

	void clearHit() {
		isHit = false;
		for (char key : hash.keySet())
			hash.get(key).clearHit();
	}

	@Override
	public String toString() {
		return "Node [isEnd=" + isEnd + ", isHit=" + isHit + ", hash=" + hash + "]";
	}
}