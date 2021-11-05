package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * �� ���� 30���� �л��� �ִ�.
 * �� �� 28���� �л��� ������ �������� ��
 * �������� ���� �л��� �⼮ ��ȣ�� ���ϴ� ����
 * �Է����� ������ ������ 28���� �л��� �⼮ ��ȣ�� �־�����.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isSubmit = new boolean[31];
		for (int i = 0; i < 28; i++)
			isSubmit[Integer.parseInt(br.readLine())] = true;
		for (int i = 1; i < isSubmit.length; i++)
			if (!isSubmit[i])
				System.out.println(i);
	}
}