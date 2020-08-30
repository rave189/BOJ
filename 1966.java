import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<Integer>();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				q.add(j);
			}
			int count = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				int cur = q.poll();
				for (int j = 0; j < n; j++)
					if (arr[cur] < arr[j]) {
						q.add(cur);
						break;
					}
				if (size != q.size()) {
					count++;
					arr[cur] = 0;
					if (cur == m)
						break;
				}
			}
			bw.write(Integer.toString(count) + "\n");
		}
		bw.flush();
	}
}
