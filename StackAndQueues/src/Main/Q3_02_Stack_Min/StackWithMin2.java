package src.Main.Q3_02_Stack_Min;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
	Stack<Integer> s2;
	
	public StackWithMin2() {
		s2 = new Stack<Integer>();		
	}
	
	public void push(int value){
		//If value is less than min then push it to another stack.
		if (value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() {
		int value = super.pop();
		//if the value is minimum then pop it from the second stack
		if (value == min()) {
			s2.pop();			
		}
		return value;
	}
	
	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}


