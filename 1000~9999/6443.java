package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * N���� ���ܾ �־�����.
 * ������ ���ܾ�� ���� �� �ִ� ��� �ܾ ����ϴ� ����
 * �ܾ�� �ߺ��� ö�ڰ� ������ �� �־�, ���� �ܾ ������� �� �ִµ� �� ���� ����ؾ� �Ѵ�.
 * ���� ����� ������ ���ĺ� ������ ����ؾ� �Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static char[] words, alphabet;
	static StringBuilder answer = new StringBuilder();

	/**
	 * hash�� �ְ� �����ϴ� ������ Ǯ���Ϸ��� ��(�޸� �ʰ�)
	 * �Է����� ���� ���ĺ��� ������ �����ش�.
	 * ���� ���ĺ� ������� �����ϴ� ���ĺ����� �������ش�.
	 * �̷��� �ϸ� ���ĺ� ������� ����� �����ϰ�, �ߺ��� ���ܾ ������ �ʴ´�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			words = br.readLine().toCharArray();
			alphabet = new char[26];
			for (char ch : words)
				alphabet[ch - 'a']++;
			bruteforce(0, "");

		}
		System.out.println(answer);
	}

	public static void bruteforce(int count, String result) {
		if (count >= words.length) {
			answer.append(result).append('\n');
			return;
		}
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] <= 0)
				continue;
			alphabet[i]--;
			bruteforce(count + 1, result + (char) ('a' + i));
			alphabet[i]++;
		}
	}
}