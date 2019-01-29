package multiThreadingImpl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class calls custom blocking queue for doing producer and consume
 * behaviour
 * 
 * currently 1 thread is producing and 2 threads are
 * 
 * @author vikas
 *
 */
public class BlockingQRunner {

	public static void main(String[] args) {
		CustomBlockingQ<Integer> queue = new CustomBlockingQ<>(12);
		ExecutorService e = Executors.newCachedThreadPool();
		e.submit(new put(queue));
		e.submit(new take(queue));
		e.submit(new take(queue));
		e.shutdown();

		BlockingQueue<Integer> bl = new ArrayBlockingQueue<>(10);

	}

}

class put implements Runnable {
	CustomBlockingQ<Integer> queue;

	/**
	 * @param queue
	 */
	public put(CustomBlockingQ<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				if (i % 2 == 0) {
					System.out.println("enqueu waiting");
					Thread.sleep(1000);
					System.out.println("enqueu waiting ended");
				}
				queue.enqueue(i);
				System.out.println(Thread.currentThread().getName() + " enqueue " + i);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println(Thread.currentThread().getName() + " finished enqueue");
	}

}

class take implements Runnable {

	CustomBlockingQ<Integer> queue;

	/**
	 * @param queue
	 */
	public take(CustomBlockingQ<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				int k = queue.dequeue();
				System.out.println(Thread.currentThread().getName() + " dequeue " + k);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " finished dequeue");

	}

}
