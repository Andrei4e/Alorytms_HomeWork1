import java.util.Date;

public class Main {

    public static void main(String[] args) {
        int[] array = {54, 24, 48, 18, 93, 4, 10};
        PrintArray(array, "Исходный массив: ");
        HeapSort(array);
    }

    public static void HeapSort(int[] array) {
        int len = array.length;
        for (int i = len/2 - 1; i >= 0; i --)
            Heap(array, i , len);

        for (int i = len - 1; i >= 0; i--){
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;

            Heap(array, 0, i);
        }

        PrintArray(array, "Отсортированный массив: ");
    }

    public static void Heap(int[] array, int i, int len) {
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        int maxIndex = i;

        if (leftChild < len && array[leftChild] > array[maxIndex])
            maxIndex = leftChild;

        if (rightChild < len && array[rightChild] > array[maxIndex])
            maxIndex = rightChild;

        if (i != maxIndex){
            int tmp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = tmp;
            Heap(array, maxIndex, len);
        }
    }    

    public static void PrintArray(int[] array, String string) {
        System.out.print(string);
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println(";");
    }
}