package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �ٹ��� ���۱��� ���� �Ѵ�.
 * �� ��, ���۱��� �ִ� ��ε��� ��հ��� ���Ϸ��� �Ѵ�.
 * ��հ��� �׻� �ø����� ����Ѵ�.
 * �ٹ��� ���ϵ� ���� ������ ��� ���� �־��� ��,
 * ��� �� ���� ���۱��� �ִ� ��ε����� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int i = Integer.parseInt(st.nextToken());
		System.out.println(a*(i-1)+1);
	}
}