package Leetcode;

import java.util.Enumeration;
import java.util.Vector;

import javax.xml.transform.Source;

public class VectorDemo {
	public static void main(String[] args) {
		Vector v = new Vector(3,2);
		System.out.println("Initial size:"+v.size());
		System.out.println("Initial capacity:"+v.capacity());
		v.addElement(new Integer(1));
		v.addElement(new Integer(2));
		v.addElement(new Integer(3));
		v.addElement(new Integer(4));
		v.addElement(new Integer(5));
		v.addElement(new Integer(6));
		System.out.println("Capacity after additions - size:"+v.size());
		System.out.println("Capacity after additions - capacity:"+v.capacity());
		v.addElement(new Float(9.4));
		v.addElement(new Double(6.08));
		System.out.println("Capacity after additions - size:"+v.size());
		System.out.println("Capacity after additions - capacity:"+v.capacity());
		System.out.println("First Element:"+(Integer)v.firstElement());
		System.out.println("Last Element:"+v.lastElement());
		if(v.contains(new Integer(2))){
			System.out.println("Vector contains 2");
		}
		Enumeration vEnum = v.elements();
		System.out.println("\nElement in vector:");
		while(vEnum.hasMoreElements()){
			System.out.print(vEnum.nextElement()+" ");
		}

	}

}
