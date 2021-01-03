package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Play;
import entity.AnimalBlock;
import entity.BlockFactory;
import entity.NormalBlock;

import controller.Game;
/**
 * 
 * @author lsq9905
 *
 */
public class View extends JFrame {
	Game game; // Interactive

//	JPanel gp=new GamePanel(game);// main game panel
	JPanel sb=new ScoreBoard();// scoreboard
	JPanel cp= new ControlPanel();//control panel

	/**
	 * Constructor
	 * @param game
	 */
	public View(Game game) {
		// set up the game
		this.game=game;
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
//        this.getContentPane().add(BorderLayout.CENTER,gp);
        this.getContentPane().add(BorderLayout.EAST,sb);
        this.getContentPane().add(BorderLayout.SOUTH,cp);
        this.setVisible(true);
	}


	/**
	 * Restart
	 */
	public void restart() {
		Container c= getContentPane();
		c.removeAll();
		new View(new Game());
	}

	public static void main(String[] args) {
		View v = new View(new Game());
	}

	static class ControlPanel extends JPanel {
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
}