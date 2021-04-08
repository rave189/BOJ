import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(br.readLine());
		long left = 1;
		long right = s;
		long mid = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			long sum = (mid * (mid+1)) / 2;
			if(s >= sum && s < sum + mid + 1)
				break;
			if(sum < s)
				left = mid + 1;
			else
				right = mid - 1;
		}
		System.out.println(mid);
	}
}

class City {
	int cost;
	int customer;

	public City(int cost, int customer) {
		this.cost = cost;
		this.customer = customer;
	}
}
