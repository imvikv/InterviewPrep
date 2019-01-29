package java.multiThreadingImpl;

/**
 * @author vikas
 *Deadlock creation using sync
 */
public class DeadlockCreation {

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private  synchronized int sum(int a, int b) {
		int c= a+b;
		synchronized (this) {
			return multiPly(c, b);
			
		}
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private synchronized int multiPly(int a, int b) {
		return a * b;
	}

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a=4,b=5;
		DeadlockCreation n1= new DeadlockCreation();
		DeadlockCreation n2= new DeadlockCreation();
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (n1) {
					for(int i=1;i<100;i++)
					{
						System.out.println("a="+a);
					}
				synchronized (n2) {
					System.out.println("b="+b);
					
				}	
				}
//				System.out.println(Thread.currentThread().getName()+" "+n.sum(a, b));
//				System.out.println(Thread.currentThread().getName()+" "+n.multiPly(a, b));
				
				
			}
		});
		
Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (n2) {
				synchronized (n1) {
					System.out.println("a="+a);
					
				}	
				}
//				System.out.println(Thread.currentThread().getName()+" "+n.sum(a, b));
//				System.out.println(Thread.currentThread().getName()+" "+n.multiPly(a, b));
				
				
			}
		});
		
t1.start();
t2.start();
	}
}
