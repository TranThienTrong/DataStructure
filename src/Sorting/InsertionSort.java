package Sorting;

public class InsertionSort {

    static int[] insertionSort(int[] array) {
        for (int pivot = 1; pivot < array.length; pivot++) {
            for (int i = 0; i < pivot; i++) {
                if (array[pivot] < array[i]) {
                    int temp = array[i];
                    array[i] = array[pivot];
                    array[pivot] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,5,4};
        insertionSort(array);

        for (int i:array){
            System.out.print(i+" ");
        }
    }
}
