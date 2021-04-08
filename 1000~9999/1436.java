import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		String[] arr = new String[num];
		arr[0] = "666";
		int index = 0;
		for (int i = 1; i + index < num; i++) {
			arr[i + index] = Integer.toString(i);
			int countSix = countSix(i);
			if (countSix != 0) {
				for (int j = 0; j < 3 - countSix; j++)
					arr[i + index] += "6";
				String first = arr[i + index];
				int count = i + index;
				int remain = (int) Math.pow(10, countSix);
				for (int j = 0; j < remain; j++) {
					String last = Integer.toString(j);
					for(int t=0; t<countSix-last.length(); t++)
						last = "0"+last;
					if (count < num)
						arr[count++] = first + last;
					else
						break;
				}
				index = count - i - 1;
			} else
				arr[i + index] += "666";
		}
		System.out.println(arr[num-1]);
	}

	public static int countSix(int n) {
		String s = Integer.toString(n);
		int count = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.substring(i, i + 1).equals("6"))
				count++;
			else
				count = 0;
		return count;
	}
}
