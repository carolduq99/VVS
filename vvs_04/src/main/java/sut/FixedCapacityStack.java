package sut;

/**
 * Software Verification and Validation
 * 
 * Master of Science in Computer Engineering,
 * University of Lisbon,
 * Faculty of Sciences,
 * Department of Informatics
 * 
 * @author Eduardo Marques
 * @version $Id: FixedCapacityStack.java 313 2016-03-21 12:46:58Z vv $
 */
public class FixedCapacityStack {
	
	private final Object[] elements;
	
	private int size;

	public FixedCapacityStack(int capacity) {
		if (capacity < 1)
			throw new IllegalArgumentException();
		elements = new Object[capacity];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == elements.length;
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return elements.length;
	}

	public Object peek() {
		if (isEmpty())
			throw new IllegalStateException("Stack is empty!");
		return elements[size - 1];
	}

	public Object pop() {
		if (size == 0)
			throw new IllegalStateException("Stack is empty!");
		size--;
		Object data = elements[size];
		elements[size] = null;
		return data;
	}

	public void push(Object data) {
		if (size == elements.length)
			throw new IllegalStateException("Stack is full!");
		elements[size] = data;
		size++;
	}
}