package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 뿌요뿌요의 상태가 주어졌을 때 몇 연쇄가 일어나는지 구하는 문제
 * 뿌요뿌요는 상, 하, 좌, 우로 4개 이상이 연결되면 터진다.
 * 터질 수 있는 뿌요뿌요가 여러 그룹이라면 한 번에 터트린다.
 * @author Rave
 *
 */
public class Main {

	static char[][] map = new char[12][6];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int count = 0;
	static boolean[][] visited;
	static ArrayList<Point> removeList = new ArrayList<>();

	/**
	 * 뿌요뿌요가 4개 이상 모였는지 확인하고, 모였다면 터트린다.
	 * 남은 뿌요뿌요를 모두 중력에 의해 아래로 끌어내린다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < map.length; i++) {
			String line = br.readLine();
			for (int j = 0; j < map[0].length; j++)
				map[i][j] = line.charAt(j);
		}
		int answer = 0;
		while (true) {
			visited = new boolean[map.length][map[0].length];
			// 뿌요뿌요가 터진다면 연쇄를 증가시키고 중력에 의해 남은 뿌요뿌요를 끌어내린다.
			// 연쇄가 종료되면 while문 종료
			if (isBomb()) {
				answer++;
				gravityPuyo();
			} else
				break;
		}
		System.out.println(answer);
	}

	public static boolean isBomb() {
		boolean isBomb = false;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == '.')
					continue;
				// 그룹이 4개 이상의 뿌요뿌요로 구성되어 있는지 확인한다.
				BFS(new Point(i, j), map[i][j]);
				// 4개 이상이라면 터트린다.
				if (removeList.size() >= 4) {
					removePuyo();
					isBomb = true;
				}
				removeList.clear();
			}
		}
		return isBomb;
	}

	public static void BFS(Point start, char type) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		removeList.add(start);
		visited[start.x][start.y] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (visited[nextX][nextY] || map[nextX][nextY] == '.' || map[nextX][nextY] != type)
						continue;
					Point next = new Point(nextX, nextY);
					visited[nextX][nextY] = true;
					q.add(next);
					removeList.add(next);
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
	}

	public static void removePuyo() {
		for (Point cur : removeList)
			map[cur.x][cur.y] = '.';
	}

	public static void gravityPuyo() {
		for (int i = 0; i < map[0].length; i++) {
			for (int j = map.length - 1; j >= 0; j--) {
				if (map[j][i] != '.')
					continue;
				for (int t = j - 1; t >= 0; t--) {
					if (map[t][i] != '.') {
						map[j][i] = map[t][i];
						map[t][i] = '.';
						break;
					}
				}
			}
		}
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}