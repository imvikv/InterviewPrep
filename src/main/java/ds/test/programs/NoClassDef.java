package ds.test.programs;

public class NoClassDef {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("ds.test.programs.NoClassDef");
		String[] a= new String[] {"a"};
		return;
	}
}
