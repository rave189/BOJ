package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * ���� ���� Ʈ���� �̷���� ���ø� �湮�Ѵ�.
 * �� ������ �湮 ������ �־��� ��, ���� ���� Ʈ���� ���ϴ� ����
 * ���ô� ���� ��ȸ ������� �湮�ߴ�.
 * @author Rave
 *
 */
public class Main {

	// Ʈ���� ������ ArrayList
	static ArrayList<Integer>[] tree;
	static StringTokenizer st;
	// Ʈ���� �ִ� ����
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		k = Integer.parseInt(br.readLine());
		tree = new ArrayList[k];
		for (int i = 0; i < k; i++)
			tree[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		traversal(0);
		for (ArrayList<Integer> line : tree) {
			for (int node : line)
				sb.append(node + " ");
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void traversal(int depth) {
		if (depth >= k)
			return;
		// ���� Ž��
		traversal(depth + 1);
		// ���� ��带 Ʈ���� �߰�
		tree[depth].add(Integer.parseInt(st.nextToken()));
		// ������ Ž��
		traversal(depth + 1);
	}
}