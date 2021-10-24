package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사다리 게임을 조작하여 i번 세로선의 결과가 i번으로 나오게 하려고 한다.
 * 이렇게 하기 위해 추가해야 하는 가로선의 최소 개수를 구하는 문제
 * 단, 가로선은 인접하거나 연속되지 않아야 한다.
 * 또한 추가해야하는 가로선의 개수가 3을 넘거나 불가능하다면 -1을 출력한다.
 * @author Rave
 *
 */
public class Main {

	static boolean[][] ladder;
	static int answer = Integer.MAX_VALUE;

	/**
	 * 많이 빠른 해결 방법이 존재한다.
	 * 브루트포스를 통해 가로선을 추가해가며 조작할 수 있는지 확인해본다.
	 * 사다리를 놓을 때 1개를 놓고 안된다면 2개, 3개를 놓아보는 방법이다.
	 * 만약 위쪽에 1개를 놓고, 추가로 1개 또는 2개를 더 놓아서 문제가 풀린다면 이 값을 리턴한다.
	 * 하지만 아래쪽에 1개를 놓는 것으로 문제가 바로 해결될 수도 있다.
	 * 그래서 탐색을 끝까지 다 돌려보고 가장 최솟값을 출력하도록 변경함.
	 * 이 부분을 수정하면 시간이 많이 단축될지도..?
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		ladder = new boolean[h][n + 1];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = true;
		}
		bruteforce(0, 0);
		System.out.println(0 <= answer && answer <= 3 ? answer : -1);
	}

	public static void bruteforce(int lineCnt, int start) {
		if (isValid()) {
			answer = Math.min(answer, lineCnt);
			return;
		} else if (lineCnt >= 3)
			return;

		for (int i = start; i < ladder.length; i++) {
			for (int j = 1; j < ladder[0].length - 1; j++) {
				if (ladder[i][j] || ladder[i][j - 1] || ladder[i][j + 1])
					continue;
				ladder[i][j] = true;
				bruteforce(lineCnt + 1, start);
				ladder[i][j] = false;
			}
		}
	}

	public static boolean isValid() {
		for (int i = 1; i < ladder[0].length; i++)
			if (!down(i))
				return false;
		return true;
	}

	public static boolean down(int n) {
		int cur = n;
		for (int i = 0; i < ladder.length; i++) {
			if (ladder[i][cur - 1])
				cur--;
			else if (ladder[i][cur])
				cur++;
		}
		return cur == n;
	}
}