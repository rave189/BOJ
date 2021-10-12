package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미아의 노트가 물에 빠지고 말았다.
 * 노트는 건졌지만 노트에 적어둔 정보들이 지워져버렸다.
 * 하지만 노트에 적힌 문자열이 번진 패턴은 세로로 H글자, 가로로 W글자가 반복되게 번지게 되었다.
 * 원래 문자열의 길이 N, 세로로 번진 글자의 수 H, 가로로 번진 글자의 수 W가 주어질 때
 * 복원된 문자열을 구하는 문제, 복원할 수 없는 경우는 ?로 출력한다.
 * 문자열에는 ?가 들어갈 수 있고, ?는 해당 자리 문자가 지워진 경우이다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 가로로 W만큼 세로로 H만큼의 직사각형 부분을 모두 탐색하여 한번이라도 글자가 나오면 그 글자가 복원된 글자이다.
	 * 글자가 나오지 않는 경우는 ?로 발견한 경우 발견한 문자를 answer에 붙이고 마지막에 출력한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		String[] input = new String[h];
		for (int i = 0; i < h; i++)
			input[i] = br.readLine();
		for (int i = 0; i < n * w; i += w) {
			char ch = '?';
			for (int j = 0; j < h; j++) {
				for (int t = i; t < i + w; t++) {
					char compare = input[j].charAt(t);
					if (compare == '?')
						continue;
					ch = compare;
				}
			}
			answer.append(ch);
		}
		System.out.println(answer);
	}
}