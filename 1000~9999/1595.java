package BOJ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * ���󿡴� �ִ� 10000���� ���ð� �ִ�.
 * �� ���ô� ������ �� ���ð� �̵��ϴ� ��ΰ� �����ϵ��� ���ΰ� ����Ǿ� �ִ�.
 * �� ��, �� ���� ���� �Ÿ��� ���� �� �Ÿ��� ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static final int SIZE = 10000;
	static List<City>[] map;

	/**
	 * ���ͽ�Ʈ�����پ˰� �����־��µ� �ƴϾ���.
	 * ��ΰ� �����ѰŸ� Ʈ���ε�...
	 * ���ð� 10000������ ���Ʈ������ �����Ѱ͵� �ǿܿ���.
	 * �ð����⵵ ����ϴ� ������ �鿩���� �� ����
	 * 
	 * ���ð� 1���� �ִ� ��� �Է� ��ü�� ���� �� ����.
	 * �׷��� NoSuchElementException�� ����.
	 * ���� ����ִ� ������ Ǯ��.
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		map = new List[SIZE];
		for (int i = 0; i < SIZE; i++)
			map[i] = new ArrayList<>();
		try {
			while (scanner.hasNextLine()) {
				StringTokenizer st = new StringTokenizer(scanner.nextLine());
				int first = Integer.parseInt(st.nextToken()) - 1;
				int second = Integer.parseInt(st.nextToken()) - 1;
				int cost = Integer.parseInt(st.nextToken());
				map[first].add(new City(second, cost));
				map[second].add(new City(first, cost));
			}
		} catch (NoSuchElementException e) {
		}
		int answer = 0;
		for (int i = 0; i < SIZE; i++) {
			if (map[i].size() == 0)
				continue;
			answer = Math.max(answer, dfs(i, -1, 0));
		}
		System.out.println(answer);
	}

	public static int dfs(int cur, int prev, int cost) {
		int max = cost;
		for (City next : map[cur]) {
			if (next.p == prev)
				continue;
			max = Math.max(max, dfs(next.p, cur, cost + next.cost));
		}
		return max;
	}
}

class City {
	int p, cost;

	public City(int p, int cost) {
		this.p = p;
		this.cost = cost;
	}
}