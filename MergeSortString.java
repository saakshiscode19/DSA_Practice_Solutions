public class MergeSortString {
    // Merge sort function
    public static String[] mergeSort(String[] arr, int lo, int hi) {
        if (lo == hi) {
            return new String[]{arr[lo]};
        }

        int mid = lo + (hi - lo) / 2;
        String[] left = mergeSort(arr, lo, mid);
        String[] right = mergeSort(arr, mid + 1, hi);

        return merge(left, right);
    }

    // Merge two sorted arrays
    static String[] merge(String[] arr1, String[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        String[] merged = new String[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (isAlphabeticallySmaller(arr1[i], arr2[j])) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        // Add remaining elements
        while (i < m) {
            merged[k++] = arr1[i++];
        }
        while (j < n) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    // Helper to compare two strings
    static boolean isAlphabeticallySmaller(String str1, String str2) {
        return str1.compareTo(str2) < 0;
    }

    // Main function
    public static void main(String[] args) {
        String[] arr = { "sun", "earth", "mars", "mercury" };

        String[] sortedArr = mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (String word : sortedArr) {
            System.out.println(word);
        }
    }
}
