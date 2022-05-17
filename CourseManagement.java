
package javaapplication9;

  
import pack.NewInterface;
import java.io.*;  
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.lang.Runnable;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;




 /*
    class CourseManagement{

     
      static {
        CONST_STR = "Course Management";
        System.out.println("Inside first static block.");
    }
 
    public static void sub()
    {
        System.out.println("Inside static method.");
        System.out.println(CONST_STR);
    }
 
    static {
        sub();
        System.out.println("Inside second static block.");
    }
 
   
	public static void main(String args[]){

        //multiple object by one type
        tutor d1=new tutor(12,"Divyansh","Maths",5,567,5,700), d2=new tutor(14,"Priyansh","Science",5,567,5,700);

        //shallow copy
        tutor d3 = d2;
        System.out.println("Shallow Copy: *** Before changes ***");
        System.out.println("Tutor id: "+d2.id+", Name: "+d2.name);
        System.out.println("Tutor id: "+d3.id+", Name: "+d3.name);
        d3.name="Arjun";
        System.out.println("Shallow Copy: *** After changes ***");
        System.out.println("Tutor id: "+d2.id+", Name: "+d2.name);
        System.out.println("Tutor id: "+d3.id+", Name: "+d3.name);

        //copy constructor - shallow
        System.out.println("Copy constructor - Shallow: *** Before changes ***");
        tutor d4 = new tutor(d2);
        System.out.println("Tutor id: "+d2.id+", Name: "+d2.name);
        System.out.println("Tutor id: "+d4.id+", Name: "+d4.name);
        d4.name="Arjun";
        System.out.println("Copy constructor - Shallow: *** After changes ***");
        System.out.println("Tutor id: "+d2.id+", Name: "+d2.name);
        System.out.println("Tutor id: "+d4.id+", Name: "+d4.name);

        //deep copy
        login new_user1 = new login();
        new_user1.userName="Divya";
        new_user1.type="student";
        login new_user2 = new login();
        new_user2.userName = new_user1.userName;
        new_user2.type = new_user1.type;
        System.out.println("Deep Copy: *** Before changes ***");
        System.out.println("Username: "+new_user1.userName+" login type: "+new_user1.type);
        System.out.println("Username: "+new_user2.userName+" login type: "+new_user2.type);
        new_user2.userName = "Priya";
        System.out.println("Deep Copy: *** After changes ***");
        System.out.println("Username: "+new_user1.userName+" login type: "+new_user1.type);
        System.out.println("Username: "+new_user2.userName+" login type: "+new_user2.type);

        Address address = new Address("Bangalore","Karnataka");

        //array of objects
        student[] students=new student[5];  
        students[0] = new student(12,"Divya", 545678990,  address); 
        students[1] = new student(14,"Priya", 789098990,  address);
        
        //copy constructor - deep
        students[2] = new student(students[0]);
        System.out.println("Copy constructor - deep: *** Before changes ***");
        System.out.println(students[0].address.city+" "+students[0].address.state); 
        System.out.println(students[2].address.city+" "+students[2].address.state);
        students[2].address.city = "Meruth";
        students[2].address.state = "UP";
        System.out.println("Copy constructor - deep: *** After changes ***");
        System.out.println(students[0].address.city+" "+students[0].address.state); 
        System.out.println(students[2].address.city+" "+students[2].address.state);

      
        
       
	}
}

 class login{
	public String userName;
	private String password;
    public String type;

//default constructor
    public login(){
        System.out.println("Enter Username : ");
        Scanner sc=new Scanner(System.in);
        this.userName = sc.next();
        setUserName(this.userName);
        System.out.println("Create Password : ");
        this.password = sc.next();
        setPassword(this.password);
        System.out.println("Enter Type(User or Admin) : ");
        this.type = sc.next();
        setType(this.type);
        sc.close();
    }
	public login(String userName, String password, String type){
		this.userName=userName;
		this.password=password;
		this.type=type;
	}
	
//copy constructor - shallow
    public login(login login_info){
        this.userName=login_info.userName;
        this.password=login_info.password;
        this.type=login_info.type;
    }

    public void setUserName(String userName){
		this.userName=userName;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setType(String type){
		this.type=type;
	}

	public String getUserName(){
		return userName;
	}
	public String getPassword(){
		return password;
	}
	public String getType(){
		return type;
	}
}

 class tutor{
	public int id;
	public String name;
	public String subject;
    public int experience;
    public int mobileNo;
    public int rating;
    public float fees;
    
	
    public tutor(int id, String name, String subject, int experience, int mobileNo, int rating, float fees)
    {
        this.id=id;
		this.name=name;
        this.subject=subject;
		this.experience=experience;
		this.mobileNo=mobileNo;
        this.rating=rating;
		this.fees=fees;
       
	}

//copy constructor - shallow
    public tutor(tutor tut){
        this.id=tut.id;
		this.name=tut.name;
        this.subject=tut.subject;
		this.experience=tut.experience;
		this.mobileNo=tut.mobileNo;
        this.rating=tut.rating;
		this.fees=tut.fees;
        
    }

	

    public void updatFees(float new_fees){
        this.fees=new_fees;
    }

   
}

 class student{
	public int id;
	public String name;
    public int mobileNo;
   
    public Address address;

    //object by method
    public student(int id, String name, int mobileNo,  Address address)
    {
            this.id=id;
		this.name=name;
		this.mobileNo=mobileNo;
       
        this.address = address;
    }

    //copy constructor - deep
    public student(student student)
    {
        this.id=student.id;
		this.name=student.name;
		this.mobileNo=student.mobileNo;
       
            this.address = new Address(student.address); //Deep Copying
    }

    public void enterData(){
        String data;
        Scanner sc = new Scanner(System.in);
        data = sc.next();
        System.out.println("Student note: "+data);
        sc.close();
    }

//fuction overloading
    public void search_tutor(int tutor_id){
        //object by reference variable
        tutor tut = new tutor(12,"Divyansh","Maths",5,567,700,5);
        if(tut.id == tutor_id){
            System.out.println("You searched for : "+tut.name+". Contact number = "+tut.mobileNo);
        }
        else{
            System.out.println("Tutor NOT FOUND");
        }
    }
//number of arguments
    public void search_tutor(String name, String subject){
        //object by reference variable
        tutor tut = new tutor(12,"Divyansh","Maths",5,567,700,5);
        if(tut.name == name && tut.subject == subject){
            System.out.println("You searched for : "+tut.id+". Contact number = "+tut.mobileNo);
        }
        else{
            System.out.println("Tutor id NOT FOUND");
        }
    }
//datatype overloading
    public void search_tutor(String name){
        //object by reference variable
        tutor tut = new tutor(12,"Divyansh","Maths",5,567,700,5);
        if(tut.name == name){
            System.out.println("You searched for : "+tut.id+". Contact number = "+tut.mobileNo);
        }
        else{
            System.out.println("Tutor id NOT FOUND");
        }
    }

    public void rate_tutor(int tutor_id, int rating){
        tutor tut = new tutor(12,"Divyansh","Maths",5,567,700,5);
        if(tut.id == tutor_id){
            tut.rating = rating;
        }
        else{
            System.out.println("Tutor id NOT FOUND");
        }
    }

   
}

 
*/


