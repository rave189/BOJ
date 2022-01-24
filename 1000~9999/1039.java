package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �� N�� �־�����.
 * �� N�� �� �ڸ� ���� �� i��° ���ڿ� j��° ���ڸ� �ٲٴ� ������ K�� �Ϸ��� �Ѵ�.
 * �� �� ���ڸ��� 0�� ������ �ٲ� ���� ����.
 * K�� ���� �� ���� �� �ִ� ���� ū ���� ���ϴ� ����
 * 
 * @author Rave
 *
 */
public class Main {

	/**
	 * �߰� ������ ��� ���� K���� ���� �� ���� ū ���� ã�� �����̴�.
	 * bfs�� ���� Ž���Ѵ�.
	 * ���� �� �ִ� ���� bruteforce�� ����Ͽ� ���Ѵ�.
	 * �� ���� ���� ���� ���� �� �����Ƿ� hash�� ����Ͽ� �ɷ��ش�.
	 * 
	 * ���� ��....
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> hash = new HashSet<>();
		q.add(n);
		while (!q.isEmpty() && k > 0) {
			hash.clear();
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				char[] strNum = Integer.toString(cur).toCharArray();
				for (int i = 0; i < strNum.length; i++) {
					for (int j = i + 1; j < strNum.length; j++) {
						if (strNum[j] == '0' && i == 0)
							continue;
						swap(strNum, i, j);
						int next = Integer.parseInt(new String(strNum));
						if (!hash.contains(next)) {
							q.add(next);
							hash.add(next);
						}
						swap(strNum, j, i);
					}
				}
			}
			k--;
		}
		int max = 0;
		while (!q.isEmpty())
			max = Math.max(max, q.poll());
		// N�� ���ڸ� �����̸� k = 0�ε� q�� ���� ���� ��� max�� 0�� ��Ȳ�� ���´�.
		System.out.println(k == 0 && max != 0 ? max : -1);
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void swap(char[] num, int i, int j) {
		char tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
}