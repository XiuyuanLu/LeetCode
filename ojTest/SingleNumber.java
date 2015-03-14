package ojTest;

public class SingleNumber {
	public static int singleNumber(int[] A) {
		if (A.length == 0)return 0;
        int r = A[0];
        for(int i=1;i<A.length;i++)
        	r^=A[i];
        return r;
    }
	public static int singleNumber2(int[] A){
		int[] x = new int[32];
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<32;j++)
			{
				x[j] += (A[i]>>j & 1);
				x[j] %= 3;
			}
		}
		int res = 0;
		for(int j=0;j<32;j++)
		{
			res += (x[j]<<j);
		}
		return res;
	}
	public static void main(String args[]){
		int[] a = {1,4,1,5,2,5,4,3,3};
		int t = singleNumber(a);
		
		System.out.println(t);
	}
}
