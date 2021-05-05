package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Ʈ���� �־��� ��, ������ ������ ����������, ������ ������ ���������� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * Ʈ������ �������� ��Ʈ ���� ���� ��带 ������ ��� ��尡 �������̴�.
	 * Ʈ������ �������� ��� ������ �������̴�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		int[] tree = new int[n + 1];
		while (--n > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			tree[first]++;
			tree[second]++;
		}
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if (t == 2 || (t == 1 && tree[k] > 1))
				sb.append("yes");
			else
				sb.append("no");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}