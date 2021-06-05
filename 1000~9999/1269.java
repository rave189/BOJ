package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * �������� �ƴ� �� ������ �־��� ��,
 * �� �� ������ �����տ��� �������� �� ������ ������ ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �� ���� ���Ҹ� ��� hash�� �ִ´�.
	 * ���� �ٸ� ���տ��� �������� �߻��ϸ� hash���� ���� �׷��� �ʴٸ� answer�� ���� ������Ų��.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int answer = 0;
		HashSet<Integer> hash = new HashSet<>();
		while (n-- > 0) {
			int key = Integer.parseInt(st.nextToken());
			hash.add(key);
		}
		st = new StringTokenizer(br.readLine());
		while (m-- > 0) {
			int key = Integer.parseInt(st.nextToken());
			if (hash.contains(key))
				hash.remove(key);
			else
				answer++;
		}
		System.out.println(answer + hash.size());
	}
}