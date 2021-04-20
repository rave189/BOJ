package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �� F������ �̷���� �ǹ��� �ִ�.
 * ��ȣ�� S���� �ְ� G������ ������ ���������͸� Ÿ���� �Ѵ�.
 * ���������ʹ� ��ư�� ���� U�� ���� ��ư�� �Ʒ��� D�� ���� ��ư�� �ִ�.
 * ��ȣ�� G������ ���� ���� ������ ��ư�� �ּڰ��� ���ϴ� ����
 * G������ ���� ���Ѵٸ� use the stairs�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	// �ش� ���� �湮�� ���� �ִ��� Ȯ���Ѵ�.
	static boolean[] visited;
	// u�� -d�� ������ �迭
	static int[] move;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		visited = new boolean[f + 1];
		move = new int[] { u, -d };
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;
		int click = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int floor = q.poll();
				if (floor == g) {
					System.out.println(click);
					return;
				}
				for (int i = 0; i < 2; i++) {
					int nextFloor = floor + move[i];
					try {
						// �湮�� ���� ���� ���̰ų� 0���� �ƴ� ��� ť�� �ش� ���� �ִ´�.
						// 0������ ���ٰ� u��ŭ �ö�� �� �����Ƿ� 0���� �����Ѵ�.
						if (nextFloor != 0 && !visited[nextFloor]) {
							q.add(nextFloor);
							visited[nextFloor] = true;
						}
					} catch (Exception e) {
					}
				}
			}
			click++;
		}
		System.out.println("use the stairs");
	}
}