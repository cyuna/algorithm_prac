import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Obj {
		int index;
		int pri;

		public Obj(int index, int pri) {
			super();
			this.index = index;
			this.pri = pri;
		}

	}

	static Queue<Obj> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken()); // 문서 개수 입력
			int tgt = Integer.parseInt(st.nextToken()); // 출력할 문서의 index
			int[] maxArray = new int[size];
			int count = 0; // 몇번째 출력할지 개수를 계산
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < size; i++) { // 우선순위와 인덱스 입력받아 큐에 저장
				Obj o = new Obj(i, Integer.parseInt(st.nextToken()));
				maxArray[i] = o.pri; // 우선순위는 추가적으로 maxArray에 저장
				q.offer(o);
			}

			Integer[] arr = Arrays.stream(maxArray).boxed().toArray(Integer[]::new); // 내림차순을 위함
			Arrays.sort(arr, Collections.reverseOrder()); // 우선순위를 저장한 배열을 정렬함.

			for (int i = 0; i < size; i++) {
				count++;
				while (true) {
					Obj temp = q.poll();
					if (temp.pri == arr[i]) {
						if (temp.index == tgt) {
							System.out.println(count);
						}
						break;
					} else {
						q.offer(temp);
					}
				}

			}
		}
	}
}
