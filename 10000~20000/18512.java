package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �� �л��� ���� �������� �ָ��ٱ⸦ �Ѵ�.
 * A �л��� �� ���� X ���͸�, B �л��� Y ���͸� �ڴ�.
 * �� �л��� ���� ������ X, Y�� �־����� ��
 * �� �л��� �������� ������ �Ǵ� ���� �� ���� ����� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �� �л��� ���� ������ ���� ������ ��ó�� �л��� �ָ��ٱ� ��Ų��.
	 * �ּ� 100�� �ȿ��� ������ �ϹǷ� 100�������� ��������. (�� 100���̶� ���ڸ� �˾ƾ� ���� �ذ�ǳ�.. �𸣸� �� ������ �� �ۿ�)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		long p1 = Integer.parseInt(st.nextToken());
		long p2 = Integer.parseInt(st.nextToken());
		int cnt = 100;
		while (cnt-- > 0) {
			if (p1 == p2)
				break;
			if (p1 < p2)
				p1 += x;
			else
				p2 += y;
		}
		System.out.println(p1 == p2 ? p1 : -1);
	}
}