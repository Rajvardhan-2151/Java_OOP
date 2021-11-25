package study.studentMdp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import study.Student;
import study.StuentDbexception;

public class Student_user {

	public static void main(String[] args) throws ClassNotFoundException   
	{
		List<Student> list=null;
		
			try {
				list=Student.read_file();
			} catch (StuentDbexception e1) 
			{
				e1.printStackTrace();
				 list=new ArrayList<Student>();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
				 list=new ArrayList<Student>();
			}
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			menu();
			System.out.println("Enter the choice");
			choice=sc.nextInt();
			switch (choice) 
			{
			case 0:
			{
				show(list);
				break;
			}
			case 1:
				poulate(sc,list);
				break;
			case 2:
				populate2(sc,list);
				break;
			case 3:
				search_stud(sc,list);
				break;
			case 4:
				remoave_stud(sc,list);
				break;
			case 5:
				remove_all(sc,list);
				break;
			case 6:
				try {
					Student.save_in(list);
				} catch (StuentDbexception e) {
					e.printStackTrace();
				}
				break;
			case 7:
				System.out.println("%%%%%%%%%%%%% END %%%%%%%%%%%%%%%%");
				break;
			}
			if(choice==6)
			{
				break;
			}
			
		}while(choice!=7);

	}//end main

	private static void show(List<Student> list)
	{
		Stream<Student> str=list.stream();
		str.forEach((ele)->{System.out.println(ele);});
		
	}

	private static void remove_all(Scanner sc, List<Student> list) 
	{
		list.removeAll(list);
		System.out.println("data erased");
		
	}

	private static void remoave_stud(Scanner sc, List<Student> list) 
	{
		sc.nextLine();
		System.out.println("Enter the name of students");
		String nam=sc.nextLine();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getName().equals(nam))
			{
				list.remove(i);
			}
		}
	}

	private static void search_stud(Scanner sc, List<Student> list) 
	{
		sc.nextLine();
		System.out.println("Enter the name of student");
		String name=sc.nextLine();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getName().equals(name))
			{
				System.out.println(list.get(i));
			}
		}
		
		
	}

	private static void populate2(Scanner sc, List<Student> list) 
	{
		sc.nextLine();
		System.out.println("Enter the name");
		String n=sc.nextLine();
		System.out.println("Enter the roll no");
		int r=sc.nextInt();
		Student st=new Student(n,r);
		list.add(st);
		
	}
	private static void poulate(Scanner sc, List<Student> list) 
	{
		sc.nextLine();
		System.out.println("Enter the name");
		String n=sc.nextLine();
		System.out.println("Enter the roll no");
		int r=sc.nextInt();
		System.out.println("Enter marks of three subjects");
		int m[]=new int[3];
		for(int i=0;i<m.length;i++)
		{
			m[i]=sc.nextInt();
		}
		Student s=new Student(n,r,m);
		list.add(s);
	}

	private static void menu()
	{
		System.out.println("########## MENU ############");
		System.out.println("0.show Student details");
		System.out.println("1.fill Student details");
		System.out.println("2.fill Student details without marks");
		System.out.println("3.search Student details");
		System.out.println("4.remove student");
		System.out.println("5.remove all");
		System.out.println("6.exit with save in file");
		System.out.println("7.exit without save");
		
	}

}
