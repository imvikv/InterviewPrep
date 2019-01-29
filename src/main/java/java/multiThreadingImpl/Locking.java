package java.multiThreadingImpl;

import java.util.concurrent.locks.ReentrantLock;

public class Locking {
	private int count =0;
	private ReentrantLock lock= new ReentrantLock();
	public static void main(String[] args) {
		Locking lc= new Locking();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			for(int i=0;i<10;i++) {	
			System.out.println(lc.getCount());	
			}}
		});
		
Thread t2 = new Thread(new Runnable() {
	
	@Override
	public void run() {
	for(int i=0;i<10;i++) {	
	System.out.println(lc.getCount());	
	}}
});
t1.start();
t2.start();
	}
	private int getCount()
	{
		
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+":"+count);
			return count++;
		} finally {
			lock.unlock();
		}
	}

}
