package view;

import javax.swing.*;
import java.awt.*;

import controller.Play;
/**
 * 
 * @author lsq9905
 *
 */
public class ControlPanel extends JPanel {
	public ControlPanel() {
		
	    JPanel p=new JPanel(new GridLayout(1,2));
	   
	    p.setVisible(true);
	    JButton jb1=new JButton("Start");
	    JButton jb2=new JButton("Restart");
	    //we dont have this function
	    jb1.addActionListener(event -> new Play());
	    /*jb1.addActionListener(event -> restart());*/
	    p.add(jb1);
	    p.add(jb2);
	}

}
