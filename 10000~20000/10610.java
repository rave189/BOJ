package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * N이 주어질 때, 이 수로 만들 수 있는 30의 배수 중 가장 큰 수를 구하는 문제
 * 만약 30의 배수가 존재하지 않다면 -1을 출력한다.
 * 30의 배수가 되려면 0이 하나 포함되어야 하고, 나머지 수들의 합이 3의 배수여야 한다.
 * N이 10^5개의 숫자로 이루어져 있어 String으로 출력해야 한다.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int check = 0;
		for (int i = 0; i < arr.length; i++)
			check += arr[i] - '0';
		Arrays.sort(arr);
		// 0이 없거나 3의 배수가 아니면 -1 출력
		if (arr[0] != '0' || check % 3 != 0) {
			System.out.println(-1);
			return;
		}
		// 정렬된 수를 다시 이어 붙이고 반대로 출력하면 가장 큰 수가 된다.
		StringBuffer answer = new StringBuffer(new String(arr));
		System.out.println(answer.reverse());
	}
}