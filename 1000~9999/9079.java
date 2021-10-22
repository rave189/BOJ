package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
<<<<<<< Updated upstream
import java.util.ArrayList;

/**
 * 이름 궁합을 보려고 한다.
 * 이름은 영어 이름을 사용하여 궁합을 보고 획수는 힌트에 주어진다.
 * 두 이름 A와 B가 주어질 때, 이름 궁합을 출력하는 문제
 * 십의 자리가 0이어도 두 자리고 출력되게 한다.
=======
import java.util.StringTokenizer;

/**
 * 9개의 동전을 3행 3열로 놓는다.
 * 앞면은 H, 뒷면은 T로 표시한다.
 * 이 때, 한 행 또는 한 열 또는 대각선 영역의 동전을 모두 뒤집는다.
 * 위와 같은 행동을 반복하여 모든 동전을 앞면 또는 뒷면으로 바꾸려고 한다.
 * 이 때, 동전을 뒤집는 횟수의 최솟값을 구하는 문제
 * 횟수 1은 한 행, 한 열, 대각선 모두를 뒤집는 것이다.
>>>>>>> Stashed changes
 * @author Rave
 *
 */
public class Main {

<<<<<<< Updated upstream
	static int[] strokes = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

	/**
	 * 처음 알파벳 획수에 따라 배열을 만들고, 이후 만들어진 배열을 더해가며 일의 자리 수만 추출하여 다음 배열을 만든다.
	 * 위와 같이 진행하다 배열의 크기가 2인 순간 두 자리를 출력하며 종료한다.
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
	// 뒤집는 행위는 무조건 1번만 나오기 때문에 boolean으로 체크가 되지 않은 경우만 뒤집어본다.
	static boolean[] visited;
	static char[][] map;
	static int min;

	/**
	 * 브루트포스를 사용하여 모든 경우를 뒤집어보며 판단한다.
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
	 * 동전이 모두 한쪽 면으로 되기 전까지 브루트 포스를 사용하여 한 번씩 뒤집어본다.
	 * @param count 현재 뒤집은 횟수
	 * @return 동전을 모두 앞면이나 뒷면으로 뒤집을 수 있으면 true, 아니라면 false
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
	 * 각 숫자마다 다른 동전을 뒤집는다.
	 * @param n 타입
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
	 * n번째 행을 모두 뒤집는다.
	 * @param n 뒤집을 행
	 */
	public static void row(int n) {
		for (int i = 0; i < map.length; i++) {
			map[n][i] = map[n][i] == 'H' ? 'T' : 'H';
		}
	}

	/**
	 * n번째 열을 모두 뒤집는다.
	 * @param n 뒤집을 열
	 */
	public static void col(int n) {
		for (int i = 0; i < map[0].length; i++) {
			map[i][n] = map[i][n] == 'H' ? 'T' : 'H';
		}
	}

	/**
	 * 증가하는 대각선 방향을 모두 뒤집는다.
	 */
	public static void upDiagonal() {
		for (int i = 0, j = map[0].length - 1; i < map.length; i++, j--) {
			map[i][j] = map[i][j] == 'H' ? 'T' : 'H';
		}
	}

	/**
	 * 감소하는 대각선 방향을 모두 뒤집는다.
	 */
	public static void downDiagonal() {
		for (int i = 0, j = 0; i < map.length; i++, j++) {
			map[i][j] = map[i][j] == 'H' ? 'T' : 'H';
		}
	}

	/**
	 * 동전이 모두 한쪽 면인지 확인한다.
	 * @return 모두 한쪽 면으로 이루어졌다면 true, 아니라면 false
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