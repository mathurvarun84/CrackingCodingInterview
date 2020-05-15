package src.Main.Q3_02_Stack_Min;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        //find the min for each push and add the min with each node
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }
    
    public int min() {
    	if (this.isEmpty()) {
    		return Integer.MAX_VALUE;
    	} else {
    		return peek().min;
    	}
    }
}
