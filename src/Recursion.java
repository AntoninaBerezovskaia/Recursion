public class Recursion {

    public static void main(String[] args) {

        System.out.println("--------Unsorted array--------");
// storing random integers in an array
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
            System.out.print(array[i]+" ");
        }
        System.out.println("\n\n--------Sorted array----------");

        merge_sort(array);
        for (int i =0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
    private static void merge_sort(int[] array){

        int length = array.length;
// Base case. A list of zero or one elements is sorted, by definition.
        if (length <= 1) return;

// Recursive case. First, divide the list into equal-sized sublists
        int middle = length/2;

// consisting of the first half and second half of the list.
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

// This assumes lists start at index 0.
        int i = 0;
        int j = 0;

        for(; i < length; i++ ){
            if (i< middle){
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        // Recursively sort both sublists.
       merge_sort(leftArray);
       merge_sort(rightArray);

        // Then merge the now-sorted sublists.
       merge(leftArray,rightArray,array);

    }

    private static void merge( int [] leftArray, int[] rightArray, int[] array){
    int leftSize = array.length/2;
    int rightSize = array.length - leftSize;

    int i = 0;
    int l = 0;
    int r = 0;

    while (l<leftSize && r < rightSize){
        if(leftArray[l]<rightArray[r]){
            array[i] = leftArray[l];
            i++;
            l++;
        } else {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
    while (l < leftSize){
        array[i] = leftArray[l];
        i++;
        l++;
    }
    while (r < rightSize){
        array[i] =rightArray[r];
        i++;
        r++;
    }
    }
}