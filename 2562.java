import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] array = new int[9];
		for(int i=0; i<9; i++)
			array[i] = Integer.parseInt(bf.readLine());
		int max = array[0];
		int num = 0;
		for(int i=1; i<9; i++)
			if(array[i] > max) {
				max = array[i];
				num = i;
			}
		bw.write(max+"\n"+(num+1));
		bw.flush();
	}
}
