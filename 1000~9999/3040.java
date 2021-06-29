package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 일곱 난쟁이는 광산으로 일을 하러 간다.
 * 어느 날 아홉 난쟁이가 돌아왔다.
 * 다행히 백설공주는 난쟁이들의 모자에 수의 합이 100이 되도록 숫자를 적어놓았다.
 * 이 때, 일곱 난쟁이를 찾는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] dwarf;
	static ArrayList<Integer> answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarf = new int[9];
		answer = new ArrayList<>();
		for (int i = 0; i < dwarf.length; i++)
			dwarf[i] = Integer.parseInt(br.readLine());
		BruteForce(0, 0);
	}

	/**
	 * 브루트포스를 사용하여 일곱 난쟁이를 구한다.
	 * @param cur 탐색을 시작할 난쟁이
	 * @param sum 현재까지 난쟁이들의 숫자의 합
	 */
	public static void BruteForce(int cur, int sum) {
		if (answer.size() == 7) {
			if (sum == 100) {
				for (int i = 0; i < answer.size(); i++)
					System.out.println(answer.get(i));
				System.exit(0);
			}
			return;
		}
		for (int i = cur; i < dwarf.length; i++) {
			answer.add(dwarf[i]);
			BruteForce(i + 1, sum + dwarf[i]);
			answer.remove(answer.size() - 1);
		}
	}
}