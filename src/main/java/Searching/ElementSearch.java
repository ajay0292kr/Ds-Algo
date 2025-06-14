package Searching;

public class ElementSearch {
    public static int countOccurrences(int[] arr, int x) {
        int first = findFirstOccurrence(arr, x);
        int last = findLastOccurrence(arr, x);

        // If the element is not found, return 0
        if (first == -1 || last == -1) {
            return 0;
        }
        return last - first + 1;
    }

    private static int findLastOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                result = mid;
                low = mid + 1; // Move right to find the last occurrence
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static int findFirstOccurrence(int[] arr, int x) {
        int l = 0, r = arr.length-1;
        int result = -1;
        while (l <=r) {
            int mid = l + (r - l)/2;
            if(arr[mid] == x) {
                result = mid;
                r = mid - 1;
            }
            else if (arr[mid] < x) {
                l = mid+1;
            }else {
                r = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int x = 2;
        System.out.println("The number " + x + " appears " + countOccurrences(arr, x) + " times.");
    }
}
