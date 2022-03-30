package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �� �ڿ����� �ִ������� �ּҰ������ �־�����.
 * �� ��, �� �ڿ����� ���� �ּҰ� �Ǵ� �� �ڿ����� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���� �ּ� = ������ �ּ�?
	 * ���̰� �ּҶ�� �����ϰ� Ǯ���µ� ����...(����?)
	 * lcm/gcd�� �ϸ� a/gcd * b/gcd�� ����.
	 * ���� �� ���� ���μ��̸鼭 �� ���� ���� lcm/gcd�� �� ���� ã��, ����� �� gcd�� �����ָ� ���� �� ����.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int gcd = Integer.parseInt(st.nextToken());
		int lcm = Integer.parseInt(st.nextToken());
		int divide = lcm / gcd;
		int[] nums = { 1, divide };
		for (int first = 2; first <= divide; first++) {
			if (divide % first == 0) {
				int second = divide / first;
				if (gcd(first, second) != 1)
					continue;
				if (first > second)
					break;
				int diff = nums[1] - nums[0];
				int compare = second - first;
				if (compare < diff)
					nums = new int[] { first, second };
			}
		}
		System.out.println(String.format("%d %d", nums[0] * gcd, nums[1] * gcd));
	}

	public static int gcd(int a, int b) {
		while (b > 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}