import java.util.Arrays;
import java.lang.Math;

//MARK: Main
public class sortalgo {

    static long[] sortTimeTotal;
    static long[] bubbleSortTime;
    static long[] selectionSortTime;
    static long[] insertionSortTime;
    static long[] quickSortTime;
    public static void main(String[] args) {
        System.out.println("Sorting Algorythm benchmark");
        System.out.println("--------------------------------------------------------");
        System.out.println("--------------------------------------------------------");
        
        // Change Arraysize
        int arraySize = 100;
        // Change amount of Runs
        int runs = 3;
        int j = 0;
        int max = 10000;

        bubbleSortTime = new long[runs];
        selectionSortTime = new long[runs];
        insertionSortTime = new long[runs];
        quickSortTime = new long[runs];

        while(j < runs) {
            int[] initialArray = generateRandomArray(arraySize, max);
            System.out.println("Initial Array: " + Arrays.toString(initialArray));
            // Change to bubbleSort, selectionSort, insertionSort, quickSort
            int[] sortedArray = bubbleSort(initialArray, j);
            System.out.println("--------------------------------------------------------");
            System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
            // Change to bubbleSort, selectionSort, insertionSort, quickSort
            System.out.println("Sortalgo time: " + bubbleSortTime[j] + " nanoseconds");
            System.out.println("--------------------------------------------------------");
            System.out.println("--------------------------------------------------------");
            j++;
// Remove for static Array length
            max = max * 10;
        }

        //Average of all runs
        long sum = 0;
        // Change to bubbleSort, selectionSort, insertionSort, quickSort
        for (long time : bubbleSortTime) {
            sum += time;
        }
        double averageTime = sum / (double) runs;
        System.out.println("Average Sort time: " + averageTime + " nanoseconds");
    }
    public static int[] generateRandomArray(int size, int max) {
        int[] initialArray = new int[size];
        for (int i = 0; i < initialArray.length; i++) {
            initialArray[i] = (int) (Math.random() * max);
        }
        return initialArray;
    }

// MARK: bubbleSort
public static int[] bubbleSort(int[] array, int runIndex) {
    int[] arrayCopy = Arrays.copyOf(array, array.length);
    long tsBubble = System.nanoTime();
    int n = arrayCopy.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arrayCopy[j] > arrayCopy[j + 1]) {
                int temp = arrayCopy[j];
                arrayCopy[j] = arrayCopy[j + 1];
                arrayCopy[j + 1] = temp;
            }
        }
    }
    long teBubble = System.nanoTime();
    long bubbleSortTimeDuration = teBubble - tsBubble;
    sortalgo.bubbleSortTime[runIndex] = bubbleSortTimeDuration;

    return arrayCopy;
}

//MARK: selectionSort
public static int[] selectionSort(int[] array, int runIndex) {
    int[] arrayCopy = Arrays.copyOf(array, array.length);
    long tsSelection = System.nanoTime();
    int n = arrayCopy.length;
    for (int i = 0; i < n - 1; i++) {
        int min_idx = i;
        for (int j = i + 1; j < n; j++) {
            if (arrayCopy[j] < arrayCopy[min_idx]) {
                min_idx = j;
            }
        }
        int temp = arrayCopy[min_idx];
        arrayCopy[min_idx] = arrayCopy[i];
        arrayCopy[i] = temp;
    }
    long teSelection = System.nanoTime();
    long selectionSortTime = teSelection - tsSelection;
    sortalgo.selectionSortTime[runIndex] = selectionSortTime;

    return arrayCopy;
}
//MARK: insertionSort
public static int[] insertionSort(int[] array, int runIndex) {
    int[] arrayCopy = Arrays.copyOf(array, array.length);
    long tsInsertion = System.nanoTime();
    int n = arrayCopy.length;
    for (int i = 1; i < n; i++) {
        int key = arrayCopy[i];
        int j = i - 1;
        while (j >= 0 && arrayCopy[j] > key) {
            arrayCopy[j + 1] = arrayCopy[j];
            j--;
        }
        arrayCopy[j + 1] = key;
    }
    long teInsertion = System.nanoTime();
    long insertionSortTime = teInsertion - tsInsertion;
    sortalgo.insertionSortTime[runIndex] = insertionSortTime;

    return arrayCopy;
}
// MARK: quickSort
public static int[] quickSort(int[] arr, int runIndex) {
    int[] arrayCopy = Arrays.copyOf(arr, arr.length);
    long tsQuick = System.nanoTime();
    quickSort(arrayCopy, 0, arrayCopy.length - 1);
    long teQuick = System.nanoTime();
    long quickSortTime = teQuick - tsQuick;
    sortalgo.quickSortTime[runIndex] = quickSortTime;

    return arrayCopy;
}

private static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
}

}