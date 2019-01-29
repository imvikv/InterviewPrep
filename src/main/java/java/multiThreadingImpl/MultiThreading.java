package java.multiThreadingImpl;

public class MultiThreading {
	int a=1,b=2,c=3,d=4;
	private  int e,f;

public static void main(String[] args) throws InterruptedException {
MultiThreading m= new MultiThreading();	
	Thread t1= new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println(m.a+m.b);
			m.e=m.a+m.b;
		}
	});
	t1.start();
	t1.join();
Thread t2= new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println(m.c+m.d);
			m.f=m.c+m.d;
		}
	});
	t2.start();
	t2.join();
	System.out.println(m.e*m.f);
}
}
