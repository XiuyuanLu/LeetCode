package ojTest;

import java.util.ArrayList;
import java.util.List;

public class mnab {
	public void findList(int n,int m){
		List<String> irreducible = new ArrayList<String>();
		List<String> reducible = new ArrayList<String>();
		
		for(int i=1;i<m;i++)
		{
			for(int j=m;j<=n;j++)
			{
				if(gcd(i,j)==1){
					irreducible.add(i+"/"+j);
				}else{
					int g = gcd(j,i);
					reducible.add(i+"/"+j);
				}
			}
		}
		System.out.println("Irreducible:");
		for(String s:irreducible)
		{
			System.out.println(s);
		}
		System.out.println("Reducible:");
		for(String s:reducible)
		{
			System.out.println(s);
		}
	}
	public int gcd(int a,int b){
		int gcd = b;
		int t = a;
		while(t>0)
		{
			int temp = gcd%t;
			gcd = t;
			t = temp;
		}
		return gcd;
	}
	public static void main(String args[]){
		int m = 10;
		int n = 5;
		mnab o = new mnab();
		o.findList(m, n);
		
	}
}
