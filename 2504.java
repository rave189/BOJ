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
			int sum = 0;
			if (ch == ')') {
				if (!Calculate(st, "(", "[", 2)) {
					System.out.println(0);
					return;
				}
			} else if (ch == ']') {
				if (!Calculate(st, "[", "(", 3)) {
					System.out.println(0);
					return;
				}
			} else
				st.push(ch + "");
		}
		int answer = 0;
		while (!st.isEmpty()) {
			if (IsInt(st.peek()))
				answer += Integer.parseInt(st.pop());
			else {
				System.out.println(0);
				return;
			}
		}
		System.out.println(answer);
	}

	public static boolean Calculate(Stack<String> st, String trueStr, String falseStr, int num) {
		int sum = 0;
		while (!st.isEmpty() && !st.peek().equals(trueStr)) {
			if (st.peek().equals(falseStr))   // 괄호의 쌍이 다르면 false
				return false;
			if (IsInt(st.peek()))     // int가 아니면 false
				sum += Integer.parseInt(st.pop());
			else
				return false;
			if (st.isEmpty())   // 여는 괄호를 못찾고 스택이 끝나면 false
				return false;
		}
		if (!st.isEmpty())    // 스택이 비어있으면 괄호 쌍이 안맞으므로 false
			st.pop();   // 여는 괄호 지우기
		else
			return false;
		if (sum == 0)
			st.push(num + "");
		else
			st.push(sum * num + "");
		return true;
	}

	public static boolean IsInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
