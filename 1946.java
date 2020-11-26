import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			Grade[] arr = new Grade[n];
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int document = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				arr[j] = new Grade(document, interview);
			}
			Arrays.sort(arr);
			int count = 1;
			Grade pick = arr[0];
			for (int j = 1; j < n; j++) {
				if (arr[j].document < pick.document ^ arr[j].interview < pick.interview) {
					count++;
					pick = arr[j];
				}
			}
			System.out.println(count);
		}
	}
}

class Grade implements Comparable<Grade> {
	int document;
	int interview;

	public Grade(int _document, int _interview) {
		this.document = _document;
		this.interview = _interview;
	}

	@Override
	public int compareTo(Grade o) {
		if (document > o.document)
			return 1;
		else if (document == o.document) {
			if (interview > o.interview)
				return 1;
			else if (interview == o.interview)
				return 0;
			else
				return -1;
		} else
			return -1;
	}
}
