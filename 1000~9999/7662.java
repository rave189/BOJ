package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * ���� �켱���� ť�� �켱���� ťó�� �����͸� ����, ������ �� �ִ� �ڷᱸ���̴�.
 * �켱���� ť�� �ٸ� ���� ���� ��ɿ� ���� �ִ񰪰� �ּڰ��� ������ �� �ִٴ� ���̴�.
 * ť�� ����� ������� ��� �����ϰ� �� �� ť�� ����� �ִ񰪰� �ּڰ��� ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	// Ʈ�� ������ ���ĵ� �켱���� ť�� �����Ѵ�.
	static TreeMap<Long, Integer> tree = new TreeMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			tree.clear();
			int n = Integer.parseInt(br.readLine());
			while (n-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				long value = Long.parseLong(st.nextToken());
				if (command.equals("I"))
					tree.put(value, tree.getOrDefault(value, 0) + 1);
				else if (!tree.isEmpty()) {
					if (value == 1)
						remove(tree.lastKey());
					else
						remove(tree.firstKey());
				}
			}
			if (tree.isEmpty())
				sb.append("EMPTY");
			else
				sb.append(tree.lastKey() + " " + tree.firstKey());
			sb.append("\n");
		}
		System.out.println(sb);
	}

	/**
	 * key���� �ش��ϴ� value�� 1 �����Ѵ�.
	 * value�� 0�� �Ǹ� Ʈ�� �ʿ��� �����Ѵ�.
	 * @param key ���� key
	 */
	public static void remove(long key) {
		tree.put(key, tree.get(key) - 1);
		if (tree.get(key) == 0)
			tree.remove(key);
	}
}