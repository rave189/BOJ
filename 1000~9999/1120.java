package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 문자열 A와 B가 주어진다.
 * A는 B보다 길이가 작거나 같은 문자열이다.
 * A와 B의 차이는 A[i] != B[i]인 i의 개수이다.
 * A에는 B와 길이가 같아질 때까지 다음과 같은 연산을 할 수 있다.
 * 1. A의 앞에 아무 알파벳이나 추가한다.
 * 2. A의 뒤에 아무 알파벳이나 추가한다.
 * 이 때, A와 B의 차이의 최소값을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * A와 B의 문자 중 다른 문자의 값을 최소로 하는 값을 구해야 한다.
	 * 길이가 10인 B와 길이가 5인 A의 차이의 최소값은 다음과 같이 구할 수 있다.
	 * A의 0~4와 B의 0~4 차이를 구한다.
	 * A의 0~4와 B의 1~5 차이를 구한다.
	 * A의 0~4와 B의 2~6 차이를 구한다.
	 * ....
	 * A에는 앞뒤로 아무 알파벳이나 붙일 수 있기 때문에
	 * A와 매칭을 시켜본 부분을 제외한 모든 부분은 B의 알파벳으로 A에 붙인다고 가정할 수 있다.
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