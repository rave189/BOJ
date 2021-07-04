package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * N���� �ڿ����� �ڿ��� M�� �־�����.
 * �� ��, N���� �ڿ��� �߿��� M���� �� ������ ���ϴ� ����
 * M���� �� �� ���� ���� ���� �� ��� �ȴ�.
 * �� ������ �񳻸������̾�� �Ѵ�.
 * �񳻸����� = ��������(?)�� �� ����.
 * @author Rave
 *
 */
public class Main {

	static int[] arr;
	// �ߺ��Ǵ� �������� �˻�
	static HashSet<String> hash = new HashSet<>();
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		// ������ ���� ������� �����غ���.
		Arrays.sort(arr);
		BruteForce(0, m, "");
		System.out.println(answer);
	}

	/**
	 * M���� �ڿ����� ���Ʈ ������ �̿��Ͽ� �����ϴ� �޼ҵ�
	 * @param depth  ���� �ڿ����� ����
	 * @param result �� �ڿ���
	 */
	public static void BruteForce(int cur, int depth, String result) {
		if (depth == 0) {
			if (!hash.contains(result)) {
				hash.add(result);
				answer.append(result + "\n");
			}
			return;
		}
		for (int i = cur; i < arr.length; i++)
			BruteForce(i, depth - 1, result + arr[i] + " ");
	}
}