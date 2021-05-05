package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 트리가 주어질 때, 각각의 정점이 단절점인지, 각각의 간선이 단절선인지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 트리에서 단절점은 루트 노드와 리프 노드를 제외한 모든 노드가 단절점이다.
	 * 트리에서 단절선은 모든 간선이 단절선이다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		int[] tree = new int[n + 1];
		while (--n > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			tree[first]++;
			tree[second]++;
		}
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if (t == 2 || (t == 1 && tree[k] > 1))
				sb.append("yes");
			else
				sb.append("no");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}