import java.sql.*;

public class JDBC {
	static Connection connection = null;
	
	
	

	
	/*try{
	Statement statement=null;
	statement= connection.createStatement();
	String sql="select * from employees join emp on employees.employee_id = emp.employee_id";
	
	ResultSet rs = statement.executeQuery(sql);
	while (rs.next()){
		int id = rs.getInt("employee_id");
		String fname = rs.getString("first_name");
		String lname = rs.getString("last_name");
		System.out.println("employee id"+id);
		System.out.println("first name "+fname);
		System.out.println("last name"+lname);
	}
	} catch(Exception e){e.printStackTrace();}*/
	
	
/*
	
public String getCustDetails(String name){
	String sql="select first_name,last_name,company_name,phone1,email from customer2"
			+ "where first_name = "+name+" or last_name ="+name;
	
	Statement statement=null;
	String fname ="";
	String lname ="";
	String companyname ="";
	String phoneNum ="";
	String email="" ;
	
	
	try{
	statement = connection.createStatement();
	ResultSet rs = statement.executeQuery(sql);
	fname = rs.getString("first_name");
	lname = rs.getString("last_name");
	 companyname= rs.getString("company_name");
	phoneNum = rs.getString("phone1");
	email = rs.getString("email");
	
	
	
	}catch(Exception e){e.printStackTrace();}
	return("Customer name: "+fname+" "+lname+", "+"Company name: "+companyname+", phone number: "+ phoneNum+", email: "+email);
} */
	

public  void connectDatabase(){

	String username="system";
	String password="Kingayro1";
	 String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	try{
		 connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
				,username,password);
		System.out.println("Successfully connected to database");
		}
		catch(Exception e){
			System.out.println("Failed to connect to database");
		}
}

public void addEmployee(Employee emp){
	try{
	if(connection.isClosed()==true){
		System.out.println("Connection failed");
	}
	}catch(Exception e){
		System.out.println("Connection successful");
	}
}
}
