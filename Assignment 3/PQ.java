public class PQ {
    public class Pair<String, Integer> {
        private String s;
        private int val;

        Pair(String str, int value) {
            this.s = str;
            this.val = value;
        }
    }

    public int n;
    public Pair<String, Integer>[] arr;

    public PQ() {
        this(1);
    }

    public PQ(int initCapacity) {
        arr = new Pair[initCapacity + 1];
        n = 0;
    }

    public int top() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return arr[1].val;
    }

    public void insert(String x, int weight) {
        if (n == arr.length - 1) {
            resize(arr.length * 2);
        }
        arr[++n] = new Pair<String, Integer>(x, weight);
        rise(n);
    }

    public void remove() {
        if (isEmpty()) {
            return;
        }

        swap(1, n--);
        fall(1);

        arr[n + 1] = null;

        if (n > 0 && n == (arr.length - 1) / 4) {
            resize(arr.length / 2);
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private void rise(int k) {
        while (k > 1 && isGreater(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void fall(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && isGreater(j, j + 1)) {
                j++;
            }
            if (!isGreater(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void resize(int capacity) {
        Pair[] temp = new Pair[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    private boolean isGreater(int a, int b) {
        return arr[a].val > arr[b].val;
    }

    private void swap(int a, int b) {
        Pair temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
