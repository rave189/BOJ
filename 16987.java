import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Egg[] egg = new Egg[n];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			int durability = Integer.parseInt(line[0]);
			int weight = Integer.parseInt(line[1]);
			egg[i] = new Egg(durability, weight);
		}
		Back(egg, 0);
		System.out.println(max);
	}

	public static void Back(Egg[] egg, int cur) {
		if (cur == egg.length) {
			int count = EggBreak(egg);
			if (count > max)
				max = count;
		} else if (egg[cur].durability <= 0 || Check(egg, cur))
			Back(egg, cur + 1);
		else
			for (int i = 0; i < egg.length; i++)
				if (i != cur && egg[i].durability > 0) {
					egg[i].durability -= egg[cur].weight;
					egg[cur].durability -= egg[i].weight;
					Back(egg, cur + 1);
					egg[i].durability += egg[cur].weight;
					egg[cur].durability += egg[i].weight;
				}
	}

	public static int EggBreak(Egg[] egg) {
		int count = 0;
		for (int i = 0; i < egg.length; i++)
			if (egg[i].durability <= 0)
				count++;
		return count;
	}

	public static boolean Check(Egg[] egg, int cur) {
		for (int i = 0; i < egg.length; i++)
			if (i != cur && egg[i].durability > 0)
				return false;
		return true;
	}
}

class Egg {
	int durability;
	int weight;

	public Egg(int durability, int weight) {
		this.durability = durability;
		this.weight = weight;
	}
}
