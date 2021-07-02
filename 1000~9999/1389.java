package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �ɺ� �������� 6�ܰ� ��Ģ�� ��� ������� �ִ� 6�ܰ� �̳��� ���� �ƴ� ������� ����� �� �ִٴ� ��Ģ�̴�.
 * �̸� ���� N���� ����� ���� �� 1���� 2���� �ܰ�, 1���� 3���� �ܰ�... 1���� N���� �ܰ踦 ���� �� �ִ�.
 * �̷��� �ܰ踦 ��� ���� ���� �ɺ� �������� ����� �� �� �� ���� ���� ���� ����� ���ϴ� ����
 * 1���� 2���� 2�ܰ�, 1���� 3���� 1�ܰ�, 1���� 4���� 1�ܰ�, 1���� 5���� 2�ܰ���
 * 2+1+1+2 = 6�� �ǰ� �� ���� �ɺ� �������� ���� �ȴ�.
 * @author Rave
 *
 */
public class Main {

	static HashSet<Integer>[] relationship;
	static boolean[] visited;

	/**
	 * ������ ģ�� ���踦 �ؽ��� �����ϰ� �� ģ������� �� �ܰ踸�� ������ �� �ִ��� �ʺ� �켱 Ž���� ���� �˾Ƴ���.
	 * ���� �̷��� �ܰ��� ���� ���� ���� ����� ���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		relationship = new HashSet[n];
		for (int i = 0; i < n; i++)
			relationship[i] = new HashSet<>();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
			relationship[first].add(second);
			relationship[second].add(first);
		}
		int min = Integer.MAX_VALUE, answer = -1;
		for (int i = 0; i < n; i++) {
			int kevinNum = KevinBacon(i);
			if (kevinNum < min) {
				min = kevinNum;
				answer = i;
			}
		}
		System.out.println(answer + 1);
	}

	public static int KevinBacon(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited = new boolean[relationship.length];
		visited[start] = true;
		int kevinNum = 0;
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int friend = q.poll();
				kevinNum += depth;
				for (int nextFriend : relationship[friend]) {
					if (visited[nextFriend])
						continue;
					visited[nextFriend] = true;
					q.add(nextFriend);
				}
			}
			depth++;
		}
		return kevinNum;
	}
}