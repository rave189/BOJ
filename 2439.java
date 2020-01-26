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
			for(int j=number; j>i+1; j--)
				bw.write(" ");
			for(int t=0; t<=i; t++)
				bw.write("*");
			bw.write("\n");
			bw.flush();
		}
	}
}
