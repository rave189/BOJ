import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	final static int devide = 15746;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			int n = Integer.parseInt(br.readLine());
			BigInteger[] bi = new BigInteger[100];
			bi[0] = new BigInteger("1");
			bi[1] = new BigInteger("1");
			bi[2] = new BigInteger("1");
			bi[3] = new BigInteger("2");
			bi[4] = new BigInteger("2");
			for (int j = 5; j < n; j++)
				bi[j] = bi[j - 1].add(bi[j - 5]);
			bw.write(bi[n - 1].toString() + "\n");
			bw.flush();
		}
	}
}
