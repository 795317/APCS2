 


/**
 * Write a description of class Sort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

 
import java.util.Arrays;

public abstract class Sorter implements Cloneable
{
    public long comparisonCount;
    public long moveCount;
    public long extraSpaceCount;
    public long startingNanoTime;
    public long elapsedNanoTime;
//    public long recursiveCallCount;
    public int arrayLength;

    /**
     * Constructor for objects of class Sort
     */
    public Sorter()
    {
        reset(null);
    }
    
    public Sorter clone() {
        try {
        return (Sorter)super.clone();
    }
        catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    
    public void reset(int[] a) {
        comparisonCount = 0;
        moveCount = 0;
        extraSpaceCount = 0;
        startingNanoTime = System.nanoTime();
//        recursiveCallCount = 0;
        if (a != null) {
            arrayLength = a.length;
        }
    }
    
    public void done() {
        elapsedNanoTime = System.nanoTime() - startingNanoTime;
    }

    public String toString() {
        return " comparisonCount: " + comparisonCount + ",\tmoveCount: " + moveCount + ",\textraSpaceCount: " + extraSpaceCount;
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
    
    public void move(int[] a, int destIndex, int sourceIndex) {
                moveCount++;
                a[destIndex] = a[sourceIndex];
    }

    public void moveValue(int[] a, int destIndex, int value) {
                moveCount++;
                a[destIndex] = value;
    }
    
    public int[] allocateTempArray(int length) {
        extraSpaceCount += length;
        return new int[length];
    }

    public int[] copyArray(int[] a) {
        extraSpaceCount += a.length;
        return Arrays.copyOf(a, a.length);
    }
    
//    public void recursiveCall() {
//        recursiveCallCount++;
//    }

    public abstract void sort(int[] a);
    
}
