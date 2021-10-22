package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 이름 궁합을 보려고 한다.
 * 이름은 영어 이름을 사용하여 궁합을 보고 획수는 힌트에 주어진다.
 * 두 이름 A와 B가 주어질 때, 이름 궁합을 출력하는 문제
 * 십의 자리가 0이어도 두 자리고 출력되게 한다.
 * @author Rave
 *
 */
public class Main {

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
	}
}