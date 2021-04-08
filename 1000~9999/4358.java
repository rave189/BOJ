import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

	static final int decimalPoint = 10000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		int total = 0;
		String line = "";
		while ((line = br.readLine()) != null) {
			treeMap.put(line, treeMap.getOrDefault(line, 0) + 1);
			total++;
		}
		for (String tree : treeMap.keySet()) {
			double value = treeMap.get(tree) / (double) total;
			double ratio = Math.round(value * decimalPoint * 100);
			sb.append(tree + " " + String.format("%.4f", ratio / decimalPoint) + "\n");
		}
		System.out.print(sb);
	}
}
