import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int[] array = new int[N];
		for(int i=0; i<N; i++)
			array[i] = input.nextInt();
		int max = 0;
		for(int i=0; i<N; i++)
			for(int j=i+1; j<N; j++)
				for(int t=j+1; t<N; t++) {
					int sum = array[i] + array[j] + array[t];
					if(sum > max && sum <= M)
						max = sum;
				}
		System.out.println(max);
	}
}
