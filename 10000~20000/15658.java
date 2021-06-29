package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� �迭�� +, -, *, / �������� ������ �־�����.
 * �������� ������ ���� N-1���� ũ�ų� ���� 4N���� �۰ų� ����.
 * �� ��, �������� �켱������ �����ϰ� �տ������� ����� ������ ��
 * ���� ����� �ִ񰪰� �ּڰ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[] arr;
	static int[] op;
	// ���� ������ -10�� ~ 10�� �̹Ƿ� MIN_VALUE�� MAX_VALUE�� �ʱ�ȭ �Ѵ�.
	static int maxAns = Integer.MIN_VALUE;
	static int minAns = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		op = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < op.length; i++)
			op[i] = Integer.parseInt(st.nextToken());
		// ù ���� �ְ� �����Ѵ�.
		BruteForce(1, arr[0]);
		System.out.println(maxAns + "\n" + minAns);
	}

	/**
	 * ���Ʈ ������ ����Ͽ� ��� ��츦 �õ��غ���.
	 * @param cur ��꿡 �� ��
	 * @param result ��������� ��� ���
	 */
	public static void BruteForce(int cur, int result) {
		if (cur == arr.length) {
			maxAns = Math.max(maxAns, result);
			minAns = Math.min(minAns, result);
			return;
		}
		// ���� �׻� ������� �̷������ �ϹǷ� �����ڸ� ���� �ȴ�.
		for (int i = 0; i < op.length; i++) {
			if (op[i] == 0)
				continue;
			op[i]--;
			BruteForce(cur + 1, Calculate(result, cur, i));
			op[i]++;
		}
	}

	/**
	 * �����ڿ� �°� ���� ����Ѵ�.
	 * @param result ��������� ��� ���
	 * @param idx ������ ������ ����
	 * @param op ������
	 * @return �����ڿ� �´� ��� ���
	 */
	public static int Calculate(int result, int idx, int op) {
		switch (op) {
		case 0:
			return result + arr[idx];
		case 1:
			return result - arr[idx];
		case 2:
			return result * arr[idx];
		default:
			return result / arr[idx];
		}
	}
}