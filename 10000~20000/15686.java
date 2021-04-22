package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * NxN인 도시에 집과 치킨 집이 있다.
 * 집에서 가장 가까운 치킨 집과의 거리를 치킨 거리라고한다.
 * 이러한 도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.
 * 또한 수익을 최대로 하기 위해서는 치킨 집 중에서 M개를 선택하고 나머지는 폐업시켜야 한다.
 * 이 때, 치킨 집 중 M개를 선택하여 도시의 치킨 거리의 최솟값을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	// 치킨 집의 위치를 저장할 배열
	static ArrayList<Point> chicken = new ArrayList<>();
	// 집의 위치를 저장할 배열
	static ArrayList<Point> houses = new ArrayList<>();
	// 선택한 치킨 집을 저장할 배열
	static ArrayList<Point> choice = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1)
					houses.add(new Point(i, j));
				else if (value == 2)
					chicken.add(new Point(i, j));
			}
		}
		BruteForce(0, m);
		System.out.println(answer);
	}

	/**
	 * 브루트포스 방법을 이용하여 치킨 집을 m개 선택하고 치킨 거리를 계산하는 메소드
	 * @param index 시작할 인덱스
	 * @param m 골라야 하는 치킨 집의 개수
	 */
	public static void BruteForce(int index, int m) {
		if (m == 0) {
			Check();
			return;
		}

		for (int i = index; i < chicken.size(); i++) {
			choice.add(chicken.get(i));
			BruteForce(i + 1, m - 1);
			choice.remove(choice.size() - 1);
		}
	}

	/**
	 * 골라진 치킨 집과 집들 사이의 치킨 거리를 구하는 메소드
	 */
	public static void Check() {
		int total = 0;
		for (Point house : houses) {
			// 집과 가장 가까운 치킨 집을 찾는다.
			int min = Integer.MAX_VALUE;
			for (Point store : choice) {
				int distance = Math.abs(house.x - store.x) + Math.abs(house.y - store.y);
				min = Math.min(min, distance);
			}
			// 치킨 거리를 total에 추가한다.
			total += min;
		}
		// 치킨 거리가 최소인지 비교한다.
		answer = Math.min(answer, total);
	}
}

class Point {
	int x, y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}

	public String toString() {
		return x + " " + y;
	}
}