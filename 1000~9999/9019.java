package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0부터 9999까지 저장할 수 있는 레지스터가 있다.
 * 각 명령어는 레지스터에 저장된 n을 다음과 같이 변환한다.
 * D: n을 두 배로 바꾼다. 결과 값이 9999보다 크다면 10000으로 나눈 나머지를 저장한다.
 * S: n에서 1을 뺀다. n이 0이라면 9999를 저장한다.
 * L: n의 각 자릿수를 왼편으로 회전시켜 저장한다.
 * R: n의 각 자릿수를 오른편으로 회전시켜 저장한다.
 * L과 R을 연산할 때에는 n을 네 자릿수로 맞춘 후 회전을 시킨다.
 * 레지스터의 초기값과 최종 값이 주어질 때 초기값에서 최종 값으로 변환하기 위한
 * 최소한의 명령어를 나열하여 출력한다.
 * 가능한 명령어가 여러가지면 아무거나 출력한다.
 * @author Rave
 *
 */
public class Main {

	static String[] command = { "D", "S", "L", "R" };

	/**
	 * 초기 값부터 너비 우선 탐색을 통해 최종 값이 될 수 있는지 검사한다.
	 * 이 코드는 12916ms로 다시 풀어봐야하는 문제이다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			String result = BFS(start, end);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	/**
	 * start부터 시작하여 너비 우선 탐색을 통해 end가 되는 최소한의 명령어를 구한다.
	 * @param start 초기 값
	 * @param end 최종 값
	 * @return 최소한의 명령어
	 */
	public static String BFS(int start, int end) {
		Queue<DSLR> q = new LinkedList<>();
		boolean[] visited = new boolean[10000];
		q.add(new DSLR(start, ""));
		visited[start] = true;
		while (!q.isEmpty()) {
			DSLR cur = q.poll();
			if (cur.value == end)
				return cur.route;
			String strNum = getString(cur.value);
			int d = (cur.value * 2) % 10000;
			int s = cur.value == 0 ? 9999 : cur.value - 1;
			int l = getLeft(strNum);
			int r = getRight(strNum);
			// D, S, L, R을 구하여 반복문을 돌리기 위해 배열로 선언한다.
			int[] cmdArr = { d, s, l, r };
			for (int i = 0; i < 4; i++) {
				if (visited[cmdArr[i]])
					continue;
				visited[cmdArr[i]] = true;
				q.add(new DSLR(cmdArr[i], cur.route + command[i]));
			}
		}
		return "";
	}

	/**
	 * 주어진 수를 네 자리의 String으로 변환해주는 메소드
	 * @param value 변환할 수
	 * @return 네 자리의 String
	 */
	public static String getString(int value) {
		StringBuilder sb = new StringBuilder(Integer.toString(value));
		while (sb.length() < 4)
			sb.insert(0, '0');
		return sb.toString();
	}

	/**
	 * 주어진 문자열을 왼쪽으로 회전시키는 메소드
	 * 가장 첫 문자를 맨 뒤로 보낸다.
	 * @param str 회전시킬 문자열
	 * @return 왼쪽으로 회전한 문자열
	 */
	public static int getLeft(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.append(sb.charAt(0));
		sb.deleteCharAt(0);
		return Integer.parseInt(sb.toString());
	}

	/**
	 * 주어진 문자열을 오른쪽으로 회전시키는 메소드
	 * 맨 마지막 문자를 맨 앞으로 보낸다.
	 * @param str 회전시킬 문자열
	 * @return 오른쪽으로 회전한 문자열
	 */
	public static int getRight(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.insert(0, sb.charAt(sb.length() - 1));
		sb.deleteCharAt(sb.length() - 1);
		return Integer.parseInt(sb.toString());
	}
}

class DSLR {
	int value;
	String route;

	public DSLR(int _value, String _route) {
		this.value = _value;
		this.route = _route;
	}
}