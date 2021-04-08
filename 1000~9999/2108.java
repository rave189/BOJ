import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int num = Integer.parseInt(s);
		int[] arr = new int[num];
		int sum = 0;
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		mergeSort(arr, 0, num - 1);
		int[] frequency = new int[num];
		frequency[0] = 1;
		int max = 1;
		int index = 0;
		int secondIdx = 0;
		for (int i = 1; i < num; i++) {
			if (arr[i] == arr[i - 1])
				frequency[i] = ++frequency[i - 1];
			else
				frequency[i] = 1;
			if (frequency[i] > max) {
				max = frequency[i];
				index = i;
				secondIdx = i;
			} else if (frequency[i] == max)
				if(index == secondIdx)
					secondIdx = i;
		}
		bw.write(Math.round((double)sum / num) + "\n");
		bw.write(arr[num / 2] + "\n");
		bw.write(arr[secondIdx] + "\n");
		bw.write(Integer.toString(arr[num - 1] - arr[0]));
		bw.flush();
	}

	public static void mergeSort(int[] arr, int first, int last) {
		if (last - first >= 1) {
			int mid = (last + first) / 2;
			mergeSort(arr, first, mid);
			mergeSort(arr, mid + 1, last);
			merge(arr, first, last);
		}
	}

	public static void merge(int[] arr, int first, int last) {
		int mid = (last + first) / 2;
		int midlast = mid++;
		int tmpFirst = first;
		int[] tmpArr = new int[last - first + 1];

		int count = 0;
		while (tmpFirst <= midlast && mid <= last)
			if (arr[tmpFirst] > arr[mid])
				tmpArr[count++] = arr[mid++];
			else
				tmpArr[count++] = arr[tmpFirst++];
		while (tmpFirst <= midlast)
			tmpArr[count++] = arr[tmpFirst++];
		while (mid <= last)
			tmpArr[count++] = arr[mid++];

		for (int i = first, j = 0; i <= last && j <= count; i++)
			arr[i] = tmpArr[j++];
	}
}
