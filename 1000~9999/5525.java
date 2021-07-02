package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * N+1개의 I와 N개의 O로 이루어져 있고, I와 O가 교대로 나오는 문자열을 Pn이라고 한다.
 * P1 = IOI
 * P2 = IOIOI
 * P3 = IOIOIOI
 * 문자열 S와 N이 주어질 때 S에 Pn이 얼마나 포함되어 있는지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		char[] line = br.readLine().toCharArray();
		int answer = 0;
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < m; i++) {
			// 비어있으면 I를 찾을 때까지 넘긴다.
			if (st.isEmpty()) {
				if (line[i] == 'I')
					st.push(line[i]);
				continue;
			}
			// 스택의 맨 위와 같은 문자라면 스택을 비우고 i를 1 감소시켜 다시 스택에 넣도록 한다.
			if (line[i] == st.peek()) {
				st.clear();
				i--;
			}
			// 아니라면 패턴이 반복되는 중이므로 스택에 넣는다.
			else
				st.push(line[i]);
			// 스택의 크기가 2*N+1개라면 Pn을 찾았으므로 answer을 증가시키고 2개를 꺼내 다음 패턴을 찾도록 한다.
			if (st.size() == 2 * n + 1) {
				answer++;
				st.pop();
				st.pop();
			}
		}
		System.out.println(answer);
	}
}