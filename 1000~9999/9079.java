package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
<<<<<<< Updated upstream
import java.util.ArrayList;

/**
 * �̸� ������ ������ �Ѵ�.
 * �̸��� ���� �̸��� ����Ͽ� ������ ���� ȹ���� ��Ʈ�� �־�����.
 * �� �̸� A�� B�� �־��� ��, �̸� ������ ����ϴ� ����
 * ���� �ڸ��� 0�̾ �� �ڸ��� ��µǰ� �Ѵ�.
=======
import java.util.StringTokenizer;

/**
 * 9���� ������ 3�� 3���� ���´�.
 * �ո��� H, �޸��� T�� ǥ���Ѵ�.
 * �� ��, �� �� �Ǵ� �� �� �Ǵ� �밢�� ������ ������ ��� �����´�.
 * ���� ���� �ൿ�� �ݺ��Ͽ� ��� ������ �ո� �Ǵ� �޸����� �ٲٷ��� �Ѵ�.
 * �� ��, ������ ������ Ƚ���� �ּڰ��� ���ϴ� ����
 * Ƚ�� 1�� �� ��, �� ��, �밢�� ��θ� ������ ���̴�.
>>>>>>> Stashed changes
 * @author Rave
 *
 */
public class Main {

<<<<<<< Updated upstream
	static int[] strokes = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

	/**
	 * ó�� ���ĺ� ȹ���� ���� �迭�� �����, ���� ������� �迭�� ���ذ��� ���� �ڸ� ���� �����Ͽ� ���� �迭�� �����.
	 * ���� ���� �����ϴ� �迭�� ũ�Ⱑ 2�� ���� �� �ڸ��� ����ϸ� �����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length(); i++)
			sb.append(a.charAt(i)).append(b.charAt(i));
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < sb.length(); i++)
			arr.add(strokes[sb.charAt(i) - 'A']);
		System.out.println(solution(arr));
	}

	public static String solution(ArrayList<Integer> arr) {
		if (arr.size() == 2)
			return arr.get(0) + "" + arr.get(1);
		ArrayList<Integer> newArr = new ArrayList<>();
		for (int i = 0; i < arr.size() - 1; i++) {
			newArr.add((arr.get(i) + arr.get(i + 1)) % 10);
		}
		return solution(newArr);
=======
	// ������ ������ ������ 1���� ������ ������ boolean���� üũ�� ���� ���� ��츸 �������.
	static boolean[] visited;
	static char[][] map;
	static int min;

	/**
	 * ���Ʈ������ ����Ͽ� ��� ��츦 ������� �Ǵ��Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			map = new char[3][3];
			visited = new boolean[8];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[0].length; j++)
					map[i][j] = st.nextToken().charAt(0);
			}
			answer.append(BruteForce(0) ? min : -1).append('\n');
		}
		System.out.println(answer);
	}

	/**
	 * ������ ��� ���� ������ �Ǳ� ������ ���Ʈ ������ ����Ͽ� �� ���� �������.
	 * @param count ���� ������ Ƚ��
	 * @return ������ ��� �ո��̳� �޸����� ������ �� ������ true, �ƴ϶�� false
	 */
	public static boolean BruteForce(int count) {
		if (check()) {
			min = Math.min(min, count);
			return true;
		}
		boolean isFind = false;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			reverseCoin(i);
			isFind |= BruteForce(count + 1);
			reverseCoin(i);
			visited[i] = false;
		}
		return isFind;
	}

	/**
	 * �� ���ڸ��� �ٸ� ������ �����´�.
	 * @param n Ÿ��
	 */
	public static void reverseCoin(int n) {
		if (n == 0) {
			row(0);
		} else if (n == 1) {
			row(1);
		} else if (n == 2) {
			row(2);
		} else if (n == 3) {
			col(0);
		} else if (n == 4) {
			col(1);
		} else if (n == 5) {
			col(2);
		} else if (n == 6) {
			upDiagonal();
		} else if (n == 7) {
			downDiagonal();
		}
	}

	/**
	 * n��° ���� ��� �����´�.
	 * @param n ������ ��
	 */
	public static void row(int n) {
		for (int i = 0; i < map.length; i++) {
			map[n][i] = map[n][i] == 'H' ? 'T' : 'H';
		}
	}

	/**
	 * n��° ���� ��� �����´�.
	 * @param n ������ ��
	 */
	public static void col(int n) {
		for (int i = 0; i < map[0].length; i++) {
			map[i][n] = map[i][n] == 'H' ? 'T' : 'H';
		}
	}

	/**
	 * �����ϴ� �밢�� ������ ��� �����´�.
	 */
	public static void upDiagonal() {
		for (int i = 0, j = map[0].length - 1; i < map.length; i++, j--) {
			map[i][j] = map[i][j] == 'H' ? 'T' : 'H';
		}
	}

	/**
	 * �����ϴ� �밢�� ������ ��� �����´�.
	 */
	public static void downDiagonal() {
		for (int i = 0, j = 0; i < map.length; i++, j++) {
			map[i][j] = map[i][j] == 'H' ? 'T' : 'H';
		}
	}

	/**
	 * ������ ��� ���� ������ Ȯ���Ѵ�.
	 * @return ��� ���� ������ �̷�����ٸ� true, �ƴ϶�� false
	 */
	public static boolean check() {
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[0].length; j++)
				if (map[0][0] != map[i][j])
					return false;
		return true;
>>>>>>> Stashed changes
	}
}