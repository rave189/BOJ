package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ����Ʋ�� N�� �ִ�.
 * �л����� ��õ�� �����ϱ� ���� ��� ����Ʋ�� ����ִ�.
 * � �л��� Ư�� �л��� ��õ�ϸ�, ��õ���� �л��� ������ �ݵ�� ����Ʋ�� �ԽõǾ�� �Ѵ�.
 * ����ִ� ����Ʋ�� ���� ��쿡�� ������� ��õ ���� Ƚ���� ���� ���� �л��� ������ �����ϰ�, �� �ڸ��� ���Ӱ� ��õ���� �л��� ������ �Խ��Ѵ�.
 * - �̶�, ������� ��õ ���� Ƚ���� ���� ���� �л��� �� �� �̻��� ��쿡�� �׷��� �л��� �� �Խõ� �� ���� ������ ������ �����Ѵ�.
 * ���� ������ �Խõ� �л��� �ٸ� �л��� ��õ�� ���� ��쿡�� ��õ���� Ƚ���� ������Ų��.
 * ����Ʋ�� �Խõ� ������ �����Ǵ� ��쿡�� �ش� �л��� ��õ���� Ƚ���� 0���� �ٲ��.
 * 
 * ��� �л����� ��ǥ�� ����� �� ����Ʋ�� ������ ����� �л� ��ȣ�� ������������ ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static Picture[] pictures = new Picture[101];

	/**
	 * ����Ž������ ã�°� ���� ������
	 * �پ��� Ǯ�̰� ���� �� ������
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