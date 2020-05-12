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
		int num = Integer.parseInt(bf.readLine());
		int[] array = new int[num];
		StringTokenizer stk = new StringTokenizer(bf.readLine());
		for (int i = 0; i < num; i++) {
			array[i] = Integer.parseInt(stk.nextToken());
		}
		int max = array[0];
		int min = array[0];
		for(int i=1; i<num; i++) {
			if(array[i] > max)
				max = array[i];
			if(array[i] < min)
				min = array[i];
		}
		bw.write(min+" "+max);
		bw.flush();
	}
}
