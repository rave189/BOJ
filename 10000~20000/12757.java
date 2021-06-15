package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * �����ͺ��̽����� ������ �߰�, ����, �˻��� �����ϴ� ���α׷��� ����� ����
 * �� ���α׷������� Key�� �������� �ʾƵ� ���� ������ Key�� ã���ִ� ���α׷��̴�.
 * ��, �� ���� ���̰� K���� ū ��� Key�� �������� �ʴ´�.
 * 1 Key Value�� ������ Key�� Value�� �����ͺ��̽��� �߰��Ѵ�.
 * 2 Key Value�� ������ Key�� �˻��� �����͸� Value�� �����Ѵ�.
 * 	������ �����ϴ� Key�� ���ٸ� �����Ѵ�.
 * 3 Key�� ������ �ش� Key�� �˻��� �����͸� ����Ѵ�.
 * 	������ �����ϴ� Key�� ���ٸ� -1�� ����Ѵ�.
 * 	������ �����ϴ� Key�� �� �� �̻� �����Ѵٸ� ?�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static TreeMap<Integer, Integer> tree = new TreeMap<>();
	static int k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			tree.put(key, value);
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int key = Integer.parseInt(st.nextToken());
			// 1�� ������ �����͸� �߰��Ѵ�.
			if (type == 1) {
				int value = Integer.parseInt(st.nextToken());
				tree.put(key, value);
			}
			// 2�� ������ Key�� ã�� �� �ִ� ��� �����͸� �����Ѵ�.
			else if (type == 2) {
				int value = Integer.parseInt(st.nextToken());
				int correctKey = getCorrectKey(key);
				if (correctKey >= 0)
					tree.put(correctKey, value);
			}
			// 3�� ������ Key�� ã�� �� �ִٸ� �׿� �ش��ϴ� Value�� ����ϰ�
			// �� �� �̻��̸� ?��, ã�� �� ���ٸ� -1�� ����Ѵ�.
			else if (type == 3) {
				int correctKey = getCorrectKey(key);
				if (correctKey >= 0)
					sb.append(tree.get(correctKey) + "\n");
				else if (correctKey == -2)
					sb.append("?\n");
				else
					sb.append("-1\n");
			}
		}
		System.out.println(sb);
	}

	/**
	 * �����ͺ��̽����� Key�� ���� ������ Key�� ã�� �޼ҵ�
	 * @param key ã������ Key
	 * @return Key�� �����Ѵٸ� Key, �� �� �̻��̶�� -2, ã�� �� ���ٸ� -1
	 */
	public static int getCorrectKey(int key) {
		Integer ceilKey = tree.ceilingKey(key);
		Integer floorKey = tree.floorKey(key);
		// null�� ��쿡�� �ٸ� Key�� ���Ѵ�.
		if (ceilKey == null) {
			if (isMatching(key, floorKey))
				return floorKey;
		} else if (floorKey == null) {
			if (isMatching(key, ceilKey))
				return ceilKey;
		}
		// �� Ű�� null�� �ƴ� ��� �� ���� ���̰� �� ���� Ű�� ��ȯ�Ѵ�.
		else {
			int ceilDiff = Math.abs(ceilKey - key);
			int floorDiff = Math.abs(floorKey - key);
			if (ceilDiff < floorDiff) {
				if (isMatching(key, ceilKey))
					return ceilKey;
			} else if (ceilDiff == floorDiff) {
				// Key�� �� �� �̻��� ���� Key�� ��ġ�ϰų� �� ���� Key�� �ִ� ����̴�.
				if (ceilKey == key)
					return key;
				else {
					return -2;
				}
			} else if (isMatching(key, floorKey))
				return floorKey;
		}
		return -1;
	}

	public static boolean isMatching(int key, int compare) {
		if (key - k <= compare && compare <= key + k)
			return true;
		return false;
	}
}