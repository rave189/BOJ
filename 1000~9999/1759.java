import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuffer sb = new StringBuffer();
	static int l;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		arr = new char[c];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++)
			arr[i] = st.nextToken().charAt(0);
		Arrays.sort(arr);
		Back(0, 0, "");
		sb.append("\n");
		System.out.print(sb);
	}

	public static void Back(int next, int depth, String s) {
		if (depth == l) {
			int collection = 0; // 모음
			int consonant = 0; // 자음
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
					collection++;
				else
					consonant++;
			}
			if (collection >= 1 && consonant >= 2)
				sb.append(s + "\n");
		} else {
			if (next < arr.length) {
				Back(next + 1, depth + 1, s + arr[next]);
				Back(next + 1, depth, s);
			}
		}
	}
}
