package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * N개의 영단어가 주어진다.
 * 각각의 영단어로 만들 수 있는 모든 단어를 출력하는 문제
 * 단어에는 중복된 철자가 존재할 수 있어, 같은 단어가 만들어질 수 있는데 한 번만 출력해야 한다.
 * 또한 출력할 때에는 알파벳 순서로 출력해야 한다.
 * @author Rave
 *
 */
public class Main {

	static char[] words, alphabet;
	static StringBuilder answer = new StringBuilder();

	/**
	 * hash에 넣고 정렬하는 식으로 풀이하려고 함(메모리 초과)
	 * 입력으로 받은 알파벳의 개수를 세어준다.
	 * 이후 알파벳 순서대로 존재하는 알파벳들을 선택해준다.
	 * 이렇게 하면 알파벳 순서대로 출력이 가능하고, 중복된 영단어가 나오지 않는다.
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