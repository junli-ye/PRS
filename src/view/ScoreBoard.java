package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel {
	public ScoreBoard() {
		JPanel p =new JPanel();
		JLabel l=new JLabel("your socore:");
		p.add(l);
		p.setVisible(true);
	}

}//its not a necessary panel
