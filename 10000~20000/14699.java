package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * ���ǻ꿡�� N���� ���Ϳ� M���� ���� �̷���� �ִ�.
 * �� ��, �ִ��� ���� ���͸� �湮�ϸ� �ֻ�ܱ��� �ö󰡷��� �Ѵ�.
 * ������ ���Ϳ��� �ִ� �� ���� ���͸� �湮�� �� �ִ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static HashSet<Integer>[] hash;
	// i��° ���� ���� ���� �湮�� �� �ִ� ������ ������ �����Ѵ�.
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] height = new int[n];
		visited = new int[n];
		hash = new HashSet[n];
		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			hash[i] = new HashSet<>();
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
			// ū ���͸� �湮�ϸ� �������� �ϹǷ� ū ��츸 hash�� �����Ѵ�.
			if (height[first] > height[second])
				hash[second].add(first);
			else if (height[second] > height[first])
				hash[first].add(second);
		}
		for (int i = 0; i < n; i++)
			sb.append(getMaxRestArea(0, i) + 1 + "\n");
		System.out.println(sb);
	}

	/**
	 * ������ ���Ϳ��� ���� ���� �湮�� �� �ִ� ������ ������ ���ϴ� �޼ҵ�
	 * �޸������̼� DFS�� ����Ͽ� �ð��� ���̸� Ž���Ѵ�.
	 * @param depth ���� �湮�� ������ ����
	 * @param cur ���� ������ ��ȣ
	 * @return ���� ���� �湮�� �� �ִ� ������ ����
	 */
	public static int getMaxRestArea(int depth, int cur) {
		// �⺻�� depth�� �ʱ�ȭ �Ѵ�.
		int max = depth;
		for (int next : hash[cur])
			// �湮�� ���� �ִٸ� �� �� + depth�� max�� ���Ѵ�.
			if (visited[next] != 0)
				max = Math.max(max, visited[next] + depth);
			// �湮���� �ʾҴٸ� DFS�� ���� ������ Ž���Ѵ�.
			else
				max = Math.max(max, getMaxRestArea(depth + 1, next));
		// �ִ� �湮 ������ ��������� �湮 ������ �� cur ���� �湮�� �� �ִ� �ִ� ����� ������ ���Ѵ�.
		// �ű⿡ +1�� �Ͽ� cur ������ ������ ���� visited�� �����Ѵ�.
		visited[cur] = max - depth + 1;
		return max;
	}
}