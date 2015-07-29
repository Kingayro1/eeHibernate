import java.awt.Container;
<<<<<<< HEAD
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

=======

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;


/**
 * Document GUI class
 * @author Michael Liang
 */
public class GUI extends JFrame {
	/**
	* The purpose of this class is to create the interfaces for adding and displaying records, and also include code of the components 	 
	* @author    Michael Liang 
	*/
	Container GUIContainer;
	ImagePanel myImagePanel;
	JDBC jdbc = new JDBC();
    JPanel Panel1;
    JPanel Panel2,Panel2a,Panel2b,Panel2c;
    JPanel displayPanel,searchPanel;
<<<<<<< HEAD
    ApplicationContext ct = new ClassPathXmlApplicationContext("bean.xml");
=======

>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	int count=0;
	Store newStoreFile;
<<<<<<< HEAD
	Employee newEmployee = (Employee) ct.getBean("employee") ;
=======
	Employee newEmployee = new Employee() ;
>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
	Employee foundRecord;
	Store employeeRecords = new Store();
	
	//declare components which will be placed on container;
	//declare container where contents will place on
	JLabel messageLabel,nameLabel, gendLabel, dobLabel, salaryLabel,natInsurNoLabel, phoneLabel, startDateLabel, jobLabel,titleLabel, maleLabel, femaleLabel;
	JLabel empNameLabel, empGendLabel, empDOBLabel, empSalaryLabel, empIDLabel, empStartDateLabel, empJobLabel;
	//declaring labels
	JButton enterBtn, clearBtn,nextBtn,prevBtn,imageBtn,searchBtn;
	JComboBox dobDateBox, dobMonthBox, dobYearBox;
	JComboBox startDateBox, startMonthBox, startYearBox;
	JTextField nameField, salaryField, natInsurNoField, phoneNoField, jobTitleField,searchField;

	BufferedImage image;
	

	GridBagConstraints c = new GridBagConstraints();
	//constraints which will be applied for grid bag layout, in  varibale c
	
	
	JMenuBar menuBar;
	JMenu fileMenu, recordMenu;
	JMenuItem newFileItem, saveFileItem, openFileItem,exitFileItem, addRecordItem, displayRecordItem,clearRecordItem,searchRecordItem;
	
	String name, natInsurNo, phoneNo, jobTitle, eid;
	char gender;
	float salary;
	Date dob, startDate;

	String searchTerm,message;
	
	
	JRadioButton maleButton; 
	JRadioButton femaleButton;
	ButtonGroup radioButtonGroup;
	
	JFileChooser fc = new JFileChooser();
	
	File file;

	
	/**
	 * convert a date value in string type variable to the date format
	 * @param a = date value in string e.g. "12/12/13"
	 */
	public Date convertStringToDate(String a) //method to convert a string value to date type value
	{
		
		String word[] = a.split("/"); //split string using "/", e.g. 12/01/92 would give 12 01 92. Store those values in word string array variable
		int aday = Integer.parseInt(word[0]);   //word 0 (e.g. 12) is converted to integer and assigned to variable
		int amonth = Integer.parseInt(word[1]);
		int ayear = Integer.parseInt(word[2]);
		Date adate = new Date(aday,amonth,ayear); //assign converted variables to date constructor 
		return adate; //return the date value 
		
	}

	GUI() {
		/**
		 Creating all components for the user interface
		 */
		super("Employee record system");//call constructor from JFrame using super syntax
	
		
		myEventHandler h = new myEventHandler();
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);  //create menu bar
		
		fileMenu = new JMenu("File");  //create menu bar, menus and menu items
		recordMenu = new JMenu ("Record");  
		
		newFileItem = new JMenuItem("New");		
		saveFileItem = new JMenuItem("Save");
		openFileItem = new JMenuItem("Open");
		addRecordItem = new JMenuItem("Add");
		clearRecordItem = new JMenuItem("Clear");
		displayRecordItem = new JMenuItem("Display");
		searchRecordItem = new JMenuItem("Search");
		exitFileItem = new JMenuItem("Exit");
		
