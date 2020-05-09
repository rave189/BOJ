import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int[] array = new int[number];
		for(int i=0; i<number; i++)
			array[i] = input.nextInt();
		for(int i=0; i<number; i++) {
			int min = array[i];
			int index = i;
			for(int j=i+1; j<number; j++) {
				if(array[j] < min) {
					min = array[j];
					index = j;
				}
			}
			int temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		for(int i=0; i<number; i++)
			System.out.println(array[i]);
	}
}
