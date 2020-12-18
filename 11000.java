import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Lecture[] arr = new Lecture[n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i] = new Lecture(start, end);
		}
		Arrays.sort(arr);
		int answer = 0;
		PriorityQueue<Lecture> result = new PriorityQueue<Lecture>(new Comparator<Lecture>() {
			@Override
			public int compare(Lecture o1, Lecture o2) {
				if (o1.end < o2.end)
					return -1;
				else if (o1.end == o2.end) {
					if (o1.start < o2.start)
						return -1;
					else if (o1.start == o2.start)
						return 0;
					else
						return 1;
				} else
					return 1;
			}
		});
		for (Lecture item : arr) {
			while (!result.isEmpty() && result.peek().end <= item.start)
				result.remove();
			result.add(item);
			answer = Math.max(answer, result.size());
		}
		System.out.println(answer);
	}
}

class Lecture implements Comparable<Lecture> {
	int start;
	int end;

	public Lecture(int _start, int _end) {
		this.start = _start;
		this.end = _end;
	}

	@Override
	public int compareTo(Lecture o) {
		if (start < o.start)
			return -1;
		else if (start == o.start) {
			if (end < o.end)
				return -1;
			else if (end == o.end)
				return 0;
			else
				return 1;
		} else
			return 1;
	}

	public String toString() {
		return start + " " + end;
	}
}
