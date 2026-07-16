class MedianFinder {
    private PriorityQueue<Integer> leftMaxHeap;
    private PriorityQueue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {  
        //O(log n) — heap mein add()/poll() operations O(log n) lete hain.
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else
            rightMinHeap.add(num);

        if (Math.abs(leftMaxHeap.size() - rightMinHeap.size()) > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        // O(1) — sirf top elements peek karne hain.
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            // even number of elements
            return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        }

        // odd number of elements
        return leftMaxHeap.peek();
    }
    //Space Complexity: O(n) — dono heaps milke total n elements store karte hain.
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */