import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        //int[] arr = { 2, 4, 3, 1, 6, 8, 5, 9, 12, 13 };
        int[] arr = new int[10000000];
        int i =0;
        while(i<10000000)
        {
            arr[i] = (int)(Math.random()*1000000);
            i++;
        }
        long timeA = System.currentTimeMillis();
        
        //System.out.println(Math.random()*100000);
        //System.out.println(Arrays.toString(arr));
        //long i = Math.round(5.0d/2.0d);
        //System.out.println(i);
        // Search element
        System.out.println(searchArray(arr, 245463643));

        long timeB = System.currentTimeMillis();
        System.out.println("Elapsed Linear Search time: " + (timeB - timeA));

        // Sort
        sort("merge", arr);
        //System.out.println(Arrays.toString(sort("merge", arr)));
        long timeC = System.currentTimeMillis();
        System.out.println("Elapsed Sort time: " + (timeC - timeB));

        // Binary search on sorted array
        System.out.println(binarySearch(arr, 245463643));
        long timeD = System.currentTimeMillis();
        // For binary search we need sorted array so including sorting time as well
        System.out.println("Elapsed Binary Search(including sort) time: " + (timeD - timeB));

        // Remove element in the sorted array and shift other elements - Naive
        //System.out.println(Arrays.toString(removeArray(arr, 8)));

        // Add element in sorted array and shift other elements - Naive
        //System.out.println(Arrays.toString(addArray(arr, 7)));
    }

    private static String binarySearch(int[] arr, int i) {
        int startPos = 0;
        int endPos = arr.length - 1;
        while (startPos <= endPos) {
            int midPos = (endPos + startPos) / 2;
            if (arr[midPos] == i)
                return "Found";
            else if (i < arr[midPos])
                endPos = midPos - 1;
            else if (i > arr[midPos])
                startPos = midPos + 1;
        }
        return "Not Found";
    }

    private static int[] sort(String sortName, int[] arr) {
        switch (sortName) {
            case "selection":
                sortSelection(arr);
                break;

            case "bubble":
                sortBubble(arr);
                break;

            case "merge":
                sortMerge(arr);
                break;

            default:
                break;
        }

        return arr;
    }

    private static int[] sortMerge(int[] arr) {
        int arrLength = arr.length;
        if (arrLength == 1)
            return arr;
        int half = arrLength/ 2;
        int left[] = new int[half];
        int right[] = new int[arrLength - half];
        for (int i = 0; i < arrLength; i++) {
            if (i < half)
                left[i] = arr[i];
            else
                right[i - half] = arr[i];
        }
        //System.out.println("Divide");
        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));
        left = sortMerge(left);
        right = sortMerge(right);
        merge(left, right, arr);
        return arr;
    }

    private static void merge(int left[], int right[], int res[]) {
        for (int i = 0, j = 0, k = 0; k < (left.length + right.length); k++) {
            if (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    res[k] = left[i];
                    i++;
                } else if (left[i] > right[j]) {
                    res[k] = right[j];
                    j++;
                }
            } else if(j < right.length){
                res[k] = right[j];
                j++;
            } else if(i < left.length){
                res[k] = left[i];
                i++;
            }
        }
        //System.out.println("Merge");
        //System.out.println(Arrays.toString(res));
    }

    private static int[] removeArray(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                for (int j = i; j < arr.length - 1; j++)
                    arr[j] = arr[j + 1];
                break;
            }
        }
        return arr;
    }

    private static int[] addArray(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= element) {
                for (int j = arr.length - 1; j > i; j--)
                    arr[j] = arr[j - 1];
                arr[i] = element;
                break;
            }
        }
        return arr;
    }

    private static String searchArray(int[] arr, int element) {
        for (int i : arr) {
            if (i == element)
                return "Found";
        }
        return "Not Found";
    }

    private static int[] sortBubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapFlag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapFlag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!swapFlag)
                break;
        }
        return arr;
    }

    private static int[] sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
