package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0���� 9999���� ������ �� �ִ� �������Ͱ� �ִ�.
 * �� ��ɾ�� �������Ϳ� ����� n�� ������ ���� ��ȯ�Ѵ�.
 * D: n�� �� ��� �ٲ۴�. ��� ���� 9999���� ũ�ٸ� 10000���� ���� �������� �����Ѵ�.
 * S: n���� 1�� ����. n�� 0�̶�� 9999�� �����Ѵ�.
 * L: n�� �� �ڸ����� �������� ȸ������ �����Ѵ�.
 * R: n�� �� �ڸ����� ���������� ȸ������ �����Ѵ�.
 * L�� R�� ������ ������ n�� �� �ڸ����� ���� �� ȸ���� ��Ų��.
 * ���������� �ʱⰪ�� ���� ���� �־��� �� �ʱⰪ���� ���� ������ ��ȯ�ϱ� ����
 * �ּ����� ��ɾ �����Ͽ� ����Ѵ�.
 * ������ ��ɾ ���������� �ƹ��ų� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static String[] command = { "D", "S", "L", "R" };

	/**
	 * �ʱ� ������ �ʺ� �켱 Ž���� ���� ���� ���� �� �� �ִ��� �˻��Ѵ�.
	 * �� �ڵ�� 12916ms�� �ٽ� Ǯ������ϴ� �����̴�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			String result = BFS(start, end);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	/**
	 * start���� �����Ͽ� �ʺ� �켱 Ž���� ���� end�� �Ǵ� �ּ����� ��ɾ ���Ѵ�.
	 * @param start �ʱ� ��
	 * @param end ���� ��
	 * @return �ּ����� ��ɾ�
	 */
	public static String BFS(int start, int end) {
		Queue<DSLR> q = new LinkedList<>();
		boolean[] visited = new boolean[10000];
		q.add(new DSLR(start, ""));
		visited[start] = true;
		while (!q.isEmpty()) {
			DSLR cur = q.poll();
			if (cur.value == end)
				return cur.route;
			String strNum = getString(cur.value);
			int d = (cur.value * 2) % 10000;
			int s = cur.value == 0 ? 9999 : cur.value - 1;
			int l = getLeft(strNum);
			int r = getRight(strNum);
			// D, S, L, R�� ���Ͽ� �ݺ����� ������ ���� �迭�� �����Ѵ�.
			int[] cmdArr = { d, s, l, r };
			for (int i = 0; i < 4; i++) {
				if (visited[cmdArr[i]])
					continue;
				visited[cmdArr[i]] = true;
				q.add(new DSLR(cmdArr[i], cur.route + command[i]));
			}
		}
		return "";
	}

	/**
	 * �־��� ���� �� �ڸ��� String���� ��ȯ���ִ� �޼ҵ�
	 * @param value ��ȯ�� ��
	 * @return �� �ڸ��� String
	 */
	public static String getString(int value) {
		StringBuilder sb = new StringBuilder(Integer.toString(value));
		while (sb.length() < 4)
			sb.insert(0, '0');
		return sb.toString();
	}

	/**
	 * �־��� ���ڿ��� �������� ȸ����Ű�� �޼ҵ�
	 * ���� ù ���ڸ� �� �ڷ� ������.
	 * @param str ȸ����ų ���ڿ�
	 * @return �������� ȸ���� ���ڿ�
	 */
	public static int getLeft(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.append(sb.charAt(0));
		sb.deleteCharAt(0);
		return Integer.parseInt(sb.toString());
	}

	/**
	 * �־��� ���ڿ��� ���������� ȸ����Ű�� �޼ҵ�
	 * �� ������ ���ڸ� �� ������ ������.
	 * @param str ȸ����ų ���ڿ�
	 * @return ���������� ȸ���� ���ڿ�
	 */
	public static int getRight(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.insert(0, sb.charAt(sb.length() - 1));
		sb.deleteCharAt(sb.length() - 1);
		return Integer.parseInt(sb.toString());
	}
}

class DSLR {
	int value;
	String route;

	public DSLR(int _value, String _route) {
		this.value = _value;
		this.route = _route;
	}
}