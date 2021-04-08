import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (ch == ')') {
				int partSum = 0;
				while (!st.peek().equals("("))
					partSum += Integer.parseInt(st.pop());
				st.pop();
				st.push(Integer.parseInt(st.pop()) * partSum + "");
			} else if (ch == '(')
				st.push(ch + "");
			else {
				if (i + 1 < line.length()) {
					char next = line.charAt(i + 1);
					if (next == '(')
						st.push(ch + "");
					else
						st.push("1");
				} else
					st.push("1");
			}
		}
		int answer = 0;
		for (String item : st)
			answer += Integer.parseInt(item);
		System.out.println(answer);
	}
}
