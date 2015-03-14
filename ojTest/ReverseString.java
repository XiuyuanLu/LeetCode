package ojTest;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseString {
	public String reverseWords(String s) {
        int start = 0;
        int end = 0;
     
        char[] newString = s.toCharArray();
        //ArrayList ss = new ArrayList();
        //char[] snew = s.toCharArray();
        for(int i=0;i<s.length();i++)
        {
        	end = i;
        	char current = s.charAt(i);
        	if(current == ' ' && i!= s.length()-1){
        		for(int j = start;j<end;j++)
        		{
        			int k = j-start;
        			newString[s.length()-i+k] = s.charAt(j);
        		}
        		newString[s.length()-i-1] = ' ';
            
        		start = i+1;
        	}else if(i==s.length()-1)
        	{
        		for(int j = start;j<=end;j++)
        		{
        			int k = j-start;
        			newString[s.length()-i+k-1] = s.charAt(j);
        		}
        	}
        	
        }

        String result = new String(newString);
        while(result.startsWith(" "))
        {
        	result = result.substring(1, result.length());
        }
        while(result.endsWith(" "))
        {
        	result = result.substring(0, result.length()-1);
        }
        String[] conseq = result.split("\\s{1,}");
        ArrayList<String> list = new ArrayList<String>();
        
        for(int i = 0;i<conseq.length;i++)
        {
        	list.add(conseq[i]);
        }
        String fi = list.toString();
        fi = fi.substring(1, fi.length()-1);
        fi = fi.replaceAll(", ", " ");
        return fi;
        
   }
	
	public String reverseWords2(String s){
		Stack<String> stack = new Stack<String>();
		if(s.length() == 0)return s;
		String[] string = s.split("\\s{1,}");
		StringBuffer re = new StringBuffer();
		for(String ss : string)
		{
			stack.push(ss);
		}
		while(!stack.isEmpty())
		{
			re = re.append(stack.pop());
			re = re.append(" ");
		}
		return re.toString().trim();
//		if(re.length() == 0)
//		{
//			return re;
//		}
//		else{
//			re = re.substring(0,re.length()-2);
//			return re;
//		}
	}
	
	public static void main(String[] args) {
		String s =  "dzzvqi,retp','uqn!ftf!ko!tmnibwhrgaqyhqhatvmihozvv!noahf?g?kxpz wzpzgnrna,,z c.kcm ld ngp?qlo!euhh!n ho!owonpwymyixpket!hs!!jmgjuwqu kj?fmdouwauvpu,?f'kvqqw'lpjvg'ochva gddqos,st.ta,vc fyrkvd'gdl.wn,crfv?ek,jcwepm.k.xrwv.jgwb?bg rfxrupfao,dxiafhbdblksqbuajubuvguhfaax?nhi'qtg!b?'mxqep wcoyvs?mdi,vtuumkepghdxz,v!w!!txiuk,fdwl.!lbpbbels.!lz'mmn jti.d'b'rvdlqfnoacvnfpkfcyoczuxzkj!oha.h'otbetmfegtpciqyjtln'jgff!kn,g,qqrbzwaavlup,?hse!fc";
		ReverseString sss = new ReverseString();
		String r = sss.reverseWords2(s);
		
		System.out.print(r);
	}
}
