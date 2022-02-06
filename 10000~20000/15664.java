package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * N개의 자연수와 자연수 M이 주어진다.
 * N개의 자연수 중에서 M개를 고른 수열이면서 고른 수열이 비내림차순인 수열을 모두 출력하는 문제
 * 중복되는 수열을 여러 번 출력하면 안되며, 사전 순으로 증가하는 순서로 출력해야 한다.
 * @author Rave
 *
 */
public class Main {

	static int[] arr;
	static boolean[] visited;
	static StringBuilder answer = new StringBuilder();
	static HashSet<String> hash = new HashSet<>();

	/**
	 * N과 M시리즈
	 * 뭔가 hash쓰니까 반칙쓰는거같다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		bruteforce(0, "", m);
		System.out.print(answer);
	}

	public static void bruteforce(int cur, String result, int depth) {
		if (depth == 0) {
			answer.append(result).append('\n');
			return;
		}

		for (int i = cur; i < arr.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			bruteforce(i + 1, result + arr[i] + " ", depth - 1);
			visited[i] = false;
		}
	}
}