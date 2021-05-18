package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ����Ϳ��� ������ ����Ϸ��� �Ѵ�.
 * ����� ������ ��뿡���� ����� �����ϴ�.
 * �� ��, ��ɲ��� ���� �����Ÿ��� L�� �� L���� �۰ų� ���� ��ġ�� ������ ���� �� �ִ�.
 * ���� ���� ������ �Ÿ��� abs(������ x��ǥ - ����� ��ġ) + ������ y��ǥ�� ���� �� �ִ�.
 * ���� �������� ��ġ�� �־��� ��, ���� �� �ִ� ������ ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���� ������ ��ġ�� �����Ѵ�.
	 * ������ �������� ����� �� �ִ� ��븦 ã�´�.
	 * Bird�� ������ �ʰ� �Է����� ���ڸ��� ������ �Ÿ��� �����ϴ°� �� ������.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] location = new int[m];
		for (int i = 0; i < m; i++)
			location[i] = Integer.parseInt(st.nextToken());
		Animal[] animals = new Animal[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			animals[i] = new Animal(x, y);
		}
		Arrays.sort(location);
		int answer = 0;
		// ���� �� �ִ� ������ ���� ���Ѵ�.
		for (Animal animal : animals) {
			// ������ y��ǥ�� �����Ÿ����� ��� ������ ������� ���Ѵ�.
			if (animal.y > l)
				continue;
			// �̺� Ž������ ����� �� �ִ� ��븦 ã�´�.
			int left = 0, right = m - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				// ����� �� �ִٸ� answer++ �� while���� �����Ѵ�.
				if (Math.abs(location[mid] - animal.x) + animal.y <= l) {
					answer++;
					break;
				}
				if (location[mid] > animal.x)
					right = mid - 1;
				else
					left = mid + 1;
			}
		}
		System.out.println(answer);
	}
}

class Animal {
	int x, y;

	public Animal(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}

	public String toString() {
		return x + " " + y;
	}
}