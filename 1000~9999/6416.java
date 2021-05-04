package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * �� �׽�Ʈ ���̽��� Ʈ������ �Ǻ��ϴ� ����
 * Ʈ���� ������ ������ ����.
 * 1.������ ������ �ϳ��� ���� �� �ϳ��� ��尡 �����Ѵ�. �̸� ��Ʈ(root) ����� �θ���.
 * 2.��Ʈ ��带 ������ ��� ���� �ݵ�� �� �ϳ��� ������ ������ �����Ѵ�.
 * 3.��Ʈ���� �ٸ� ���� ���� ��δ� �ݵ�� �����ϸ�, �����ϴ�. �̴� ��Ʈ�� ������ ��� ��忡 �����ؾ� �Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static HashMap<Integer, Integer> hash;
	static boolean isTree;

	/**
	 * ��Ʈ ��尡 �� ������ Ȯ���ϰ�, ������ ������ �ϳ�����, ���� ��ȣ�� ������ ���������� Ȯ���Ͽ� �����Ѵ�.
	 * 1 2 2 3 3 1 4 5 0 0�� �Է¿��� Ʈ����� �Ǵ��Ѵ�. (����� ������ ������ �� ����.) 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int testCase = 1;
		loop: while (true) {
			hash = new HashMap<>();
			isTree = true;
			input: while (true) {
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					int parent = Integer.parseInt(st.nextToken());
					int child = Integer.parseInt(st.nextToken());
					if (parent == 0 && child == 0)
						break input;
					if (parent < 0 && child < 0)
						break loop;
					if (hash.containsKey(child))
						isTree = false;
					else if (hash.containsKey(parent) && hash.get(parent) == child)
						isTree = false;
					else if(parent == child)
						isTree = false;
					hash.put(child, parent);
				}
			}
			if (isTree)
				isOneOfTree();
			if (isTree)
				sb.append(String.format("Case %d is a tree.\n", testCase++));
			else
				sb.append(String.format("Case %d is not a tree.\n", testCase++));
		}
		System.out.print(sb);
	}

	/**
	 * ��Ʈ ��尡 �� ������ ���ϴ� �޼ҵ�.
	 * parent���� ������ parent�� �ٸ� ����� child ����̸� ��� ã�� �����.
	 * ���� ���� ���� �߿� parent�� �� ����� ��Ʈ ��尡 �� ���̴�.
	 */
	public static void isOneOfTree() {
		ArrayList<Integer> removeList = new ArrayList<>();
		for (int child : hash.keySet()) {
			int parent = hash.get(child);
			if (hash.containsKey(parent))
				removeList.add(child);
		}
		for (int key : removeList)
			hash.remove(key);
		Integer root = null;
		for (int key : hash.keySet()) {
			if (root == null)
				root = hash.get(key);
			else if (root != hash.get(key)) {
				isTree = false;
				return;
			}
		}
	}
}