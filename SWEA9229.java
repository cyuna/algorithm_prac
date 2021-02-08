package SWEA9229;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA9229 {
	static int count, max;
	static int[] src;
	static int[] tgt = new int[2]; //과자 n 개 중에 2개를 뽑음
	static int answer;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			count = Integer.parseInt(st.nextToken());
			max = Integer.parseInt(st.nextToken());
			src = new int[count];
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int i = 0; i < count; i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}
			answer = -1;
			comb(0, 0);
			System.out.println("#" + t + " " + answer);

		}

	}

	private static void comb(int srcIdx, int tgtIdx) {

		if (tgtIdx == tgt.length) {
			int temp = tgt[0] + tgt[1];
			if (temp <= max && answer <= temp) {
				answer = temp;
			}
			return;
		}
		if (srcIdx == src.length) {
			return;
		}
		tgt[tgtIdx] = src[srcIdx];
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);

	}
}