class  InvalidPassException extends Exception
{
    InvalidPassException(String msg){
        System.out.println(msg);
    }
}
class lessexpexception extends Exception{
     lessexpexception(String msg1){
        System.out.println(msg1);
    }
}







class Admission
{

    static int availableSeats = 10;

     synchronized void reserveSeat(int requestedSeats) // LINE D
    {
        System.out.println(Thread.currentThread().getName() + " entered.");
        System.out.println("Availableseats : " + availableSeats + " Requestedsetas : " + requestedSeats);
        if (availableSeats >= requestedSeats)
        {
            System.out.println("Seat Available. Reserve now :-)");
            try
            {
                Thread.sleep(100);     // LINE E
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted");
            }
            System.out.println(requestedSeats + " seats reserved.");
            availableSeats = availableSeats - requestedSeats;
        }
        else
        {
            System.out.println("Requested seats not available :-(");
        }
        System.out.println(Thread.currentThread().getName() + " leaving.");
        System.out.println("----------------------------------------------");
    }
}

class mAdmin extends Thread
{

    Admission reserve;
    int requestedSeats;

    public mAdmin(Admission reserve, int requestedSeats)
    {
        this.reserve = reserve;
        this.requestedSeats = requestedSeats;
    }

    @Override
    public void run() // LINE C
    {
        reserve.reserveSeat(requestedSeats);
    }
}


















interface Exam {
 
