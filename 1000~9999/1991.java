package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���� Ʈ���� �Է¹޾� ���� ��ȸ, ���� ��ȸ, ���� ��ȸ�� ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tree.add(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
		}
		PreOrder(tree.root);
		System.out.println();
		InOrder(tree.root);
		System.out.println();
		PostOrder(tree.root);
	}

	/**
	 * ���� ��ȸ�� ����ϴ� �޼ҵ�
	 * ���� ���, ���� �ڽ�, ������ �ڽ� ������ �����Ѵ�.
	 * @param next ���� ���
	 */
	public static void PreOrder(Node next) {
		if (next == null)
			return;
		System.out.print(next.ch);
		PreOrder(next.left);
		PreOrder(next.right);
	}

	/**
	 * ���� ��ȸ�� ����ϴ� �޼ҵ�
	 * ���� �ڽ�, ���� ���, ������ �ڽ� ������ �����Ѵ�.
	 * @param next ���� ���
	 */
	public static void InOrder(Node next) {
		if (next == null)
			return;
		InOrder(next.left);
		System.out.print(next.ch);
		InOrder(next.right);
	}

	/**
	 * ���� ��ȸ�� ����ϴ� �޼ҵ�
	 * ���� �ڽ�, ������ �ڽ�, ���� ��� ������ �����Ѵ�.
	 * @param next ���� ���
	 */
	public static void PostOrder(Node next) {
		if (next == null)
			return;
		PostOrder(next.left);
		PostOrder(next.right);
		System.out.print(next.ch);
	}
}

class Tree {
	Node root;

	public Tree() {
		root = new Node('A');
	}

	public void add(char ch, char left, char right) {
		Node node = Search(root, ch);
		if (left != '.')
			node.left = new Node(left);
		if (right != '.')
			node.right = new Node(right);
	}

	public Node Search(Node next, char ch) {
		if (next == null)
			return null;
		if (next.ch == ch)
			return next;
		Node result = Search(next.left, ch);
		if (result != null)
			return result;
		return Search(next.right, ch);
	}
}

class Node {
	char ch;
	Node left, right;

	public Node(char _ch) {
		this.ch = _ch;
	}
}