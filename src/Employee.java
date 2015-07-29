import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
/**
* Employee class documentation here, inherited from Person class
* @author Michael Liang
*/
public class Employee extends Person implements Serializable
{ 
//protected variables 

protected  String jobTitle; 
       protected Date start; 
       protected float salary; 
       protected BufferedImage imageFile;
       private static final long serialVersionUID = 1L;
<<<<<<< HEAD
       private long id= null; //can be used to identify an employee
       public long getEmpId(){
    	   return id;
       }
=======
       private Long id = null;
       private String phoneNo="";
       private String natInsNo="";
       

>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
public Employee() 
{ 
//Default constructor
name = "";
gender = ' ';
dateOfBirth = null;

start = null;
} 
<<<<<<< HEAD
public Employee(String name, char gender, Date dob, long eid, Date estart) 
=======
public Employee(String name, char gender, Date dob, Date estart) 
>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
{ 
//Constructor to set employee variables

	super(name,gender,dob);
<<<<<<< HEAD
	id=eid;
=======
	//id=eid;
>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
	start=estart;	
} 


/**
 * method to retrive employee name
 * return name
 */
public String getName()
{
	return name;
}
/**
 * method to retrive employee gender
 * return gender
 */
public String getGender()
{
	return String.valueOf(gender);
}
/**
 * method to retrive employee dob
 * return dob
 */
public String getDOB()
{
	return dateOfBirth.toString();
}
/**
 * method to retrive employee's id
 * return id
 */
<<<<<<< HEAD
public long getID()
=======
public Long getID()
>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
{
	return id;
}
/**
 * method to retrive employee start date
 * return start date in string
 */
public String getStartDate()
{
	return start.toString();
}
/**
 * method to set salary for employee
 * @param aSalary salary of employee
 */
public void setSalary(float aSalary) 
{
//Setter method to alter salary 
	salary = aSalary;
} 
/**
 * retrieve salary
 * @return salary
 */
public float getSalary() 
{
//Getter method to return salary
return salary;
} 
/**
 * set employee's job title
 * @param aJobTitle
 */
public void setJobTitle(String aJobTitle) 
{
//Setter method to alter the job title String
	jobTitle = aJobTitle;
}
/**
 * retrive employee's job title
 * @return jobtitle
 */
public String getJobTitle() 
{
//Getter method to return the job title string
	return jobTitle;
} 
/**
 * set employee's image
 * @param image
 */
public void setEmployeeImage(BufferedImage image)
{
	imageFile = image;
}
/**
 * retrive employee's image
 * @return employee's imagefile
 */
public BufferedImage getEmployeeImage()
{
	return imageFile;
}
/**
 * 
 * @return employee's first name
 */
public String getFirstName(){
	String firstName;
	String[] names=name.split(" ");
	firstName = names[0];
	return firstName;
}
/**
 * @return employee data in string
 */
public String toString() 
{ 
//Override the toString() method of the Object class
	return(name+","+ gender+","+dateOfBirth+","+id+ ","+jobTitle+","+start+","+salary);
} 
public int hashCode() {
<<<<<<< HEAD
return this.getEmpId().intValue();
=======
	return this.getID().intValue();
>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
}
public static long getSerialVersionUID() {
return serialVersionUID;
}
<<<<<<< HEAD
=======
public void setID(Long id){
	this.id=id;
}

public void setstartDate (Date astart){
	start = astart;
}
>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
} 