 void Percent_cal();
}

class myStudent {
 
 String name;
 int roll_no, Marks1, Marks2;
 myStudent(String n, int rn, int m1, int m2) {
  
  name = n;
  roll_no = rn;
  Marks1 = m1;
  Marks2 = m2;
 }
 
 void show() {
  
  System.out.println("Student Name : "+name);
  System.out.println("Roll no : "+roll_no);
  System.out.println("Marks1 : "+Marks1);
  System.out.println("Marks2 : "+Marks2);
 }
}

class Result extends myStudent implements Exam {
 
 float per;
 Result(String n,int rn,int m1,int m2) {
  
  super(n,rn,m1,m2);
 }
 
 public void Percent_cal() {
     
       
  
  int tot = Marks1 + Marks2;
  per = (float)tot / 2;
 }
 
 void display() {
  
  show();
  System.out.println("Percentage = "+per);
 } 
 
}



interface Test
{

//nested interface
   interface Yes
   {
      void show();    
   }
}
  
class Testing implements Test.Yes
{
   public void show()
   {
      System.out.println("show method of interface");
   } 
} 






interface fee

{

default public void showpay()
{
System.out.println(" Pay = 1222222");}
}


interface salary
{
 public void showsalary();
}


interface pay extends fee, salary{
   public void showamount();
}







class Staff
{

public String name;
public int age;
public int roll_no;

 Scanner sc=new Scanner(System.in);
              void Enter_data()
           
                {      
                        System.out.print("\n\t Enter the name:");
                        name= sc.nextLine();
                        System.out.print("\n\t Enter the age:");
                        age= sc.nextInt();
                        System.out.print("\n\t Enter the roll no:");
                        roll_no= sc.nextInt();
                       
                       
                }
                void Display_data()
                { 

                  System.out.println("\n\t *** TUTOR DETAILS ***");   
                  System.out.println("\n\t  Name = " +name);     
                  System.out.println("\n\t  Age = " +age);  
                  System.out.println("\n\t  Roll no = "+roll_no);  
                }


}


class Tutor extends Staff
{

public String sub;
public int exp;
public String qual;

void Enter_data()
           
                {      super.Enter_data();
                        System.out.print("\n\t Enter the subject:");
                        sub= sc.next();
                        System.out.print("\n\t Enter the experience:");
                        exp= sc.nextInt();
                        
                         try{
        if(  exp< 2)
          throw new lessexpexception("Less Experience");
        }
        catch(lessexpexception le){
        System.out.println("InvalidPassException");
         }
                        System.out.print("\n\t Enter the Qualification:");
                        qual = sc.next();
                       
                       
                }
                void Display_data()
                {  super.Display_data();
                  System.out.println("\n\t  Subject = " +sub);     
                  System.out.println("\n\t  Experience = "+exp);  
                  System.out.println("\n\t  Qualification = "+qual);  
                }

final float salary = 40000;
void dispSalary()
{
System.out.println("The Employee salary is :" +salary);
}
}


class PermanentTut extends Tutor{
double hike = 0.5;
void incrementSalary()
{
super.dispSalary();
System.out.println("The Permanent Tutor salary incremented is :" +(salary+(salary * hike)) );
}
}
class TemporaryTut extends Tutor{
double hike = 0.35;
void incrementSalary()
{
super.dispSalary();
System.out.println("The Temporary Tutor salary incremented is :" +(salary+(salary * hike)) );
}
}



class Course {   
    public String name;   
    public String description;   
    Course(String name, String description)   
    {   
        this.name = name;   
        this.description = description;   
    }   
    Course()   
    {   
        
    }  
    
    
    public void run()
    {
        Course z1 = new Course();
        Thread t2 = new Thread(z1);
        // Thread is created and its in new state.
        t2.start();
        // Now t2 is moved to runnable state
        System.out.println(
            "state of t2 Thread, post-calling of start() method is"
            + " " + t2.getState());
        // create a try-catch block to set t1 in waiting
        // state
        try {
            Thread.sleep(202);
        }
        catch (InterruptedException i2) {
            i2.printStackTrace();
        }
        System.out.println("State of Thread t2 after invoking to method sleep() is"+ " " + t2.getState());
        try {
            t2.join();
        }
        catch (InterruptedException i3) {
            i3.printStackTrace();
        }
        System.out.println("state of Thread t2 after completing the execution is"+ " " + t1.getState());
    }
}   



