package quicksort;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {9, 2, 7, 1, 5, 8, 3, 6, 4};

        System.out.println("Unsorted:");
        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("Sorted:");
        printArray(numbers);
    }

    private static void quickSort(int[] numbers, int low, int high) {
        // if two elements to sort, then partition the array and sort the two halves
        if(low  < high) {
            // sort the pivot and find out its final position
            int pivotIndex = partition(numbers, low, high);

            // sort left half
            quickSort(numbers, low, pivotIndex - 1);

            // sort right half
            quickSort(numbers, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] numbers, int low, int high) {
        int pivot = numbers[high];
        int i = low - 1;

        for(int j = low; j < high; j++) {
            if(numbers[j] <= pivot) {
                i++;
                swap(numbers, i, j);
            }
        }
        swap(numbers, i+1, high);
        return i+1;
    }

    // swaps exactly two elements in the array
    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
