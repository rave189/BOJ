import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		BigInteger[] bi = new BigInteger[n + 2];
		bi[0] = new BigInteger("0");
		bi[1] = new BigInteger("1");
		for (int i = 2; i <= n; i++)
			bi[i] = bi[i - 1].add(bi[i - 2]);
		bw.write(bi[n].toString());
		bw.flush();
	}
}
