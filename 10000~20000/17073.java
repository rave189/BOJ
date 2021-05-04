package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1�� ��尡 ��Ʈ ����� Ʈ���� �־�����.
 * 1�� ��忡�� w�� ���� �ְ�, �� ���� ���� ������ ���� ������� �ڽ� �������� ��������.
 * 1.���� ������ ������, �ڽ� ������ �ִٸ� �ڽ� ���� �� �ϳ��� ��� ���� 1 �ش�. �ڽ� ������ ���� ����� ������ Ȯ���� �� �� �ϳ��� ����.
 * 2.���� �θ� ������ �ڽſ��� ���� ������´ٸ� �޾Ƽ� �׾� �д�.
 * �� ��, ���� �� �̻� �������� �ʴ� ���°� �Ǿ��� �� i�� ������ ���� ���� ����� Pi��� �Ѵ�.
 * Pi�� 0���� ū �����鿡 ���Ͽ� Pi�� ����� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���� �� �̻� �������� �ʴ� �ٴ� ���� ��� ���� ���� ��忡 �׿��ִٴ� ���̴�.
	 * ���� ������忡 ���� ���� ����� ����� ���ϴ� ����
	 * ����� ���� �� w�� �� ���� ���� �� Ȯ���� ���ϴ� ���̴�.
	 * �� ����� ��� ���� ���� �ᱹ w ���� �ȴ�. (���� ���̿� �ִ� ������ Ȯ���� �� ���ϸ� �θ� ����� Ȯ���� ������ ����)
	 * ���� w�� ���� ����� ���� �����ٸ� Pi ���� ã�� �� �ִ�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] tree = new int[n + 1];
		// ����� �������� ��� �����ش�.
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			tree[first]++;
			tree[second]++;
		}
		// ���� ����� ������ ��Ʈ ��尡 �ƴϸ鼭 ������ ������ 1���� ����̴�.
		double leafCnt = 0;
		for (int i = 2; i <= n; i++)
			if (tree[i] == 1)
				leafCnt++;
		System.out.println(String.format("%.6f", w / leafCnt));
	}
}