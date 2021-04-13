package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ��ȥ�Ŀ� �б� ���� �� ģ���� ģ���� ģ���� �ʴ��Ϸ��� �Ѵ�.
 * ������� �й��� 1���� �� �ʴ��� ����� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static boolean[][] relationship;
	static boolean[] visited;
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int people = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		relationship = new boolean[people + 1][people + 1];
		visited = new boolean[people + 1];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			relationship[first][second] = true;
			relationship[second][first] = true;
		}
		DFS(1, 2);
		System.out.println(answer);
	}

	/**
	 * ģ���� ģ���� ģ���� ã�� �޼ҵ�
	 * @param next ���� Ž���� ģ��
	 * @param depth ģ���� ����
	 */
	public static void DFS(int next, int depth) {
		// �湮���� ���� ģ���� ��� ������Ų��.
		if (!visited[next])
			answer++;
		visited[next] = true;
		// ģ���� ģ������ �����ߴٸ� ��ȯ�Ѵ�.
		if (depth == 0)
			return;
		for (int i = 2; i < relationship.length; i++)
			// ģ���� ģ������ ��� Ž���ؾ� �ϹǷ� visited�� ������� �ʴ´�.
			if (relationship[next][i])
				DFS(i, depth - 1);
	}
}