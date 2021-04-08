import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int A = Integer.parseInt(bf.readLine());
		int B = Integer.parseInt(bf.readLine());
		int C = Integer.parseInt(bf.readLine());
		String s = Integer.toString(A*B*C);
		String[] sa = new String[s.length()];
		int[] result = new int[10];
		for(int i=0; i<s.length(); i++) {
			sa[i] = s.substring(i, i+1);
		}
		for(int i=0; i<s.length(); i++)
			for(int j=0; j<10; j++) {
				int temp = Integer.parseInt(sa[i]);
				if(temp == j)
					result[j]++;
			}
		for(int i=0; i<10; i++)
			System.out.println(result[i]);
	}
}
