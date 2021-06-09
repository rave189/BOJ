package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * N개의 숫자가 저장된 수열이 주어질 때
 * 이 수열의 부분 합중 그 합이 K가 되는 부분합의 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static HashMap<Long, Integer> hash = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] arr = new long[n + 1];
		long answer = 0;
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
			// 합이 K이면 answer을 증가시킨다.
			if (arr[i] == k)
				answer++;
			// arr[i] - X = k 이므로 X = arr[i] - k이고
			// 이 값을 hash에서 찾아 answer에 더해준다.
			answer += hash.getOrDefault(arr[i] - k, 0);
			// arr[i]를 hash에 추가한다.
			hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
		}
		System.out.println(answer);
	}
}