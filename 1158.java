import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++)
			ll.add(i);
		int count = 1;
		bw.write("<");
		while (!ll.isEmpty()) {
			if (count++ % k == 0) {
				if (ll.size() == 1)
					bw.write(Integer.toString(ll.pop()));
				else
					bw.write(Integer.toString(ll.pop()) + ", ");
			} else
				ll.add(ll.pop());
		}
		bw.write(">");
		bw.flush();
	}
}
