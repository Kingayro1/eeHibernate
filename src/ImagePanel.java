import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
* ImagePanel class documentation here
* @author Michael Liang
*/

 public class ImagePanel  extends JPanel{
	BufferedImage myImage=null;
	
	public ImagePanel()
	{
		super();
	}
	public void setImage(BufferedImage aimage)
	{		//set image of panel
		myImage = aimage;		
	}
	
	@Override	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(myImage!=null){
		g.drawImage(myImage,0,0,200,200,null); //draw image if variable is not null, set dimension: 200x200
		}
		else{
			g.setColor(Color.LIGHT_GRAY);
		   g.drawRect(0, 0, 200, 200);//draw light gray rectangle if no image
		}
	}

}
