package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * NxM 크기의 격자판이 있다.
 * 격자판에는 적이 있다.
 * N+1에는 성이 있다.
 * 이 성에 궁수 3명을 배치하려고 한다.
 * 궁수는 거리가 D이하인 적 중 가장 가까운 적을, 그러한 적이 많다면 가장 왼쪽의 적을 제거할 수 있다.
 * 궁수를 잘 배치하여 제거할 수 있는 최대 적을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static List<Point> enemies = new ArrayList<>();
	static int answer = 0, archerSize = 3, d, n, m;
	static Point[] archers = new Point[archerSize];

	/**
	 * 빡구현
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int v = Integer.parseInt(st.nextToken());
				if (v == 1)
					enemies.add(new Point(i, j));
			}
		}
		bruteforce(0, 0);
		System.out.println(answer);
	}

	public static void bruteforce(int depth, int cur) {
		if (depth == archerSize) {
			answer = Math.max(answer, simulation());
			return;
		}
		for (int i = cur; i < m; i++) {
			archers[depth] = new Point(n, i);
			bruteforce(depth + 1, i + 1);
		}
	}

	public static int simulation() {
		Set<Point> hash = new HashSet<>();
		for (Point enemy : enemies)
			hash.add(new Point(enemy.x, enemy.y));
		int totalRemoveCnt = 0;
		while (hash.size() > 0) {
			Point[] removeEnemies = getCloseEnemy(hash);
			for (Point remove : removeEnemies) {
				if (hash.contains(remove)) {
					hash.remove(remove);
					totalRemoveCnt++;
				}
			}
			Iterator<Point> it = hash.iterator();
			while (it.hasNext()) {
				Point cur = it.next();
				cur.move();
				if (cur.x == n)
					it.remove();
			}
		}
		return totalRemoveCnt;
	}

	public static int getDistance(Point archer, Point enemy) {
		return Math.abs(archer.x - enemy.x) + Math.abs(archer.y - enemy.y);
	}

	public static boolean isClose(Point archer, Point enemy, Point compare) {
		int enemyDistance = getDistance(archer, enemy);
		int compareDistance = getDistance(archer, compare);
		if (compareDistance < enemyDistance)
			return true;
		else if (compareDistance == enemyDistance)
			return compare.y - enemy.y < 0;
		return false;
	}

	public static Point[] getCloseEnemy(Set<Point> hash) {
		Point[] removeEnemies = new Point[archerSize];
		for (int i = 0; i < archerSize; i++) {
			Point archer = archers[i];
			Point remove = null;
			for (Point enemy : hash) {
				if (getDistance(archer, enemy) <= d) {
					if (remove == null)
						remove = enemy;
					else if (isClose(archer, remove, enemy))
						remove = enemy;
				}
			}
			removeEnemies[i] = remove;
		}
		return removeEnemies;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move() {
		x++;
	}
}