package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �̾��� ��Ʈ�� ���� ������ ���Ҵ�.
 * ��Ʈ�� �������� ��Ʈ�� ����� �������� ���������ȴ�.
 * ������ ��Ʈ�� ���� ���ڿ��� ���� ������ ���η� H����, ���η� W���ڰ� �ݺ��ǰ� ������ �Ǿ���.
 * ���� ���ڿ��� ���� N, ���η� ���� ������ �� H, ���η� ���� ������ �� W�� �־��� ��
 * ������ ���ڿ��� ���ϴ� ����, ������ �� ���� ���� ?�� ����Ѵ�.
 * ���ڿ����� ?�� �� �� �ְ�, ?�� �ش� �ڸ� ���ڰ� ������ ����̴�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���η� W��ŭ ���η� H��ŭ�� ���簢�� �κ��� ��� Ž���Ͽ� �ѹ��̶� ���ڰ� ������ �� ���ڰ� ������ �����̴�.
	 * ���ڰ� ������ �ʴ� ���� ?�� �߰��� ��� �߰��� ���ڸ� answer�� ���̰� �������� ����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		String[] input = new String[h];
		for (int i = 0; i < h; i++)
			input[i] = br.readLine();
		for (int i = 0; i < n * w; i += w) {
			char ch = '?';
			for (int j = 0; j < h; j++) {
				for (int t = i; t < i + w; t++) {
					char compare = input[j].charAt(t);
					if (compare == '?')
						continue;
					ch = compare;
				}
			}
			answer.append(ch);
		}
		System.out.println(answer);
	}
}