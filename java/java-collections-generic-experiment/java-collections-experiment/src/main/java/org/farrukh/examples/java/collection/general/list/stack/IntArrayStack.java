package org.farrukh.examples.java.collection.general.list.stack;

public class IntArrayStack {

	private int[]	stack;
	private int		size;
	private int		top;

	public IntArrayStack(int size) {
		this.size = size;
		stack = new int[size];
		top = -1;
	}

	public void push(int element) {
		if (top == stack.length - 1)
			System.out.println("Stack is full");
		else
			stack[++top] = element;
	}

	public int peek() {
		if (top < 0) {
			System.out.println("Stack is empty");
			return 0;
		}
		return stack[top--];
	}
	
	public int pop() {
		if (top < 0) {
			System.out.println("Stack is empty");
			return 0;
		}
		final int index = top--;
		int element = stack[index];
		stack = removeElement(index);
		return element;
	}

	private int[] removeElement(int index) {
		int[] copy = new int[stack.length - 1];
		System.arraycopy(stack, 0, copy, 0, index);
		//System.arraycopy(stack, index + 1, copy, index, stack.length - 1 - index);
		return copy;
	}

	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		IntArrayStack stack = new IntArrayStack(10);
		for (int i = 0; i < stack.getSize(); i++)
			stack.push(i * i);
		for (int i = 0; i < stack.getSize(); i++)
			System.out.println(stack.pop());
	}
}
