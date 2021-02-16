import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//greedy 방식으로 풀이 
public class Main {
	static class temp implements Comparable<temp> { // 냉장고의 최대온도와 최저 온도를 저장할 수 있는 클래스 생성
		int low;
		int high;

		public temp(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(temp o) {
			int diff = this.low - o.low;
			return diff != 0 ? diff : this.high - o.high;
		}
	}

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("JG1828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Size = Integer.parseInt(br.readLine()); // 화학물질의 개수 입력 받음
		
		temp[] t = new temp[Size]; //화학물질의 개수만큼 배열을 생성하여 최저온도와 최고온도를 입력받음
		for (int i = 0; i < Size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = new temp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		ArrayList<temp> list = new ArrayList<temp>(); //list에 들어갈 수 있는 
		Arrays.sort(t); //정렬

		list.add(t[0]); //최저온도의 물질을 수용할 수 있는 냉장고는 무조건 1개 이상 있으므로
		int count = 1; // 냉장고 개수를 카운트 하나는 무조건 들어가도록 하였기 때문에 1부터 시작
		for (int i = 0, size = t.length; i < size; i++) {
			if (list.get(list.size() - 1).high <= t[i].low) { //만약 이전에 넣은 물질의 최고 온도가 다음 물질의 최저 온도보다 낮으면 새로운 냉장고가 필요
				list.add(t[i]);
				count++; //냉장고 개수 카운트
			}
		}
		System.out.println(count);
	}

}
