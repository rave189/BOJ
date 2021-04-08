import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<String> dq = new ArrayDeque<String>();
		Stack<String> st = new Stack<String>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++)
				switch (line.charAt(j)) {
				case '<':
					if (!dq.isEmpty())
						st.push(dq.pollLast());
					break;
				case '>':
					if (!st.isEmpty())
						dq.addLast(st.pop());
					break;
				case '-':
					dq.pollLast();
					break;
				default:
					dq.addLast(line.substring(j, j + 1));
				}
			while (!st.isEmpty())
				dq.addLast(st.pop());
			while (!dq.isEmpty())
				bw.write(dq.poll());
			bw.write("\n");
		}
		bw.flush();
	}
}
