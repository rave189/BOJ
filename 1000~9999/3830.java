package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 샘플 중 두 샘플의 무게를 비교하는 것을 M번을 한다.
 * 무게를 재는 동안 중간 중간 교수님이 A와 B의 무게 차가 얼마인지 물어본다.
 * 만약 무게를 비교했다면 대답하고, 비교하지 않았다면 대답하지 못한다.
 * 교수님에게 할 수 있는 대답을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] unionFind;
	static int[] weightDiff;

	/**
	 * 유니온 파인드를 사용하여 문제를 풀 수 있다.
	 * 무게를 비교한 샘플들은 같은 그룹 내에 존재하도록 한다.
	 * 가장 가벼운 샘플을 루트로 두고, 내려가면서 루트와의 무게차를 저장한다.
	 * 
	 * 무게 차를 저장한다는 생각도 힘들고, 차이를 저장하는 방법도 잘 이해가 되지 않는다.
	 * 다시 구현해보라고 하면 절대 못할 듯...
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0)
				break;
			unionFind = new int[n];
			weightDiff = new int[n];
			for (int i = 1; i < n; i++)
				unionFind[i] = i;
			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				if (command == '!') {
					int diff = Integer.parseInt(st.nextToken());
					union(a, b, diff);
				} else {
					if (find(a) == find(b))
						answer.append(weightDiff[b] - weightDiff[a]);
					else
						answer.append("UNKNOWN");
					answer.append('\n');
				}
			}
		}
		System.out.println(answer);
	}

	public static void union(int a, int b, int diff) {
		int parentA = find(a);
		int parentB = find(b);
		if (parentA == parentB)
			return;
		weightDiff[parentB] = weightDiff[a] - weightDiff[b] + diff;
		unionFind[parentB] = parentA;
	}

	public static int find(int n) {
		if (n == unionFind[n])
			return n;
		int parent = find(unionFind[n]);
		weightDiff[n] += weightDiff[unionFind[n]];
		return unionFind[n] = parent;
	}
}