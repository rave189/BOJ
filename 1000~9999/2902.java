package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ����̸�-����̸�-����̸�.... ������ ������ �־�����.
 * ��� �̸��� ù ���ڸ� ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringBuilder answer = new StringBuilder(line.charAt(0) + "");
		for (int i = 0; i < line.length(); i++)
			if (line.charAt(i) == '-')
				answer.append(line.charAt(i + 1));
		System.out.println(answer);
	}
}