package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���� x, ���� y ������ Ÿ���� �ִ�.
 * �� Ÿ�Ͽ� �밢���� �׾��� ��, �밢���� �׾��� 1x1Ÿ���� �� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �밢�� ���ϴ� ���� ���ϴٰ� �ǹ̾��� ���ΰŰ��Ƽ� �׳� �� ��
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int gcd = gcd(x, y);
		System.out.println(x + y - gcd);
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