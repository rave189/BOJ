package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * N���� ���Ҹ� ���� ���� A�� �־�����.
 * Ai�� ����ū���� ���ϴ� ����
 * ����ū���� Ai���� �����ʿ� �����鼭 ���� A���� Ai���� �� ���� ������ ���� �ǹ��Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * ��ū������ Ƚ���� �߰��ϸ� �Ǵ� ����
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] count = new int[1000001];
		int[] arr = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
			count[arr[i]]++;
		}
		Stack<Integer> st = new Stack<>();
		int[] result = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && count[st.peek()] <= count[arr[i]])
				st.pop();
			result[i] = st.isEmpty() ? -1 : st.peek();
			st.add(arr[i]);
		}
		for (int v : result)
			answer.append(v).append(' ');
		System.out.println(answer);
	}
}