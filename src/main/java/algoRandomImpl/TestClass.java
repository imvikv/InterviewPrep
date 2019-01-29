package algo.java.randomImpl;

import java.util.Scanner;



public class TestClass {
	public static boolean  checkBalance(String str) {
		JStack stack = new JStack();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')'
					&& (!stack.isEmpty())) {
				if (((char) stack.peek() == '(' && ch == ')'))
						 {
					stack.pop();
				} else {
					return false;
				}
			} else {
				if ( ch == ')') {
					return false;
				}
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}
	

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int ind = in.nextInt();
		int len = input.length();
		int counter=0;
		if(ind==2)
		{
			for(int i=1;i<len;i++)
			{
				if(TestClass.checkBalance(input.substring(0, i)+")"+input.substring(i,len)))
				{
					counter++;
				}
			}
		}
		else
		{

			for(int i=len-1;i<len;i++)
			{
				if(TestClass.checkBalance(input.substring(0, i)+"("+input.substring(i,len)))
				{
					counter++;
				}
			}
		
		}
	
		System.out.println(counter);
		
		}	
}

 class JStack
 
   {
	private Object[] data;
	private int index = 0;
	private int size = 0;
	public JStack() {
		super();
		this.size = 30; /* default stack size of 20 */
		data = new Object[this.size];
	}
	/**
	 * @param o
	 * @throws RuntimeException
	 */
	public void push(char o) {
		if (index >= size) {
			this.increaseSize();
		}
		this.data[index] = o;
		index++;
	}
	/**
	 * @return
	 */
	public Object pop() {
		if (index != 0) {
			Object obj = data[index - 1];
			this.data[index - 1] = null; // Deleted
			index--;
			return obj;
		} else
			return null;
	}
	public Object peek() throws RuntimeException {
		if (index != 0)
			return this.data[index - 1];
		else
			return null;
	}
	/* @Method This returns true if stack is empty */
	public boolean isEmpty() {
		return index == 0 ? true : false;
	}
	/* @Method This method returns the stack size */
	public int getStackSize() {
		return index;
	}
	/* @Method This deletes the entire stack */
	public void deleteStack() {
		if (index != 0) {
			for (int i = 0; i < index; i++) {
				this.data[i] = null;
			}
			index = 0;
			System.out.println("The Stack has been deleted");
		}
	}
	private void increaseSize() {
		Object[] temp = new Object[size];
		size = size * 2;
		for (int i = 0; i < index; i++) {
			temp[i] = this.data[i];
		}
		this.data = new Object[this.size];
		for (int i = 0; i < index; i++) {
			this.data[i] = temp[i];
		}
	}
}
