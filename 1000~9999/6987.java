package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 6개 팀의 월드컵 경기 결과가 주어진다.
 * 각 팀들은 다른 5개의 팀과 한 번씩 경기를 해야한다.
 * 경기 결과는 승, 무, 패로 주어지며 0이상 6이하의 자연수로 주어진다.
 * 이 때 경기 결과가 가능한 결과인지 아닌지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[][] status;
	static boolean[][] fight;

	/**
	 * 브루트포스를 사용하여 모든 경기 결과가 가능한지 탐색해본다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int testCase = 4;
		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			status = new int[6][3];
			fight = new boolean[6][6];
			boolean isValidInput = false;
			for (int i = 0; i < status.length; i++) {
				for (int j = 0; j < status[0].length; j++) {
					status[i][j] = Integer.parseInt(st.nextToken());
					// 경기를 6번 한다는 것은 불가능하기 때문에 예외 처리해준다.
					if (status[i][j] >= 6)
						isValidInput = true;
				}
			}
			answer.append(isValidInput ? 0 : isPossible(0, 0) ? 1 : 0).append(' ');
		}
		System.out.println(answer);
	}

	/**
	 * 경기 결과가 맞는지 확인하는 메소드
	 * 다른 팀들과 경기를 한 번씩 해야하므로 총 경기 횟수는 15회이다.
	 * 경기 결과가 모두 0이어도 경기 횟수가 15회가 되지 않는다면 올바르지 않은 결과이다.
	 * @param cur 현재 탐색하는 팀
	 * @param matchCnt 현재까지 경기 횟수
	 * @return 가능한 경기 결과라면 true, 아니라면 false
	 */
	public static boolean isPossible(int cur, int matchCnt) {
		if (cur >= status.length) {
			return matchCnt == 15 && isValid();
		}
		if (status[cur][0] == 0 && status[cur][1] == 0)
			return isPossible(cur + 1, matchCnt);

		for (int i = 0; i < status.length; i++) {
			if (i == cur || fight[cur][i])
				continue;
			fight[i][cur] = fight[cur][i] = true;
			if (status[cur][0] != 0 && status[i][2] != 0) {
				status[cur][0]--;
				status[i][2]--;
				if (isPossible(cur, matchCnt + 1))
					return true;
				status[cur][0]++;
				status[i][2]++;
			}
			if (status[cur][1] != 0 && status[i][1] != 0) {
				status[cur][1]--;
				status[i][1]--;
				if (isPossible(cur, matchCnt + 1))
					return true;
				status[cur][1]++;
				status[i][1]++;
			}
			fight[i][cur] = fight[cur][i] = false;
		}
		return false;
	}

	/**
	 * 경기가 모두 제대로 치루어졌는지 확인한다.
	 * @return 경기가 모두 치루어졌다면 true, 아니라면 false
	 */
	public static boolean isValid() {
		for (int i = 0; i < status.length; i++)
			for (int j = 0; j < status[0].length; j++)
				if (status[i][j] != 0)
					return false;
		return true;
	}
}