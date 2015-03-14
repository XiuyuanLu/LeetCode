package ojTest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MajorityNum {
	public int majorityElement(int[] num) {
        int candidate = 0;
        int counter = 0;
        for(int i=0;i<num.length;i++)
        {
        	if(counter==0)
        	{
        		candidate = num[i];
        		counter++;
        	}
        	else{
        		if(num[i]==candidate)counter++;
        		else counter--;
        	}
        }
        
		return candidate;
//		Arrays.sort(num,0,num.length);
//		return num[num.length/2];
    }
	public static void main(String args[]){
		int num[] = {1};
		System.out.println(new MajorityNum().majorityElement(num));
	}
}
