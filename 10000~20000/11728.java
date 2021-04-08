import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
			b[i] = Integer.parseInt(st.nextToken());
		for (int i = 0, j = 0;;)
			if (i < n && j < m)
				sb.append((a[i] < b[j] ? a[i++] : b[j++]) + " ");
			else if (i < n)
				sb.append(a[i++] + " ");
			else if (j < m)
				sb.append(b[j++] + " ");
			else
				break;
		System.out.println(sb);
	}
}
