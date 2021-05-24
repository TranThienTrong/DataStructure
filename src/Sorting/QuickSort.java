package Sorting;

public class QuickSort {

    static int[] quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    private static void quickSortHelper(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivot = startIndex;
        int left = pivot + 1;
        int right = endIndex;

        while (right >= left) {
            if (array[left] > array[pivot] && array[right] < array[pivot]) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

            if (array[left] <= array[pivot]) {
                left++;
            }

            if (array[right] >= array[pivot]) {
                right--;
            }
        }

        int temp = array[pivot];
        array[pivot] = array[right];
        array[right] = temp;

        // Now the Right Index Is Pivot So:
        int newRightOfLeftSide = right-1;
        int newLeftOfRightSide = right+1;
        int leftSubArray = newRightOfLeftSide - startIndex;
        int rightSubArray = endIndex - newLeftOfRightSide;


        if (leftSubArray < rightSubArray){
            quickSortHelper(array, startIndex, newRightOfLeftSide);
            quickSortHelper(array, newLeftOfRightSide, endIndex);
        } else {
            quickSortHelper(array, newLeftOfRightSide, endIndex);
            quickSortHelper(array, startIndex, newRightOfLeftSide);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 5, 4};
        quickSort(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
