package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * N개의 자연수와 자연수 M이 주어진다.
 * 이 때, N개의 자연수 중에서 M개를 고른 수열을 구하는 문제
 * M개를 고를 때 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 * 비내림차순 = 오름차순(?)인 것 같다.
 * @author Rave
 *
 */
public class Main {

	static int[] arr;
	// 중복되는 수열인지 검사
	static HashSet<String> hash = new HashSet<>();
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		// 정렬해 놓고 순서대로 선택해본다.
		Arrays.sort(arr);
		BruteForce(0, m, "");
		System.out.println(answer);
	}

	/**
	 * M개의 자연수를 브루트 포스를 이용하여 선택하는 메소드
	 * @param depth  남은 자연수의 개수
	 * @param result 고른 자연수
	 */
	public static void BruteForce(int cur, int depth, String result) {
		if (depth == 0) {
			if (!hash.contains(result)) {
				hash.add(result);
				answer.append(result + "\n");
			}
			return;
		}
		for (int i = cur; i < arr.length; i++)
			BruteForce(i, depth - 1, result + arr[i] + " ");
	}
}