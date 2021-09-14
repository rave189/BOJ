package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 64cm의 막대기가 주어진다.
 * 이 막대기를 길이가 Xcm로 만들려고 한다.
 * 만드는 과정은 다음과 같다.
 * 가지고 있는 막대의 길이를 모두 더한다.
 * 처음에는 64cm 막대 하나만 가지고 있다.
 * 이때, 합이 X보다 크다면, 아래와 같은 과정을 반복한다.
 * 1. 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
 * 2. 만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면,
 * 	    위에서 자른 막대의 절반 중 하나를 버린다.
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