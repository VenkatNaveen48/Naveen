package com.naveen.intechAdditive.Interview;

/*Java Program to get minimum element from the Stack*/

/*Importing utility classes*/
import java.util.Stack;

public class StackMinimun {

	private Stack<Integer> stack;
	private int min = 0;
	private int count = 0;

	/* constructor to initialize the Stack */
	public StackMinimun() {
		stack = new Stack<Integer>();
	}

	/* this method is used to update the minimum element in the Stack */
	private int getMin() {
		int newMin = 0;
		int c = 0;
		for (int i : stack) {
			if (newMin == 0 && c == 0) {
				newMin = i;
				c++;
			} else if (newMin > i) {
				newMin = i;
			}

		}
		return newMin;
	}

	/* This method is to insert the values into the Stack. This method also updates
	   with the appropriate minimum value  */
	
	public int push(int value) {

		if (min == 0 && count == 0) {
			min = value;
			count++;

		} else if (min > value) {
			min = value;
		}

		return stack.push(value);
	}

	/* This method is to get the last added values into the Stack. This method also
	   updates with the appropriate minimum value */
	 
	public int pop() {
		Integer pop = stack.pop();
		min = getMin();
		return pop;
	}

	/* This method is used to return the minimum element from the Stack */
	public int min() {
		return min;
	}

	/* this method is to print the elements in the Stack */
	@Override
	public String toString() {
		return stack.toString();
	}

	/* Driver method */
	public static void main(String[] args) {
		StackMinimun sm = new StackMinimun();
		/* calling the methods to add the data into the Stack */
		sm.push(10);
		sm.push(0);
		sm.push(40);
		sm.push(1);
		/* calling a method to print the minimum value from the Stack */
		System.out.println(sm.min());
		/* to print the elements in the Stack */
		System.out.println(sm);
	}
}
