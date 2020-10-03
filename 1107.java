import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[] button;
	static int result;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		button = new boolean[10]; // false가 고장나지 않은 버튼
		int start = 100;
		result = Math.abs(n - start);
		if (m == 0) {
			System.out.println(Math.min(result, Integer.toString(n).length()));
			return;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
			button[Integer.parseInt(st.nextToken())] = true;
		if (n == 100 || m == 10) {
			System.out.println((n == 100) ? 0 : result);
			return;
		}
		Back(0, "");
		System.out.println(result);
	}

	public static String Back(int depth, String next) {
		if (depth < Integer.toString(n).length() + 1)
			for (int i = 0; i < button.length; i++)
				if (!button[i]) {
					String s = Back(depth + 1, next + Integer.toString(i));
					int num = Integer.parseInt(s);
					int compare = Math.abs(num - n) + Integer.toString(num).length();
					if (compare < result)
						result = compare;
				}
		return next;
	}
}
