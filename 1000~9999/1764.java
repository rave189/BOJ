import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<String>();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++)
			arr[i] = br.readLine();
		for (int i = 0; i < m; i++)
			hs.add(br.readLine());
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < n; i++)
			if (hs.contains(arr[i])) {
				sb.append(arr[i] + "\n");
				count++;
			}
		System.out.println(count + "\n" + sb);
	}
}
