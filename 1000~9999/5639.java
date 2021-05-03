package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이진 검색 트리가 주어진다.
 * 이 트리의 전위 순회한 결과가 주어질 때 후위 순회 결과를 구하는 문제
 * 전위 순회 (루트-왼쪽-오른쪽)
 * 후위 순회(왼쪽-오른쪽-루트)
 * @author Rave
 *
 */
public class Main {

	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Tree tree = new Tree();
		String input = "";
		// 들어온 순서대로 트리에 추가한다.
		while ((input = br.readLine()) != null)
			tree.add(Integer.parseInt(input));
		postTraversal(tree.root);
		System.out.print(sb);
	}

	/**
	 * 재귀 호출을 사용하여 트리의 후위 순회한 결과를 구하는 메소드
	 * @param cur 현재 노드
	 */
	public static void postTraversal(Node cur) {
		if (cur == null)
			return;
		postTraversal(cur.left);
		postTraversal(cur.right);
		sb.append(cur.value + "\n");
	}
}

class Tree {
	Node root;

	public void add(int value) {
		if (root == null) {
			root = new Node(value);
			return;
		}
		Node it = root;
		while (it != null) {
			if (value > it.value) {
				if (it.right == null) {
					it.right = new Node(value);
					return;
				} else
					it = it.right;
			} else {
				if (it.left == null) {
					it.left = new Node(value);
					return;
				} else
					it = it.left;
			}
		}
	}
}

class Node {
	int value;
	Node left, right;

	public Node(int _value) {
		this.value = _value;
	}

	public String toString() {
		return value + "";
	}
}