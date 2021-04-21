package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� �л��� ���� ������Ʈ�� �Բ��ϰ� ���� �л��� �����Ѵ�.
 * ������ �л����� ����Ŭ�� �̷�ٸ� �� �л����� ���� �ȴ�.
 * ������ ���� ���� �л����� ���� ���ϴ� ����
 */
public class Main {

	static int[] arr;
	static int[] visited;
	static int[] firstIdx;
	static int first;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n + 1];
			visited = new int[n + 1];
			firstIdx = new int[n + 1];
			answer = 0;
			for (int i = 1; i <= n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			int answer = 0;
			for (int i = 1; i <= n; i++)
				// �� �� �湮�ߴ� ������ �ٽ� �湮���� �ʴ´�.
				if (visited[i] == 0) {
					first = i;
					answer += DFS(i, 1);
				}
			sb.append(n - answer + "\n");
		}
		System.out.println(sb);
	}

	/**
	 * visited���� �� ��° �湮������ �����Ѵ�.
	 * firstIdx���� first�� ���� ������ ������.
	 * ���� ���� �湮 �ߴ� ������ �ٽ� �湮�ϰ� �ǰ� first�� ���� ���ٸ� ���� Ž�� ���߿� ������ �� ���̴�.
	 * �̷� ��� ������ �����ص� ���� �湮 Ƚ���� count���� ���� �湮 Ƚ���� visited[index]�� ����,
	 * ����Ŭ�� �̷�� �л����� ���� ���� �� �ִ�.
	 * first�� ���� �ٸ��ٸ� �ٸ� Ž�� ���߿� ������ �� ������, ����Ŭ�� ���� �� ����.
	 * @param index ���� �ε���
	 * @param count �湮 Ƚ��
	 * @return ����Ŭ�� �̷�� �л��� ��
	 */
	public static int DFS(int index, int count) {
		if (visited[index] != 0) {
			if (firstIdx[index] == first)
				return count - visited[index];
			return 0;
		}
		visited[index] = count;
		firstIdx[index] = first;
		return DFS(arr[index], count + 1);
	}
}