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
		int[] A = new int[n];
		int[] B = new int[n];
		A[0] = 0;
		B[0] = 1;
		for (int i = 1; i < n; i++) {
			A[i] = B[i - 1];
			B[i] = A[i - 1] + B[i - 1];
		}
		bw.write(Integer.toString(A[n - 1]) + " " + Integer.toString(B[n - 1]));
		bw.flush();
	}
}
