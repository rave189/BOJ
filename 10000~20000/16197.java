package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * NxM 크기의 보드에 동전이 2개가 있다.
 * 이 두 동전을 4개의 버튼으로 상, 하, 좌, 우로 동시에 이동시킬 수 있다.
 * 이동은 다음과 같이 움직인다.
 * 1. 동전이 이동하려는 칸이 벽이면, 동전은 이동하지 않는다.
 * 2. 동전이 이동하려는 방향에 칸이 없으면 동전은 보드 바깥으로 떨어진다.
 * 3. 그 외의 경우에는 이동하려는 방향으로 한 칸 이동한다.이동하려는 칸에 동전이 있는 경우에도 한 칸 이동한다.
 * 두 동전 중 하나만 떨어뜨리기 위한 최소 버튼 수를 구하는 문제
 * 만약 동전이 떨어지지 않거나, 버튼을 10번 보다 많이 눌러야 한다면 -1을 출력한다.
 * @author Rave
 *
 */
public class Main {

	static char[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Point> coin = new LinkedList<>();

	/**
	 * 동전을 두 개씩 꺼내며 bfs를 수행한다.
	 * 일반적인 bfs와 같으나 try문을 2개 사용하여 두 동전 중 하나만 떨어지는지 확인한다.
	 * 
	 * 방문체크를 3차원으로 했는데 틀렸습니다가 나옴.
	 * 방문체크를 지우니 통과
	 * 어차피 10번보다 더 누르면 종료되고, 동전을 어디 벽에 끼워놓고 한 개만 떨어뜨리는 케이스가 존재하는 거 같다.
	 * 
	 * 4차원 배열을 선언하여 방문체크를 할 수 있음.
	 * 4차원 배열의 각 차원은 동전1의 X좌표, Y좌표, 동전2의 X좌표, Y좌표인거같다.
	 * 2개의 동전의 x, y좌표를 전부 기억하여 방문체크를 한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'o')
					coin.add(new Point(i, j));
			}
		}
		System.out.println(bfs());
	}

	public static int bfs() {
		int count = 0;
		while (!coin.isEmpty()) {
			count++;
			int size = coin.size();
			while ((size -= 2) >= 0) {
				Point coin1 = coin.poll();
				Point coin2 = coin.poll();
				for (int i = 0; i < dx.length; i++) {
					int dropCoinCnt = 0;
					int firstCoinX = coin1.x + dx[i];
					int firstCoinY = coin1.y + dy[i];
					int secondCoinX = coin2.x + dx[i];
					int secondCoinY = coin2.y + dy[i];
					try {
						if (map[firstCoinX][firstCoinY] == '#')
							coin.add(coin1);
						else
							coin.add(new Point(firstCoinX, firstCoinY));
					} catch (ArrayIndexOutOfBoundsException e) {
						dropCoinCnt++;
					}
					try {
						if (map[secondCoinX][secondCoinY] == '#')
							coin.add(coin2);
						else
							coin.add(new Point(secondCoinX, secondCoinY));
					} catch (ArrayIndexOutOfBoundsException e) {
						dropCoinCnt++;
					}
					if (dropCoinCnt == 1)
						return count;
				}
			}
			if (count >= 10)
				return -1;
		}
		return -1;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}