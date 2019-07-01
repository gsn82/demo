public class BinarySearch {

    public static void main(String[] args) {
        final int[] items = {-1,2, 5 ,10, 11, 12, 14, 15, 24, 30, 45};
        System.out.println(binarySearch(items, 14));
    }

    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (key == a[middle]) return middle;

            if (key > a[middle]) {
                low = middle+1;
            } else {
                high = middle-1;
            }
        }
        return -1;
    }


}
