package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ���ĺ����� �̷���� ���ڿ��� �־�����.
 * �ҹ��ڴ� �빮�ڷ�, �빮�ڴ� �ҹ��ڷ� �ٲپ� ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder answer = new StringBuilder();
		for (char ch : input.toCharArray())
			answer.append(ch <= 90 ? (char) (ch + 32) : (char) (ch - 32));
		System.out.println(answer);
	}
}