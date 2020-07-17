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
		Member[] mmArr = new Member[num];
		for(int i=0; i<num; i++) {
			String[] s = br.readLine().split(" ");
			mmArr[i] = new Member(Integer.parseInt(s[0]), s[1]);
		}
		mergeSort(mmArr, 0, num-1);
		for(int i=0; i<num; i++)
			System.out.println(mmArr[i].toString());
	}
	public static void mergeSort(Member[] arr, int first, int last) {
		if(last-first >= 1) {
			int mid = (last+first)/2;
			mergeSort(arr, first, mid);
			mergeSort(arr, mid+1, last);
			sort(arr, first, mid, last);
		}
	}
	public static void sort(Member[] arr, int first, int mid, int last) {
		int start = first;
		Member[] temp = new Member[last-first+1];
		int index = 0;
		int first2 = mid+1;
		while(start <= mid && first2 <= last)
			if(arr[start].age <= arr[first2].age)
				temp[index++] = arr[start++];
			else
				temp[index++] = arr[first2++];
		while(start <= mid)
			temp[index++] = arr[start++];
		while(first2 <= last)
			temp[index++] = arr[first2++];
		index = 0;
		for(int i=first; i<=last; i++)
			arr[i] = temp[index++];
	}
}

class Member{
	int age;
	String name;
	public Member(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public String toString() {
		return age+" "+name;
	}
}
