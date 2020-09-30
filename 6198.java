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
		Stack<Long> st = new Stack<Long>();
		int n = Integer.parseInt(br.readLine());
		long count = 0;
		for (int i = 0; i < n; i++) {
			long num = Long.parseLong(br.readLine());
			while (!st.isEmpty())
				if (num < st.peek()) {
					count += st.size();
					st.add(num);
					break;
				} else
					st.pop();
			if (st.isEmpty())
				st.add(num);
		}
		bw.write(Long.toString(count));
		bw.flush();
	}
}
