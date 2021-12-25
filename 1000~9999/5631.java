package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * �� ���� ���ڷ� �����Ұ� �ִ�.
 * �� ���ڷ� �����Ҵ� �������� R�� �������� ���ɿ� ������� ���� ������ �������� �����.
 * �̸� ��ó�ϱ� ���� �� ���� ���� ��ȣ���� �ް� �ȴ�.
 * ����, �� �������� ���������� ��� ���ԵǴ� ���� ��ȣ���� 2���� �ް� �ȴ�.
 * 2���� �޴� ���� �ϳ��� ��ȣ���� ���� ���ϴ� ���� �����ش�.
 * �̶�, ��ȣ���� ���� ���ϴ� ���� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static double[][] distance;

	/**
	 * ���� �������� ��ġ�� �־����� ������ �Ÿ��� distance�� �����ϰ� ������ �Ѵ�.
	 * ���� ù ��° �����ҷ� ��ȣ���� �޴� ���� ���� �� ��° �����ҷ� ��ȣ���� �޴� ���� ���� ���� ���� ��ü ���� ������ ���ش�.
	 * ���� �� ���� ������� ��� ���� ��ȣ���� ���� �� �ִٴ� �ǹ��̹Ƿ� 0�� ����Ѵ�.
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