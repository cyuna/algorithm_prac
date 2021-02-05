import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ9742 {

	static char[] src_array; // 입력 받은 배열
	static char[] tgt; // 정답이 저장될 배열
	static boolean[] select; // 사용되었던 숫자인지를 확인
	static int target; // 출력할 순열 번호
	static int count; // 순열의 순서를 카운트
	static boolean flag; // 만약 출력할 순열 번호가 없을 경우 No를 출력하기 위한 flag

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input9742.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			String str = br.readLine();
			if (str == null) // 더 이상의 테스트 케이스가 없다면 멈춤
				break;
			StringTokenizer st = new StringTokenizer(str);
			String src = st.nextToken();
			src_array = src.toCharArray();
			target = Integer.parseInt(st.nextToken()); // 입력받음

			select = new boolean[src_array.length]; // 초기화
			tgt = new char[src_array.length];
			count = 0;
			flag = false;

			System.out.print(str + " = ");
			perm(0); // 순열
			if (flag == false) {
				System.out.println("No permutation");
			} else {
				System.out.println();
			}
			// System.out.println(Arrays.toString(src_array));
		}
	}

	private static void perm(int tgt_idx) {
		// 기저 조건
		if (tgt_idx == src_array.length) {
			count++;
			if (count == target) {
				flag = true;
				for (int i = 0; i < tgt.length; i++) {
					System.out.print(tgt[i]);
				}

			}
			return;
		}
		for (int i = 0; i < src_array.length; i++) {
			if (select[i]) // 사용되어 있으면 패스
				continue;
			tgt[tgt_idx] = src_array[i]; // 사용되어 있지 않으면 사용하기
			select[i] = true;
			perm(tgt_idx + 1);
			select[i] = false;
		}

	}
}
