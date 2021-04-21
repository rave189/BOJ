package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 수빈이가 동생과 숨바꼭질을 하고있다.
 * 수빈이는 1초 후 +1, -1, *2의 방향으로 움직일 수 있다.
 * 동생은 1초 후 +1, 2초 후 +2, 3초 후 +3과 같이 가속이동을 한다.
 * 수빈이가 동생을 찾는 가장 빠른 시간을 구하는 문제
 * 찾을 수 없거나 찾는 위치가 50만을 넘는 경우 -1을 출력한다.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 예외 처리
		if (n == k) {
			System.out.println(0);
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		// time[0]은 수빈이가 짝수시간에 도착한 시간을
		// time[1]은 수빈이가 홀수시간에 도착한 시간을 저장한다.
		// 수빈이는 +1과 -1을 움직일 수 있기 때문에 임의의 t좌표에 t+2, t+4, t+6의 시간에도 도착할 수 있다.
		int[][] time = new int[2][500001];
		q.add(n);
		int answer = Integer.MAX_VALUE;
		// 동생의 가속 + 흘러간 시간을 알려주는 변수이다.
		int accel = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			// 동생의 위치에 수빈이가 온 적이 있다면 answer을 업데이트 해준다.
			if (k <= 500000 && time[accel++ % 2][k] != 0)
				answer = Math.min(answer, accel - 1);
			// 1초 동안 수빈이가 움직인 위치를 업데이트 한다.
			while (size-- > 0) {
				int cur = q.poll();
				int[] move = { -1, 1, cur };
				for (int i = 0; i < 3; i++) {
					int next = cur + move[i];
					try {
						// 한번도 온 적이 없거나 더 짧은 시간에 도달할 수 있다면 업데이트해준다.
						if (time[accel % 2][next] == 0 || time[(accel - 1) % 2][cur] + 1 < time[accel % 2][next]) {
							time[accel % 2][next] = time[(accel - 1) % 2][cur] + 1;
							q.add(next);
						}
					} catch (Exception e) {
					}
				}
			}
			// 동생의 위치 변경
			k += accel;
		}
		System.out.println(answer > 500000 ? -1 : answer);
	}
}