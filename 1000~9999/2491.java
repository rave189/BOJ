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
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int[] increase = new int[n];
		int[] decrease = new int[n];
		increase[0] = 1;
		decrease[0] = 1;
		for (int i = 1; i < n; i++)
			if (arr[i] >= arr[i - 1])
				increase[i] = increase[i - 1] + 1;
			else
				increase[i] = 1;
		for (int i = 1; i < n; i++)
			if (arr[i] <= arr[i - 1])
				decrease[i] = decrease[i - 1] + 1;
			else
				decrease[i] = 1;
		int max = 0;
		for (int i = 0; i < n; i++)
			max = Math.max(Math.max(max, increase[i]), decrease[i]);
		bw.write(Integer.toString(max));
		bw.flush();
	}
}
