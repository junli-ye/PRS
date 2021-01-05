package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

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
	public View(Game game) {
		// set a title
		setTitle("PRS");
		//set window size
        setSize(500, 700);
        //set method to exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //open it centrally
        setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BorderLayout());
        // add panels
		cp = new ControlPanel();
        this.getContentPane().add(BorderLayout.SOUTH,cp);
        this.game = game;
		this.gp = new GamePanel(game);
		this.getContentPane().add(BorderLayout.CENTER,gp);
	}

	public void restart() {
		gp.restart();
		gp.revalidate();
		gp.repaint();
	}

	public void robotPlay() {
		gp.robotPlay();
	}

	/**
	 * Inner class controlPanel which describe a control set of this game on the bottom of window
	 */
	class ControlPanel extends JPanel {
		public ControlPanel() {
			JPanel p=new JPanel(new GridLayout(2,2));
			this.add(p);
			p.setVisible(true);
			JButton jb0=new JButton("Difficult");
			JButton jb1=new JButton("Help");
			JButton jb2=new JButton("Can't continue? Try to start over");
			JButton jb3=new JButton("Robot");
			p.add(jb0);
			p.add(jb1);
			p.add(jb2);
			p.add(jb3);

			jb0.addActionListener((ActionEvent e) -> new DimensionChoose());

			jb1.addActionListener((ActionEvent e) -> new RulesPanel());

			jb2.addActionListener((ActionEvent e) -> restart());

			jb3.addActionListener((ActionEvent e) -> robotPlay());
		}
	}

	static class RulesPanel extends JPanel {
		public RulesPanel() {
			String r = "You can click any square to eliminate the squares of the same color adjacent to it.\n" +
					"Please note that animals cannot be selected.\n"+
					"If you find that you cannot perform any operations without getting the news of the game's victory, it means the game has failed.";
			JOptionPane.showMessageDialog(null, r, "Rules",JOptionPane.PLAIN_MESSAGE);
		}
	}

	class DimensionChoose extends JPanel {
		public DimensionChoose() {
			Object[] options ={ "Easy(6*6)", "Normal(8*8)", "Master(10*10)"};
			String s = (String) JOptionPane.showInputDialog(null,"Please select difficulty：\n", "Difficulty", JOptionPane.PLAIN_MESSAGE, new ImageIcon("xx.png"), options, "xx");
			if (s.equals("Easy(6*6)")) game.setSize(6);
			if (s.equals("Normal(8*8)")) game.setSize(8);
			if (s.equals("Master(10*10)")) game.setSize(10);
			else game.setSize(6);
			restart();
		}
	}
}
