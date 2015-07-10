
import javax.swing.JFrame;

public class GUIController  {
	/**
	* GUIController class documentation here
	* @author Michael Liang
	*/
	
	
 public static void main (String []args) {
		
	 javax.swing.SwingUtilities.invokeLater(new Runnable(){
		 public void run(){
	    GUI a = new GUI();   
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setSize(600, 400);
		a.setVisible(true);
		 }});
	 
	 

 }}
	



