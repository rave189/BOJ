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
		String line = br.readLine();
		for (int i = 0; i < line.length(); i++)
			dq.addLast(line.substring(i, i + 1));
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			line = br.readLine();
			if (line.contains("P"))
				dq.addLast(line.split(" ")[1]);
			else if (line.equals("L")) {
				if (!dq.isEmpty())
					st.push(dq.pollLast());
			} else if (line.equals("D")) {
				if (!st.isEmpty())
					dq.addLast(st.pop());
			} else if (line.equals("B"))
				if (!dq.isEmpty())
					dq.pollLast();
		}
		while (!st.isEmpty())
			dq.addLast(st.pop());
		while (!dq.isEmpty())
			bw.write(dq.poll());
		bw.flush();
	}
}
