import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		for (int i = 0; i < num; i++)
			arr[i] = Integer.parseInt(br.readLine());
		mergeSort(arr, 0, num - 1);
		for (int i = 0; i < num; i++)
			bw.write(arr[i] + "\n");
		bw.flush();
	}

	public static void mergeSort(int[] items, int first, int last) {
		if (last - first >= 1) {
			int half = (first + last) / 2;
			mergeSort(items, first, half);
			mergeSort(items, (half + 1), last);
			merge(items, first, half, (half + 1), last);
		}
	}

	public static void merge(int[] items, int first1, int last1, int first2, int last2) {
		int start1 = first1;
		int[] temp = new int[last2 - first1 + 1];
		int index = 0;
		while (first1 <= last1 && first2 <= last2) {
			if (items[first1] < items[first2])
				temp[index++] = items[first1++];
			else
				temp[index++] = items[first2++];
		}
		if (first1 <= last1)
			for (int i = first1; i <= last1; i++)
				temp[index++] = items[i];
		if (first2 <= last2)
			for (int i = first2; i <= last2; i++)
				temp[index++] = items[i];
		index = 0;
		for (int i = start1; i <= last2; i++)
			items[i] = temp[index++];
	}
}
