import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] nodes;
	static LinkedList<Integer>[] edges;
	static boolean[] visited;
	static boolean answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			nodes = new int[n];
			edges = new LinkedList[n];
			visited = new boolean[n];
			answer = false;
			for (int i = 0; i < n; i++)
				edges[i] = new LinkedList<Integer>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int firstNode = Integer.parseInt(st.nextToken()) - 1;
				int secondNode = Integer.parseInt(st.nextToken()) - 1;
				edges[firstNode].add(secondNode);
				edges[secondNode].add(firstNode);
			}
			Search();
			if (answer)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb);
	}

	public static void Search() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < nodes.length; i++) {
			if (visited[i])
				continue;
			q.add(i);
			nodes[i] = 1;
			while (!q.isEmpty()) {
				int node = q.poll();
				int type = nodes[node];
				visited[node] = true;
				for (int next : edges[node]) {
					if (visited[next])
						continue;
					int nextNodeType = nodes[next];
					if (nextNodeType == type)
						return;
					else if (nextNodeType == 0)
						nodes[next] = type * -1;
					q.add(next);
				}
			}
		}
		answer = true;
	}
}
