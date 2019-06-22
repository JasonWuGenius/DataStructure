package SortAlgorithm;
/**
 * 归并排序
 */
public class MergeSort{
    public static int[] mergeSort(int[] a, int low, int high){
        int mid = (low+high)/2;
        if(low < high){
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
        return a;
    }
    
    public static void merge(int[] a, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }
            else{
                temp[k++] = a[j++];
            }
        }
        while(i<=mid){
            temp[k++] = a[i++]; 
        }
        while(j<=high){
            temp[k++] = a[j++];
        }
        for(int x=0; x<temp.length; x++){
            a[x+low] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1};
        System.out.println("The Array:");
        for(int item: a){
            System.out.print(item+" ");
        }
        int[] b = mergeSort(a, 0, a.length-1);
        System.out.println("\nThe Sorted Array:");
        for(int item: a){
            System.out.print(item+" ");
        }
        
    }

}