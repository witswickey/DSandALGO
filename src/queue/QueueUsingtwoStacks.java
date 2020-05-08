package queue;

import java.util.Stack;

public class QueueUsingtwoStacks {
	public static void main(String[] args) {
		StackQueue st = new StackQueue();
		st.insert(10);
		st.remove();
	}
}

class StackQueue {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	/*
	 * The method insert to push element into the queue
	 */
	void insert(int B) {

		s1.push(B);
	}

	/*
	 * The method remove which return the element popped out of the queue
	 */
	int remove() {
		int m = -1;

		while (!s2.isEmpty()) {
			s2.pop();
		}

		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		if (!s2.isEmpty())
			m = s2.pop();
		while (!s1.isEmpty()) {
			s1.pop();
		}
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		return m;
	}
}
