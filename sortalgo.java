import java.util.Arrays;
import java.lang.Math;
import java.lang.reflect.Array;

public class sortalgo {
    public static void main(String[] args) {
        System.out.println("Sorting Algorythm benchmark");
        System.out.println("-------------------------");
        
        int arraySize = 15;
        int runs = 5;
        int j = 0;
        int max = 1000000;

        while(j < runs) {
            int[] initialArray = generateRandomArray(arraySize, max);
            System.out.println("Initial Array: " + Arrays.toString(initialArray));
            int[] sortedArray = bubbleSort(initialArray);
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
                    // swap temp and array[i]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}