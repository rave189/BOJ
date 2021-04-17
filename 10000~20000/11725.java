package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Ʈ���� ��Ʈ�� 1�̶�� �� ��, �� Ʈ���� �θ� ã�� ����
 * �Է��� �� Ʈ�� �� ����� �� ������ �־�����.
 * �Է��� ������ 1���Ͱ� �ƴϰ�, ������ �θ��� ����, �������� �θ� �� ���� �ִ�.
 * @author Rave
 *
 */
public class Main {

	// �Է��� 10���̱� ������ ������ �迭�� ���� �� �޸� �ʰ�
	static ArrayList<Integer>[] treeMap;
	// �� Ʈ���� �θ� ������ �迭
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// �Է��� 10���̱� ������ ���۸� ����ؼ� ����Ѵ�.
        StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		treeMap = new ArrayList[n + 1];
		tree = new int[n + 1];
		for (int i = 1; i <= n; i++)
			treeMap[i] = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			treeMap[first].add(second);
			treeMap[second].add(first);
		}
		DFS(1);
		for (int i = 2; i <= n; i++)
			sb.append(tree[i]+"\n");
        System.out.println(sb);
	}

	/**
	 * �� Ʈ���� �ڽĵ��� ���� �켱 Ž������ Ž���Ѵ�.
	 * ���� �켱 Ž���� �ʺ� �켱 Ž������ �ӵ��� ������.
	 * @param next ���� Ʈ�� 1
	 */
	public static void DFS(int next) {
		for (int item : treeMap[next])
			if (tree[item] == 0) {
				// �θ� ��带 �������ش�.
				tree[item] = next;
				DFS(item);
			}
	}
}