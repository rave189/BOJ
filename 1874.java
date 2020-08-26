import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<Integer>();
		boolean done = true;
		int count = 1;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			while (st.empty() || st.peek() < num) {
				st.add(count++);
				sb.append("+\n");
			}
			if (st.peek() == num) {
				st.pop();
				sb.append("-\n");
			} else {
				done = false;
				break;
			}
		}
		if (done)
			System.out.println(sb);
		else
			System.out.println("NO");
	}
}
