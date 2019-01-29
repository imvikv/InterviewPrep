package multiThreadingImpl;

public class CustomLockImpl {

	private boolean isLocked = false;
	private Thread lockedBy = null;
	private int lockCount = 0;

	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			System.out.println("inside while");
			wait();
		}
		isLocked = true;

	}

	public synchronized void unLock() throws InterruptedException {

		isLocked = false;
		notifyAll();
	}

	public synchronized void lockReentrant() throws InterruptedException {
		while (isLocked && lockedBy != Thread.currentThread()) {
			wait();
		}
		isLocked = true;
		lockedBy = Thread.currentThread();
		lockCount++;
	}

	public synchronized void unlockReentrant() {
		if (lockedBy == Thread.currentThread()) {
			lockCount--;
		}
		if (lockCount == 0) {
			isLocked = false;
			notifyAll();
		}
	}
}
