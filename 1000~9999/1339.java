package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * ���ĺ� �빮�ڷ� �̷���� N���� �ܾ �־�����. �� �ܾ��� ���ĺ� ���ڿ� 0���� 9������ ���ڸ� �����Ϸ��� �� ��, ������ ������ ����
 * �ִ��� ���ϴ� ����
 * 
 * @author Rave
 *
 */
public class Main {

	/**
	 * 2 AB BB = 188
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		int[] alphabet = new int[26];
		for (int i = 0; i < n; i++)
			words[i] = br.readLine();
		// ������ �ڸ����� ���� ����� alphabet�� �����Ѵ�.
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				char ch = words[i].charAt(j);
				alphabet[ch - 'A'] += Math.pow(10, words[i].length() - j - 1);
			}
		}
		int answer = 0;
		// alphabet�� �ڸ����� ���� ���� ������� ������ �Ѵ�.
		Arrays.sort(alphabet);
		// ���� ������ alphabet���� 9�� �ο��Ѵ�.
		for (int i = 25, count = 9; i >= 0 && count > 0; i--)
			answer += alphabet[i] * count--;
		System.out.println(answer);
	}
}