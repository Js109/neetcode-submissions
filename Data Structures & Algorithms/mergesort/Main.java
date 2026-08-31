package mergesort;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {9, 2, 7, 1, 5, 8, 3, 6, 4};

        System.out.println("Unsorted:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("Sorted:");
        printArray(numbers);
    }

    private static void mergeSort(int[] arr) {
        int length = arr.length;

        if(length < 2) {
            return;
        }

        int mid = length / 2;

        // new arrays for left and right half
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];

        for(int i =0; i<mid; i++) {
            leftArray[i] = arr[i];
        }
        for(int i = 0; i<length - mid; i++) {
            rightArray[i] = arr[i + mid];
        }

        // sort recurisively the left and right halves
        mergeSort(leftArray);
        mergeSort(rightArray);

        // merge the sorted halves (put together)
        merge(arr, leftArray, rightArray);
    }

    //
    private static void merge(int[] arr, int[] leftArray, int[] rightArray) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int i = 0; // pointer for leftArray
        int j = 0; // pointer for rightArray
        int k = 0; // pointer for main array

        // compare and write smaller element to main array
        while(i<leftSize && j < rightSize) {
            if(leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // last elements from leftArray
        while(i< leftSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // last elements from rightArray
        while(j< rightSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
