package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 디지털 시계는 hh:mm:ss로 표기된다.
 * 이때, 콜론(:)기호를 없애 hhmmss라는 시계 정수를 얻을 수 있다.
 * 두 시간이 주어질 때, 두 시간 사이에 존재하는 시계 정수 중 3의 배수인 수의 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	public static int[] startArr = new int[3];
	public static int[] endArr = new int[3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 3; i++) {
			int answer = 0;
			String[] split = br.readLine().split(" ");
			init(split);
			// 두 시간이 같지 않으면 같을 때까지 반복문을 실행한다.
			while (!equals(startArr, endArr)) {
				// startArr의 시간을 시간 정수로 바꾼 후 3의 배수인지 확인한다.
				if (timeNumber(startArr) % 3 == 0)
					answer++;
				// 시간을 1초 증가시킨다.
				timeAdd();
			}
			// 양쪽 끝 시간도 포함하여 계산해야 하므로 두 시간이 같아지는 시간도 포함하여 계산한다.
			if (timeNumber(endArr) % 3 == 0)
				answer++;
			System.out.println(answer);
		}
	}

	/**
	 * startArr과 endArr을 설정하는 메소드
	 * @param split 시작 시간과 끝나는 시간이 담긴 배열
	 */
	public static void init(String[] split) {
		String[] start = split[0].split(":");
		String[] end = split[1].split(":");
		for (int i = 0; i < 3; i++)
			startArr[i] = Integer.parseInt(start[i]);
		for (int i = 0; i < 3; i++)
			endArr[i] = Integer.parseInt(end[i]);
	}

	/**
	 * 두 시간이 같은 시간인지 구하는 메소드
	 * @param s 시작 시간
	 * @param e 끝나는 시간
	 * @return 두 시간이 같다면 true, 아니라면 false
	 */
	public static boolean equals(int[] s, int[] e) {
		for (int i = 0; i < s.length; i++)
			if (s[i] != e[i])
				return false;
		return true;
	}

	/**
	 * 주어진 배열을 시간 정수로 반환하는 메소드
	 * @param arr 시간 정보가 담긴 배열
	 * @return
	 */
	public static int timeNumber(int[] arr) {
		return arr[0] * 10000 + arr[1] * 100 + arr[2];
	}

	/**
	 * 시간을 1초 증가시키는 메소드
	 */
	public static void timeAdd() {
		if (++startArr[2] == 60) {
			startArr[2] = 0;
			if (++startArr[1] == 60) {
				startArr[1] = 0;
				if (++startArr[0] == 24)
					startArr[0] = 0;
			}
		}
	}
}