		newFileItem.addActionListener(h);
		saveFileItem.addActionListener(h);
		openFileItem.addActionListener(h);
		addRecordItem.addActionListener(h);
		clearRecordItem.addActionListener(h);
		displayRecordItem.addActionListener(h);
		searchRecordItem.addActionListener(h);
		exitFileItem.addActionListener(h);
		
		menuBar.add(fileMenu);   //add menu bar / menu / menu items
		fileMenu.add(newFileItem);
		fileMenu.add(saveFileItem);
		fileMenu.add(openFileItem);
		fileMenu.add(exitFileItem);
		menuBar.add(recordMenu);
		recordMenu.add(addRecordItem);
		recordMenu.add(clearRecordItem);
		recordMenu.add(displayRecordItem);
		recordMenu.add(searchRecordItem);
	
		GUIContainer=this.getContentPane();   
	    GUIContainer.setLayout(new GridBagLayout());  //set grid bag layout
	    
	    Panel1 = new JPanel(new GridBagLayout());
	    Panel2 = new JPanel(new GridBagLayout());
	    Panel2a = new JPanel(new GridBagLayout());
	    Panel2b = new JPanel(new GridBagLayout());
	    Panel2c = new JPanel(new GridBagLayout());
		
	    Font f = new Font("Dialog", Font.PLAIN, 16);    //set font size, style 	    
	    titleLabel = new JLabel ("Employee record system");
	    titleLabel.setFont(f);    //apply font settings to titlelabel's text
	    c.gridx=0;
		c.gridy=0;		//on grid 0,0 (top left)
		c.anchor = GridBagConstraints.NORTH;  //set component to be at the top(north)
		c.weighty=0.5;
		c.gridheight= 2;  //1 cell high
		c.gridwidth=GridBagConstraints.HORIZONTAL;
		this.getContentPane().add(titleLabel,c);  //add component with the constraints on container.

		//adding items on the components
		nameLabel = new JLabel("Enter name");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		c.ipady=10;

		Panel1.add(nameLabel,c);
		
		gendLabel = new JLabel("Select Gender");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth=1;
		c.gridheight=1;
		
		c.anchor = GridBagConstraints.WEST;
		Panel1.add(gendLabel,c);
		
		dobLabel = new JLabel("Select Date of Birth");
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth=1;
		c.gridheight=1;
		
		c.anchor = GridBagConstraints.WEST;
		Panel1.add(dobLabel,c);
		
		salaryLabel = new JLabel("Enter Salary");
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		Panel1.add(salaryLabel,c);
		
		natInsurNoLabel = new JLabel("Enter National insurance No");
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		Panel1.add(natInsurNoLabel,c);
		
		phoneLabel = new JLabel("Enter Phone number");
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		Panel1.add(phoneLabel,c);
		
		startDateLabel = new JLabel("Enter Start date");
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		Panel1.add(startDateLabel,c);
		
		jobLabel = new JLabel("Enter Job title");
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		Panel1.add(jobLabel,c);
		
		enterBtn = new JButton ("Enter");		
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth=1;
		c.gridheight=1;
		Panel1.add(enterBtn,c);
		enterBtn.addActionListener(h);
		
		nameField = new JTextField(10);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth=3;
		c.gridheight=1;
		c.ipady=0;
        Panel2.add(nameField,c);
		
		salaryField = new JTextField(10);
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth=3;
		c.gridheight=1;
		c.ipady=3;
		Panel2.add(salaryField,c);
		
		natInsurNoField = new JTextField(10);
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth=3;
		c.gridheight=1;	
		c.ipady=3;
		Panel2.add(natInsurNoField,c);
		
		phoneNoField = new JTextField(10);
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth=3;
		c.gridheight=1;		
		Panel2.add(phoneNoField,c);
		
		jobTitleField = new JTextField(10);
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth=3;
		c.gridheight=1;
		c.ipady=3;
		Panel2.add(jobTitleField,c);

		//************adding radio boxes
		maleButton = new JRadioButton();
		c.gridx = 0;
		c.gridy = 0;
		
