package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * N+1���� I�� N���� O�� �̷���� �ְ�, I�� O�� ����� ������ ���ڿ��� Pn�̶�� �Ѵ�.
 * P1 = IOI
 * P2 = IOIOI
 * P3 = IOIOIOI
 * ���ڿ� S�� N�� �־��� �� S�� Pn�� �󸶳� ���ԵǾ� �ִ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		char[] line = br.readLine().toCharArray();
		int answer = 0;
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < m; i++) {
			// ��������� I�� ã�� ������ �ѱ��.
			if (st.isEmpty()) {
				if (line[i] == 'I')
					st.push(line[i]);
				continue;
			}
			// ������ �� ���� ���� ���ڶ�� ������ ���� i�� 1 ���ҽ��� �ٽ� ���ÿ� �ֵ��� �Ѵ�.
			if (line[i] == st.peek()) {
				st.clear();
				i--;
			}
			// �ƴ϶�� ������ �ݺ��Ǵ� ���̹Ƿ� ���ÿ� �ִ´�.
			else
				st.push(line[i]);
			// ������ ũ�Ⱑ 2*N+1����� Pn�� ã�����Ƿ� answer�� ������Ű�� 2���� ���� ���� ������ ã���� �Ѵ�.
			if (st.size() == 2 * n + 1) {
				answer++;
				st.pop();
				st.pop();
			}
		}
		System.out.println(answer);
	}
}