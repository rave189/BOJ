package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 혜빈이는 패션에 민감하여 한 번 입었던 옷들의 조합을 다시 입지 않는다.
 * 혜빈이가 가진 옷의 이름과 종류가 주어졌을 때
 * 혜빈이가 입을 수 있는 옷의 경우의 수를 구하는 문제
 * 단, 아무것도 입지 않는 경우는 제외한다.
 * @author Rave
 *
 */
public class Main {

	static HashMap<String, Integer> hash = new HashMap<>();

	/**
	 * 같은 종유의 옷의 개수에 입지 않는 경우를 1 더한 후
	 * 모든 경우의 수를 곱하여 구할 수 있다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			hash.clear();
			while (n-- > 0) {
				String[] split = br.readLine().split(" ");
				hash.put(split[1], hash.getOrDefault(split[1], 0) + 1);
			}
			int answer = 1;
			for (String key : hash.keySet())
				answer *= hash.get(key) + 1;
			sb.append(answer - 1 + "\n");
		}
		System.out.println(sb);
	}
}