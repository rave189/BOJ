package BOJ;

/**
 * a <= 100�� ��� a^3 = b^3 + c^3 + d^3�� (a, b, c, d) ���� ��� ã�� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * bruteforce�� �̿��Ͽ� ��� ����� ���� Ž���Ѵ�.
	 * ������ for���� ���� ���� ���� break�� �����صд�.
	 * Math.pow�� ����߾��µ� �̴� �Ǽ��� �����̱� ������ ������ ���꿡 ���� ��û���� ������. (1300ms����)
	 * �̸� ������ �������� �����ϴ� 124ms�� �پ���.
	 */
	public static void main(String[] args) {
		StringBuilder answer = new StringBuilder();
		for (int a = 6; a <= 100; a++)
			for (int b = 2; b < a; b++)
				for (int c = b; c < a; c++)
					for (int d = c; d < a; d++) {
						int result = b * b * b + c * c * c + d * d * d;
						int compare = a * a * a;
						if (result == compare)
							answer.append(print(a, b, c, d)).append('\n');
						else if (result > compare)
							break;
					}
		System.out.println(answer);
	}

	public static String print(int a, int b, int c, int d) {
		return String.format("Cube = %d, Triple = (%d,%d,%d)", a, b, c, d);
	}
}