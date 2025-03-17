public class problemm1095 {

    // Find peak index first
    public static int findPeakIndexOfMountainArray(int arr[]) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid; // Peak is on the left
            } else {
                start = mid + 1; // Peak is on the right
            }
        }
        return end; // or start, they will be equal here
    }

    // Search method for mountain array
    public static int search(int arr[], int target) {
        // Find peak index
        int peakIndex = findPeakIndexOfMountainArray(arr);

        // Search in the ascending part (from 0 to peak)
        int result = binarySearchAscending(arr, 0, peakIndex, target);
        if (result != -1) {
            return result;  // Target found in the ascending part
        }

        // Search in the descending part (from peak + 1 to end)
        return binarySearchDescending(arr, peakIndex + 1, arr.length - 1, target);
    }

    // Binary search for the ascending part
    public static int binarySearchAscending(int arr[], int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                System.out.println("Target found in ascending part");
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;  // Search right
            } else {
                end = mid - 1;    // Search left
            }
        }
        return -1;  // Target not found in ascending part
    }

    // Binary search for the descending part
    public static int binarySearchDescending(int arr[], int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                System.out.println("Target found in descending part");
                return mid;
            }
            if (arr[mid] > target) {
                start = mid + 1;  // Search right
            } else {
                end = mid - 1;    // Search left
            }
        }
        System.out.println("Target not found");
        return -1;  // Target not found in descending part
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 8, 12, 4, 2};
        int target = 4;
        int result = search(arr, target);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array");
        }
    }
}

