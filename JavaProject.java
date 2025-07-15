package JavaProject;


//abstract class User for all users(Student,Admin,Instructor)
abstract class User{
//all variables are accessible by using getter/setter method
	private String name;
	private String email;
	private String userID;
//all getter methods 	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUserID() {
		return userID;
	}
//all setter methods
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
//Parameterized constructor of the User class to initialize the object
	User(String name,String email,String userID){
		this.name=name;
		this.email=email;
		this.userID=userID;
	}
//Abstract method to be implemented by subclasses for showing profile	
	public abstract void viewProfile();
//Final method in use for constant - cannot be overridden, common to all users
	final void displayWelcome() {
		System.out.println("\n Hello, welcome to the EduSmart LMS project " );
	}
	
}

//Interface to be implemented by class that can track course progress
interface ProgressTrackble{
	 abstract void trackProgress();
}

//class Student extends the Parent class User which also implements the interface ProgressTrackable
class Student extends User implements ProgressTrackble{
	 
	 private String enrolledCourse1;
	 private String enrolledCourse2;
//all getter methods 
	 public String getEnrolledCourse1() {
		return enrolledCourse1;
	}
	 
	 public String getEnrolledCourse2() {
		 return enrolledCourse2;
	 }
//all setter methods
   public void setEnrolledCourse1(String enrolledCourse1) {
		 this.enrolledCourse1 = enrolledCourse1;
	 }
   
   public void setEnrolledCourse2(String enrolledCourse2) {
		 this.enrolledCourse2 = enrolledCourse2;
	 }
//Parametrized constructor of child class Student which intialize the User fields	
	 
   Student(String name, String email, String userID) {
		super(name, email, userID);
		this.enrolledCourse1 =null;
		this.enrolledCourse2=null;
		
	}
//Method to enroll the course    

	 public void enrollCourse(String courseName) {
		 if (this.enrolledCourse1 == null) {
	            this.enrolledCourse1 = courseName;
	        } else if (this.enrolledCourse2 == null) {
	            this.enrolledCourse2 = courseName;
	        } else {
	            System.out.println("Cannot enroll in more than 2 courses.");
	        }

}
//abstract method only defined in abstract class and we can implement in child class only 
	@Override
	 public void viewProfile() {
		System.out.println("Welcome to the student profile in EduSmart Project");
		System.out.println("\t Name of the student is " + getName());
		System.out.println("\t The email id of the student is " + getEmail());
		System.out.println("\t The userID of the student is " + getUserID());
		
		
	}
//Implementation of interface method to show progress
	public void trackProgress() {
		System.out.println("\t The progress of the student track is " + getName());
	}
}
//class Instructor inherits the all properties of the Parent class User
class Instructor extends User{
	private String createdCourse1;
	private String createdCourse2;
//All getter methods
	public String getCreatedCourse1() {
		return createdCourse1;
	}
	
	public String getCreatedCourse2() {
		return createdCourse2;
	}
//All setter Methods
  public void setCreatedCourse1(String createdCourse1) {
		this.createdCourse1 = createdCourse1;
	}

  public void setCreatedCourse2(String createdCourse2) {
		this.createdCourse2 = createdCourse2;
	}
//Parameterized constructor initialize the field of the Parent class by using super keyword	
	Instructor(String name, String email, String userID) {
		super(name, email, userID);
//this keyword is used to initialize the current class object.
		this.createdCourse1=null;
		this.createdCourse2=null;
		
	}
	
	
	
//Method:createCourse(StringcourseName)→ storecoursename incomplete	
	void createCourse(String courseName) {
		 if (this.createdCourse1 == null) {
	            this.createdCourse1 = courseName;
	        } else if (this.createdCourse2 == null) {
	            this.createdCourse2 = courseName;
	        } else {
	            System.out.println("Cannot create more than 2 courses.");
	        }

		
	}

@Override
public void viewProfile() {
	System.out.println(" Welcome to the instructor profile in EduSmart Project ");
	System.out.println("\t The name of the instructor is " + getName());
	System.out.println("\t The email id of the instructor is " + getEmail());
	System.out.println("\t The userID of the instructor is " + getUserID());
	
	
}
	
}
//Admin class extends abstract class User (Inheritance)
class Admin extends User{
	
	 // Constructor calls the superclass constructor (super)
	Admin(String name, String email, String userID) {
		super(name, email, userID);
		
	}
	 // Method to simulate removing a user from the system
	 public void removeUser(User user) {
		System.out.println("\t Removed user is " + user.getName());
		
	}

	@Override
	 public void viewProfile() {
		System.out.println(" Welcome to the Admin profile in EduSmart Project ");
		System.out.println("\t Name of Admin: " + getName());
		System.out.println("\t Email of Admin: " + getEmail());
		System.out.println("\t UserID of Admin: " + getUserID());
		
		
		
	}
	
}

class Course{
	private String title;
	private int durationInHours;
	final int maxStudents=15;
	
//parameterized constructor called Course to initialize the current class object by using this keyword	
	Course(String title,int durationInHours,int maxStudents){
		
		this.title=title;
		this.durationInHours=durationInHours;
		
	}
	// Constructor Overloading:
  // Constructor to initialize only title
	Course(String title){
		
		
		this.title=title;
		
	}
	
	void showCourseDetails() {
		System.out.println("\n Welcome to the Course Details in EduSmart Project");
		System.out.println("\t Title of the course is " + title);
		System.out.println("\t Duration in hours of the class is: " + durationInHours);
		System.out.println("\t Maximun students who enrolled the course is: " + maxStudents);
		
	}
}



public class EduSmart {

	public static void main(String[] args) {
		Student s1 = new Student("Porto ", "portoranan18@gmail.com " , "Porto78");
		Student s2 = new Student("Braga ", "Braga456@gmail.com " , "Braga0");
		
		s1.enrollCourse("Automation Course	");
		s1.enrollCourse("Software QA");
		s1.viewProfile();
		s1.trackProgress();
		s1.displayWelcome();
		
		s2.enrollCourse("CDPL");
		s2.enrollCourse("Mahesh Academy");
		s2.viewProfile();
      s2.trackProgress();
		s2.displayWelcome();
		
		
		
		
		Instructor i1 = new Instructor("Mohsin ","mohsinp9893@gmail.com "," MCP1"); 
		Instructor i2 = new Instructor("Mohit ","mohit@gmail.com "," MT12"); 
		
		i1.createCourse("Valia College");
		i1.createCourse("Automation course");
		i1.viewProfile();
		i1.displayWelcome();
		
		i2.createCourse("AI Course");
		i2.createCourse("Automation QA");
		i2.viewProfile();
		i2.displayWelcome();
		
		Admin admin = new Admin("Aidetech " ,"aidetech@gmail.com ", " AD1");
		admin.viewProfile();
      admin.displayWelcome();
		admin.removeUser(s1);
		admin.removeUser(s2);
		
		Course c1 = new Course("Cinute Academy", 45, 21);
		c1.showCourseDetails();
      Course c2 = new Course("Automation Course");
		c2.showCourseDetails();
		

	}

}