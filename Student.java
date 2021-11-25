package study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student implements Serializable {
	
private	String name;
private	int rollno;
private	int marks[];
	
					public Student() 
					{
						name="";
						rollno=0;
						marks=null;

					}

					public Student(String name, int rollno, int[] marks) {
						
						this.name = name;
						this.rollno = rollno;
						this.marks = marks;
					}
					public Student(String name, int rollno) {
						
						this.name = name;
						this.rollno = rollno;
						this.marks = null;
					}

					public String getName() {
						return name;
					}

					public void setName(String name) {
						this.name = name;
					}

					public int getRollno() {
						return rollno;
					}

					public void setRollno(int rollno) {
						this.rollno = rollno;
					}

					public int[] getMarks() {
						return marks;
					}

					public void setMarks(int[] marks) {
						this.marks = marks;
					}

					@Override
					public String toString() {
						return "Student [name=" + name + ", rollno=" + rollno + ", marks=" + Arrays.toString(marks)
								+ "]";
					}
					public static void save_in(List<Student> list) throws StuentDbexception 
					{
						ObjectOutputStream obj = null;

						try {
							OutputStream out = new FileOutputStream("D:\\CDAC IET\\Sample pr files\\student_new.txt");
							obj=new ObjectOutputStream(out);
							System.out.println(list.size());
							for(int i=0;i<list.size();i++)
							{
								obj.writeObject(list.get(i));
							}
							obj.flush();
							
						} catch (FileNotFoundException e1) 
						{
							throw new StuentDbexception();
							
						}	
						catch (IOException e) {
							e.printStackTrace();
						}
						finally
						{
							try {
								obj.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					public static List<Student> read_file() throws StuentDbexception, ClassNotFoundException 
					{
						List<Student> nlist=new ArrayList<>();
						try {
							InputStream it=new FileInputStream("D:\\CDAC IET\\Sample pr files\\student_new.txt");
							ObjectInputStream obj=new ObjectInputStream(it);
							while(true)
							{
								if(it.available()==0)
								{
									nlist.add((Student) obj.readObject());
								}
							}
						} catch (FileNotFoundException e) 
						{
							throw new StuentDbexception();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
							return nlist;
					}
					
	

}
