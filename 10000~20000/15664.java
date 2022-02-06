package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * N���� �ڿ����� �ڿ��� M�� �־�����.
 * N���� �ڿ��� �߿��� M���� �� �����̸鼭 �� ������ �񳻸������� ������ ��� ����ϴ� ����
 * �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static int[] arr;
	static boolean[] visited;
	static StringBuilder answer = new StringBuilder();
	static HashSet<String> hash = new HashSet<>();

	/**
	 * N�� M�ø���
	 * ���� hash���ϱ� ��Ģ���°Ű���.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		bruteforce(0, "", m);
		System.out.print(answer);
	}

	public static void bruteforce(int cur, String result, int depth) {
		if (depth == 0) {
			answer.append(result).append('\n');
			return;
		}

		for (int i = cur; i < arr.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			bruteforce(i + 1, result + arr[i] + " ", depth - 1);
			visited[i] = false;
		}
	}
}