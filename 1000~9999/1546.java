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
		int number = Integer.parseInt(bf.readLine());
		int[] array = new int[number];
		StringTokenizer stk = new StringTokenizer(bf.readLine());
		int max = 0;
		for(int i=0; i<number; i++) {
			array[i] = Integer.parseInt(stk.nextToken());
			if(array[i] > max)
				max = array[i];
		}
		double sum = 0;
		for(int i=0; i<number; i++)
			sum += ((double)array[i]/max)*100;
		bw.write(Double.toString(sum/number));
		bw.flush();
	}
}
