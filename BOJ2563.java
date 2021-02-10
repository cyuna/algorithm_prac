package hwalgo07_서울_13반_최윤아;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_색종이_2563 {
	static int[][] map = new int[100][100];
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x - 1; j < x + 9; j++) {
				for (int k = y - 1; k < y + 9; k++) {
					map[j][k] = 1;
				}
			}

		}
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if (map[j][k] == 1)
					answer++;
			}
		}
		System.out.println(answer);

	}
}
