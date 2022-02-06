package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N명의 학생이 있다.
 * 이 중 두 명의 학생의 키를 비교하는 행동을 M번 했다.
 * 키 비교 정보를 가지고 자신의 키가 몇 번째인지 정확히 알 수 있는 학생의 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 플로이드 와샬로 푸는 문제
	 * 우선 연결 가능한 모든 점을 플로이드 와샬로 체크해둔다.
	 * 이후 i에서 j로 갈 수 있다면 j에서 i로도 갈 수 있다는 체크를 한다.
	 * 그러면 자기 자신을 제외한 모든 노드가 true인 노드들이 있다.
	 * 이 노드들의 개수가 자신의 키를 정확히 알 수 있는 학생의 수이다.
	 * 
	 * 처음에 위상 정렬인 줄 알았는데, 분류보고 플로이드 와샬인거 알게됨
	 * 느낌상으로는 왜 정답인지 알 것 같은데 정확히 설명을 못함
	 * 플로이드 와샬한 결과 보면서 생각해보니까 i에서 j가는게 true이면 j에서 i도 true로 바꿔주면
	 * 자기 자신 빼고 다 true가 나올 것 같아서 해봤는데 정답
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] compare = new boolean[n + 1][n + 1];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			compare[first][second] = true;
		}
		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					if (compare[i][k] && compare[k][j])
						compare[i][j] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				compare[i][j] = compare[i][j] || compare[j][i];
				compare[j][i] = compare[i][j] || compare[j][i];
			}
		}
		int answer = 0;
		loop: for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (!compare[i][j])
					continue loop;
			}
			answer++;
		}
		System.out.println(answer);
	}
}