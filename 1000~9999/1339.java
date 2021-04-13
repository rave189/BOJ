package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 알파벳 대문자로 이루어진 N개의 단어가 주어진다. 각 단어의 알파벳 문자에 0부터 9까지의 숫자를 대입하려고 할 때, 대입한 수들의 합의
 * 최댓값을 구하는 문제
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
		// 각각의 자리수를 곱한 결과를 alphabet에 저장한다.
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				char ch = words[i].charAt(j);
				alphabet[ch - 'A'] += Math.pow(10, words[i].length() - j - 1);
			}
		}
		int answer = 0;
		// alphabet의 자리수의 합이 높은 순서대로 정렬을 한다.
		Arrays.sort(alphabet);
		// 높은 순서의 alphabet부터 9를 부여한다.
		for (int i = 25, count = 9; i >= 0 && count > 0; i--)
			answer += alphabet[i] * count--;
		System.out.println(answer);
	}
}