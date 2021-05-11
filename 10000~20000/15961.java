package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ȸ�� �ʹ������� ���� �� �ִ� �ʹ��� �������� �ִ��� ���ϴ� ����
 * �ʹ��� �� ��ġ�������� k�� �������� �Դ´�.
 * �ʹ����� ������ ������ �־� ������ ���� ������ �ʹ� �� ���� ����� �����Ѵ�.
 * �� ��, �ʹ��� ��Ʈ���� ������ ���� �����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * �ʹ��� 0������ k���� �԰� ������ ������ ����.
	 * ���� 0���� ����� k��° �ʹ��� �߰��ϰ�, ���� �ʹ��� ������ �ִ����� Ȯ���Ѵ�.
	 * �ʹ����� ��Ʈ�� ȸ���� �ϱ� ������ �������� �̷���� �ִ�.
	 * ���� (0, k-1), (1, k), ... (n-1, k-1)���� ����Ѵ�. 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		int[] type = new int[d + 1];
		int typeCnt = 0;
		// ó�� �ʹ� k���� ���� ���� �ʹ��� �������� ���Ѵ�.
		for (int i = 0; i < k; i++) {
			if (type[arr[i]] == 0)
				typeCnt++;
			type[arr[i]]++;
		}
		int answer = 0;
		for (int index = 0; index < n; index++) {
			// �ʹ��� ������ �ִ����� Ȯ���Ѵ�.
			answer = type[c] == 0 ? Math.max(answer, typeCnt + 1) : Math.max(answer, typeCnt);
			// index��°�� �ʹ��� 1�� ����, �� ���� ���� 0 �̸� ������ 1 ���ҽ�Ų��.
			if (--type[arr[index]] == 0)
				typeCnt--;
			// �����̱� ������ n���� ��ⷯ�� �����ش�.
			// index+k��° �ִ� �ʹ��� 1 ������Ű��, ���� 0�̾����� ������ 1 ������Ų��.
			if (type[arr[(index + k) % n]]++ == 0)
				typeCnt++;
		}
		System.out.println(answer);
	}
}