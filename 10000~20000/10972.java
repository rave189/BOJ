import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] permutation = new int[k];
		for (int i = 0; i < k; i++)
			permutation[i] = Integer.parseInt(st.nextToken());
		int lastIncreaseIdx = FindLastIncreaseIdx(permutation);
		if (lastIncreaseIdx < 0) {
			System.out.println(-1);
			return;
		}
		int lastBigNumIdx = FindLastBigNumIdx(permutation, lastIncreaseIdx);
		Swap(permutation, lastIncreaseIdx, lastBigNumIdx);
		PartReverse(permutation, lastIncreaseIdx + 1);
		for (int i = 0; i < k; i++)
			System.out.print(permutation[i] + " ");
	}

	public static int FindLastIncreaseIdx(int[] permutation) {
		int idx = -1;
		for (int i = 1; i < permutation.length; i++)
			if (permutation[i - 1] < permutation[i])
				idx = i - 1;
		return idx;
	}

	public static int FindLastBigNumIdx(int[] permutation, int lastIncreaseIdx) {
		int idx = 0;
		for (int i = lastIncreaseIdx + 1; i < permutation.length; i++)
			if (permutation[i] > permutation[lastIncreaseIdx])
				idx = i;
		return idx;
	}

	public static void Swap(int[] permutation, int left, int right) {
		int tmp = permutation[left];
		permutation[left] = permutation[right];
		permutation[right] = tmp;
	}

	public static void PartReverse(int[] permutation, int startIdx) {
		for (int left = startIdx, right = permutation.length - 1; left <= right; left++, right--) {
			int tmp = permutation[left];
			permutation[left] = permutation[right];
			permutation[right] = tmp;
		}
	}
}
