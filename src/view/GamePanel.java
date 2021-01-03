package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Game;
import entity.*;

/**
 * 
 * @author lsq9905
 *
 */

public class GamePanel extends JPanel {
	JPanel p=new JPanel();
	public GamePanel() {
	
	JButton bl= new JButton(new ImageIcon("blue.png"));
	JButton gr= new JButton(new ImageIcon("green.jpeg"));
	JButton or= new JButton(new ImageIcon("img/orange.png"));
	JButton re= new JButton(new ImageIcon("img/red.jpeg"));
	JButton ye= new JButton(new ImageIcon("yellow.png"));
	JButton[][] bu;
	Game g=new Game();
	Block[][] blocks=g.getBoard().getBlocks();
	GridBagConstraints gbc=new GridBagConstraints();
	
    
	GridBagLayout gir=new GridBagLayout();
    
	p.setLayout(gir);
	
	for(int i=0;i<g.getBoard().getHeight();i++) {
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
		  
			if(blocks[i][j].getElement()==Color.B) {
			 bu[i][j]=bl;
				
			}
			if(blocks[i][j].getElement()==Color.G) {
				bu[i][j]=gr;
					
				}
			if(blocks[i][j].getElement()==Color.O) {
				bu[i][j]=or;
					
				}
			if(blocks[i][j].getElement()==Color.R) {
				bu[i][j]=re;
					
				}
			if(blocks[i][j].getElement()==Color.Y) {
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
			bu[i][j].addActionListener(event->g.eliminate(i, j));
			
			
			//i dont know how to do action Fall and recover new panel;
			
			
			
			
			
			p.add(bu[i][j],gbc);

		}
		
	}
	
	p.setVisible(true);
	
	
	
 }
}


