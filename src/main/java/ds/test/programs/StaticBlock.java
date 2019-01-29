package ds.test.programs;

public class StaticBlock {

	static {
		System.out.println("start");
		System.out.println("end");
	}
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
	}
}
