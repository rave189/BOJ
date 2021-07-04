package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * N���� �ڿ����� �ڿ��� M�� �־�����.
 * �� ��, N���� �ڿ��� �߿��� M���� ���� �� ������ ���ϴ� ����
 * �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�,
 * ������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static int[] arr;
	// ���� ���� �� �� ���� �ʱ� ���� �迭
	static boolean[] visited;
	// �ߺ��Ǵ� �������� Ȯ���ϱ� ���� �ؽ�
	static HashSet<String> hash = new HashSet<>();
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		// ������ �صξ� �����ϴ� ������ ������ �� �ְ� �Ѵ�.
		Arrays.sort(arr);
		BruteForce(m, "");
		System.out.println(answer);
	}

	/**
	 * �ߺ��� ������� �����鼭 M���� ���� �����ϴ� �޼ҵ�
	 * @param depth ���� ������ ��
	 * @param result ������� ������ ���� �����ϴ� ����
	 */
	public static void BruteForce(int depth, String result) {
		if (depth == 0) {
			if (!hash.contains(result)) {
				hash.add(result);
				answer.append(result + "\n");
			}
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			BruteForce(depth - 1, result + arr[i] + " ");
			visited[i] = false;
		}
	}
}