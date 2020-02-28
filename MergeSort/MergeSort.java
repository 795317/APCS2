
/**
 * Class MergeSort 
 *
 * @author (Nikhitha Nair)
 * @version (228)
 */
public class MergeSort
{
    public void sort(int[] arr){
        if(null == arr||arr.length == 0){
            return;
        }
        merge_sort(arr);
    }
    
    private void merge_sort(int[] arr){
        if(arr.length == 1){
            return;
        }
         int [] leftarr = new int[arr.length/2];
         System.arraycopy(arr, 0, leftarr, 0, leftarr.length);
         
         int[] rightarr = new int[arr.length - leftarr.length];
         System.arraycopy(arr,leftarr.length, rightarr, 0, rightarr.length);
         
         merge_sort(leftarr);
         
         merge_sort(rightarr);
         
         merge(leftarr, rightarr, arr);
         
        }
    
    private void merge(int[] left, int[] right, int [] arr){
        int [] tmpArray = new int [arr.length];
        int leftpos = 0;
        int rightpos = 0;
        int tmppos = 0;
        
        while(leftpos < left.length && rightpos < right.length){
            if(left[leftpos] < right[rightpos]){
                tmpArray[tmppos] = left[leftpos];
                leftpos++;
            }
            else{
                tmpArray[tmppos] = right[rightpos];
                rightpos++;
            }
            tmppos++;
        }
        
        while(leftpos < left.length){
            tmpArray[tmppos] = left[leftpos];
            tmppos++;
            leftpos++;
        }
        
        while(rightpos < right.length){
            tmpArray[tmppos] = right[rightpos];
            tmppos++;
            rightpos++;
        }
        
        for(int i =0; i < arr.length; i++){
            arr[i] = tmpArray[i];
        }
        
    }
    
    public static void main(String [] args){
        int [] intArr = new int [] {1, 3, 60, 10, 2, 7, 90, 100, 35};
        System.out.println("Before");
        System.out.println(" ");
        for(int val: intArr){
            System.out.println(val);
        }
        System.out.println(" ");
        MergeSort msort = new MergeSort();
        msort.sort(intArr);
        System.out.println("After");
        System.out.println(" ");
        for(int val: intArr){
            System.out.println(val);
        }
        
    }
        
        
}
