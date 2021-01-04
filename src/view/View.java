package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

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
 * @author Junli YE
 */
public class View extends JFrame {
	Game game; // Interactive with user
	GamePanel gp;
	ControlPanel cp;

	/**
	 * Constructor of view
	 */
	public View() {
		// set a title
		setTitle("PRS");
		//set window size
        setSize(500, 500);
        //set method to exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //open it centrally
        setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BorderLayout());
        // add panels
		cp = new ControlPanel();
        this.getContentPane().add(BorderLayout.SOUTH,cp);
        this.game = new Game();
		this.gp = new GamePanel(game);
		this.getContentPane().add(BorderLayout.CENTER,gp);
		// Visibility
        this.setVisible(true);
        //MusicPlay.play();// bgm begins!!!
	}

	// NOT READY
	protected void restart() {
		// Code 0 for test
		System.out.println("0");

		this.gp = new GamePanel(new Game());
		this.getContentPane().add(BorderLayout.CENTER,gp);
	}

	/**
	 * Inner class controlPanel which describe a control set of this game on the bottom of window
	 */
	class ControlPanel extends JPanel {
		public ControlPanel() {
			JPanel p=new JPanel(new GridLayout(1,2));
			this.add(p);
			p.setVisible(true);
			JButton jb1=new JButton("Start");
			JButton jb2=new JButton("Restart");
			jb2.setEnabled(false);
			p.add(jb1);
			p.add(jb2);

			// Use of lambda expression
			jb1.addActionListener((ActionEvent e) -> {
				jb1.setEnabled(false);
				jb2.setEnabled(true);
			});

			jb2.addActionListener((ActionEvent e) -> {
				restart();
			});
		}

	}
}
