import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class SmallestInfiniteSet {
    private int currentSmallest;
    private PriorityQueue<Integer> minHeap;
    private Set<Integer> addedBackSet;

    public SmallestInfiniteSet() {
        this.currentSmallest = 1;
        this.minHeap = new PriorityQueue<>();
        this.addedBackSet = new HashSet<>();
    }
    
    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            addedBackSet.remove(smallest);
            return smallest;
        }
        int smallest = currentSmallest;
        currentSmallest++;
        return smallest;
    }
    
    public void addBack(int num) {
        if (num < currentSmallest && !addedBackSet.contains(num)) {
            minHeap.offer(num);
            addedBackSet.add(num);
        }
    }
}
