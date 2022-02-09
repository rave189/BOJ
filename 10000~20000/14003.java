package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * ���� A�� �־��� ��, ���� �� �����ϴ� �κ� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static ArrayList<Integer> d = new ArrayList<>();

	/**
	 * �Է��� �ʹ� ũ�� ������ ������ �����ϴ� �κ� ���� ���ϵ��� �ϸ� �ð� �ʰ��� ����.
	 * ���� ���� �����ص� d �迭�� �����.
	 * d �迭�� ���� ������ ���� ���� ��� ������ �ִ����� �����ϴ� ���ĵ� �迭�� ���̳ʸ� ��ġ�� ���� ã�� �� �ִ�.(�Ǵ� �ε��� Ʈ��)
	 * ���� �˻��ؾ� �ϴ� ���� d�� ������ ������ ū ���̶�� d�� �״�� ���� �߰����־� ���� ���� ������ ũ�⸦ �ø���.
	 * ���� �߰��� �ִ� ����� �̺� Ž���� ���� �� ���� ��� �������� ���� �ϴ����� �޾ƿ´�.
	 * ���� �� ������ �� ��° ���������� order �迭�� �����Ѵ�.
	 * �׸��� Ư�� ������ ����� Ư�� ������ ������Ʈ ���ְ�, d�� ������ ������ ũ�ٸ� d�� �״�� �߰����ش�.
	 * ���� ���� ���� ������ order�� ���� �ε����� d�� ũ�⸦ �ϳ��� �ٿ����� �´��� ���Ѵ�.
	 * ���� ���� ������ ��Ҵ� ���� ���� �� �� ������ ���� ó������ ������ �ε����� ���� ���� ������ ��ҷ� �Ǵ��Ͽ� �����ϰ� ����Ѵ�. 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] order = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		d.add(arr[0]);
		for (int i = 1; i < n; i++) {
			int index = binarySearch(arr[i]);
			order[i] = index;
			if (index >= d.size())
				d.add(arr[i]);
			else
				d.set(index, arr[i]);
		}
		answer.append(d.size()).append('\n');
		int[] result = new int[d.size()];
		for (int i = n - 1, count = d.size() - 1; i >= 0; i--) {
			if (order[i] == count)
				result[count--] = arr[i];
		}
		for (int v : result)
			answer.append(v).append(' ');
		System.out.print(answer);
	}

	public static int binarySearch(int target) {
		int left = 0, right = d.size() - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (d.get(mid) >= target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}
}