		c.gridwidth=1;
		c.gridheight=1;		
		
		Panel2a.add(maleButton,c);
		
		femaleButton = new JRadioButton();
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight=1;	
		
		Panel2a.add(femaleButton,c);
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(maleButton);
		radioButtonGroup.add(femaleButton);

		//************adding combo boxes
		dobDateBox = new JComboBox<String>();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight=1;	
		for(int k =1;k<=31;k++)
		{
			dobDateBox.addItem(k);
		}
		Panel2b.add(dobDateBox,c);
		
		dobMonthBox = new JComboBox<String>();
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight=1;		
		for(int k =1;k<=12;k++)
		{
			dobMonthBox.addItem(k);
		}
		Panel2b.add(dobMonthBox,c);
		
		dobYearBox = new JComboBox<String>();
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight=1;
		for(int k =1900;k<=2015;k++)
		{
			dobYearBox.addItem(k);
		}
		Panel2b.add(dobYearBox,c);
		
		startDateBox = new JComboBox<String>();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight=1;
		for(int k =1;k<32;k++)
		{
			startDateBox.addItem(k);
		}
        Panel2c.add(startDateBox,c);
		
		startMonthBox = new JComboBox<String>();
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight=1;
		for(int k =1;k<=12;k++)
		{
			startMonthBox.addItem(k);
		}
        Panel2c.add(startMonthBox,c);
		
		startYearBox = new JComboBox<String>();
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight=1;
		for(int k =1900;k<=2015;k++)
		{
			startYearBox.addItem(k);
		}
		Panel2c.add(startYearBox,c);
		
		maleLabel = new JLabel("Male");
		c.gridx = 2;
		c.gridy = 0;
   
		c.gridwidth=1;
		c.gridheight=1;
		
		Panel2a.add(maleLabel,c);
		
		femaleLabel = new JLabel("Female");
		c.gridx = 4;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight=1;
		
		Panel2a.add(femaleLabel,c);
		
		clearBtn = new JButton ("Clear");		
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth=1;
		c.gridheight=1;
		c.ipady=10;
		Panel2.add(clearBtn,c);
		clearBtn.addActionListener(h);
		
		
		displayPanel=new JPanel(new GridBagLayout());
		//display interface components
		empNameLabel = new JLabel("Name:");// ("Name:"+ employeeRecords.get(i).getName());
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		displayPanel.add(empNameLabel,c);
		
		empDOBLabel = new JLabel("Date of birth:");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		displayPanel.add(empDOBLabel,c);
		//empNameLabel, empGendLabel, empDOBLabel, empSalaryLabel, empNatInsNoLabel, empStartDateLabel, empJobLabel
		empGendLabel = new JLabel ("Gender: ");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		displayPanel.add(empGendLabel,c);
		
		empSalaryLabel = new JLabel("Salary: ");
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		displayPanel.add(empSalaryLabel,c);
		
		empIDLabel = new JLabel("ID: ");
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		displayPanel.add(empIDLabel,c);
		
		empStartDateLabel = new JLabel("Start Date: ");
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		displayPanel.add(empStartDateLabel,c);
		
		empJobLabel = new JLabel("Job title: ");
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor = GridBagConstraints.WEST;
		displayPanel.add(empJobLabel,c);
		
		nextBtn = new JButton("Next record");
		c.gridx=1;
		c.gridy=7;
		c.anchor = GridBagConstraints.SOUTHEAST;
		c.ipadx=5;
		displayPanel.add(nextBtn,c);
		nextBtn.addActionListener(h);
		
		prevBtn = new JButton("Previous record");
		c.gridx=0;
		c.gridy=7;
		c.anchor = GridBagConstraints.SOUTHWEST;
		c.ipadx=5;
		displayPanel.add(prevBtn,c);
		prevBtn.addActionListener(h);
		
		imageBtn = new JButton("Choose image");
		c.gridx =4;
		c.gridy = 9;
		c.gridwidth=1;
		c.gridheight=1;
	
