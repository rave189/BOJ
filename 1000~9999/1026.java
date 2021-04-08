import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			b[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(a);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (b[i] > b[j]) {
					int temp = b[j];
					b[j] = b[i];
					b[i] = temp;
				}
		int ans = 0;
		for (int i = 0; i < n; i++)
			ans += a[i] * b[i];
		System.out.println(ans);
	}
}
