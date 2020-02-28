
/**
 * Write a description of class Sort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Arrays;

public abstract class Sorter
{
    long comparisonCount;
    long moveCount;
    long extraSpaceCount;

    /**
     * Constructor for objects of class Sort
     */
    public Sorter()
    {
        reset();
    }
    
    public void reset() {
        comparisonCount = 0;
        moveCount = 0;
        extraSpaceCount = 0;
    }

    public String toString() {
        return " comparisonCount: " + comparisonCount + ", moveCount: " + moveCount + ", extraSpaceCount: " + extraSpaceCount;
    }

    public boolean less(int leftInt, int rightInt) {
        comparisonCount++;
        return (leftInt < rightInt);
    }
    
    public boolean lessEqual(int leftInt, int rightInt) {
        comparisonCount++;
        return (leftInt <= rightInt);
    }
    
    public void swap(int[] a, int index1, int index2) {
            moveCount += 3;
            int value = a[index1];
            a[index1] = a[index2];
            a[index2] = value;
    }
    
    public void move(int[] a, int leftIndex, int rightIndex) {
                moveCount++;
                a[leftIndex] = a[rightIndex];
    }

    public void moveValue(int[] a, int leftIndex, int value) {
                moveCount++;
                a[leftIndex] = value;
    }
    
    public int[] allocateTempArray(int length) {
        extraSpaceCount += length;
        return new int[length];
    }

    public int[] copyArray(int[] a) {
        extraSpaceCount += a.length;
        return Arrays.copyOf(a, a.length);
    }

    public abstract void sort(int[] a);
    
}
