import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		int sum = 0;
		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if (ch == '+') {
				sum += Integer.parseInt(sb.substring(0, i));
				sb.replace(0, i + 1, "");
				i = -1;
			} else if (ch == '-') {
				q.add(sum + Integer.parseInt(sb.substring(0, i)));
				sum = 0;
				sb.replace(0, i + 1, "");
				i = -1;
			} else if (i == sb.length() - 1) {
				sum += Integer.parseInt(sb.toString());
				q.add(sum);
			}
		}
		sum = q.poll();
		while (!q.isEmpty())
			sum -= q.poll();
		System.out.println(sum);
	}
}
