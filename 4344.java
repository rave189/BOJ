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
		StringTokenizer stk;
		for(int i=0; i<number; i++) {
			stk = new StringTokenizer(bf.readLine());
			int stunum = Integer.parseInt(stk.nextToken());
			int[] array = new int[stunum];
			double sum = 0;
			for(int j=0; j<stunum; j++) {
				array[j] = Integer.parseInt(stk.nextToken());
				sum += array[j];
			}
			double ave = sum/stunum;
			int count = 0;
			for(int j=0; j<stunum; j++)
				if(array[j] > ave)
					count++;
			double radio = ((double)count/stunum)*100;
			bw.write(String.format("%.3f", radio)+"%\n");
			bw.flush();
		}
	}
}