		Panel2.add(imageBtn,c);
		imageBtn.addActionListener(h);
		
		//search interface components;
		searchPanel = new JPanel();
		searchField = new JTextField(10);
		c.gridx=0;
		c.gridy=0;
		searchPanel.add(searchField,c);
		
		searchBtn = new JButton("Search");
		c.gridx=1;
		c.gridy=0;
		searchPanel.add(searchBtn,c);
		searchBtn.addActionListener(h);
	
		c.gridx=1;
		c.gridy=0;
		c.anchor=GridBagConstraints.SOUTH;
		GUIContainer.add(searchPanel,c);
		c.gridx=0;
		c.gridy=2;
		c.anchor=GridBagConstraints.WEST;
		Panel2.add(Panel2a,c);
		c.gridx=0;
		c.gridy=3;
		c.ipady=3;
		Panel2.add(Panel2b,c);
		c.gridx=0;
		c.gridy=7;
		Panel2.add(Panel2c,c);
		
		c.gridx=0;
		c.gridy=1;
		GUIContainer.add(Panel1,c);
		c.gridx=1;
		c.gridy=1;
		GUIContainer.add(Panel2,c);
		
		c.gridx=0;
		c.gridy=0;
		c.ipadx=10;
		c.anchor=GridBagConstraints.NORTHWEST;
		GUIContainer.add(displayPanel,c);

