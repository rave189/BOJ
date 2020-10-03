import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[20];
		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			if (command.equals("all"))
				for (int j = 0; j < arr.length; j++)
					arr[j] = 1;
			else if (command.equals("empty"))
				for (int j = 0; j < arr.length; j++)
					arr[j] = 0;
			else {
				String[] split = command.split(" ");
				int number = Integer.parseInt(split[1]) - 1;
				if (split[0].equals("add"))
					arr[number] = 1;
				else if (split[0].equals("check"))
					sb.append((arr[number] == 0 ? 0 : 1) + "\n");
				else if (split[0].equals("remove"))
					arr[number] = 0;
				else if (split[0].equals("toggle"))
					arr[number] = (arr[number] == 0) ? arr[number] + 1 : 0;
			}
		}
		System.out.println(sb);
	}
}
