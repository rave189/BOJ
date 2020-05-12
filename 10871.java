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
		StringTokenizer stk = new StringTokenizer(bf.readLine());
		int number = Integer.parseInt(stk.nextToken());
		int condition = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(bf.readLine());
		for (int i = 0; i < number; i++) {
			int temp = Integer.parseInt(stk.nextToken());
			if (temp < condition)
				bw.write(temp + " ");
		}
		bw.flush();
	}
}
