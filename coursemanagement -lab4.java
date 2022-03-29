import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;  
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import static javax.swing.JOptionPane.showMessageDialog;
import java.time.format.DateTimeFormatter;  
 
 class CourseManagement{
	public static void main(String args[]){

        //multiple object by one type
        tutor t1=new tutor(12,"Divya","Maths",5,567,5,700, "11:00:00"), t2=new tutor(14,"Priya","Science",5,567,5,700, "11:00:00");

        //shallow copy
        tutor d3 = d2;
        System.out.println("Shallow Copy: *** Before changes ***");
        System.out.println("Tutor id: "+t2.id+", Name: "+t2.name);
        System.out.println("Tutor id: "+t3.id+", Name: "+t3.name);
        t3.name="Arjun";
        System.out.println("Shallow Copy: *** After changes ***");
        System.out.println("Tutor id: "+t2.id+", Name: "+t2.name);
        System.out.println("Tutor id: "+t3.id+", Name: "+t3.name);

        //copy constructor - shallow
        System.out.println("Copy constructor - Shallow: *** Before changes ***");
        doctor d4 = new doctor(d2);
        System.out.println("Doctor id: "+d2.id+", Name: "+d2.name);
        System.out.println("Doctor id: "+d4.id+", Name: "+d4.name);
        d4.name="Adarsh";
        System.out.println("Copy constructor - Shallow: *** After changes ***");
        System.out.println("Doctor id: "+d2.id+", Name: "+d2.name);
        System.out.println("Doctor id: "+d4.id+", Name: "+d4.name);

        //deep copy
        login new_user1 = new login();
        new_user1.userName="Ankur";
        new_user1.type="patient";
        login new_user2 = new login();
        new_user2.userName = new_user1.userName;
        new_user2.type = new_user1.type;
        System.out.println("Deep Copy: *** Before changes ***");
        System.out.println("Username: "+new_user1.userName+" login type: "+new_user1.type);
        System.out.println("Username: "+new_user2.userName+" login type: "+new_user2.type);
        new_user2.userName = "Pradeep";
        System.out.println("Deep Copy: *** After changes ***");
        System.out.println("Username: "+new_user1.userName+" login type: "+new_user1.type);
        System.out.println("Username: "+new_user2.userName+" login type: "+new_user2.type);

        Address address = new Address("Bangalore","Karnataka");

        //array of objects
        patient[] patients=new patient[5];  
        patients[0] = new patient(12,"Ankur", 545678990, "2022-12-03", address); 
        patients[1] = new patient(14,"Pradeep", 789098990, "2022-03-26", address);
        
        //copy constructor - deep
        patients[2] = new patient(patients[0]);
        System.out.println("Copy constructor - deep: *** Before changes ***");
        System.out.println(patients[0].address.city+" "+patients[0].address.state); 
        System.out.println(patients[2].address.city+" "+patients[2].address.state);
        patients[2].address.city = "Meruth";
        patients[2].address.state = "UP";
        System.out.println("Copy constructor - deep: *** After changes ***");
        System.out.println(patients[0].address.city+" "+patients[0].address.state); 
        System.out.println(patients[2].address.city+" "+patients[2].address.state);

        //object using reference variable
        payment pay = new payment(103, 12, 2, "2022-12-03", "UPI");

        //Anonymous Class Extending a Class
        payment t = new payment(103, 12, 2, "2022-12-03", "UPI") {
            public void generate_bill(){
                System.out.println("------------------");
                System.out.println("*** Anonymous Class ***");
                System.out.println("Doctor id: "+d1.id+", Name: "+d1.name);
                System.out.println("Payment id: "+pay.id+", Fees: "+pay.total_amount);
            }
        };
        t.generate_bill();
        System.out.println("Patient id: "+patients[0].id+", Name: "+patients[0].name);
            
        appointment schedule = new appointment();
        schedule.display();
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

 class doctor{
	public int id;
	public String name;
	public String designation;
    public int experience;
    public int mobileNo;
    public int rating;
    public float fees;
    public LocalTime timing;
	
    public doctor(int id, String name, String designation, int experience, int mobileNo, int rating, float fees, String timing)
    {
        this.id=id;
		this.name=name;
        this.designation=designation;
		this.experience=experience;
		this.mobileNo=mobileNo;
        this.rating=rating;
		this.fees=fees;
        this.timing=LocalTime.parse(timing);
	}

//copy constructor - shallow
    public doctor(doctor doc){
        this.id=doc.id;
		this.name=doc.name;
        this.designation=doc.designation;
		this.experience=doc.experience;
		this.mobileNo=doc.mobileNo;
        this.rating=doc.rating;
		this.fees=doc.fees;
        this.timing=doc.timing;
    }

	public void updatTime(String new_timing){
        String data;
        Scanner sc=new Scanner(System.in);
        data = sc.next();
        this.timing=LocalTime.parse(new_timing); 
        sc.close();
        System.out.println("Patient symtom description: "+data);
    }

    public void updatFees(float new_fees){
        this.fees=new_fees;
    }

    public void accept_appointment(boolean accept){
        if(accept == true){
            System.out.println("Appointment is Accepted");
        }
        else{
            System.out.println("Appointment is Rejected");
        }
    }    
}

 class patient{
	public int id;
	public String name;
    public int mobileNo;
    public LocalDate consult_date;
    public Address address;

    //object by method
    public patient(int id, String name, int mobileNo, String consult_date, Address address)
    {
        this.id=id;
		this.name=name;
		this.mobileNo=mobileNo;
        this.consult_date=LocalDate.parse(consult_date);
        this.address = address;
    }

    //copy constructor - deep
    public patient(patient patient)
    {
        this.id=patient.id;
		this.name=patient.name;
		this.mobileNo=patient.mobileNo;
        this.consult_date=patient.consult_date;
        this.address = new Address(patient.address); //Deep Copying
    }

    public void enterData(){
        String data;
        Scanner sc = new Scanner(System.in);
        data = sc.next();
        System.out.println("Patient note: "+data);
        sc.close();
    }

//fuction overloading
    public void search_doctor(int doctor_id){
        //object by reference variable
        doctor doc = new doctor(12,"Ankur","dentist",5,567,700,5,"11:00:00");
        if(doc.id == doctor_id){
            System.out.println("You searched for : "+doc.name+". Contact number = "+doc.mobileNo);
        }
        else{
            System.out.println("Doctor id NOT FOUND");
        }
    }
//number of arguments
    public void search_doctor(String name, String designation){
        //object by reference variable
        doctor doc = new doctor(12,"Ankur","dentist",5,567,700,5,"11:00:00");
        if(doc.name == name && doc.designation == designation){
            System.out.println("You searched for : "+doc.id+". Contact number = "+doc.mobileNo);
        }
        else{
            System.out.println("Doctor id NOT FOUND");
        }
    }
//datatype overloading
    public void search_doctor(String name){
        //object by reference variable
        doctor doc = new doctor(12,"Ankur","dentist",5,567,700,5,"11:00:00");
        if(doc.name == name){
            System.out.println("You searched for : "+doc.id+". Contact number = "+doc.mobileNo);
        }
        else{
            System.out.println("Doctor id NOT FOUND");
        }
    }

    public void rate_doc(int doctor_id, int rating){
        doctor doc = new doctor(12,"Ankur","dentist",5,567,700,5, "11:00:00");
        if(doc.id == doctor_id){
            doc.rating = rating;
        }
        else{
            System.out.println("Doctor id NOT FOUND");
        }
    }

    public void reschedule(String newTime){
        appointment schedule = new appointment(12,"11:00:00","2022-12-03",103,12);
        schedule.timing = LocalTime.parse(newTime);
    }
}

class appointment{
	public int id;
	public int patient_id;
    public int doctor_id;
    public LocalTime timing;
	public LocalDate date;	

//constructor chaining
    public appointment()
    {
     //this will call the constructor with (int, String, String) parameters
        this(102,"12:30:00","2022-03-26");
    }

    public appointment(int id, String timing, String date)
    {
     //call the constructor with (int, String, String, int, int) parameters
     this(id, timing, date, 12, 102);
    }

    public appointment(int id, String timing, String date, int patient_id, int doctor_id)
    {
     this.id=id;
     this.patient_id=patient_id;
     this.doctor_id=doctor_id;
     this.timing=LocalTime.parse(timing);
     this.date=LocalDate.parse(date);    
    }

    public void display() {
     System.out.println("Appointment id: "+id);
     System.out.println("Patient id: "+patient_id);
     System.out.println("Doctor id: "+doctor_id);
     System.out.println("Timing: "+timing);
     System.out.println("Date: "+date);
    }

    public void change_time(String new_time){
        this.timing=LocalTime.parse(new_time);
    }

    public void change_date(String new_date){
        this.date=LocalDate.parse(new_date);
    }

    public void cancel(boolean appointment_status){
        if(appointment_status == false){
            System.out.println("Cancled Appoinment");
        }
    }
}

 class payment{
    public int id;
    public int student_id;
    public float total_amount;
    public LocalDate pay_date;
    public String pay_method;

    public payment(int id, int student_id, String pay_date, String pay_method)
    {
        this.id=id;
        this.student_id=student_id;
        this.pay_date=LocalDate.parse(pay_date);
        this.pay_method=pay_method;
        this.calculate_fees();
    }

    public void calculate_fees(){
        float platform_charge = 67, hourly = 150;
        doctor doc = new doctor(12,"Ankur","dentist",5,567,700,5, "11:00:00");
        this.total_amount = doc.fees + platform_charge + (hourly*this.hours);
    }

    public void change_method(String new_method){
        this.pay_method = new_method;
    }

    public void generate_slip(){
        System.out.println("Transaction id: "+this.id);
        System.out.println("Patient id: "+this.patient_id);
        System.out.println("Paid Fees: "+this.total_amount);
        System.out.println("Date: "+this.pay_date);
    }

    public void inform_paitient(boolean payment_status){
        if(payment_status == true){
            showMessageDialog(null, "Payment Successfull for id = "+this.id);
        }
        else{
            showMessageDialog(null, "Payment NOT Successfull for id = "+this.id);
        }
    }
}

