package ojTest;

public class prime {
	public void goodprime(int n){
		int[] a = new int[n+1];
		for(int b = 0;b<n+1;b++)
			a[b] = 1;
		a[0] = 0;
		a[1] = 0;

		for(int i=2;i<=Math.sqrt(n);i++)
			if(a[i] == 1)
			for(int j=i;j<=n/i;j++)
				a[i*j] = 0;

		for(int i = 0;i<n;i++)
			if(a[i] == 1)System.out.println(i);
	}
	public void badPrime(int n){
		
	}
	public static void main(String args[]){
		int n = 10000000;
		prime p = new prime();
		p.goodprime(n);
	}
}
