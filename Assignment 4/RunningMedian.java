import java.util.PriorityQueue;

public class RunningMedian {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    public double runningMedian(int num) {
       if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
        maxHeap.offer(num);
       }
       else minHeap.offer(num);

       if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
       }
       else if (maxHeap.size() < minHeap.size()) {
        maxHeap.offer(minHeap.poll());
       }

       if (minHeap.size() == maxHeap.size()) {
        return (minHeap.peek() + maxHeap.peek()) / 2;
       }
       return maxHeap.peek();
    }
}
