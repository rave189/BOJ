package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * N개의 자연수와 자연수 M이 주어진다.
 * 이 때, N개의 자연수 중에서 M개의 수를 고른 수열을 구하는 문제
 * 중복되는 수열을 여러 번 출력하면 안되며,
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 * @author Rave
 *
 */
public class Main {

	static int[] arr;
	// 같은 수를 두 번 쓰지 않기 위한 배열
	static boolean[] visited;
	// 중복되는 수열인지 확인하기 위한 해쉬
	static HashSet<String> hash = new HashSet<>();
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		// 정렬을 해두어 증가하는 순서로 선택할 수 있게 한다.
		Arrays.sort(arr);
		BruteForce(m, "");
		System.out.println(answer);
	}

	/**
	 * 중복을 허용하지 않으면서 M개의 수를 선택하는 메소드
	 * @param depth 남은 선택할 수
	 * @param result 현재까지 선택한 수를 저장하는 변수
	 */
	public static void BruteForce(int depth, String result) {
		if (depth == 0) {
			if (!hash.contains(result)) {
				hash.add(result);
				answer.append(result + "\n");
			}
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			BruteForce(depth - 1, result + arr[i] + " ");
			visited[i] = false;
		}
	}
}