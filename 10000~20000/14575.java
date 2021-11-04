package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ��Ǯ�̸� �Ϸ��� �Ѵ�.
 * ��Ǯ�̿� ���� ������� ���� ������ �� ������� ���ø� ����� ������, ������� ���ø� �������� �־�����.
 * ��� ����� ����� ���� ������ ���� ���� ������ ���� �����鼭
 * ��� ����� ���� ���� ������ ��Ȯ�� T�� �ǰ�
 * � ����� S�� �ʰ��ϴ� ���� ���� �ʵ����ϴ� S�� �ּڰ��� ���ϴ� ����
 * S ���� ������� �Ұ����ϴٸ� -1 ���
 * @author Rave
 *
 */
public class Main {

	static Beer[] people;
	static int t;

	/**
	 * �̺�Ž���� ���� S�� ���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		people = new Beer[n];
		int minSum = 0, maxSum = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			people[i] = new Beer(min, max);
			minSum += min;
			maxSum += max;
		}
		// �̸� min�� max�� ��� ���� �� �� ���̿� ���ٸ� -1�� ���
		if (t < minSum || t > maxSum) {
			System.out.println(-1);
			return;
		}
		int left = 0, right = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;
			// �����ϸ� �ּҰ��� ���ؾ��ϴ� �������� ���δ�.
			if (isPossible(mid, minSum))
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left);
	}

	/**
	 * ��� ����� �ּ� ���� ���̴ٰ� �����Ѵ�.
	 * ���� v�� max �� ���� ���� ���ϰ� ���⿡ min���� ���־� �� ���� �� �ִ� ���� ���Ѵ�.
	 * �ּ� �� + �� ���� �� �ִ� ���� ���� T���� ũ�� true�� ��ȯ�Ͽ� �������� ���δ�.
	 * @param v S�� �� �� �ִ� ��
	 * @param minSum ��� ������� ���� �ּ����� ���� ��
	 * @return T �̻����� ���� �� �ִٸ� true, �ƴ϶�� false
	 */
	public static boolean isPossible(int v, int minSum) {
		int more = 0;
		
		for (int i = 0; i < people.length; i++) {
			if (people[i].min > v)
				return false;
			more += Math.min(people[i].max, v) - people[i].min;
		}
		if (more >= t - minSum)
			return true;
		return false;
	}
}

class Beer {
	int min, max;

	public Beer(int min, int max) {
		this.min = min;
		this.max = max;
	}
}