package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �� �м��� �־�����.
 * �� �м��� ���� ���м��� ����ϴ� ����
 * �Է��� ���� �и� ������ �־�����.
 * 
 * @author Rave
 *
 */
public class Main {

	/**
	 * �� �м��� ��� ���� �ܼ� ����Ѵ�.
	 * ���ڿ� �и��� �ִ� ������� ���ϰ� �ִ� ������� ���� ���� ����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int y1 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int r2 = x2 * y2;
		int r1 = x1 * y2 + y1 * x2;
		int gcd = gcd(r1, r2);
		System.out.printf("%d %d", r1 / gcd, r2 / gcd);
	}

	public static int gcd(int a, int b) {
		while (a % b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return b;
	}
}