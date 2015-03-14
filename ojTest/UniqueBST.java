package ojTest;

public class UniqueBST {
	public static int numTrees(int n) {
        int sum[] = new int[n+1];
        sum[0]=1;
        for(int i=1;i<=n;i++)
        {
        	sum[i]=0;
        	if(i<3)sum[i]=i;
        	else{
	        	
	        	
	        	for(int j=1;j<=i;j++)
	        	{
	        		sum[i]+=sum[j-1]*sum[i-j];
	        	}
        	}
        }
        
        return sum[n];
    }
	public static void main(String args[]){
		System.out.println(numTrees(3));
	}
}
