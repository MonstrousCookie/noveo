package Array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class TimeNeededToBuyTickets {

    public static void main(String[] args) {

        System.out.println(timeRequiredToBuy(List.of(2,3,2),2));

        System.out.println(timeRequiredToBuy(List.of(5,1,1,1),0));

    }

    // O(N) Time
    // O(N) Space
    public static int timeRequiredToBuy(List<Integer> tickets, int k) {
        if (tickets.get(k) == 0) {
            return 0;
        }

        Deque<int[]> A = new ArrayDeque<>();
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i) > 0) {
                A.addLast(new int[] {i, tickets.get(i)});
            }
        }

        int time = 0;
        while (!A.isEmpty()) {
            int n = A.size();
            for (int i = 0; i < n; i++) {
                int[] p = A.pollFirst();
                int index = p[0];
                int t = p[1];
                time++;
                if (index == k && t == 1) {
                    return time;
                }
                if (t - 1 > 0) {
                    A.addLast(new int[] {index, t - 1});
                }
            }
        }
        return time;
    }

}
