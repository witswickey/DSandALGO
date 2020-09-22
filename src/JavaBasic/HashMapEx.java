package JavaBasic;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class student implements Comparable{
	int rollno;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public student(int ron,String nam) {
		this.rollno=ron;
		this.name=nam;
	}
	@Override
	public int compareTo(Object st) {
		student sm=(student)st;
		return this.getRollno()>sm.getRollno()?0:1;
	}
	@Override
	public String toString() {
		
		return "Student rollno:"+this.getRollno()+" and name is:"+this.getName();
	}

}

public class HashMapEx {

	public static void main(String[] args) {
		
		student map[]=new student[5];
		
		map[0]=new student(10, "Ankit");
		map[1]=new student(20, "Kamnini");
		map[2]=new student(30, "Raju");
		map[3]=new student(40, "Shipra");
		map[4]=new student(50, "Himanshu");
		
		HashMap<Integer,student> cica=new HashMap();
		
		for(student st:map) {
			cica.put(st.getRollno(),st);
		}
		Arrays.parallelSort(map);
		
		for(student st:map) {
			System.out.println(st);
		}
		Comparator<student> comp=new Comparator<student>() {

			@Override
			public int compare(student o1, student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}

		};
		System.out.println();
		Collections.sort(Arrays.asList(map),comp);
		for(student st:map) {
			System.out.println(st);
		}
		//System.out.println("Student cicada is"+cica);
		

	}

}
