package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� ���ڷ� �̷���� ������ �־�����.
 * �� ������ �κ� �� �߿��� M���� ������ �������� �κ����� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * m�� �ִ밪�� 1000�̹Ƿ� �������� ������ 0~ 999�����̴�.
	 * ���� ���� ���� �������� mod�� �����Ͽ� 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		int[] mod = new int[1001];
		long answer = 0;
		for (int i = 1; i <= n; i++) {
			// �������� ���� ���� ���Ѵ�.
			arr[i] = (arr[i - 1] + Integer.parseInt(st.nextToken())) % m;
			// �������� 0�̶�� answer�� ������Ų��.
			if (arr[i] == 0)
				answer++;
			// arr[i] ~ arr[j]������ ���� �� = arr[0]~arr[j] ������ - arr[0]~arr[i]������ ���� �� �̴�.
			// �׸��� �������� 0���� ����°� �����̹Ƿ� �������� 1�̶�� 1�� ���־�� �Ѵ�.
			// ���� ���� �������� ����ŭ answer�� ������Ų��.
			answer += mod[arr[i]];
			mod[arr[i]]++;
		}
		System.out.println(answer);
	}
}