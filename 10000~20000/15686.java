package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * NxN�� ���ÿ� ���� ġŲ ���� �ִ�.
 * ������ ���� ����� ġŲ ������ �Ÿ��� ġŲ �Ÿ�����Ѵ�.
 * �̷��� ������ ġŲ �Ÿ��� ��� ���� ġŲ �Ÿ��� ���̴�.
 * ���� ������ �ִ�� �ϱ� ���ؼ��� ġŲ �� �߿��� M���� �����ϰ� �������� ������Ѿ� �Ѵ�.
 * �� ��, ġŲ �� �� M���� �����Ͽ� ������ ġŲ �Ÿ��� �ּڰ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	// ġŲ ���� ��ġ�� ������ �迭
	static ArrayList<Point> chicken = new ArrayList<>();
	// ���� ��ġ�� ������ �迭
	static ArrayList<Point> houses = new ArrayList<>();
	// ������ ġŲ ���� ������ �迭
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
	 * ���Ʈ���� ����� �̿��Ͽ� ġŲ ���� m�� �����ϰ� ġŲ �Ÿ��� ����ϴ� �޼ҵ�
	 * @param index ������ �ε���
	 * @param m ���� �ϴ� ġŲ ���� ����
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
	 * ����� ġŲ ���� ���� ������ ġŲ �Ÿ��� ���ϴ� �޼ҵ�
	 */
	public static void Check() {
		int total = 0;
		for (Point house : houses) {
			// ���� ���� ����� ġŲ ���� ã�´�.
			int min = Integer.MAX_VALUE;
			for (Point store : choice) {
				int distance = Math.abs(house.x - store.x) + Math.abs(house.y - store.y);
				min = Math.min(min, distance);
			}
			// ġŲ �Ÿ��� total�� �߰��Ѵ�.
			total += min;
		}
		// ġŲ �Ÿ��� �ּ����� ���Ѵ�.
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