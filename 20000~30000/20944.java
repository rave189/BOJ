package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * �Ӹ������ ����� �Ȱ��� ���ڿ��� ���Ѵ�.
 * ���̻���� ���� ���ݰ� ���� ������ ���� ���ڿ��� ���Ѵ�.
 * �Ӹ�����̸鼭 ���̻���� ���ڿ��� �ƹ��ų� ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���� ���ڸ� ����ϸ� �Ӹ�����̸鼭 ���̻���� �ȴ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < n; i++)
			answer.append('a');
		System.out.println(answer);
	}
}