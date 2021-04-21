package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �����̰� ������ ���ٲ����� �ϰ��ִ�.
 * �����̴� 1�� �� +1, -1, *2�� �������� ������ �� �ִ�.
 * ������ 1�� �� +1, 2�� �� +2, 3�� �� +3�� ���� �����̵��� �Ѵ�.
 * �����̰� ������ ã�� ���� ���� �ð��� ���ϴ� ����
 * ã�� �� ���ų� ã�� ��ġ�� 50���� �Ѵ� ��� -1�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// ���� ó��
		if (n == k) {
			System.out.println(0);
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		// time[0]�� �����̰� ¦���ð��� ������ �ð���
		// time[1]�� �����̰� Ȧ���ð��� ������ �ð��� �����Ѵ�.
		// �����̴� +1�� -1�� ������ �� �ֱ� ������ ������ t��ǥ�� t+2, t+4, t+6�� �ð����� ������ �� �ִ�.
		int[][] time = new int[2][500001];
		q.add(n);
		int answer = Integer.MAX_VALUE;
		// ������ ���� + �귯�� �ð��� �˷��ִ� �����̴�.
		int accel = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			// ������ ��ġ�� �����̰� �� ���� �ִٸ� answer�� ������Ʈ ���ش�.
			if (k <= 500000 && time[accel++ % 2][k] != 0)
				answer = Math.min(answer, accel - 1);
			// 1�� ���� �����̰� ������ ��ġ�� ������Ʈ �Ѵ�.
			while (size-- > 0) {
				int cur = q.poll();
				int[] move = { -1, 1, cur };
				for (int i = 0; i < 3; i++) {
					int next = cur + move[i];
					try {
						// �ѹ��� �� ���� ���ų� �� ª�� �ð��� ������ �� �ִٸ� ������Ʈ���ش�.
						if (time[accel % 2][next] == 0 || time[(accel - 1) % 2][cur] + 1 < time[accel % 2][next]) {
							time[accel % 2][next] = time[(accel - 1) % 2][cur] + 1;
							q.add(next);
						}
					} catch (Exception e) {
					}
				}
			}
			// ������ ��ġ ����
			k += accel;
		}
		System.out.println(answer > 500000 ? -1 : answer);
	}
}