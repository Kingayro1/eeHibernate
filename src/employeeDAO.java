import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class employeeDAO {
	private Session session=null; //initialise session variable
	public void createSession(){ //create session method
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml"); //reference hibernate configuration file
		SessionFactory sf =cfg.buildSessionFactory();
		this.session=sf.getCurrentSession();	//retrieve current session
	}

	public Employee create(Employee newEmployee){  
		Transaction transaction = session.beginTransaction();
		session.save(newEmployee);
		transaction.commit();
		return newEmployee;
	}
	
}
