package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * �̸� ������ ������ �Ѵ�.
 * �̸��� ���� �̸��� ����Ͽ� ������ ���� ȹ���� ��Ʈ�� �־�����.
 * �� �̸� A�� B�� �־��� ��, �̸� ������ ����ϴ� ����
 * ���� �ڸ��� 0�̾ �� �ڸ��� ��µǰ� �Ѵ�.
 * @author Rave
 *
 */
public class Main {

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
	}
}