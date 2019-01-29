package java.multiThreadingImpl;

public class ThreadT1T2T3 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("current thread is " + Thread.currentThread().getName());

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				System.out.println("current thread is " + Thread.currentThread().getName());

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				System.out.println("current thread is " + Thread.currentThread().getName());

			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {

				System.out.println("current thread is " + Thread.currentThread().getName());

			}
		});
		t1.start();
		t1.join();
		t2.start();
		t2.join(0);
		t3.start();
		t3.join(0);
	}

}
