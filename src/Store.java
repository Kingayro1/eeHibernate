import java.awt.image.BufferedImage;
import java.io.*; 
import java.util.ArrayList;

import javax.swing.JTextArea;
/**
 * Store class documentations
 * @author Michael
 *
 */
public class Store 
{ 
private static int MAXSIZE; // holds the size of the array 
private static int count; // keeps count of number of  employees stored in array 
ArrayList <Person> List= new ArrayList<Person>();//Person [] list;
String listOfPeople = "";
public static int getCount() 
{ 
//Getter method to return the number of elements currently in store
	return count;
}
/**
 * check if store is full(not applicable, using arraylist)
 * @return true or false
 */
public static boolean isFull() 
{ 
//Returns true if no more space in store 
	if(count>=MAXSIZE)  //if count bigger or equal maxsize of store
	{
		return true; //then return true
	}
	else
	{
		return false; //else return false
	}
} 
public Store() 
{ 
//Default constructor

	count = 0;//default to be 0 employees
	MAXSIZE = 0;//no max size(0)

} 
/**
 * 
 * @return maxsize of the store
 */
public int maxSize()
{
	return MAXSIZE;
}
/**
 * set size of the store
 * @param size of the store will become
 */
public Store(int size) 
{ 
//Constructor which allow the size of the store to be specified


	MAXSIZE = size;
	
}
/**
 * create new store 
 * @param s
 */
public Store(Store s) 
{ 
//Create a Store from another Store s


	 s = new Store();
}
/**
 * method to add new employee to store
 * @param p
 */
public void add(Employee p) 
{ 
// Method to add Employee p to array 
	 for(int i = count; i!= count+1; i++)
	 {
		 List.add(i,p);		
	 }
	 count = count+1;
	
} 
/**
 * 
 * @return employee data in string, each record in a new line
 */
public String returnListOfEmployee(){
	for (int i = 0; i<getCount(); i++)
	{
		listOfPeople += List.get(i)+"\n";   //go through list variable and assign them to listOfPeople variable
	}
	return listOfPeople; //return the variable
	
}
/**
 * 
 * @param i store's index 
 * @return employee at index of i
 */
public Employee  returnEmployee(int i){
	return (Employee) List.get(i);
}
/**
 * 
 * @param i
 * @return employee's name 
 */

public String returnEmployeeName(int i){
	return List.get(i).getName();
}
/**
 * 
 * @param i
 * @return employee's gender 
 */
public String returnEmployeeGender(int i){
	return List.get(i).getGender();
}
/**
 * 
 * @param i
 * @return employee's dob 
 */
public String returnEmployeeDOB(int i){
	return List.get(i).getDOB();
}
/**
 * 
 * @param i
 * @return employee's salary 
 */
public String returnEmployeeSalary(int i){
	return Float.toString(returnEmployee(i).getSalary());
}
/**
 * 
 * @param i
 * @return employee's id 
 */
public String returnEmployeeID(int i){
	
	return returnEmployee(i).getID();

}
/**
 * 
 * @param i
 * @return employee's start date
 */
public String returnEmployeeStartDate(int i){
	return returnEmployee(i).getStartDate();
}
/**
 * 
 * @param i
 * @return employee's job title 
 */
public String returnEmployeeJob(int i){
	return returnEmployee(i).getJobTitle();
}
/**
 * 
 * @param i
 * @return employee's image
 */
public BufferedImage returnEmployeeImage(int i){
	return returnEmployee(i).getEmployeeImage();
}
/**
 * delete all records in store
 */
public void clearStore(){
	List.clear();
}
public void deleteEmployee(int i){
	List.remove(i);
}

}