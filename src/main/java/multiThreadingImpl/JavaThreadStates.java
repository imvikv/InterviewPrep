package multiThreadingImpl;

public class JavaThreadStates implements Runnable {

	public static void main(String[] args) {
		Thread t = new Thread(new JavaThreadStates());
		t.run();
		t.start();
		// t.setDaemon(true);
		t.run();
		Thread t1 = new Thread(new Thread("sad"));
		t1.start();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());

	}
}
