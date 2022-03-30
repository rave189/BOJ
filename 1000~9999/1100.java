package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 8x8 ũ���� ü������ �ִ�.
 * ���� ���� ���� (0, 0)�� �Ͼ���̴�.
 * ü������ �Ͼ���� �������� �����ư��� ĥ���� �ִ�.
 * ü������ ���°� �־����� ��, �Ͼ� ĭ ���� ���� �� �� �ִ��� ���ϴ� ���� ���� F�̰� .�� ��ĭ�̴�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * i�� j�� %2�� ���� ��ġ�� �Ͼ���̴�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = 8;
		int answer = 0;
		for (int i = 0; i < size; i++) {
			String line = br.readLine();
			for (int j = 0; j < size; j++)
				if (i % 2 == j % 2 && line.charAt(j) == 'F')
					answer++;
		}
		System.out.println(answer);
	}
}