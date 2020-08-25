import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++)
			q.add(i);
		int count = 1;
		while (!q.isEmpty()) {
			if (count++ % k == 0)
				if (q.size() == 1)
					sb.append(q.poll());
				else
					sb.append(q.poll() + ", ");
			else
				q.add(q.poll());
		}
		System.out.println("<" + sb + ">");
	}
}
