package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * N���� ī�尡 �־�����.
 * �� ī�� �߿��� K���� �����ؼ� ������ ���� ������ ������� �Ѵ�.
 * �� ��, ���� �� �ִ� ������ ������ ���ϴ� ����
 * �ߺ��� �����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static String[] arr;
	static boolean[] visited;
	static HashSet<String> hash = new HashSet<>();

	/**
	 * ���Ʈ������ Hash�� ������ ã�´�.
	 * 
	 * �����̷��� �������� ����Ǯ�� �ߴµ� �ᱹ ó�� ������ ����
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		arr = new String[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++)
			arr[i] = br.readLine();
		find(k, "");
		System.out.println(hash.size());
	}

	public static void find(int depth, String result) {
		if (depth == 0) {
			hash.add(result);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			find(depth - 1, result + arr[i]);
			visited[i] = false;
		}
	}
}