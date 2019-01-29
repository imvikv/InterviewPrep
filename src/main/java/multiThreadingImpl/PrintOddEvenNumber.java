package multiThreadingImpl;

/**
 * This Programe will print even and odd numbers using multiThreading using wait
 * and notify Logic here is : you need to different runnables for printing
 * separately even number and odd number , main trick is how you print them one
 * by one one after another using a monitor , monitor here is sharedObject which
 * takes lock on sharedObject one any of thread is in execution
 * 
 * @author vikas
 *
 */
public class PrintOddEvenNumber {

	public static void main(String[] args) {
		SharedObject s1 = new SharedObject();
		Thread t1 = new Thread(new printEven(20, s1));
		Thread t2 = new Thread(new printOdd(20, s1));
		t1.start();
		t2.start();

	}

}

class SharedObject {

	boolean isEven = true;

	public synchronized void printEven(int value) {
		while (!isEven) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " " + value);
		isEven = false;
		notify();

	}

	public synchronized void printOdd(int value) {
		while (isEven) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " " + value);
		isEven = true;
		notify();

	}

}

class printEven implements Runnable {
	int max;
	SharedObject s1;

	/**
	 * @param max
	 * @param s1
	 */
	printEven(int max, SharedObject s1) {
		super();
		this.max = max;
		this.s1 = s1;
	}

	@Override
	public void run() {
		for (int i = 0; i <= max; i += 2) {
			s1.printEven(i);
		}

	}

}

class printOdd implements Runnable {
	int max;
	SharedObject s1;

	/**
	 * @param max
	 * @param s1
	 */
	printOdd(int max, SharedObject s1) {
		super();
		this.max = max;
		this.s1 = s1;
	}

	@Override
	public void run() {
		for (int i = 1; i <= max; i += 2) {
			s1.printOdd(i);
		}

	}

}
