package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �����̴� N���� �ǾƳ� �Ǻ��� ������ �ִ�.
 * ������ �Ǻ��� ������ ǥ���Ǵ� ���̵��� ������ �ִ�.
 * 1���� N������ �� �߿��� �� �� x, y�� ��� x������ y������ �����Ϸ��� �Ѵ�.
 * ������ i�� �Ǻ��� i+1�� �Ǻ����� ���̵��� ���ٸ� �����̴� �׻� �Ǽ��� �Ѵ�.
 * ���� ������ �Ǻ������� ���� �Ǽ����� �ʴ´�.
 * �� ��, �� �� x, y�� q�� �־��� �� �����̰� �Ǽ��ϴ� Ƚ���� ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �����̰� �Ǽ��ϴ� Ƚ���� ���������� �̸� ���صΰ�
	 * �־����� x, y�� ���� �����̰� �Ǽ��ϴ� Ƚ���� ����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] notes = new int[n];
		for (int i = 0; i < n; i++)
			notes[i] = Integer.parseInt(st.nextToken());
		int[] partSum = new int[n];
		for (int i = 1; i < n; i++) {
			partSum[i] = notes[i] < notes[i - 1] ? 1 : 0;
			partSum[i] += partSum[i - 1];
		}
		int q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
			sb.append(partSum[second] - partSum[first]).append("\n");
		}
		System.out.println(sb);
	}
}