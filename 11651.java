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
		Point[] arr = new Point[num];
		for (int i = 0; i < num; i++) {
			String[] s = br.readLine().split(" ");
			arr[i] = new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		}
		mergeSort(arr, 0, num - 1);
		for (int i = 0; i < num; i++)
			bw.write(arr[i].x + " " + arr[i].y + "\n");
		bw.flush();
	}

	public static void mergeSort(Point[] arr, int first, int last) {
		if (last - first >= 1) {
			int mid = (first + last) / 2;
			mergeSort(arr, first, mid);
			mergeSort(arr, mid + 1, last);
			merge(arr, first, last);
		}
	}

	public static void merge(Point[] arr, int first, int last) {
		int mid = (first + last) / 2;
		int midlast = mid++;
		Point[] temp = new Point[last - first + 1];
		int count = 0;
		int tmpFirst = first;
		while (first <= midlast && mid <= last) {
			if (arr[first].y < arr[mid].y)
				temp[count++] = new Point(arr[first].x, arr[first++].y);
			else if (arr[first].y == arr[mid].y) {
				if (arr[first].x < arr[mid].x)
					temp[count++] = new Point(arr[first].x, arr[first++].y);
				else
					temp[count++] = new Point(arr[mid].x, arr[mid++].y);
			} else
				temp[count++] = new Point(arr[mid].x, arr[mid++].y);
		}
		while (first <= midlast)
			temp[count++] = new Point(arr[first].x, arr[first++].y);
		while(mid <= last)
			temp[count++] = new Point(arr[mid].x, arr[mid++].y);
		count = 0;
		for(int i=tmpFirst; i<=last; i++)
			arr[i] = new Point(temp[count].x, temp[count++].y);
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
