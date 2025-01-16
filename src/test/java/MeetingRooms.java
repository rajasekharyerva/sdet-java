import java.util.*;

class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        // Edge case: no meetings, no rooms needed
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Step 1: Sort the meetings in increasing order of their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap to track the minimum end time of meetings that are ongoing
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // Step faq2: Process each meeting
        for (int[] interval : intervals) {
            // If the room due to the earliest ending meeting is free, remove it
            if (!heap.isEmpty() && heap.peek() <= interval[0]) {
                heap.poll();
            }

            // Add the current meeting's end time to the heap
            heap.offer(interval[1]);
        }

        // The size of the heap is the number of rooms required
        return heap.size();
    }

    public static void main(String[] args) {
        MeetingRooms mr = new MeetingRooms();

        // Test case
        int[][] intervals = {
                {15, 20},
                {0, 10},
                {5, 20}
        };

        System.out.println("Minimum rooms required: " + mr.minMeetingRooms(intervals)); // Output: faq2
    }
}

