package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * N�� �־��� ��, �� ���� ���� �� �ִ� 30�� ��� �� ���� ū ���� ���ϴ� ����
 * ���� 30�� ����� �������� �ʴٸ� -1�� ����Ѵ�.
 * 30�� ����� �Ƿ��� 0�� �ϳ� ���ԵǾ�� �ϰ�, ������ ������ ���� 3�� ������� �Ѵ�.
 * N�� 10^5���� ���ڷ� �̷���� �־� String���� ����ؾ� �Ѵ�.
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
		// 0�� ���ų� 3�� ����� �ƴϸ� -1 ���
		if (arr[0] != '0' || check % 3 != 0) {
			System.out.println(-1);
			return;
		}
		// ���ĵ� ���� �ٽ� �̾� ���̰� �ݴ�� ����ϸ� ���� ū ���� �ȴ�.
		StringBuffer answer = new StringBuffer(new String(arr));
		System.out.println(answer.reverse());
	}
}