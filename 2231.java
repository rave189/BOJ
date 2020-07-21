import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[1000001];
		for (int i = 1; i <= arr.length-1; i++) {
			String num = Integer.toString(i);
			int index = i;
			for (int j = 0; j < num.length(); j++)
				index += Integer.parseInt(num.substring(j, j + 1));
			if (index <= arr.length-1)
				if (arr[index] == 0 || arr[index] > i)
					arr[index] = i;
		}
		int num = input.nextInt();
		System.out.println(arr[num]);
	}
}
