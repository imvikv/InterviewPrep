package algo.java.randomImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		String s1 = "My name is John";
		char[] sc = s1.toCharArray();
		int a = 10;
		int b = 251;
		Integer c = 129;
		Integer d = -127;
		Integer e = new Integer("-127");
		System.out.println(d == e);
		System.out.println(c + 1 + " " + d + 2);
		StringBuilder s = new StringBuilder();

		List<String> abc = Arrays.asList("a");
		abc.set(0, "asd");
		// abc.add("asasd");
		System.out.println(abc.get(0));
		abc = Collections.unmodifiableList(abc);
		System.out.println(abc.get(0));
		Integer z = new Integer(234);

		TreeMap<Integer, Boolean> aa = new TreeMap<>();
		aa.put(4, true);
		aa.put(5, true);
		aa.put(1, true);
		aa.put(2, true);
		aa.put(3, true);
		aa.put(3, false);
		System.out.println(aa.keySet());

		// abc.set(0, "asd");
		/*
		 * Scanner in = new Scanner(System.in); int max=0; int v=0; int
		 * s=in.nextInt(); for(int i=0;i<s;i++) { int a=in.nextInt(); int
		 * b=in.nextInt(); int value=Math.abs(a-b); if(max<value) { max=value;
		 * if(a>b) { v=1; } else v=2;
		 * 
		 * }
		 * 
		 * } System.out.print(v+" "+max);
		 */}

}
