package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 개의 원자력 발전소가 있다.
 * 이 원자력 발전소는 반지름이 R인 원지역을 방사능에 노출시켜 방사능 고위험 지역으로 만든다.
 * 이를 대처하기 위해 원 안의 집은 방호복을 받게 된다.
 * 만약, 두 발전소의 위험지역에 모두 포함되는 집은 방호복을 2개를 받게 된다.
 * 2개를 받는 집은 하나를 방호복을 받지 못하는 집에 나눠준다.
 * 이때, 방호복을 받지 못하는 집의 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static double[][] distance;

	/**
	 * 집과 발전소의 위치가 주어지면 각각의 거리를 distance에 저장하고 정렬을 한다.
	 * 이후 첫 번째 발전소로 방호복을 받는 집의 수와 두 번째 발전소로 방호복을 받는 집의 수를 더한 값을 전체 집의 수에서 빼준다.
	 * 만약 뺀 값이 음수라면 모든 집이 방호복을 받을 수 있다는 의미이므로 0을 출력한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		for (int testCase = 1;; testCase++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			Point[] houses = new Point[n];
			Point[] powerStations = new Point[2];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				houses[i] = new Point(x, y);
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < powerStations.length; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				powerStations[i] = new Point(x, y);
			}
			distance = new double[powerStations.length][n];
			for (int i = 0; i < distance.length; i++) {
				for (int j = 0; j < n; j++)
					distance[i][j] = powerStations[i].getDistance(houses[j]);
				Arrays.sort(distance[i]);
			}
			int q = Integer.parseInt(st.nextToken());
			answer.append(String.format("Case %d:", testCase)).append('\n');
			while (q-- > 0) {
				st = new StringTokenizer(br.readLine());
				int r1 = Integer.parseInt(st.nextToken());
				int r2 = Integer.parseInt(st.nextToken());
				int noReceiveHouse = distance[0].length - getReceiveHouse(0, r1) - getReceiveHouse(1, r2);
				answer.append(noReceiveHouse < 0 ? 0 : noReceiveHouse).append('\n');
			}
		}
		System.out.print(answer);
	}

	public static int getReceiveHouse(int idx, int r) {
		int left = 0, right = distance[idx].length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (distance[idx][mid] <= r)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double getDistance(Point o) {
		int diffX = x - o.x;
		int diffY = y - o.y;
		return Math.sqrt(diffX * diffX + diffY * diffY);
	}
}