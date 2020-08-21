import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = 1;
			for (int j = 0; j < i; j++)
				if (arr[j] < arr[i] && result[i] < result[j] + 1)
					result[i] = result[j] + 1;
		}
		int max = 0;
		for (int i = 0; i < n; i++)
			max = Math.max(max, result[i]);
		bw.write(Integer.toString(max));
		bw.flush();
	}
}
