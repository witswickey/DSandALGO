package java1;
import java.util.Arrays;
import java.util.Stack;

public class Stack1 {

	public static void main(String[] args) {
		
		Stack<Character> st=new Stack<Character>();
		String exp="a+b*(c^d-e)^(f+g*h)-i";	
		//System.out.println(InfixtoPostFix(st,exp));
		System.out.println("abcd^e-fgh*+^*+i-".equalsIgnoreCase(InfixtoPostFix(st, exp)));

	}
	

	public static boolean checkoperator(char a) {
		if(a=='+' || a=='-'|| a=='/' || a=='*' || a=='^') {
			return true;
		}
		return false;
	}
	public static int getprecendence(char ch) {
		switch (ch) {
		case '+':
			return 1;
		case '-':return 1;
		case '*':
		case '/':
			return 2;
		case '^':return 3;
		}
		return 0;
	}

	private static String InfixtoPostFix(Stack<Character> st,String exp) {
		
	char[] expo=exp.toCharArray();
	int count=0;
	String result="";
	System.out.println(Arrays.toString(expo));
	while(count<expo.length) {
		char ch=expo[count];
		boolean flag=Character.isLetterOrDigit(ch);
		if(flag)
			result+=ch;
		else if(ch=='(')
			st.push(ch);
		else if(ch==')') {
			while(!st.isEmpty() && (char)st.peek()!='(')
				result+=st.pop();
			if(!st.isEmpty() && (char)st.peek()!='(')
			return("Invalid exp");
			else
				st.pop();
		}
		else
		{
			while(!st.isEmpty() && getprecendence(ch)<=getprecendence((char)st.peek())){
				result+=st.pop();
			}
			st.push(ch);
		}
	count++;
	}
        // pop all the operators from the stack 
        while (!st.isEmpty()){ 
            if((char)st.peek() == '(') 
                return "Invalid Expression"; 
            result += st.pop(); 
         } 
       
	return result;
	}

}
