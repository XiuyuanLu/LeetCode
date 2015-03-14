package ojTest;

public class MaximumGap {
	
	public void qsort(int[] a,int low,int high){
		int location = 0;
		if(low<high){
			location = partition(a,low,high);
			qsort(a,low,location-1);
			qsort(a,location+1,high);
		}
	}
	
	public int partition(int[] a,int low, int high){
		int povit = a[low];
		while(low<high){
			while(low<high && povit<a[high])high--;
				a[low] = a[high];
			while(low<high && povit>=a[low])low++;
				a[high] = a[low];
			a[low] = povit;
		}
		return low;
	}
	
	public int maximumGap(int[] num) {
		qsort(num,0,num.length-1);
		int gap = 0;
		for(int i=1;i<num.length;i++)
		{
			gap = gap>num[i]-num[i-1]?gap:num[i]-num[i-1];
		}
		return gap;
    }
}
