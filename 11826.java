import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(1000, new Comparator<Integer>() {
			@Override
			public int compare(Integer p1, Integer p2) {
				int a1 = Math.abs(p1);
				int a2 = Math.abs(p2);
				if (a1 > a2)
					return 1;
				else if (a1 == a2) {
					if (p1 > p2)
						return 1;
					else if (p1 == p2)
						return 0;
					else
						return -1;
				} else
					return -1;
			}
		});
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				if (pq.peek() == null)
					bw.write("0\n");
				else
					bw.write(pq.poll() + "\n");
			else
				pq.add(num);
		}
		bw.flush();
	}
}
