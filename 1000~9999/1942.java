package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ������ �ð�� hh:mm:ss�� ǥ��ȴ�.
 * �̶�, �ݷ�(:)��ȣ�� ���� hhmmss��� �ð� ������ ���� �� �ִ�.
 * �� �ð��� �־��� ��, �� �ð� ���̿� �����ϴ� �ð� ���� �� 3�� ����� ���� ������ ���ϴ� ����
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
			// �� �ð��� ���� ������ ���� ������ �ݺ����� �����Ѵ�.
			while (!equals(startArr, endArr)) {
				// startArr�� �ð��� �ð� ������ �ٲ� �� 3�� ������� Ȯ���Ѵ�.
				if (timeNumber(startArr) % 3 == 0)
					answer++;
				// �ð��� 1�� ������Ų��.
				timeAdd();
			}
			// ���� �� �ð��� �����Ͽ� ����ؾ� �ϹǷ� �� �ð��� �������� �ð��� �����Ͽ� ����Ѵ�.
			if (timeNumber(endArr) % 3 == 0)
				answer++;
			System.out.println(answer);
		}
	}

	/**
	 * startArr�� endArr�� �����ϴ� �޼ҵ�
	 * @param split ���� �ð��� ������ �ð��� ��� �迭
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
	 * �� �ð��� ���� �ð����� ���ϴ� �޼ҵ�
	 * @param s ���� �ð�
	 * @param e ������ �ð�
	 * @return �� �ð��� ���ٸ� true, �ƴ϶�� false
	 */
	public static boolean equals(int[] s, int[] e) {
		for (int i = 0; i < s.length; i++)
			if (s[i] != e[i])
				return false;
		return true;
	}

	/**
	 * �־��� �迭�� �ð� ������ ��ȯ�ϴ� �޼ҵ�
	 * @param arr �ð� ������ ��� �迭
	 * @return
	 */
	public static int timeNumber(int[] arr) {
		return arr[0] * 10000 + arr[1] * 100 + arr[2];
	}

	/**
	 * �ð��� 1�� ������Ű�� �޼ҵ�
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