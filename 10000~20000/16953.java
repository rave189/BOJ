package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���� A�� 2�� ���ϰų� �����ʿ� 1�� �߰��Ͽ� B�� ��������Ѵ�.
 * �̶�, A�� B�� �ٲٴµ� �ʿ��� ������ �ּڰ� + 1�� ���ϴ� ���� B�� �ٲ� �� ���ٸ� -1�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		Search(a, b, 1);
		System.out.println(-1);
	}

	/**
	 * ����ġ�� ������� B�� �� �� �ִ��� ���ϴ� ����
	 * @param a   ���� A
	 * @param b   ���� B
	 * @param cnt ������ Ƚ��
	 */
	public static void Search(long a, int b, int cnt) {
		if (a == b) {
			System.out.println(cnt);
			System.exit(0);
		} else if (a > b)
			return;
		Search(a * 2, b, cnt + 1);
		Search(Long.parseLong(Long.toString(a) + "1"), b, cnt + 1);
	}
}