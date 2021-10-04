package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �� ���ڿ� A�� B�� �־�����.
 * A�� B���� ���̰� �۰ų� ���� ���ڿ��̴�.
 * A�� B�� ���̴� A[i] != B[i]�� i�� �����̴�.
 * A���� B�� ���̰� ������ ������ ������ ���� ������ �� �� �ִ�.
 * 1. A�� �տ� �ƹ� ���ĺ��̳� �߰��Ѵ�.
 * 2. A�� �ڿ� �ƹ� ���ĺ��̳� �߰��Ѵ�.
 * �� ��, A�� B�� ������ �ּҰ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * A�� B�� ���� �� �ٸ� ������ ���� �ּҷ� �ϴ� ���� ���ؾ� �Ѵ�.
	 * ���̰� 10�� B�� ���̰� 5�� A�� ������ �ּҰ��� ������ ���� ���� �� �ִ�.
	 * A�� 0~4�� B�� 0~4 ���̸� ���Ѵ�.
	 * A�� 0~4�� B�� 1~5 ���̸� ���Ѵ�.
	 * A�� 0~4�� B�� 2~6 ���̸� ���Ѵ�.
	 * ....
	 * A���� �յڷ� �ƹ� ���ĺ��̳� ���� �� �ֱ� ������
	 * A�� ��Ī�� ���Ѻ� �κ��� ������ ��� �κ��� B�� ���ĺ����� A�� ���δٰ� ������ �� �ִ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int length = B.length() - A.length();
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i <= length; i++) {
			int count = 0;
			for (int j = 0; j < A.length(); j++)
				if (B.charAt(i + j) != A.charAt(j))
					count++;
			answer = Math.min(answer, count);
		}
		System.out.println(answer);
	}
}