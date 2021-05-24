package Sorting;

public class SelectionSort {

    static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length-1; i++) {
            int smallestIndex = i;

            for (int j = i+1; j<array.length;j++){
                if (array[j]<array[smallestIndex]){
                    smallestIndex=j;
                }
            }

            int temp = array[smallestIndex];
            array[smallestIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 5, 4};
        selectionSort(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
