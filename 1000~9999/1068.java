package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Ʈ���� �־����� ��带 �ϳ� ������ �� ���� ����� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	// Ʈ���� ������ �迭
	static ArrayList<Integer>[] tree;
	// ����� ���
	static int remover;
	// ���� ����� ����
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		tree = new ArrayList[n];
		for (int i = 0; i < n; i++)
			tree[i] = new ArrayList<>();
		// ���� ������ �𸣱� ������ �����Ѵ�.
		int start = 0;
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (value == -1)
				start = i;
			else
				tree[value].add(i);
		}
		remover = Integer.parseInt(br.readLine());
		// ����� ����� �ڽ� ������ ���� Ž���� �������� ���ϵ��� �Ѵ�.
		tree[remover].clear();
		DFS(start);
		System.out.println(answer);
	}

	/**
	 * Ʈ���� ���� ����� ������ ���� �켱 Ž������ ���ϴ� �޼ҵ�
	 * @param next ���� ���
	 */
	public static void DFS(int next) {
		if (next == remover)
			return;
		// �ڽ� ����� ������ ������ ���� ����� ���� 1 ����
		else if (tree[next].size() == 0) {
			answer++;
			return;
		}
		for (int value : tree[next])
			// remover�� �θ��尡 �ڽ��� remover�� ������ �ִٸ� 1 ������Ų��.
			if (value == remover && tree[next].size() == 1)
				answer++;
			else
				DFS(value);
	}
}