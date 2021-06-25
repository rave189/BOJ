package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 8���� ���� ���� N������ ��� �ִ�.
 * �� ������� ���� ���� ��� ���������� �Ϸ��� �Ѵ�.
 * �� �� ���Ѿ� �� ������ �ִµ� ������ ����.
 * 1. ���� ���� ��ȣ�� ���� ��ƾ� �Ѵ�.
 * 2. �� ����� �� �̻��� ���� ���� �� ����.
 * 3. �� ������ ���� ������ ���� ���� �� ����.
 * ������ �տ� ��ȣ�� �ο��� ��, ������� ���� ���� ��ȣ�� �̾� ������ ���� �� �ִ�.
 * �� ��, ���� ������ ���� �ռ��� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		while (n >= 2) {
			n -= 2;
			answer.append("1 2 ");
		}
		if (n > 0)
			answer.append("3");
		System.out.println(answer);
	}
}