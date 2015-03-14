package ojTest;

import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle==null || triangle.get(0)==null)
		{
			return 0;
		}
		
		int n = triangle.size();
		int m = triangle.get(n-1).size();
		if(n==1){return triangle.get(0).get(0);}
		
		int dp[][] = new int[n][m];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			dp[i][j] = 0;
		
		dp[0][0] = triangle.get(0).get(0);
		for(int i=1;i<n;i++)
		{
			int i_size = triangle.get(i).size();
			for(int j=0;j<i_size;j++)
			{
				int temp = triangle.get(i).get(j);
				if(j==0){
					dp[i][j]= temp + dp[i-1][j];
				}else if(j==i_size-1){
					dp[i][j]= temp + dp[i-1][j-1];
				}else{
					dp[i][j]= temp + dp[i-1][j-1] < temp + dp[i-1][j]?
							temp + dp[i-1][j-1]:temp + dp[i-1][j];	
				}	
			}
		}
		int min = dp[n-1][0];
		for(int i=1;i<m;i++)
		{
			min = min<dp[n-1][i]?min:dp[n-1][i];
		}
		return min;
    }
	
	public static void main(String args[])
	{
		List<List<Integer>> triangle;
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				
			}
		}
	}
	
}
