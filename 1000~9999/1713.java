package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사진틀이 N개 있다.
 * 학생들이 추천을 시작하기 전에 모든 사진틀은 비어있다.
 * 어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
 * 비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고, 그 자리에 새롭게 추천받은 학생의 사진을 게시한다.
 * - 이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는 그러한 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
 * 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가시킨다.
 * 사진틀에 게시된 사진이 삭제되는 경우에는 해당 학생이 추천받은 횟수는 0으로 바뀐다.
 * 
 * 모든 학생들의 투표가 종료된 후 사진틀에 사진이 게재된 학생 번호를 오름차순으로 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	static Picture[] pictures = new Picture[101];

	/**
	 * 선형탐색으로 찾는게 가장 빨라보임
	 * 다양한 풀이가 나올 수 있을듯
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		for (int i = 0; i < m; i++) {
			int vote = Integer.parseInt(st.nextToken());
			if (pictures[vote] != null)
				pictures[vote].add();
			else {
				if (count == n) {
					int removeIdx = findRemovePicture();
					pictures[removeIdx] = null;
					count--;
				}
				pictures[vote] = new Picture(i, 1);
				count++;
			}
		}
		for (int i = 1; i < pictures.length; i++)
			if (pictures[i] != null)
				answer.append(i).append(' ');
		System.out.println(answer);
	}

	public static int findRemovePicture() {
		int idx = -1;
		int oldIn = Integer.MAX_VALUE;
		int minVote = Integer.MAX_VALUE;
		for (int i = 1; i < pictures.length; i++) {
			if (pictures[i] == null)
				continue;
			Picture cur = pictures[i];
			if (cur.voteCnt < minVote) {
				idx = i;
				minVote = cur.voteCnt;
				oldIn = cur.in;
			} else if (cur.voteCnt == minVote) {
				if (cur.in < oldIn) {
					idx = i;
					oldIn = cur.in;
				}
			}
		}
		return idx;
	}
}

class Picture {
	int in, voteCnt;

	public Picture(int in, int voteCnt) {
		this.in = in;
		this.voteCnt = voteCnt;
	}

	public void add() {
		voteCnt++;
	}
}