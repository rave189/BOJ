import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = bf.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		long[] array = new long[N+1];
		for(int i=2; i<=N; i++) {
			if(array[i] == 0) {
				if(M > 2) {
					if(i >= M)
						System.out.println(i);
				} else
					System.out.println(i);
				for(int j=i*2; j<=N; j+=i) {
					array[j] = 1;
				}
			}
		}
	}
}
