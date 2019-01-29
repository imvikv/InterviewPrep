package java.multiThreadingImpl;

/*Singleton pattern ensures that exactly one instance of class will remain in Java program at any time

Read more: http://javarevisited.blogspot.com/2012/12/how-to-create-thread-safe-singleton-in-java-example.html#ixzz4ittBbpVS
 * */
public class SingleTonDesignpattern {

	SingltonIntance s = SingltonIntance.getInstance();

}

class SingltonIntance {
	private static SingltonIntance single = new SingltonIntance(); // early
																	// initialization
																	// using
																	// static
																	// field

	private SingltonIntance() {
		System.out.println("private Instance");
	}

	public static SingltonIntance getInstance() {
		return single;
	}

}