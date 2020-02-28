
/**
 * Write a description of class SortRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.lang.reflect.*;

public class SortRunner
{
    static int[] lengthArray = { 10, 100, 1000, 10000 };
    static boolean printArrayFlag = false;
    static SortRunner sortRunner;

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

    static int[] columnIndexArray = {40, 50, 68, 86, 104, 122 };

    public static String advanceToColumnIndex(String string, int columnIndex) {
        while (string.length() < columnIndex) {
            string += " ";
        }
        return string;
    }

    public static void printHeader() {
        String resultString = "";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[0]);
        resultString += "length";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[1]);
        resultString += "comparisonCount";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[2]);
        resultString += "moveCount";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[3]);
        resultString += "extraSpaceCount";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[4]);
        //         resultString += "recursiveCall";
        //         resultString = advanceToColumnIndex(resultString, columnIndexArray[5]);
        resultString += "isSorted returns";
        System.out.println(resultString);
    }

    public static void printScaledResult(Sorter sorter, int[] a, String prefixString, double divisor) {
        String resultString = prefixString;
        resultString = advanceToColumnIndex(resultString, columnIndexArray[1]);
        resultString += String.format("%4.2f", (sorter.comparisonCount/divisor)) + ",";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[2]);
        resultString += String.format("%4.2f", (sorter.moveCount/divisor)) + ",";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[3]);
        resultString += String.format("%4.2f", (sorter.extraSpaceCount/divisor)) + ",";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[4]);
        //         resultString += sorter.recursiveCallCount;
        //         while (resultString.length() < columnIndexArray[5]) {
        //             resultString += " ";
        //         }
        resultString += isSorted(a);
        System.out.println(resultString);
    }

    public static void printResult(Sorter sorter, int[] a, String prefixString) {
        String resultString = prefixString;
        resultString = advanceToColumnIndex(resultString, columnIndexArray[0]);
        resultString += a.length + ",";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[1]);
        resultString += sorter.comparisonCount + ",";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[2]);
        resultString += sorter.moveCount + ",";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[3]);
        resultString += sorter.extraSpaceCount + ",";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[4]);
        //         resultString += sorter.recursiveCallCount;
        //         while (resultString.length() < columnIndexArray[5]) {
        //             resultString += " ";
        //         }
        resultString += isSorted(a);
        System.out.println(resultString);
    }

    static String[] statNameArray = { "comparisons", "moves", "extraSpace", "elapsed time" };
    static String[] arrayNameArray = { "Sorted array", "Reverse sorted array", "Random array" };
    static final int COMPARISON_STAT_ID = 0;
    static final int MOVE_STAT_ID = 1;
    static final int EXTRA_SPACE_STAT_ID = 2;
    static final int ELAPSED_TIME_STAT_ID = 3;

    public static final int SORTED_ARRAY_INDEX = 0;
    public static final int REVERSE_SORTED_ARRAY_INDEX = 1;
    public static final int RANDOM_ARRAY_INDEX = 2;
    public static final int MAX_ARRAY_INDEX = 3;

    public static void printOneStatistic(Sorter[][] outerSorterArray, int statId, String name) {
        if (outerSorterArray[0] == null) {
            return; // runStandardSorts not executed for this outerSorterArray 
        }
        System.out.println();
        System.out.println(name + " " + statNameArray[statId] + " = c");
        String resultString = advanceToColumnIndex("", columnIndexArray[0]);
        resultString += "length";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[1]);
        resultString += "c";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[2]);
        resultString += "c/length";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[3]);
        resultString += "c/length^2";
        resultString = advanceToColumnIndex(resultString, columnIndexArray[4]);
        resultString += "c/(length*log(length))";
        System.out.println(resultString);
        for (int innerIndex = SORTED_ARRAY_INDEX; innerIndex <= RANDOM_ARRAY_INDEX; innerIndex++) {
            for (int outerIndex = 0; outerIndex < lengthArray.length; outerIndex++) {
                Sorter[] innerSorterArray = outerSorterArray[outerIndex];
                Sorter sorter = innerSorterArray[innerIndex];
                resultString = name + " - " + arrayNameArray[innerIndex];
                resultString = advanceToColumnIndex(resultString, columnIndexArray[0]);
                resultString += sorter.arrayLength + ",";
                long longStat = 0;
                double arrayLength = sorter.arrayLength;
                switch (statId) {
                    case COMPARISON_STAT_ID:
                    longStat = sorter.comparisonCount;
                    break;
                    case MOVE_STAT_ID:
                    longStat = sorter.moveCount;
                    break;
                    case EXTRA_SPACE_STAT_ID:
                    longStat = sorter.extraSpaceCount;
                    break;
                    case ELAPSED_TIME_STAT_ID:
                    longStat = sorter.elapsedNanoTime;
                    break;
                }
                resultString = advanceToColumnIndex(resultString, columnIndexArray[1]);
                resultString += longStat;
                resultString = advanceToColumnIndex(resultString, columnIndexArray[2]);
                resultString += String.format("%4.2f", ((double)longStat/arrayLength)) + ",";
                resultString = advanceToColumnIndex(resultString, columnIndexArray[3]);
                resultString += String.format("%4.2f", ((double)longStat/(arrayLength*arrayLength))) + ",";
                resultString = advanceToColumnIndex(resultString, columnIndexArray[4]);
                double nLogN = arrayLength*Math.log(arrayLength);
                resultString += String.format("%4.2f", ((double)longStat/(arrayLength*Math.log(arrayLength))));
                System.out.println(resultString);

            }

        }
    }

    public static void runOneSort(Sorter sorter, int[] a, String prefixString) {
        sorter.reset(a);
        if (printArrayFlag) {
            System.out.println(prefixString + " - pre sort");
            printArray(a);
        }
        sorter.sort(a);
        sorter.done();
        if (printArrayFlag) {        
            System.out.println(prefixString + "  - post sort");
            printArray(a);
        }
        //         printResult(sorter, a, prefixString);
        //         printScaledResult(sorter, a, "        / length", a.length);
        //         printScaledResult(sorter, a, "        / length^2", a.length*a.length);
        //         printScaledResult(sorter, a, "        / length*log(length)", a.length*Math.log(a.length));
        //         System.out.println(prefixString + "\tlength: " + a.length + ",\tisSorted returns " + isSorted(a));
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

    public static Sorter[] runStandardSorts(Sorter sorter, int length, String name) {
        Sorter[] resultSorterArray = new Sorter[MAX_ARRAY_INDEX];        
        runOneSort(sorter, createSortedArray(length), name + " - " + arrayNameArray[SORTED_ARRAY_INDEX]);
        resultSorterArray[SORTED_ARRAY_INDEX] = sorter.clone();
        runOneSort(sorter, createReverseSortedArray(length), name + " - " + arrayNameArray[REVERSE_SORTED_ARRAY_INDEX]); 
        resultSorterArray[REVERSE_SORTED_ARRAY_INDEX] = sorter.clone();
        runOneSort(sorter, createRandomSortedArray(length), name + " - " + arrayNameArray[RANDOM_ARRAY_INDEX]); 
        resultSorterArray[RANDOM_ARRAY_INDEX] = sorter.clone();
        return resultSorterArray;
    }

    public static void printStandardResults(Sorter[][] outerSorterArray, String name) {
        printOneStatistic(outerSorterArray, COMPARISON_STAT_ID, name);
        printOneStatistic(outerSorterArray, MOVE_STAT_ID, name);
        printOneStatistic(outerSorterArray, EXTRA_SPACE_STAT_ID, name);
        //        printOneStatistic(outerSorterArray, ELAPSED_TIME_STAT_ID, name);
    }

    public static Sorter createSorterObject(String className) {
        Class sorterRunnerClass = sortRunner.getClass();
        ClassLoader classLoader = sorterRunnerClass.getClassLoader();
        try {
            Class sorterClass1 = classLoader.loadClass(className);
            Constructor sorterConstructor = sorterClass1.getConstructor();
            Sorter sorter = (Sorter)(sorterConstructor.newInstance());
            return sorter;
        }
        catch (ClassNotFoundException e) {
            System.out.println(e);
            return null;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public static void main() {
        sortRunner = new SortRunner();
        //         printHeader();
        Sorter[][] selectionSorterArray = new Sorter[lengthArray.length][];
        Sorter[][] insertionSorterArray = new Sorter[lengthArray.length][];
        Sorter[][] mergeSorterArray = new Sorter[lengthArray.length][];
        Sorter[][] quickSorterArray = new Sorter[lengthArray.length][];
        Sorter[][] heapSorterArray = new Sorter[lengthArray.length][];
        for (int lengthIndex = 0; lengthIndex < lengthArray.length; lengthIndex++) {
            int length = lengthArray[lengthIndex];
            SelectionSorter selectionSorter = new SelectionSorter();
            selectionSorterArray[lengthIndex] = runStandardSorts(selectionSorter, length, "Selection sort");
            Sorter insertionSorter = createSorterObject("InsertionSorter");
            if (insertionSorter != null) {
                insertionSorterArray[lengthIndex] = runStandardSorts(insertionSorter, length, "Insertion sort");
            }
            Sorter mergeSorter = createSorterObject("MergeSorter");
            if (mergeSorter != null) {
                mergeSorterArray[lengthIndex] = runStandardSorts(mergeSorter, length, "Merge sort");
            }
            Sorter heapSorter = createSorterObject("HeapSorter");
            if (heapSorter != null) {
                heapSorterArray[lengthIndex] = runStandardSorts(heapSorter, length, "Heap sort");
            }
            Sorter quickSorter = createSorterObject("QuickSorter");
            if (quickSorter != null) {
                quickSorterArray[lengthIndex] = runStandardSorts(quickSorter, length, "Quick sort");
            }
        }
        printStandardResults(selectionSorterArray, "Selection sort");
        printStandardResults(insertionSorterArray, "Insertion sort");
        printStandardResults(mergeSorterArray, "Merge sort");
        printStandardResults(heapSorterArray, "Heap sort");
        printStandardResults(quickSorterArray, "Quick sort");    
    }
}
