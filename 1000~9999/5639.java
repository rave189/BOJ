package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ���� �˻� Ʈ���� �־�����.
 * �� Ʈ���� ���� ��ȸ�� ����� �־��� �� ���� ��ȸ ����� ���ϴ� ����
 * ���� ��ȸ (��Ʈ-����-������)
 * ���� ��ȸ(����-������-��Ʈ)
 * @author Rave
 *
 */
public class Main {

	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Tree tree = new Tree();
		String input = "";
		// ���� ������� Ʈ���� �߰��Ѵ�.
		while ((input = br.readLine()) != null)
			tree.add(Integer.parseInt(input));
		postTraversal(tree.root);
		System.out.print(sb);
	}

	/**
	 * ��� ȣ���� ����Ͽ� Ʈ���� ���� ��ȸ�� ����� ���ϴ� �޼ҵ�
	 * @param cur ���� ���
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