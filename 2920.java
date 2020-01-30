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
		int[] array = new int[8];
		for(int i=0; i< 8; i++)
			array[i] = Integer.parseInt(stk.nextToken());
		String s = "";
		for(int i=0; i<8; i++) {
			if(array[i] != i+1)
				break;
			if(i==7)
				s = "ascending";
		}
		for(int i=0; i<8; i++) {
			if(array[i] != 8-i)
				break;
			if(i==7)
				s = "descending";
		}
		if(s == "")
			s = "mixed";
		bw.write(s);
		bw.flush();
	}
}
