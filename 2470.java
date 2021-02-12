import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr.add(Integer.parseInt(st.nextToken()));
		arr.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		int diff = Integer.MAX_VALUE;
		int[] answer = new int[2];
		for (int i = 0; i < n - 1; i++) {
			int first = arr.get(i);
			int second = arr.get(i + 1);
			int compareDiff = Math.abs(0 - (first + second));
			if (compareDiff < diff) {
				diff = compareDiff;
				answer[0] = first;
				answer[1] = second;
			}
		}
		if (answer[0] > answer[1])
			System.out.println(answer[1] + " " + answer[0]);
		else
			System.out.println(answer[0] + " " + answer[1]);
	}
}
