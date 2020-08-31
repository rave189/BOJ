import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int i = 1; i <= n; i++)
			dq.addLast(i);
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			int count = 0;
			while (dq.peek() != num) {
				dq.addLast(dq.poll());
				count++;
			}
			if (count < dq.size() - count)
				sum += count;
			else
				sum += dq.size() - count;
			dq.poll();
		}
		bw.write(Integer.toString(sum));
		bw.flush();
	}
}
