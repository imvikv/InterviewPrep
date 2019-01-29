package multiThreadingImpl;

import java.util.LinkedList;
import java.util.List;

public class CustomBlockingQ<E> {

	private List<E> queue = new LinkedList<>();
	private int limit = 10;

	/**
	 * @param limit
	 */
	public CustomBlockingQ(int limit) {
		super();
		this.limit = limit;
	}

	public synchronized void enqueue(E e) throws InterruptedException {
		while (queue.size() == this.limit) {
			wait();
		}
		if (queue.size() == 0) {
			notifyAll();
		}
		queue.add(e);

	}

	// removes from the first in element
	public synchronized E dequeue() throws InterruptedException {
		while (queue.size() == 0) {
			wait();
		}
		if (queue.size() == this.limit) {
			notifyAll();
		}

		return queue.remove(0);
	}
}
