package ojTest;

public class SortColor {
	public static void sortColors(int[] A) {
        qsort(A,0,A.length-1);
    }
	
	public static void qsort(int[] a,int low,int high){
        int location = 0;
        if(low<high){
        	location = partition(a,low,high);
        	qsort(a,low,location-1);
        	qsort(a,location+1,high);
        }
	}
	
	public static int partition(int[] a,int low, int high){
		int povit = a[low];
		while(low<high){
			while(povit<a[high] && low<high)high--;
			a[low] = a[high];
			while(povit>=a[low] && low<high)low++;
			a[high] = a[low];
		}
		a[low] = povit;
		return low;
	}
	
	public static void main(String[] args) {
		int a[] = {3,1,3,5,6,7,5,4};
		sortColors(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	
}
