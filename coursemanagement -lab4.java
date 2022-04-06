import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;  
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import static javax.swing.JOptionPane.showMessageDialog;
import java.time.format.DateTimeFormatter;  
 
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

 

class Address
{
    public String city;
    public String state;
    
    public Address(String city, String state)
    {
        super();
        this.city = city;
        this.state = state;
    }

    public Address(Address address)
    {
        this.city = address.city;;
        this.state = address.state;
    }
}
