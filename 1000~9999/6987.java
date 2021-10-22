package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 6�� ���� ������ ��� ����� �־�����.
 * �� ������ �ٸ� 5���� ���� �� ���� ��⸦ �ؾ��Ѵ�.
 * ��� ����� ��, ��, �з� �־����� 0�̻� 6������ �ڿ����� �־�����.
 * �� �� ��� ����� ������ ������� �ƴ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[][] status;
	static boolean[][] fight;

	/**
	 * ���Ʈ������ ����Ͽ� ��� ��� ����� �������� Ž���غ���.
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
					// ��⸦ 6�� �Ѵٴ� ���� �Ұ����ϱ� ������ ���� ó�����ش�.
					if (status[i][j] >= 6)
						isValidInput = true;
				}
			}
			answer.append(isValidInput ? 0 : isPossible(0, 0) ? 1 : 0).append(' ');
		}
		System.out.println(answer);
	}

	/**
	 * ��� ����� �´��� Ȯ���ϴ� �޼ҵ�
	 * �ٸ� ����� ��⸦ �� ���� �ؾ��ϹǷ� �� ��� Ƚ���� 15ȸ�̴�.
	 * ��� ����� ��� 0�̾ ��� Ƚ���� 15ȸ�� ���� �ʴ´ٸ� �ùٸ��� ���� ����̴�.
	 * @param cur ���� Ž���ϴ� ��
	 * @param matchCnt ������� ��� Ƚ��
	 * @return ������ ��� ������ true, �ƴ϶�� false
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
	 * ��Ⱑ ��� ����� ġ��������� Ȯ���Ѵ�.
	 * @return ��Ⱑ ��� ġ������ٸ� true, �ƴ϶�� false
	 */
	public static boolean isValid() {
		for (int i = 0; i < status.length; i++)
			for (int j = 0; j < status[0].length; j++)
				if (status[i][j] != 0)
					return false;
		return true;
	}
}