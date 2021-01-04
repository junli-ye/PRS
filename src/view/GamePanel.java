package view;

import java.awt.*;

import javax.swing.*;

import controller.Game;
import entity.*;

/**
 *
 * @author Junli YE
 * @author lsq9905
 */

public class GamePanel extends JPanel {
    protected JButton[][] bu;
    private Game g;
	// the dimension of the game board
	protected int height;
	protected int width;

	/**
	 * Constructor of GamePanel
	 */
	public GamePanel(Game game) {
		this.g = game;
		g.print();
		this.height = g.getBoard().getHeight();
		this.width = g.getBoard().getWidth();

		// Set the size of JButton according to the size of the Board in the Game g
		bu = new JButton[height][width];

		// Set layout
		this.setLayout(new GridLayout(height, width));

		// Add all Buttons to the pane，according to he information provided by Game g
		this.addButton();

		// Set visibility
		this.setVisible(true);
	}

	/**
	 * Determine whether the game is over (including success and failure)
	 */
	private void isGameOver() {
		if(this.g.isWin()) {
			JPanel jp = new JPanel();
			JOptionPane.showMessageDialog(jp,"Congratulation! Game success! The window will close automatically","OK",JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * add buttons
	 */
	private void addButton() {
		GridBagConstraints gbc = new GridBagConstraints();
		Block<?>[][] tmp = g.getBoard().getBlocks();
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				gbc.gridx=i;
				gbc.gridy=j;
				gbc.fill= GridBagConstraints.CENTER;

				if(tmp[i][j] == null || tmp[i][j].getElement() == null) {
					bu[i][j] = new JButton();
				}
				else {
					bu[i][j] = setColor(tmp[i][j]);
				}

				int x = i;
				int y = j;
				bu[i][j].addActionListener(e -> {
					System.out.println("Clicked" + x + "," + y);
					clickedToEliminate(x, y);
					this.updateUI();
					isGameOver();
				});

				bu[i][j].setBorder(null);

				// Add the color (animal) button to the panel to represent blocks
				this.add(bu[i][j],gbc);
			}
		}
	}

	/**
	 * Generate buttons with corresponding colors (or animals) for the specified block
	 */
 	private JButton setColor(Block<?> B) {
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

 	public void restart() {
 		EventQueue.invokeLater( () -> {
			this.g = new Game();
			this.removeAll();
			this.bu=new JButton[height][width];
			this.addButton();
		});
 		g.print();
	}

	private void clickedToEliminate(int x, int y) {
		EventQueue.invokeLater( () -> {
			try{
				g.eliminate(x,y);
				g.print();
				this.removeAll();
				this.bu=new JButton[height][width];
				this.addButton();
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}

