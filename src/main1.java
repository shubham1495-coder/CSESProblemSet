import java.util.*;

final class MEXReducerMain {
    private TreeSet<Integer> treeSet;
    private Map<Integer, Integer> frequency;
    private List<Integer> arr;
    private List<int[]> operations;

    public MEXReducerMain(List<Integer> arr) {
        this.arr = new ArrayList<>(arr);
        this.treeSet = new TreeSet<>();
        this.frequency = new HashMap<>();
        this.operations = new ArrayList<>();

        for (int i = 0; i <= arr.size(); i++) {
            treeSet.add(i); // Potential MEX values
        }

        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            treeSet.remove(num);
        }
    }

    public int getMEX(int l, int r) {
        Set<Integer> tempSet = new HashSet<>();
        for (int i = l; i <= r; i++) {
            tempSet.add(arr.get(i));
        }
        int mex = 0;
        while (tempSet.contains(mex)) {
            mex++;
        }
        return mex;
    }

    public void applyMEXOperation(int l, int r) {
        int mexValue = getMEX(l, r);
        for (int i = l; i <= r; i++) {
            update(i, mexValue);
        }
        operations.add(new int[]{l, r});
    }

    public void update(int index, int newValue) {
        int old = arr.get(index);
        frequency.put(old, frequency.get(old) - 1);
        if (frequency.get(old) == 0) {
            treeSet.add(old);
        }
        arr.set(index, newValue);
        frequency.put(newValue, frequency.getOrDefault(newValue, 0) + 1);
        treeSet.remove(newValue);
    }

    public boolean isReduced() {
        return arr.size() == 1 && arr.get(0) == 0;
    }

    public int reduceArray() {
        int operationsCount = 0;
        while (arr.size() > 1) {
            int l = 0, r = arr.size() - 1;
            applyMEXOperation(l, r);
            operationsCount++;
            arr = arr.subList(0, Math.max(1, arr.size() - 1)); // Reduce size
        }
        return operationsCount;
    }

    public void printOperations() {
        for (int[] op : operations) {
            System.out.println((op[0]+1) + " " + (op[1]+1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            MEXReducerMain reducer = new MEXReducerMain(arr);
            int operations = reducer.reduceArray();
            System.out.println(operations);
            reducer.printOperations();
        }
    }
}
