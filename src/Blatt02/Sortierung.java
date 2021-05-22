package Blatt02;

public class Sortierung {

    //merge
    public static void mergeSort(int[] array) {
        int[] tmpArray = new int[array.length];
        mergeSort(array, tmpArray, 0, array.length-1);

        assert isSorted(array);
    }



    //sort
    public static void mergeSort(int[] array, int[] tmpArray, int left, int right){

    }

    private static void merge(int[] array, int[] tmpArray, int left, int middle, int right) {
        int l = left, r = middle + 1, i = l;

        //Wenn es in den beiden Teilfeld noch Elemente gibt, wird das kleinere in tmpArray gelegt
        while (l <= middle && r <= right) {
            if (array[l] <= array[r]) {
                tmpArray[i++] = array[l++];
            } else {
                tmpArray[i++] = array[r++];
            }
        }

        //Falls alle Elemente von dem linken Teilfeld fertig ausgenomen geworden sind, werden die restlichen Elemente von dem rechten Teilfeld direkt in tmpArray gelegt
        if (l > middle) {
            while (r <= right) {
                tmpArray[i++] = array[r++];
            }
        }

        //Falls alle Elemente von dem rechten Teilfeld fertig ausgenomen geworden sind, werden die restlichen Elemente von dem linken Teilfeld direkt in tmpArray gelegt
        if (r > right) {
            while (l <= middle) {
                tmpArray[i++] = array[l++];
            }
        }

        //Die schon sortierten Elementen werden in array zurück gelegt
        for (int n = left; n <= right; n++) {
            array[n] = tmpArray[n];
        }
    }



    //aufsteigend sortiert?
    public static boolean isSorted(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }









}
