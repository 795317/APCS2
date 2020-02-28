
/**
 * Write a description of class SortRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SortRunner
{
    static int[] lengthArray = {
        10, 100, 1000, 10000, 
        100000 };
    static boolean printArrayFlag = false;

    public static boolean isSorted(int[] a) {
        for (int index = 1; index < a.length; index++) {
            if (a[index] < a[index-1])
                return false;
        }
        return true;
    }

    public static void printArray(int[] a) {
        System.out.print("[");
        for (int index = 0; index < a.length; index++) {
            System.out.print(" " + a[index] + " ");
        }
        System.out.println("]");
    }

    public static void runOneSort(Sorter sorter, int[] a, String prefixString) {
        sorter.reset();
        if (printArrayFlag) {
            System.out.println(prefixString + " - pre sort");
            printArray(a);
        }
        sorter.sort(a);
        if (printArrayFlag) {        
            System.out.println(prefixString + "  - post sort");
            printArray(a);
        }
        System.out.println(prefixString + "\tstats for length: " + a.length + " - " + sorter + ", isSorted returns " + isSorted(a));
    }

    public static int[] createSortedArray(int length) {
        int[] resultArray = new int[length];
        for (int index = 0; index < length; index++) 
            resultArray[index] = index + 1;
        return resultArray;
    }

    public static int[] createReverseSortedArray(int length) {
        int[] resultArray = new int[length];
        for (int index = 0; index < length; index++) 
            resultArray[index] = length - index;
        return resultArray;
    }

    public static int[] createRandomSortedArray(int length) {
        int[] resultArray = new int[length];
        for (int index = 0; index < length; index++) 
            resultArray[index] = (int)(Math.random() * length);
        return resultArray;
    }

    public static void runStandardSorts(Sorter sorter, int length, String name) {
        runOneSort(sorter, createSortedArray(length), name + " - Sorted array\t");
        runOneSort(sorter, createReverseSortedArray(length), name + " - Reverse sorted array"); 
        runOneSort(sorter, createRandomSortedArray(length), name + " - Random sorted array"); 
    }

    public static void main() {
        for (int lengthIndex = 0; lengthIndex < lengthArray.length; lengthIndex++) {
            int length = lengthArray[lengthIndex];
            SelectionSorter selectionSorter = new SelectionSorter();
            runStandardSorts(selectionSorter, length, "Selection sort");
            InsertionSorter insertionSorter = new InsertionSorter();
            runStandardSorts(insertionSorter, length, "Insertion sort");
//             HeapSorter heapSorter = new HeapSorter();
//             runStandardSorts(heapSorter, length, "Heap sort");
//             QuickSorter quickSorter = new QuickSorter();
//             runStandardSorts(quickSorter, length, "Quick sort");
            MergeSorter mergeSorter = new MergeSorter();
            runStandardSorts(mergeSorter, length, "Merge sort");
        }
    }
}
