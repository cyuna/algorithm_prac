package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {
	static int[] answer;
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
		int[] answer;

		for (int i = 0; i < operations.length; i++) {
			StringTokenizer st = new StringTokenizer(operations[i]);
			String op = st.nextToken();
			int temp = Integer.parseInt(st.nextToken());

			if (op.equals("I")) {
				pq.add(temp);
			} else if (op.equals("D")) {
				if (pq.isEmpty()) {
					continue;
				}
				if (temp == -1) {
					PriorityQueue<Integer> pqr = new PriorityQueue<>();
					while (!pq.isEmpty()) {
						pqr.add(pq.poll());
					}
					pqr.poll();
					while (!pqr.isEmpty()) {
						pq.add(pqr.poll());
					}

				} else if (temp == 1) {
					pq.poll();
				}
			}
		}
        answer = new int[2];
		if (pq.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
		} else {
			answer[0] = pq.poll();
            while(!pq.isEmpty()){
               answer[1] = pq.poll(); 
            }
		}
       System.out.println(Arrays.toString(answer));
    }
}
