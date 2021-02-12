import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		String[] number = br.readLine().split("");
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < number.length; i++) {
			while (!st.isEmpty() && k > 0 && st.peek().compareTo(number[i]) < 0) {
				st.pop();
				k--;
			}
			st.push(number[i]);
		}
		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			if (k-- > 0)
				st.pop();
			else
				sb.append(st.pop());
		}
		System.out.println(sb.reverse());
	}
}
