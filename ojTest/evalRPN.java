package ojTest;

import java.util.Stack;

public class evalRPN {
	public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);
        for(String c : tokens){
        	char[] s = c.toCharArray();
        	if(s[0] >= 48 && s[0]<= 57){
        		int k = 0;
        		for(int i=0 ;i<=s.length-1;i++)
        		{
        			k = (int) (k+ (int)(s[i]-48)*Math.pow(10,s.length-i-1));
        		}
        		stack.push(k);
        	}else if(s[0] == '-' && s.length>1 && s[1] >=48 && s[1] <= 57){
        		int k = 0;
        		for(int i=s.length-1;i>0;i--)
        		{
        			k = (int) (k+ (int)(s[i]-48)*Math.pow(10,s.length-i-1));
        		}
        		stack.push(-k);
        	}else{
        		int a,b;
        		a = stack.pop();
        		b = stack.pop();
        		switch(s[0]){
        		case '+' : {
        			        stack.push(a+b);
        			        break;
        			        }
        		case '-' : {
        					stack.push(b-a);
        					break;
        					}
        		case '*' : {
        					stack.push(a*b);
        		            break;
        		            }
        		case '/' :  {
        			        stack.push(b/a);
        			        break;
        					}
        		}
        	}
        }
        int result = stack.pop();
        return result;
    }
	public static void main(String args[]){
		String[] tokens = {"-4","13","5","/","+"};
		int re = evalRPN(tokens);
		System.out.print(re);
	}
}
