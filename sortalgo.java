import java.util.Arrays;
import java.lang.Math;

public class sortalgo {
    public static void main(String[] args) {
        System.out.println("Sorting Algorythm benchmark");
        System.out.println("-------------------------");
        
        int arraySize = 20;
        int runs = 5;
        int j = 0;
        int max = 1000000;

        while(j < runs) {
            int[] initialArray = generateRandomArray(arraySize, max);
            System.out.println("Initial Array: " + Arrays.toString(initialArray));
            int[] sortedArray = insertionSort(initialArray);
            System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
            System.out.println("-------------------------");
            j++;
        }
    }
    public static int[] generateRandomArray(int size, int max) {
        int[] initialArray = new int[size];
        for (int i = 0; i < initialArray.length; i++) {
            initialArray[i] = (int) (Math.random() * max);
        }
        return initialArray;
    }

    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public static int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
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

//TODO: Cases?