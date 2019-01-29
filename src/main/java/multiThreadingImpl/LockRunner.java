package multiThreadingImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * This class uses custom impelmentation of lock
 * */
public class LockRunner {
	CustomLockImpl lock = new CustomLockImpl();
	private int count = 0;

	public int incrementAndGet() throws InterruptedException {
		lock.lock();
		int newCount = count + 1;
		lock.unLock();
		return newCount;
	}

	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(2);
		e.submit(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while (i < 10) {
					try {
						new LockRunner().incrementAndGet();
						i++;

						System.out.println(Thread.currentThread().getName() + " " + i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		e.submit(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while (i < 10) {
					try {
						new LockRunner().incrementAndGet();
						i++;
						System.out.println(Thread.currentThread().getName() + " " + i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}

}
