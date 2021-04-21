package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N명의 학생이 각자 프로젝트를 함께하고 싶은 학생을 선택한다.
 * 선택한 학생들이 사이클을 이룬다면 그 학생들은 팀이 된다.
 * 팀원이 되지 못한 학생들의 수를 구하는 문제
 */
public class Main {

	static int[] arr;
	static int[] visited;
	static int[] firstIdx;
	static int first;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n + 1];
			visited = new int[n + 1];
			firstIdx = new int[n + 1];
			answer = 0;
			for (int i = 1; i <= n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			int answer = 0;
			for (int i = 1; i <= n; i++)
				// 한 번 방문했던 정점은 다시 방문하지 않는다.
				if (visited[i] == 0) {
					first = i;
					answer += DFS(i, 1);
				}
			sb.append(n - answer + "\n");
		}
		System.out.println(sb);
	}

	/**
	 * visited에는 몇 번째 방문인지를 저장한다.
	 * firstIdx에는 first의 값을 저장해 나간다.
	 * 진행 도중 방문 했던 정점을 다시 방문하게 되고 first의 값이 같다면 같은 탐색 도중에 만나게 된 것이다.
	 * 이런 경우 이전에 저장해둔 현재 방문 횟수인 count에서 이전 방문 횟수인 visited[index]를 빼면,
	 * 사이클을 이루는 학생들의 수를 구할 수 있다.
	 * first의 값이 다르다면 다른 탐색 도중에 만나게 된 것으로, 사이클을 구할 수 없다.
	 * @param index 현재 인덱스
	 * @param count 방문 횟수
	 * @return 사이클을 이루는 학생의 수
	 */
	public static int DFS(int index, int count) {
		if (visited[index] != 0) {
			if (firstIdx[index] == first)
				return count - visited[index];
			return 0;
		}
		visited[index] = count;
		firstIdx[index] = first;
		return DFS(arr[index], count + 1);
	}
}