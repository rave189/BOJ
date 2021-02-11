import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> arr = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++)
			arr.add(Integer.parseInt(br.readLine()));
		int answer = 0;
		while (arr.size() != 1) {
			int sum = arr.poll() + arr.poll();
			answer += sum;
			arr.add(sum);
		}
		System.out.println(answer);
	}
}
