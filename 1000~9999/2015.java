package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * N���� ���ڰ� ����� ������ �־��� ��
 * �� ������ �κ� ���� �� ���� K�� �Ǵ� �κ����� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static HashMap<Long, Integer> hash = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] arr = new long[n + 1];
		long answer = 0;
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
			// ���� K�̸� answer�� ������Ų��.
			if (arr[i] == k)
				answer++;
			// arr[i] - X = k �̹Ƿ� X = arr[i] - k�̰�
			// �� ���� hash���� ã�� answer�� �����ش�.
			answer += hash.getOrDefault(arr[i] - k, 0);
			// arr[i]�� hash�� �߰��Ѵ�.
			hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
		}
		System.out.println(answer);
	}
}