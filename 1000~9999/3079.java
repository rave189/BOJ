package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ������ ������ ���ؼ� �Ա� �ɻ縦 ���ľ� �Ѵ�.
 * �� �ɻ��� �� ���� �� �� �ְ�, ����־�� �� �� �ִ�.
 * ���� �ɻ������ ��� �ɻ��ϴµ� �ɸ��� �ð��� �ٸ� �� �ִ�.
 * �� ��, M���� ����� ��� �˻��ϴµ� ��� �ּ� �ð��� ���ϴ� ����
 * �ɻ�밡 ����ִ��� �����ɸ��ٸ� ��ٷȴٰ� ª�� �ɻ��� �� �� �ִ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * �ɻ翡 �ɸ��� �ּ� �ð��� mid�� �ΰ� �̺� Ž���� �Ѵ�.
	 * mid�� �ð����� �ɻ縦 �� �� �ִ� ����� mid/�ɻ�ð��� �����̴�.
	 * ������ ���ϰ� �� ���� M���� ū�� ������ Ȯ���Ѵ�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] immigration = new int[n];
		// right�� �ɻ簡 ���� �����ɸ��� �ɻ�� * m���� �ִ� �ð��̴�.
		// m�� 10���̰�, �ɻ�ð��� 10���̱� ������ long���� �����Ѵ�.
		long left = 0, right = 0;
		for (int i = 0; i < n; i++) {
			immigration[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, immigration[i]);
		}
		right *= m;
		while (left <= right) {
			long mid = (left + right) / 2;
			long checkPeople = 0;
			for (int i = 0; i < n; i++)
				checkPeople += mid / immigration[i];
			if (checkPeople >= m)
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left);
	}
}