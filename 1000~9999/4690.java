package BOJ;

/**
 * a <= 100인 경우 a^3 = b^3 + c^3 + d^3인 (a, b, c, d) 쌍을 모두 찾는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * bruteforce를 이용하여 모든 경우의 수를 탐색한다.
	 * 마지막 for문을 적게 돌기 위해 break를 설정해둔다.
	 * Math.pow를 사용했었는데 이는 실수형 연산이기 때문에 정수형 연산에 비해 엄청나게 느리다. (1300ms정도)
	 * 이를 정수형 연산으로 변경하니 124ms로 줄어든다.
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