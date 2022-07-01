package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * ����ġ N���� ���� M���� �ִ�.
 * ����ġ�� 0�� �̻��� ������ ����Ǿ� �ִ�.
 * ����ġ�� ������ ����� ��� ������ ���� ������.
 * N���� ����ġ�� ��� ������ ��� ������ ������.
 * N-1���� ����ġ�� ������ ��� ������ �������� ���ϴ� ����
 * ��� ������ ������ 1 �ƴϸ� 0�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static Set<Integer>[] map;

	/**
	 * ��������
	 * N, M�� 2000�ε� �������� ���� �γ���
	 * hash�� ���ϰ� �迭�� �ϸ� �� �� ��������?
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new Set[n];
		for (int i = 0; i < n; i++)
			map[i] = new HashSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			while (t-- > 0)
				map[i].add(Integer.parseInt(st.nextToken()) - 1);
		}
		loop: for (int i = 0; i < n; i++) {
			next: for (int v : map[i]) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;
					if (map[j].contains(v))
						continue next;
				}
				continue loop;
			}
			System.out.println(1);
			return;
		}
		System.out.println(0);
	}
}