// Subject has more than one course.   
class Subject{   
    
    private final List<Course> courses;   
    Subject(List<Course> courses)  
    {  
        this.courses = courses;  
    }   
    // Getting total number of courses  
    public List<Course> getTotalCoursesInSubject()   
    {   
        return courses;   
    }   
}   






 class Student extends User implements Runnable{
	public int exp;
        	public int id;
        	public String password;
	public String name;
      public Address address;
    void login(){System.out.println("Student Login");} 
    
     public void run()
    {
        System.out.println(
            "Thread is Running Successfully");
    }
    
    
    
    
    
    
    
    
    //object by method
    public Student(int id, String name,   Address address)
    {
                this.id=id;
		this.name=name;
		this.address = address;
    }
  public Student()
    {
             
    }


   public void display()
   {

   System.out.print(id+", "+name);
   
   System.out.println(address.state +", "+address.city);

    }
   public void setPassword(String password) throws InvalidPassException
    {
        
        
        try{
       this.password=password;
      int value =  password.length();
      if(value <  8)
          throw new InvalidPassException("Type a longer password");
      
      
      
      
        }catch(InvalidPassException ab){ System.out.println("InvalidPassException");}
        
      
    }
   
   
 }


class RunnableDemo implements Runnable {
   private Thread t;
   private String threadName;
   
   RunnableDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
        
             
      }
    try {
            t.join();
        }
        catch (InterruptedException i3) {
            i3.printStackTrace();
        }
   }
}





 class Address  implements Runnable
{
String state,city;
public Address(String state,String city)
{
this.state=state;
this.city=city;
}



 public void run(){
        
        try{Thread.sleep(10000);}
        catch(InterruptedException e)
        {System.out.println(e);
        }  
        System.out.println("The Yearly profit is: "+ yearly_profit);
    }
}
 




