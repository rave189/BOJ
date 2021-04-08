import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int first = input.nextInt();
		for(int i=1; i<num; i++) {
			int tmpFir = first;
			int second = input.nextInt();
			int tmpSec = second;
			while(tmpSec != 0) {
				int r = tmpFir%tmpSec;
				tmpFir = tmpSec;
				tmpSec = r;
			}
			System.out.println(first/tmpFir+"/"+second/tmpFir);
		}
	}
}
