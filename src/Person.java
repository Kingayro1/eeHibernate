import java.io.*; 
/**
 * Person class documentation here
 * @author Michael
 *
 */
public abstract class  Person 
{ 
      protected String name;
      protected char gender; 
      protected Date dateOfBirth; 
      protected String address; 
      protected String natInsceNo; 
      protected String phoneNo; 

      public Person() 
{ 
          name =""; //default constructor
    	  gender =' ';
    	  dateOfBirth = new Date();
    	  address = "";
    	  natInsceNo = "";
    	  phoneNo = "";
    	  
} 

      public Person(Person other) 
{
//Create a clone from Person other


    	  name = other.name;
    	  gender = other.gender;
    	  dateOfBirth = other.dateOfBirth;
    	  address = other.address;
    	  natInsceNo = other.natInsceNo;
    	  phoneNo = other.phoneNo;
} 

      public Person(String aName, char sex, Date dob) 
{ 
//Constructor to set class variables name, gender and dateOfBirth


    	  name = aName;
    	  gender = sex;
    	  dateOfBirth = dob;
}
      /**
       * set a person's name
       * @param aName, name of the person to have
       */
      public void setName(String aName) 
{  
//Setter method to alter the Person aName string


    	  name = aName;
} 
/**
 * set person's address
 * @param addr
 */
      public void setAddress(String addr) 
{ 
//Setter method to alter the Person address string


    	  address = addr;
} 
/**
 * set person's nation insurance number
 * @param ins
 */
      public void setNatInsNo(String ins) 
{ 
//Setter method to alter the Person national insurance number


    	  natInsceNo = ins;
} 

      /**
       * set person's phone number
       * @param phone
       */
      public void setPhone(String phone) 
{ 
//Setter method to alter the Person phone number
 
    	  phoneNo = phone;
} 
/**
 *  retrive a person's name
 * @return person's name
 */
      public String getName() 
{ 
//Getter method to return the Person name String


    	  return name;
} 
      /**
       * get person's gender
       * @return gender in char
       */
      public String getGender()
      {
    	  String str=String.valueOf(gender);
    	  return str ;
      }
      /**
       * retrive person's dob
       * @return date of birth
       */
      public String getDOB()
      {
    	  String DOB = dateOfBirth.toString();
    	  return DOB;
      }
      /**
       * 
       * @return person's address
       */
      public String getAddress() 
{ 
//Getter method to return the Person address String


    	  return address;
} 
/**
 * 
 * @return national insurance number
 */
      public String getNatInsNo() 
{ 
//Getter method to return the Person national insurance String
    	  return natInsceNo;
} 

      /**
       * 
       * @return national phone number
       */
      public String getPhone() 
{ 
//Getter method to return the Person phone number
 	  
    	  return phoneNo;
}
      /**
       * check if one person equals another person
       * @return true or false
       */
      public boolean equals(Person other) 
{ 
// return true if name, dateOfBirth and national insurance number are same 

    	  if(name == other.name && dateOfBirth == other.dateOfBirth && natInsceNo == other.natInsceNo)
    	  {
    		  return true;
    	  }
    	  else{
    		  return false;
    	  }
} 

      /**
       * return person's data in string
       */
      public String toString() 
{ 
//Override the toString() method of the Object class


    	  return("The name of this person is "+name+", gender is "+ gender+", date of birth is"+ dateOfBirth+", nation insurance number is "+ natInsceNo+", address is"+ address+", phone number is "+phoneNo+".");
}

	
} 