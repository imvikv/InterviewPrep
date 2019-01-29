package ds.test.programs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectCreation implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String s = "yes";

	public ObjectCreation() {
		super();
	}

	/**
	 * @param s
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 *//*
		 * public ObjectCreation(String s) { super(); this.s = s; }
		 */
	// we will try all the ways here by which we can create objects.
	public static void main(String[] args) throws CloneNotSupportedException, InstantiationException,
			IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException, IOException, ClassNotFoundException {

		// 1 internally calls constructor
		Object a = new ObjectCreation();
		System.out.println(((ObjectCreation) a).getS());
		// 2 , this does not calls constructor inside , this is a bit by bit
		// copy of the object , this is not same objet , it's a new object in
		// different memory location than earlier so b !=temp and b.equals(temp)
		// is true

		ObjectCreation temp = new ObjectCreation();
		Object b = temp.clone();

		boolean bi = (b != temp);
		System.out.println("b != temp returns " + bi);
		System.out.println(((ObjectCreation) b).getS());

		// 3 using reflection , can call only default public constructor with no
		// arguments
		Class cl = b.getClass();
		ObjectCreation c = (ObjectCreation) cl.newInstance();
		System.out.println("using class.newInstance " + c.getS());

		// 4 using reflection , this can work with all the types of constructor
		// except private constructors
		Constructor[] con = cl.getConstructors();
		System.out.println("using constructor " + ((ObjectCreation) con[0].newInstance()).getS());

		// serialization , use of outputStream

		FileOutputStream out1 = new FileOutputStream("obejct.ser");
		ObjectOutputStream out2 = new ObjectOutputStream(out1);
		out2.writeObject(b);
		out2.close();
		// deserialzation

		FileInputStream in1 = new FileInputStream("obejct.ser");
		ObjectInputStream in2 = new ObjectInputStream(in1);
		ObjectCreation d = (ObjectCreation) in2.readObject();
		System.out.println("yayy from deserialization " + d.getS());
		System.out.println(d.equals(b));

	}

	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}

}
