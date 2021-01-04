package view;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Game;
import entity.*;

/**
 *
 * @author Junli YE
 *
 */

public class GamePanel extends JPanel {
    private JButton[][] bu;
    private Game g;
	// the dimension of the game board
	private int height;
	private int width;

	/**
	 * Constructor of GamePanel
	 */
	public GamePanel(Game game) {
		this.g = game;
		g.print();
		this.height = g.getBoard().getHeight();
		this.width = g.getBoard().getWidth();

		// Set the size of JButton according to the size of the Board in the Game g
		bu=new JButton[height][width];

		// Set layout
		this.setLayout(new GridLayout(height,width));

		// Add all Buttons to the pane，according to he information provided by Game g
		this.addButton();

		// Set visibility
		this.setVisible(true);

		// Use a loop to assign a listener to each button to monitor the position selected by the mouse
//		for(int i=0; i<height; i++) {
//			for(int j=0; j<width; j++) {
//				bu[i][j].addMouseListener(new MouseAdapter(){
//
//					public void mouseClicked(MouseEvent e) {
//						// click left button
//						if(e.getButton()==MouseEvent.BUTTON1) {
//
//						int x=e.getX();
//						int y=e.getY();
//						g.eliminate(x, y);
//					}
//					   }
//				});
//			}
//		}
	/**
	 * decide if the game is win
	 */
//	if(g.isWin()) {
//		JPanel etiquette = null;
//
//	JOptionPane.showMessageDialog(etiquette,"Congratulations! Game success! The window will close automatically after clicking on Confirm.","Win",JOptionPane.WARNING_MESSAGE);
//	        System.exit(0);
//	    }else {
//	    	this.addButton(bu);
//	}
	}

	/**
	 * add buttons
	 */
	private void addButton() {
		GridBagConstraints gbc = new GridBagConstraints();
		Block[][] tmp = g.getBoard().getBlocks();
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				gbc.gridx=i;
				gbc.gridy=j;
				gbc.fill= GridBagConstraints.CENTER;

				if(tmp[i][j] == null) {
					bu[i][j] = new JButton();
				}
				else {
					bu[i][j] = setColor(tmp[i][j]);
				}

				// Eliminate the border around the button (enable after finishing all debugging)
//				b[i][j].setBorder(null);

				// Add the color (animal) button to the panel to represent blocks
				this.add(bu[i][j],gbc);
			}
		}
	}

	/**
	 * Generate buttons with corresponding colors (or animals) for the specified block
	 * @param B
	 * @return
	 */
 	private JButton setColor(Block B) {
 		JButton tmp = new JButton();
        JButton bl= new JButton(new ImageIcon("img/blue.png"));
		JButton gr= new JButton(new ImageIcon("img/green.jpeg"));
		JButton or= new JButton(new ImageIcon("img/orange.png"));
		JButton re= new JButton(new ImageIcon("img/red.jpeg"));
		JButton ye= new JButton(new ImageIcon("img/yellow.png"));
		
        JButton a= new JButton(new ImageIcon("img/a.jpg"));
		JButton b= new JButton(new ImageIcon("img/b.jpg"));
		JButton c= new JButton(new ImageIcon("img/c.jpg"));
		JButton d= new JButton(new ImageIcon("img/d.jpg"));
		JButton e= new JButton(new ImageIcon("img/e.jpg"));

		// Select the corresponding button according to the color in b
		if (B instanceof NormalBlock) {
			switch(((NormalBlock) B).getElement()) {
			case B: tmp=bl;	break;
			case G: tmp=gr;	break;
			case O: tmp=or;	break;
			case R: tmp=re;	break;
			case Y: tmp=ye;	break;
			}
		}else if (B instanceof AnimalBlock){
			switch(((AnimalBlock) B).getElement()) {
			case p: tmp=a;	break;
			case m: tmp=b;	break;
			case t: tmp=c;	break;
			case c: tmp=d;	break;
			case i: tmp=e;	break;
			}
		}
		return tmp;
 	}
}

