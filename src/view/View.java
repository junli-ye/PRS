package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.AnimalBlock;
import entity.BlockFactory;
import entity.NormalBlock;
/**
 * 
 * @author lsq9905
 *
 */
public class View extends JFrame {
	
	JPanel gp=new GamePanel();// main game panel
	JPanel sb=new ScoreBoard();// scoreboard
	JPanel cp=new ControlPanel();//control panel
	
	public View() {
		// set a title
		setTitle("Pet Rescue Saga");
		//set window size
        setSize(1000, 1000);
        //set method to exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //open it centrally
        setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BorderLayout());
        //set layout of these 3 panels
        this.getContentPane().add(BorderLayout.CENTER,gp);
        this.getContentPane().add(BorderLayout.EAST,sb);
        this.getContentPane().add(BorderLayout.SOUTH,cp);
        this.setVisible(true);
       
	
	}
	
 
	//restart
	public void restart() {
		Container c= getContentPane();
		c.removeAll();
		new View();
		
		
		
	}

public static void main(String[] args){
		 new View();
		//v.restart();
		
		
	
}
}