import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<String> st;
		while (true) {
			st = new Stack<String>();
			String line = br.readLine();
			if (line.equals("."))
				break;
			boolean done = true;
			for (int i = 0; i < line.length(); i++) {
				if (line.substring(i, i + 1).equals("("))
					st.push("(");
				else if (line.substring(i, i + 1).equals("["))
					st.push("[");
				else if (line.substring(i, i + 1).equals(")"))
					if (!st.empty() && st.peek().equals("("))
						st.pop();
					else {
						done = false;
						break;
					}
				else if (line.substring(i, i + 1).equals("]"))
					if (!st.empty() && st.peek().equals("["))
						st.pop();
					else {
						done = false;
						break;
					}
			}
			if (done && st.empty())
				System.out.println("yes");
			else
				System.out.println("no");
		}
		bw.flush();
	}
}
