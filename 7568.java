import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		People[] pp = new People[num];
		int[] ans = new int[num];
		for(int i=0; i<num; i++)
			pp[i] = new People(input.nextInt(), input.nextInt());
		for(int i=0; i<num; i++) {
			People p1 = pp[i];
			int count = 1;
			for(int j=0; j<num; j++) {
				People p2 = pp[j];
				if(p1.weight < p2.weight && p1.tall < p2.tall)
					count++;
			}
			ans[i] = count;
		}
		for(int i=0; i<num; i++)
			System.out.print(ans[i]+" ");
	}
}
class People{
	int weight;
	int tall;
	public People(int weight, int tall) {
		this.weight = weight;
		this.tall = tall;
	}
}