abstract class User{  
abstract void login();  
}    
class Admin extends User{  
void login(){System.out.println("***** Login******");
}  




}  













 abstract class CourseManagement  implements Runnable
{
public static Thread t1;
public static CourseManagement o1;

public static void main(String args[])throws IOException,InvalidPassException,lessexpexception  {

//ABSTRACT
User s=new Admin();
s.login(); 

  
      RunnableDemo R1 = new RunnableDemo( "Thread-1");
      R1.start();
      
      RunnableDemo R2 = new RunnableDemo( "Thread-2");
      R2.start();
        
 try{
                Class temp = Class.forName( "ABC"); 
               }
            catch (ClassNotFoundException e2) {
               
                System.out.println(
                    "Class does not exist check the name of the class");
            }

      try{
              login user1 = new login();
              user1.setPassword("diiiivya");
            }
            catch(Exception e3){
            
                System.out.println(e3);
            }


 


System.out.println("-----------------------------------------------------------------------------------");
//STRING BUFFER
StringBuffer sBuffer=new StringBuffer ("Welcome---To---CMS");
System.out.println("Original String is ::: " + sBuffer + ":: having length " + sBuffer.length());
sBuffer.replace(0,9,"This is ");
System.out.println("Course Management system :: " + sBuffer + " :: having length " + sBuffer.length());
sBuffer.delete(0,7);
System.out.println("Modified String after delete is :: " + sBuffer);


System.out.println("-----------------------------------------------------------------------------------");
//STRING BUILDER
StringBuilder sb=new StringBuilder("WELCOME");  
sb.insert(0,"USER");//now original string is changed  
System.out.println(sb);


	        System.out.println("****************************");
		System.out.println("Enter '1' to login as Admin");
		System.out.println("Enter '2' to login as Student");
		System.out.println("Enter '3' to Exit");
            Scanner sc=new Scanner(System.in);
            int op = sc.nextInt();
System.out.println("Congrats! You have been successfully logged in as an admin!");


                                        System.out.println("******Course Management*******");
					System.out.println("Enter '1' to Create a New Course");
					System.out.println("Enter '2' to Delete a Course");
					System.out.println("Enter '3' to Edit a Course");
					System.out.println("Enter '4' to Display Information for a Given Course");
					System.out.println("Enter '5' to Register a Student");
                              System.out.println("Enter '6' to Register a Tutor");
					System.out.println("Enter '7' to Exit");
					int option = sc.nextInt();

System.out.println("Enter tutor details ");





Tutor tt = new Tutor();
tt.Enter_data();
tt.Display_data();


System.out.println("-----------------------------------------------------------------------------------");
//HEIRARCHIAL INHERITANCE
PermanentTut p = new PermanentTut();
TemporaryTut t = new TemporaryTut();
// All objects of inherited classes can access the variable of class Tutor
p.incrementSalary();
t.incrementSalary();


System.out.println("-----------------------------------------------------------------------------------");
//COMPOSITION
       
        Course c1   = new Course("Python", "Programming Fundamental in Python");   
        Course c2   = new Course("Java", "Programming Fundamental in Java");   
        Course c3   = new Course("C", "Programming Fundamental in C");   
        // Creating list which contains the no. of courses.   
        List<Course> course = new ArrayList<Course>();   
        course.add(c1);   
        course.add(c2);   
        course.add(c3);   
        Subject subject = new Subject(course);   
        List<Course> courses = subject.getTotalCoursesInSubject();   
        for (Course cg : courses) {   
        System.out.println("Name : " + cg.name + " , "  + " Description : " + cg.description); }

        
        
         List<String> listOfStr = new LinkedList<>();
        
        // Add Elements at the end of LinkedList
        listOfStr.add("Marks : 20");
        listOfStr.add("Marks : 30");
        listOfStr.add("Marks : 40");
        listOfStr.add("Marks : 50");
        listOfStr.add("Marks : 60");
        
        // Get ListIterator from List Object 
        // which points to 0th Position in List
        ListIterator<String> listIt = listOfStr.listIterator();
        
        System.out.println("Iterate List in forward Direction");
    
        // Iterate through LinkedList in forward direction
        while(listIt.hasNext())
        {
                        // Will return the element to which cursor points
                        // Also, increments the cursor to point to next location
            String temp = listIt.next();
            System.out.println(temp);
        }
        
        // Get ListIterator from List Object 
        // which points to 2nd Position in List
        listIt = listOfStr.listIterator(2);
        
        System.out.println("Start from 2nd Position : Iterate List in forward Direction");
    
        // Iterate through LinkedList in forward direction
        while(listIt.hasNext())
        {
            String temp = listIt.next();
            System.out.println(temp);
        }
System.out.println("-----------------------------------------------------------------------------------");



//AGGREGATION



Address a1= new Address("Kerala","Kannur");
Student s1= new Student(1,"Divya ",a1);

Student s2= new Student();
s2.setPassword("Tddd");
 HashSet<String> hashSet = new HashSet<String>();
 System.out.print("Student List");
      hashSet.add("Divya");
      hashSet.add("Priyanka");
      hashSet.add("Ankur");
      hashSet.add("Priya");
      hashSet.add("Amber");
      hashSet.add("Adarsh");
      
      System.out.println("HashSet = "+ hashSet);
      Set<String> set = new TreeSet<String>(hashSet);
      System.out.println("TreeSet = "+set);




s1.display();
 Result r = new Result("Divya",11,75,95);
  r.Percent_cal();
  r.display();

 
Test.Yes obj;
     Testing test = new Testing();
     obj=test;
     obj.show();


try{
 
 FileReader file = new FileReader("C:\Onedrive\Desktop\abc.txt");
  
        // Creating object as one of ways of taking input
        BufferedReader fileInput = new BufferedReader(file);
  
        // Printing first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++)
            System.out.println(fileInput.readLine());
  
        // Closing file connections
        // using close() method
        fileInput.close();
}catch(FileNotFoundException e){System.out.println("******File Not Found set correct path*****");}
  finally
        {
            System.out.println("finally block executed\n");
           
        }
         
pay pop = new pay() {
        
         public void showsalary() {
            System.out.println("Salary = 9090909");
         }
         public void showamount() {
            System.out.println("Amount = 7979797");
         }
      };
 

    
      pop.showpay();
      pop.showsalary();
      pop.showamount();
      
      
      
       Student g1 = new Student();
        // initializing Thread Object
        Thread t1 = new Thread(g1);
        t1.start();
        
        
        Admission reserve = new Admission(); // LINE A
        mAdmin thread1 = new mAdmin(reserve, 5); // LINE B
        thread1.start();
        mAdmin thread2 = new mAdmin(reserve, 4);
        thread2.start();
        mAdmin thread3 = new mAdmin(reserve, 2);
        thread3.start();
}



}




