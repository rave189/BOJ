import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int number = Integer.parseInt(bf.readLine());
		for(int i=0; i<number; i++)
		{
			for(int j=0; j<=i; j++)
				bw.write("*");
			bw.write("\n");
			bw.flush();
		}
	}
}
