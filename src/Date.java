import java.io.*; 
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
* Date class documentation here
* @author Michael Liang
*/
public class Date 
{ 
private int day; 
private int month; 
private int year; 
public Date() 
{ 
  day = 0;
  month = 0;
  year = 0;
} 
public Date(int d, int m, int y) 
{ 
 
	day = d;
	month = m;
	year = y;
}
public Date(Date other) 
{
//Create a clone from Date other


	day = other.day;
	month = other.month;
	year = other.year;
}  
public String monthAsString() 
{ 
//Method to convert month integer variable to a month String

	String Month = Integer.toString(month);
	return Month;

} 
/**
 * compare one date with another to see if they are the same
 * @param other = date
 * @return true or false
 */
public boolean equals(Date other) 
{ 
//Returns true if day, month and year are all equal 
            //to the corresponding fields in other


	if(day == other.day && month == other.month && year == other.year)
	{
		return true;
	}
	else 
	{
		return false;
	}
} 
/**
 * compare one date with another to see if one is earlier than the other
 * @param other = date
 * @return true or false
 */
public boolean earlierThan(Date other) 
{ 
//Check if Date is earlier than Date Other


	if(  year+13< other.year) //minimum of age 13 is required to work 
	{
		return true;
	}
	else 
	{
		return false;
	}
} 
/**
 * compare one date with another too see if they are the same
 * 
 * @return a date value in String
 */
public String toString() 
{ 
//Override the toString() method of the Object class


	return( day +"/"+month+"/"+year+"/");
} 

}