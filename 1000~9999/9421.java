package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * ���� ���� n�� �� �ڸ����� ������ ���� ����Ѵ�.
 * ���� ���� ������ �ݺ����� �� 1�� ������ ���� ��ټ���� �Ѵ�.
 * �̶� �Ҽ��̸鼭 ��ټ��� ���� ��� ã�� ����
 * @author Rave
 *
 */
public class Main {

	static int[] visited = new int[1000001];

	/**
	 * n���� �����Ͽ� 7���� �������� Ž���ϸ� �Ҽ��̸鼭 ��ټ��� ��츦 ã�´�.
	 * n���� �����ؼ� �Ҽ���ټ��� ���� �ƴ� ���� Ž���Ѵ�.
	 * Ž���� ����� visited�� ����ǰ� Ž���� ���� ���� ã�ԵǸ� ����� �ٷ� �� �� �ִ�.
	 * (�������� ������ �� ������..?)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = n; i >= 7; i--) {
			if (isPrime(i) && isValidNumber(i) == 1)
				arr.add(i);
		}
		for (int i = arr.size() - 1; i >= 0; i--)
			answer.append(arr.get(i)).append('\n');
		System.out.println(answer);
	}

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	/**
	 * @param n ���� ����
	 * @return �Ҽ���ټ��̸� 1 �ƴϸ� -1
	 */
	public static int isValidNumber(int n) {
		if (n == 1)
			return 1;
		else if (visited[n] == -1)
			return -1;
		else if (visited[n] == 1)
			return 1;
		// �⺻�� �Ҽ���ټ��� �ƴѰɷ� ����
		visited[n] = -1;
		int next = 0;
		String number = Integer.toString(n);
		for (char ch : number.toCharArray())
			next += Math.pow(ch - '0', 2);
		return visited[n] = isValidNumber(next);
	}
}