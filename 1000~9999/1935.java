import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				String left = st.pop();
				String right = st.pop();
				double leftNum = IsAlphabet(left) ? arr[left.charAt(0) - 65] : Double.parseDouble(left);
				double rightNum = IsAlphabet(right) ? arr[right.charAt(0) - 65] : Double.parseDouble(right);
				if (ch == '+')
					st.push(rightNum + leftNum + "");
				else if (ch == '-')
					st.push(rightNum - leftNum + "");
				else if (ch == '*')
					st.push(rightNum * leftNum + "");
				else
					st.push(rightNum / leftNum + "");
			} else
				st.push(ch + "");
		}
		System.out.printf("%.2f", Double.parseDouble(st.pop()));
	}

	public static boolean IsAlphabet(String str) {
		char ch = str.charAt(0);
		if (65 <= ch && ch <= 90)
			return true;
		return false;
	}
}
