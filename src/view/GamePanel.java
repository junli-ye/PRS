package view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Game;
import entity.Animal;
import entity.Block;
import entity.Color;
import entity.NormalBlock;
import org.w3c.dom.Element;

/**
 * 
 * @author lsq9905
 *
 */

public class GamePanel extends JPanel {
	
    GridBagConstraints gbc=new GridBagConstraints();
    GridBagLayout gir=new GridBagLayout();
	/**
	 * Constructor of GamePanel
	 * @param g
	 */
	public GamePanel(Game g) {

	JButton[][] bu=new JButton[g.getBoard().getHeight()][g.getBoard().getWidth()];
	this.addButton(g, bu);
	this.setLayout(gir);
	this.setVisible(true);
	/**
	 * add listener
	 */
	for(int i=0;i<g.getBoard().getHeight();i++) {
		for(int j=0;j<g.getBoard().getWidth();j++) {
			bu[i][j].addMouseListener(new MouseAdapter(){
				
				public void mouseClicked(MouseEvent e) {
					// click left button
					if(e.getButton()==MouseEvent.BUTTON1) {
				
					int x=e.getX();
					int y=e.getY();
					g.eliminate(x, y);
				}
			       }
			});
		}
		}
	/**
	 * decide if the game is win
	 */
	if(g.isWin()) {
		JPanel etiquette = null;
	        
	JOptionPane.showMessageDialog(etiquette,"Congratulations! Game success! The window will close automatically after clicking on Confirm.","Win",JOptionPane.WARNING_MESSAGE);
	        System.exit(0);
	    }else {
	    	this.addButton(g, bu);
	    	
	    

	}
	
	
	
			
	
	
	
	}
	
	
	
	
	
	
	/**
	 * add buttons
	 * @param g
	 * @param b
	 */
	
	private void addButton(Game g,JButton[][]b) {
		GridBagConstraints gbc=new GridBagConstraints();
		Block[][]tmp=g.getBoard().getBlocks();
		for(int i=0;i<g.getBoard().getHeight();i++) {
			for(int j=0;j<g.getBoard().getWidth();j++) {
				gbc.gridx=i;
				gbc.gridy=j;
				gbc.fill= GridBagConstraints.CENTER;
				if(tmp[i][j]==null) {
					b[i][j]=null;
				}else {
					b[i][j]=setColor(tmp[i][j]);
						
					}
				this.add(b[i][j],gbc);
			}
			
			}
			
		}
		
		/**
	 *Initialize different colored squares
	 * @param b
	 * @return
	 */
 	private JButton setColor(Block B) {
 		JButton tmp = null;
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
		Object E = B.getElement();
		if(E==null) {
			tmp=null;}
		else {
		if (E instanceof NormalBlock) {
			switch(((NormalBlock) E).getElement()) {
			case B:
				tmp=bl;
				break;
			case G:
				tmp=gr;
				break;
			case O:
				tmp=or;
				break;
			case R:
				tmp=re;
				break;
			case Y:
				tmp=ye;
				break;
			
			}
			
		}else {
			switch(((Block<Animal>) E).getElement()) {
			case p:
				tmp=a;
				break;
			case m:
				tmp=b;
				break;
			case t:
				tmp=c;
				break;
			case c:
				tmp=d;
				break;
			case i:
				tmp=e;
				break;
			
			
			}
			
				
			}
			
		
		}
		 
	
 	
		return tmp;
 	}
 
 
}
 	/*for(int i=0;i<g.getBoard().getHeight();i++) {
	for(int j=0;j<g.getBoard().getWidth();j++) {
		gbc.fill=GridBagConstraints.CENTER;
		gbc.gridx=i;
		gbc.gridy=j;
		if(i==0) {
			if(blocks[i][j].getElement()==null) {
				bu[i][j]=null;
			}else {
			bu[i][j]=new JButton(blocks[i][j].getElement().toString());
			//currently,use his name as a icon,required several pics for icon//
			//add animal
			}
			}else {
	  
		if(blocks[i][j].getElement() == entity.Color.B) {
		 bu[i][j]=bl;
			
		}
		if(blocks[i][j].getElement() == entity.Color.G) {
			bu[i][j]=gr;
				
			}
		if(blocks[i][j].getElement() == entity.Color.O) {
			bu[i][j]=or;
				
			}
		if(blocks[i][j].getElement() == entity.Color.R) {
			bu[i][j]=re;
				
			}
		if(blocks[i][j].getElement() == entity.Color.Y) {
			bu[i][j]=ye;
				
			}
		if(blocks[i][j].getElement()==null) {
			bu[i][j]=null;
		}
		}//add normal blocks
		//need debug
		
		bu[i][j].setFocusPainted(false);
		bu[i][j].setBorderPainted(false);
		//eliminate boarder & focus
//		bu[i][j].addActionListener(event -> g.eliminate(i, j));
		
		
		//i dont know how to do action Fall and recover new panel;
		
		
		
		
		
		this.add(bu[i][j],gbc);

	}
	}
this.setVisible(true);
	}*/



