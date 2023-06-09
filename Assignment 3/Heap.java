import java.util.Arrays;

public class Heap {
    private int[] arr;
    private int n;

    public Heap(int initCapacity) {
        this.arr = new int[initCapacity + 1];
        arr[0] = Integer.MIN_VALUE;
    }

    public int top() {
        if (n == 0) {
            return Integer.MIN_VALUE; // to mark error
        }

        return arr[1];
    }

    public void insert(int x) {
        if (n == arr.length - 1) {
            this.arr = Arrays.copyOf(arr, 2 * arr.length); // resize array
        }
        arr[++n] = x;
        int cur = n;
        while (arr[cur] < arr[parent(cur)]) {
            swap(cur, parent(cur));
            cur = parent(cur);
        }
    }

    public void remove() {
        arr[1] = arr[n--];
        minHeapify(1);
    }

    // helper functions
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > (arr.length / 2)) {
            return true;
        }

        return false;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            int swapP = pos;
            if (rightChild(pos) <= arr.length) {
                swapP = arr[leftChild(pos)] < arr[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
            } else {
                swapP = leftChild(pos);
            }

            if (arr[pos] > arr[leftChild(pos)] || arr[pos] > arr[rightChild(pos)]) {
                swap(pos, swapP);
                minHeapify(swapP);
            }
        }
    }
}
