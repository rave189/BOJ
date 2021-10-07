package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� ���ÿ� N-1���� ���ΰ� �ִ�.
 * �� ���ø� ���������� �ΰ�, ���� ������ ���ÿ��� ���� ������ ���÷� �̵��Ϸ��� �Ѵ�.
 * ó�� ��� �ÿ��� �⸧�� ���� ���� �⸧�� �־�� �Ѵ�.
 * �⸧���� ũ��� �������̾ �󸶵��� �� �� �ִ�.
 * ���θ� �̿��Ͽ� 1km���� 1������ �⸧�� ����Ͽ� �̵��� �� �ִ�.
 * �� ���ÿ��� �ϳ��� �����Ұ� ������, ���ø��� ���ʹ� ������ �ٸ� �� �ִ�.
 * �� ��, ���� ������ ���ø� �� �� �ִ� �ּ� ����� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �� ���ø� �̵��ϸ� �⸧���� ���� �� ������ �⸧ ���� ������ ��
	 * �� �⸧���� ���� ���ñ��� ��� ����.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] distance = new long[n - 1];
		long[] city = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < distance.length; i++)
			distance[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			city[i] = Integer.parseInt(st.nextToken());
		// �⺻�� max
		long min = Long.MAX_VALUE;
		long sum = 0;
		for (int i = 0; i < distance.length; i++) {
			// �⸧ ���� ���� ���� ���Ѵ�.
			min = Math.min(min, city[i]);
			// �⸧ ���� ���� �� ������ �⸧���� ���� ���ø� ����.
			sum += min * distance[i];
		}
		System.out.println(sum);
	}
}