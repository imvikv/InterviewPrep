package multiThreadingImpl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MTWithCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int a=1,b=2,c=3,d=4;
		ExecutorService s= Executors.newFixedThreadPool(2);
		Runner r1= new Runner(a,b);
		Runner r2= new Runner(c,d);
		Future<Integer> f1= s.submit(r1);
		Future<Integer> f2= s.submit(r2);
		System.out.println(f1.get()*f2.get());
	}
	
}
// callable class which return the o/p
class Runner implements Callable<Integer>
{
Integer a=null;
Integer b=null;

 public  Runner(int a, int b)
 {
	 this.a=a;
	 this.b=b;
 }
	@Override
	public Integer call() throws Exception {
		
		return this.a+this.b;
	}
	
	}