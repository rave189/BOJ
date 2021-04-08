import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] array = new int[10];
		for (int i = 0; i < 10; i++)
			array[i] = Integer.parseInt(bf.readLine())%42;
		for(int i=0; i<10; i++)
			for(int j=0; j<10; j++) {
				if(i != j)
					if(array[i] == array[j]) {
						array[j] = -1;
						break;
					}
			}
		int count = 0;
		for(int i=0; i < 10; i++)
			if(array[i] != -1)
				count++;
		bw.write(Integer.toString(count));
		bw.flush();
	}
}
