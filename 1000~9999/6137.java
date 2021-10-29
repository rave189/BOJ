package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * N개의 문자로 이루어진 문자열이 주어진다.
 * 이 문자열로 문자열 T를 만들려고 한다.
 * T를 만드는 규칙은 다음과 같다.
 * 1. S의 맨 앞 문자 하나를 T에 추가한다.
 * 2. S의 맨 뒤 문자 하나를 T에 추가한다.
 * 이 규칙으로 만들 수 있는 문자열 T 중 사전순으로 가장 빠른 문자열을 출력하는 문제
 * 출력 시 80글자마다 개행문자를 넣어준다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 맨 앞과 맨 뒤 문자를 비교한다. 한쪽이 크거나 작은 경우는 작은 문자를 T에 추가해준다.
	 * 그러나 둘 다 같은 문자인 경우 반복문으로 어느 한쪽이 작을 때까지 비교해본다.
	 * 더 작은 문자를 가진 쪽을 발견하면 작은 문자를 T에 추가하고 종료한다.
	 * 아무 문자도 추가하지 못한다면 앞의 문자를 추가한다.
	 * 
	 * result를 StringBuilder로 사용하여 문제를 풀려했음.
	 * StringBuilder의 크기가 80일 때마다 개행 문자를 넣도록 for문 안에 if문을 사용하였음.
	 * 하지만 개행 문자도 하나의 글자이기 때문에 정확히 80글자마다 개행을 하지 않음.
	 * 따라서 List로 바꾼 후 출력 시 80글자마다 개행하도록 변경.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder input = new StringBuilder();
		ArrayList<Character> result = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++)
			input.append(br.readLine().charAt(0));
		for (int left = 0, right = input.length() - 1; left <= right;) {
			// 한쪽이 크거나 작은 경우
			if (input.charAt(left) < input.charAt(right))
				result.add(input.charAt(left++));
			else if (input.charAt(left) > input.charAt(right))
				result.add(input.charAt(right--));
			else {
				// 두 문자가 같은 경우 다음 문자들을 비교해본다.
				int i = left, j = right, length = result.size();
				for (; i <= j; i++, j--) {
					if (input.charAt(i) < input.charAt(j)) {
						result.add(input.charAt(left++));
						break;
					} else if (input.charAt(i) > input.charAt(j)) {
						result.add(input.charAt(right--));
						break;
					}
				}
				// 아무것도 추가하지 못하면 맨 앞 문자를 추가한다.
				if (length == result.size())
					result.add(input.charAt(left++));
			}
		}
		// 80줄마다 개행을 넣어서 출력한다.
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if ((i + 1) % 80 == 0)
				System.out.println();
		}
	}
}