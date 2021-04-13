package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 결혼식에 학교 동기 중 친구과 친구의 친구를 초대하려고 한다.
 * 상근이의 학번이 1번일 때 초대할 사람의 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static boolean[][] relationship;
	static boolean[] visited;
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int people = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		relationship = new boolean[people + 1][people + 1];
		visited = new boolean[people + 1];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			relationship[first][second] = true;
			relationship[second][first] = true;
		}
		DFS(1, 2);
		System.out.println(answer);
	}

	/**
	 * 친구와 친구의 친구를 찾는 메소드
	 * @param next 다음 탐색할 친구
	 * @param depth 친구의 깊이
	 */
	public static void DFS(int next, int depth) {
		// 방문하지 않은 친구일 경우 증가시킨다.
		if (!visited[next])
			answer++;
		visited[next] = true;
		// 친구의 친구까지 조사했다면 반환한다.
		if (depth == 0)
			return;
		for (int i = 2; i < relationship.length; i++)
			// 친구의 친구까지 모두 탐색해야 하므로 visited를 사용하지 않는다.
			if (relationship[next][i])
				DFS(i, depth - 1);
	}
}