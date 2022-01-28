package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �����佺�׳׽��� ü�� ����Ͽ� K��°�� �������� ���� ���ϴ� ����
 * �˰����� ������ ����.
 * 2���� N���� ��� ������ ���´�.
 * ���� ������ ���� �� �� ���� ���� ���� ã�´�. �̰��� P��� �ϰ�, �� ���� �Ҽ��̴�.
 * P�� �����, ���� ������ ���� P�� ����� ũ�� ������� �����.
 * ���� ��� ���� ������ �ʾҴٸ�, �ٽ� 2�� �ܰ�� ����.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] isRemoved = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			if (isRemoved[i])
				continue;
			for (int j = i; j <= n; j += i) {
				if (!isRemoved[j]) {
					isRemoved[j] = true;
					k--;
					if (k == 0) {
						System.out.println(j);
						return;
					}
				}
			}
		}
	}
}