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

/**
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n+2];
		arr[0] = "0";
		arr[1] = "1";
		for (int i = 2; i <= n; i++)
			arr[i] = add(arr[i-2], arr[i-1]);
		bw.write(arr[n]);
		bw.flush();
	}

	public static String add(String a, String b) {
		StringBuilder tmp = new StringBuilder();
		int carry = 0;
		for (int i = b.length() - 1, j = a.length() - 1; i >= 0; i--, j--) {
			int aNum = 0;
			if (j >= 0)
				aNum = Integer.parseInt(a.substring(j, j + 1));
			int bNum = Integer.parseInt(b.substring(i, i + 1));
			int sum = aNum + bNum + carry;
			if (sum >= 10) {
				carry = 1;
				tmp.append(sum - 10);
			} else {
				carry = 0;
				tmp.append(sum);
			}
		}
		if (carry != 0)
			tmp.append(carry);
		return tmp.reverse().toString();
	}
}
*/
