package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1번 노드가 루트 노드인 트리가 주어진다.
 * 1번 노드에는 w의 물이 있고, 이 물은 매초 다음과 같은 방법으로 자식 정점에게 떨어진다.
 * 1.물을 가지고 있으며, 자식 정점이 있다면 자식 정점 중 하나를 골라 물을 1 준다. 자식 정점이 여러 개라면 동일한 확률로 그 중 하나를 고른다.
 * 2.만약 부모 정점이 자신에게 물을 흘려보냈다면 받아서 쌓아 둔다.
 * 이 때, 물이 더 이상 움직이지 않는 상태가 되었을 때 i번 정점에 쌓인 물의 기댓값을 Pi라고 한다.
 * Pi가 0보다 큰 정점들에 대하여 Pi의 평균을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 물이 더 이상 움직이지 않는 다는 것은 모든 물이 리프 노드에 쌓여있다는 뜻이다.
	 * 따라서 리프노드에 쌓인 물의 기댓값의 평균을 구하는 문제
	 * 기댓값은 물의 양 w에 각 리프 노드로 들어갈 확률을 곱하는 것이다.
	 * 이 기댓값을 모두 더한 값은 결국 w 값이 된다. (같은 높이에 있는 노드들의 확률을 다 더하면 부모 노드의 확률이 나오기 때문)
	 * 따라서 w에 리프 노드의 수로 나눈다면 Pi 값을 찾을 수 있다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] tree = new int[n + 1];
		// 연결된 정점들을 모두 더해준다.
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			tree[first]++;
			tree[second]++;
		}
		// 리프 노드의 개수는 루트 노드가 아니면서 간선의 개수가 1개인 노드이다.
		double leafCnt = 0;
		for (int i = 2; i <= n; i++)
			if (tree[i] == 1)
				leafCnt++;
		System.out.println(String.format("%.6f", w / leafCnt));
	}
}