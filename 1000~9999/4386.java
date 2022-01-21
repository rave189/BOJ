package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 별들의 좌표가 주어진다.
 * 이 별들을 직/간접적으로 이어주려고 한다.
 * 이 때 별들 사이의 거리만큼의 비용이 든다고 할때
 * 별자리를 만드는 최소 비용을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] unionFind;

	/**
	 * 최소 스패닝 트리를 사용하여 문제를 풀 수 있다.
	 * 크루스칼 알고리즘을 사용하여 문제를 품
	 * 모든 간선을 우선순위 큐에 넣는다.
	 * 이후 하나의 간선을 꺼내며 사이클이 생성되지 않는다면 간선을 이어준다.
	 * 사이클이 생성되는 조건은 같은 부모를 가지는 경우
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		unionFind = new int[n];
		for (int i = 1; i < n; i++)
			unionFind[i] = i;
		ArrayList<Point> stars = new ArrayList<>();
		PriorityQueue<Line> pq = new PriorityQueue<>();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			for (int i = 0; i < stars.size(); i++) {
				Point star = stars.get(i);
				double distance = getDistance(star.x - x, star.y - y);
				pq.add(new Line(i, stars.size(), distance));
				pq.add(new Line(stars.size(), i, distance));
			}
			stars.add(new Point(x, y));
		}
		int lineCnt = unionFind.length;
		double answer = 0;
		while (lineCnt > 1) {
			Line cur = pq.poll();
			if (union(cur.x, cur.y)) {
				answer += cur.cost;
				lineCnt--;
			}
		}
		System.out.println(answer);
	}

	public static double getDistance(double x, double y) {
		return Math.sqrt(x * x + y * y);
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			unionFind[y] = x;
			return true;
		}
		return false;
	}

	public static int find(int n) {
		if (n == unionFind[n])
			return n;
		return unionFind[n] = find(unionFind[n]);
	}
}

class Point {
	double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Line implements Comparable<Line> {
	int x, y;
	double cost;

	public Line(int x, int y, double cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Line o) {
		return (int) (cost - o.cost);
	}
}