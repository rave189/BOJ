import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[][] food;
	static PriorityQueue<Wood> wood;
	static Queue<Wood> deadWood = new LinkedList<Wood>();
	static Queue<Wood> newWood = new LinkedList<Wood>();
	static int[] drtX = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] drtY = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(map[i], 5);
		food = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				food[i][j] = Integer.parseInt(st.nextToken());
		}
		wood = new PriorityQueue<Wood>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			wood.add(new Wood(x, y, age));
		}
		for (int i = 0; i < k; i++) {
			Spring();
			Summer();
			Fall();
			Winter();
			newWood.clear();
		}
		System.out.println(wood.size());
	}

	public static void Spring() {
		while (!wood.isEmpty()) {
			Wood cur = wood.poll();
			if (map[cur.x][cur.y] - cur.age >= 0) {
				map[cur.x][cur.y] -= cur.age;
				newWood.add(new Wood(cur.x, cur.y, cur.age + 1));
			} else
				deadWood.add(cur);
		}
	}

	public static void Summer() {
		while (!deadWood.isEmpty()) {
			Wood cur = deadWood.poll();
			map[cur.x][cur.y] += cur.age / 2;
		}
	}

	public static void Fall() {
		while (!newWood.isEmpty()) {
			Wood cur = newWood.poll();
			if (cur.age % 5 == 0)
				for (int i = 0; i < 8; i++) {
					int nextX = cur.x + drtX[i];
					int nextY = cur.y + drtY[i];
					if ((0 <= nextX && nextX < map.length) && (0 <= nextY && nextY < map.length))
						wood.add(new Wood(nextX, nextY, 1));
				}
			wood.add(cur);
		}
	}

	public static void Winter() {
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map.length; j++)
				map[i][j] += food[i][j];
	}
}

class Wood implements Comparable<Wood> {
	int x;
	int y;
	int age;

	public Wood(int _x, int _y, int _age) {
		this.x = _x;
		this.y = _y;
		this.age = _age;
	}

	@Override
	public int compareTo(Wood o) {
		if (age < o.age)
			return -1;
		else if (age == o.age)
			return 0;
		else
			return 1;
	}
}
