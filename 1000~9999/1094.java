package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 64cm�� ����Ⱑ �־�����.
 * �� ����⸦ ���̰� Xcm�� ������� �Ѵ�.
 * ����� ������ ������ ����.
 * ������ �ִ� ������ ���̸� ��� ���Ѵ�.
 * ó������ 64cm ���� �ϳ��� ������ �ִ�.
 * �̶�, ���� X���� ũ�ٸ�, �Ʒ��� ���� ������ �ݺ��Ѵ�.
 * 1. ������ �ִ� ���� �� ���̰� ���� ª�� ���� �������� �ڸ���.
 * 2. ����, ������ �ڸ� ������ ���� �� �ϳ��� ������ �����ִ� ������ ������ ���� X���� ũ�ų� ���ٸ�,
 * 	    ������ �ڸ� ������ ���� �� �ϳ��� ������.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		int sum = 64;
		st.add(sum);
		while (sum != x) {
			int cur = st.pop();
			sum -= cur;
			int devide = cur / 2;
			if (devide != 0) {
				st.add(devide);
				st.add(devide);
				sum += devide * 2;
			}
			if (sum - st.peek() > x) {
				sum -= st.pop();
			}
		}
		System.out.println(st.size());
	}
}