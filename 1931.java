import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] arr = new Point[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		int prev = 0;
		int result = 0;
		for (int i = 0; i < n; i++)
			if (arr[i].start >= prev) {
				prev = arr[i].end;
				result++;
			}
		System.out.println(result);
	}
}

class Point implements Comparable<Point> {
	int start, end;

	public Point(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Point o) {
		if (end > o.end)
			return 1;
		else if (end == o.end) {
			if (start > o.start)
				return 1;
			else if (start == o.start)
				return 0;
			else
				return -1;
		} else
			return -1;
	}

	public String toString() {
		return "(" + start + ", " + end + ")";
	}
}
