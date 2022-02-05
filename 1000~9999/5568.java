package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * N개의 카드가 주어진다.
 * 이 카드 중에서 K장을 선택해서 나란히 붙인 정수를 만들려고 한다.
 * 이 때, 만들 수 있는 정수의 개수를 구하는 문제
 * 중복은 빼야한다.
 * @author Rave
 *
 */
public class Main {

	static String[] arr;
	static boolean[] visited;
	static HashSet<String> hash = new HashSet<>();

	/**
	 * 브루트포스로 Hash에 넣으며 찾는다.
	 * 
	 * 조합이래서 조합으로 어케풀지 했는데 결국 처음 생각이 맞음
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		arr = new String[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++)
			arr[i] = br.readLine();
		find(k, "");
		System.out.println(hash.size());
	}

	public static void find(int depth, String result) {
		if (depth == 0) {
			hash.add(result);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			find(depth - 1, result + arr[i]);
			visited[i] = false;
		}
	}
}