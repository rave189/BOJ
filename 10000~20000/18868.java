package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� ���ְ� �ִ�.
 * �� ���ֿ��� 1������ M������ ���ڰ� ���� �༺�� �ִ�.
 * �༺�� ũ�⸦ �˰� ���� ��, �յ��� ������ ���� �� ������ ���ϴ� ����
 * �յ��� ���ֶ� 1 <= i, j <= M�� ���ؼ� �Ʒ��� ���� ������ �����ϴ� ���ָ� �ǹ��Ѵ�.
 * Ai < Aj -> Bi < Bj
 * Ai = Aj -> Bi = Bj
 * Ai > Aj -> Bi > Bj
 * ������ ���� �����ε� ������ �ٸ� ���� �� ���� ����.
 * (1�� ����, 2�� ����)�� (2�� ����, 1�� ����)�� �� ���� ����.
 * @author Rave
 *
 */
public class Main {

	static int[][] space;
	static int answer = 0;

	/**
	 * ���Ʈ������ ����Ͽ� ���ָ� 2���� �����ϰ� ������ ���ְ� �յ����� Ȯ���غ���.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		space = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				space[i][j] = Integer.parseInt(st.nextToken());
		}
		bruteforce();
		System.out.println(answer);
	}

	/**
	 * ���ָ� 2���� �����Ѵ�.
	 */
	public static void bruteforce() {
		for (int i = 0; i < space.length; i++)
			for (int j = i + 1; j < space.length; j++)
				if (isMatching(i, j))
					answer++;
	}

	/**
	 * �� ���ְ� �յ����� Ȯ���غ���.
	 * @param x ������ ���� 1
	 * @param y ������ ���� 2
	 * @return �յ��ϴٸ� true, �ƴ϶�� false
	 */
	public static boolean isMatching(int x, int y) {
		for (int i = 0; i < space[0].length; i++) {
			for (int j = i + 1; j < space[0].length; j++) {
				if (space[x][i] < space[x][j] ^ space[y][i] < space[y][j])
					return false;
				else if (space[x][i] == space[x][j] ^ space[y][i] == space[y][j])
					return false;
				else if (space[x][i] > space[x][j] ^ space[y][i] > space[y][j])
					return false;
			}
		}
		return true;
	}
}