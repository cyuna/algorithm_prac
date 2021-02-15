package boj_백설공주와일곱난장이_3040;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] tgt = new int[7];
	static int[] src = new int[9];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}
		com(0, 0);
	}

	private static void com(int srcIdx, int tgtIdx) {
		if (tgtIdx == 7) {
			check();
			// System.out.println(Arrays.toString(tgt));
			return;
		}

		for (int i = srcIdx; i < src.length; i++) {
			tgt[tgtIdx] = src[i];
			com(i + 1, tgtIdx + 1);
		}

	}

	private static void check() {
		// TODO Auto-generated method stub
		int temp = 0;
		for (int i = 0; i < 7; i++) {
			temp += tgt[i];
		}
		if (temp == 100) {
			for (int i = 0; i < 7; i++) {
				System.out.println(tgt[i]);
			}
		}
	}
}