		myImagePanel=new ImagePanel();
		c.gridx = 1;
		c.gridy = 0;
		c.anchor=GridBagConstraints.NORTHEAST;
		myImagePanel.setPreferredSize(new Dimension(200,200));
		GUIContainer.add(myImagePanel,c);
		
				
		myImagePanel.setVisible(false);	
		displayPanel.setVisible(false);
		searchPanel.setVisible(false);
		
<<<<<<< HEAD
	
=======
		jdbc.connectDatabase();
>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
	}


	public class myEventHandler implements ActionListener {
		/**
		 * 
		 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==enterBtn){ //enter button code
			boolean dateValidated=true;
			boolean salaryValidated=true;
			//error checking for null values 
			if(nameField.getText() != null && maleButton.isSelected() == true || femaleButton.isSelected()==true && salaryField.getText() != null && natInsurNoField.getText() != null && phoneNoField.getText() != null && jobTitleField.getText() != null)
			{
			//assign values to variables				
			
			
			name = nameField.getText();
			if(maleButton.isSelected())
			{
				gender = 'M';				
			}
			if(femaleButton.isSelected())
			{
				gender='F';				
			}			
			dob = new Date(Integer.parseInt(dobDateBox.getSelectedItem().toString()),Integer.parseInt(dobMonthBox.getSelectedItem().toString()),Integer.parseInt(dobYearBox.getSelectedItem().toString()));
			//convert object to string then to integer and store in dob variable
			startDate = new Date(Integer.parseInt(startDateBox.getSelectedItem().toString()),Integer.parseInt(startMonthBox.getSelectedItem().toString()),Integer.parseInt(startYearBox.getSelectedItem().toString()));
					
			//convert string into float type value
			natInsurNo = natInsurNoField.getText();
			phoneNo = phoneNoField.getText();
			jobTitle = jobTitleField.getText();	
			
			try //salary error check, if not a number
			{
				salary = Float.parseFloat(salaryField.getText()); //convert object to string then to integer and store in startDate variable
			} 
			catch (NumberFormatException nfe)
			{
				// handle a malformed float here				
				salaryValidated =false;
				
			}
			
				if(dob.earlierThan(startDate)){ //dates check if date of birth is earlier than start date
					dateValidated = true;
				}
				else{
					dateValidated = false;
					
				}
			
			if(dateValidated==false||salaryValidated==false){ //if either validations equals false then display error message else  add records
				JOptionPane.showMessageDialog(null, "Please enter salary and dates correctly.");
			}
			else{
<<<<<<< HEAD
			employeeRecords.add(newEmployee = new Employee(name, gender, dob,newEmployee.getEmpId(), startDate));
			newEmployee.setJobTitle(jobTitle);//passing parametres into newemployee
			newEmployee.setSalary(salary);
			newEmployee.setEmployeeImage(image);
			
			
			employeeDAO empDAO = (employeeDAO) ct.getBean("employeeDAO");
			
			
			empDAO.createSession();
			empDAO.create(newEmployee);
			
=======
			employeeRecords.add(newEmployee = new Employee(name, gender, dob, startDate));
			newEmployee.setJobTitle(jobTitle);//passing parametres into newemployee
			newEmployee.setSalary(salary);
			newEmployee.setEmployeeImage(image);
			newEmployee.setNatInsNo(natInsurNo);
			newEmployee.setphone(phoneNo);
			employeeDAO empDAO = new employeeDAO();
			empDAO.createSession();
			empDAO.create(newEmployee);
			System.out.println(phoneNo);
>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
			//reset text fields			
			nameField.setText("");
			salaryField.setText("");
			natInsurNoField.setText("");
			phoneNoField.setText("");
			jobTitleField.setText("");
			maleButton.setSelected(false);
			femaleButton.setSelected(false);
		}
			}
			else
			{
				//pop up box with error message
				JOptionPane.showMessageDialog(null,"Please enter value in all fields.");
			}
		}
		//clear button codes, clear textfields and uncheck checkboxes
		if(e.getSource()==clearBtn){
			nameField.setText("");
			maleButton.setSelected(false);
			femaleButton.setSelected(false);
			salaryField.setText("");
			natInsurNoField.setText("");
			phoneNoField.setText("");
			jobTitleField.setText("");
			
			//employeeRecords.displayAll();
		}
		if(e.getSource()==nextBtn){
			
			if(Store.getCount()==0)//if no records, display the message
			{
				JOptionPane.showMessageDialog(null, "There are no records.");
			}
			else{
				
				for(int i = count; i!=count+1;i++) //else, display the employee's info at index of i
				{
					
					empNameLabel.setText("Name: "+employeeRecords.returnEmployeeName(i));
					empGendLabel.setText("Gender: "+employeeRecords.returnEmployeeGender(i));
					empDOBLabel.setText("Date of birth: "+employeeRecords.returnEmployeeDOB(i));
					empSalaryLabel.setText("Salary: "+employeeRecords.returnEmployeeSalary(i));
					empIDLabel.setText("ID: "+ employeeRecords.returnEmployeeID(i));
					empStartDateLabel.setText("Start date: "+ employeeRecords.returnEmployeeStartDate(i));
					empJobLabel.setText("Job title: "+ employeeRecords.returnEmployeeJob(i));	
					
					myImagePanel.setImage(employeeRecords.returnEmployeeImage(i));
				    myImagePanel.repaint();
				    
										
					
				}
				count=count+1;
				if(Store.getCount()==count) //reset when reached last employee
				{
					count=0;
				}
			}
		}
		if(e.getSource()==prevBtn) //previous button code
		{
			if(Store.getCount()==0)
			{
				JOptionPane.showMessageDialog(null, "There are no records.");
			}
			else{
				
				
				for(int i = count; i!=count-1;i--)//go back by one
				{
					if(count ==-1){//if = -1, then reset to store size
						count = Store.getCount();
					}
					//display certain employee's info
					empNameLabel.setText("Name: "+employeeRecords.returnEmployeeName(i));   
					empGendLabel.setText("Gender: "+employeeRecords.returnEmployeeGender(i));
					empDOBLabel.setText("Date of birth: "+employeeRecords.returnEmployeeDOB(i));
					empSalaryLabel.setText("Salary: "+employeeRecords.returnEmployeeSalary(i));
					empIDLabel.setText("ID: "+ employeeRecords.returnEmployeeID(i));
					empStartDateLabel.setText("Start date: "+ employeeRecords.returnEmployeeStartDate(i));
					empJobLabel.setText("Job title: "+ employeeRecords.returnEmployeeJob(i));
					myImagePanel.setImage(employeeRecords.returnEmployeeImage(i));
				    myImagePanel.repaint();
				}
			
				
				
				}
			
				
				
			}

		if(e.getSource()==imageBtn){ //open file chooser and read in image file, catch exception
			
			int opt =fc.showDialog(null, "Open file");
			if(opt==JFileChooser.APPROVE_OPTION){
			file = fc.getSelectedFile(); 
			try{
				image = ImageIO.read(file);
				
			}
			catch(IOException c){
				c.printStackTrace();
			}
			}
			else{
				
			}
		}
		
		if(e.getSource()== addRecordItem){//add record menu item, similar to enter button's code
			
			boolean dateValidated=true;
			boolean salaryValidated = true;
			if(Panel1.isShowing()==false&&Panel2.isShowing()==false) //check if labels and textfields are visible
			{
				JOptionPane.showMessageDialog(GUIContainer, "Please go back to adding record interface in order to add a record"); //if add record interface not showing, display message
			}
			else{
		
				
			if(nameField.getText() != null && maleButton.isSelected() == true || femaleButton.isSelected()==true && salaryField.getText() != null && natInsurNoField.getText() != null && phoneNoField.getText() != null && jobTitleField.getText() != null)
			{
			//assign values to variables				
				//auto generate id
			
			
			name = nameField.getText();
			if(maleButton.isSelected())
			{
				gender = 'M';				
			}
			if(femaleButton.isSelected())
			{
				gender='F';				
			}			
			dob = new Date(Integer.parseInt(dobDateBox.getSelectedItem().toString()),Integer.parseInt(dobMonthBox.getSelectedItem().toString()),Integer.parseInt(dobYearBox.getSelectedItem().toString()));
			//convert object to string then to integer and store in dob variable
			startDate = new Date(Integer.parseInt(startDateBox.getSelectedItem().toString()),Integer.parseInt(startMonthBox.getSelectedItem().toString()),Integer.parseInt(startYearBox.getSelectedItem().toString()));
					
			//convert string into float type value
			natInsurNo = natInsurNoField.getText();
			phoneNo = phoneNoField.getText();
			jobTitle = jobTitleField.getText();	
			
			try 
			{
				salary = Float.parseFloat(salaryField.getText()); //convert object to string then to integer and store in startDate variable
			} 
			catch (NumberFormatException nfe)
			{
				// handle a malformed float here
				
				salaryValidated =false;
			}
			if(dob.earlierThan(startDate)){
				dateValidated = true;
			}
			else{
				dateValidated = false;
			}
			if(dateValidated==false||salaryValidated==false){
				JOptionPane.showMessageDialog(null, "Please enter data correctly.");
			}
			else{
<<<<<<< HEAD
			employeeRecords.add(newEmployee = new Employee(name, gender, dob,newEmployee.getEmpId(), startDate));
=======
			employeeRecords.add(newEmployee = new Employee(name, gender, dob, startDate));
>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
			newEmployee.setJobTitle(jobTitle);//passing parametres into newemployee
			newEmployee.setSalary(salary);
			newEmployee.setEmployeeImage(image);
			
			//empty text fields			
			nameField.setText("");
			salaryField.setText("");
			natInsurNoField.setText("");
			phoneNoField.setText("");
			jobTitleField.setText("");
			maleButton.setSelected(false);
			femaleButton.setSelected(false);
		}
			}
			else
			{
				//pop up box with error message
				JOptionPane.showMessageDialog(null,"Please enter value in all fields.");
			}
			}
		}
		if(e.getSource()==saveFileItem){//write records to a text file *file writer
			 //choose file
			int opt =fc.showDialog(null, "Open file");
			if(opt==JFileChooser.APPROVE_OPTION){
			PrintWriter pw;
			FileWriter fw;
			file = fc.getSelectedFile(); 
			try{//use buffered writer to fasten writing file process
				bw = new BufferedWriter(fw = new FileWriter(file));
				pw = new PrintWriter(bw); //print the file
				pw.println(employeeRecords.returnListOfEmployee()); //write content in the file
				
				pw.close();  //closes streams prevent memory leaks
				bw.close();
				fw.close();
			}
			catch(Exception a)
			{}
			
			finally
			{
				if(br!=null){try {
					br.close();
				} catch (IOException e1) {
				
					e1.printStackTrace();
				}}
			}
			}
			else{
				
			}
		
		}
		if(e.getSource()==openFileItem){//read in a text file, and put it into the store
			 //choose file
			int opt =fc.showDialog(null, "Open file");
			if(opt==JFileChooser.APPROVE_OPTION){
			file = fc.getSelectedFile(); 
			try{
				Scanner readFile = new Scanner(file);  //scan in file
			while (readFile.hasNextLine()){            //if file has next line
				String words[] = readFile.nextLine().split(",\\s*");	//split next line of string using ",", and store in words string array variable
				String name = words[0];                           //assign words to variables
				char gender = words[1].charAt(0);
				Date DOB = convertStringToDate(words[2]);
				String id = words[3];
				String job = words[4];
				Date start = convertStringToDate(words[5]);
				float salary = Float.parseFloat(words[6]);
<<<<<<< HEAD
				employeeRecords.add(newEmployee = new Employee (name,gender,DOB,newEmployee.getEmpId(),start));     //assign values to employee constructor and add the employee to employeerecords store
=======
				employeeRecords.add(newEmployee = new Employee (name,gender,DOB,start));     //assign values to employee constructor and add the employee to employeerecords store
>>>>>>> 549120e47da240779c47463b221dc7e42e7ceedd
				newEmployee.setJobTitle(job);//passing parametres into newemployee
				newEmployee.setSalary(salary);
			
				}
				
			}
			catch(Exception a)
			{a.printStackTrace();}
			
			finally
			{
				if(br!=null){try { //while bufferedreader not null, close the stream
					br.close();
				} catch (IOException e1) { //catch exception and print out
				
					e1.printStackTrace();
				}}
			}
			}
			else{
				
			}
		}	
		
		if(e.getSource()==clearRecordItem){
			myImagePanel.setVisible(false);
			count=0;

			if(Store.getCount()>=1){
			String input = JOptionPane.showInputDialog(GUIContainer,"Enter name of employee");
			if(input.equals("")){
				JOptionPane.showMessageDialog(GUIContainer, "No input entered.");
			}
			else{
				for(int i =0;i<Store.getCount();i++){
					//loop through store
					//if first word or full name matches, display employee info
					//doesn't work for last name*
					if(input.equalsIgnoreCase(employeeRecords.returnEmployee(i).getFirstName())||input.equalsIgnoreCase(employeeRecords.returnEmployee(i).getName()))
					{
						employeeRecords.deleteEmployee(i);
						JOptionPane.showMessageDialog(GUIContainer, "Employee deleted.");
					}
					else
					{
						JOptionPane.showMessageDialog(GUIContainer, "No records matched.");
					}
			}
			empNameLabel.setText("Name: ");//reset labels
			empGendLabel.setText("Gender: ");
			empDOBLabel.setText("Date of birth: ");
			empSalaryLabel.setText("Salary: ");
			empIDLabel.setText("ID: ");
			empStartDateLabel.setText("Start date: ");
			empJobLabel.setText("Job title: ");
			
			}}
			else
			{
				JOptionPane.showMessageDialog(GUIContainer, "There are no records.");
			}
				
		}    
		if(e.getSource()==displayRecordItem){
        	Panel1.setVisible(false);//setting components visible and invisible
        	Panel2.setVisible(false);
			imageBtn.setVisible(false);
			titleLabel.setVisible(false);
			searchPanel.setVisible(false);
			displayPanel.setVisible(true);
			nextBtn.setVisible(true);
			prevBtn.setVisible(true);
            myImagePanel.setVisible(true);
            myImagePanel.setImage(null);
            myImagePanel.repaint();
			empNameLabel.setText("Name: ");//reset labels
			empGendLabel.setText("Gender: ");
			empDOBLabel.setText("Date of birth: ");
			empSalaryLabel.setText("Salary: ");
			empIDLabel.setText("ID: ");
			empStartDateLabel.setText("Start date: ");
			empJobLabel.setText("Job title: ");
			
			
		}  

		if(e.getSource()==newFileItem){
			titleLabel.setVisible(true); //display main form
			Panel1.setVisible(true);
			Panel2.setVisible(true);
			imageBtn.setVisible(true);
			searchPanel.setVisible(false);
			displayPanel.setVisible(false);
			myImagePanel.setVisible(false);
			
		}
		if(e.getSource()==searchBtn)//search menu item code
		    {
                if(searchField.getText().equals(""))//if nothing was entered in text field, display error message
                {
				JOptionPane.showMessageDialog(null, "Please enter name of employee.");
			     }
                if(Store.getCount()==0)//if no records in store, display error message
                 {
                	 JOptionPane.showMessageDialog(GUIContainer,"Store is empty!");
                 }
			else{
				searchTerm=searchField.getText();//retrieve text on text field
			 String word[]=searchTerm.split(" ");//search button code
			 
			
				for(int i =0;i<Store.getCount();i++){
					//loop through store
					//if first word or full name matches, display employee info
					//doesn't work for last name*
					if(word[0].equalsIgnoreCase(employeeRecords.returnEmployee(i).getFirstName())||searchTerm.equalsIgnoreCase(employeeRecords.returnEmployee(i).getName()))
					{
						foundRecord = employeeRecords.returnEmployee(i);//only return one record...
						displayPanel.setVisible(true);
						nextBtn.setVisible(false);
						prevBtn.setVisible(false);
						empNameLabel.setText("Name: "+employeeRecords.returnEmployeeName(i));
						empGendLabel.setText("Gender: "+employeeRecords.returnEmployeeGender(i));
						empDOBLabel.setText("Date of birth: "+employeeRecords.returnEmployeeDOB(i));
						empSalaryLabel.setText("Salary: "+employeeRecords.returnEmployeeSalary(i));
						empIDLabel.setText("ID: "+ employeeRecords.returnEmployeeID(i));
						empStartDateLabel.setText("Start date: "+ employeeRecords.returnEmployeeStartDate(i));
						empJobLabel.setText("Job title: "+ employeeRecords.returnEmployeeJob(i));
						myImagePanel.setImage(employeeRecords.returnEmployeeImage(i));
					    myImagePanel.repaint();
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, "No records found.");
						
						}
					}
			}//end else statement

		}//end searchbtn code
		
		if(e.getSource()==searchRecordItem){
			Panel1.setVisible(false);  //set items invisible and search panel visible
			Panel2.setVisible(false);
			myImagePanel.setVisible(true);
			myImagePanel.setVisible(true);
	        myImagePanel.setImage(null);
			displayPanel.setVisible(false);
			searchPanel.setVisible(true);
			titleLabel.setVisible(false);
			
		}
		
		if(e.getSource()==exitFileItem){ //exit file item, show yes no option, if yes exit, else do nothing
			int isYes =JOptionPane.showConfirmDialog(null, "Would you like to save the records before exiting?","Message", JOptionPane.YES_NO_CANCEL_OPTION);
			if(isYes == JOptionPane.YES_OPTION)
			{
				int opt =fc.showDialog(null, "Open file");
				if(opt==JFileChooser.APPROVE_OPTION){ //if user picks open file option
				PrintWriter pw;
				FileWriter fw;
				file = fc.getSelectedFile(); 
				try{//use buffered writer to fasten writing file process
					bw = new BufferedWriter(fw = new FileWriter(file));
					pw = new PrintWriter(bw); //print the file
					pw.println(employeeRecords.returnListOfEmployee()); //write content in the file
					
					pw.close();  //closes streams prevent memory leaks
					bw.close();
					fw.close();
				}
				catch(Exception a)
				{
					a.printStackTrace();
					}
				System.exit(0);
			}
				
			else if(isYes == JOptionPane.NO_OPTION) //if user picked no option, program closes
			{
				System.exit(0);
			}
			else{  //if user picks cancel
				//do nothing
			}
		}
		}//end action performed method
		}//action listener class
      }//gui class
}











	

