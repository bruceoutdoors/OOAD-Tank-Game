import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Board;
import model.Tile;



public class GamePanel extends JPanel implements KeyListener{
    
        int x=0;
        int y=0;
        int w=70;
        int h=70;
        
        int cols = 10;
        int rows = 10;
        String [][] boardarray = new String [cols][rows];
          
        
        
        int [][] x_axis = new int [cols][rows];
        int [][] y_axis = new int [cols][rows];
        Board bb = new Board(cols, rows);
        
        Tile tmyrobot = bb.getPlayerTank().getTile();
        Tile tairobot = bb.getEnemyTank().getTile();
        

        
        
	int a, b, heigth, width, s_x, s_y, s2_x, s2_y;
	MyRobot myRobot = new MyRobot();
	PcRobot pcRobot = new PcRobot();
	JLabel logoLabel;
	
	public GamePanel(){
		
		s_x = 900; s_y = 900;s2_x = 900; s2_y = 900;
		a = 650; b = 650;
		
		this.setSize(702, 703);
		this.setLocation(0, 0);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setFocusable(true);
		addKeyListener(this);
		
		logoLabel = new JLabel();
		logoLabel.setBounds(0, 0, 700, 700);
		ImageIcon icon = createImageIcon("/Robot_War.jpg", "Nothing");
		logoLabel.setIcon(icon);
		this.add(logoLabel);
		
                
                
               
  
                  

		this.add(myRobot);
		this.add(pcRobot);
                
                  for (int i = 0; i < cols; i++) 
                  {
                        for (int j = 0; j < rows; j++) 
                       {
                            x_axis[i][j] = -1;
                            y_axis[i][j] = -1;
                         }
                   }
		
		
	}
        
	ImageIcon createImageIcon(String path,
            String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
    @Override
    protected void paintComponent(Graphics g){
        
        
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        
        for (y=0; y<700; y=y+70) 
        {
            for (x=0; x<700; x=x+70) 
            {
                intialisexy(x,y);
                g.drawRect (x, y, w, h);
            }
        }
      
        for (int i = 0; i < cols; i++) 
        {
            for (int j = 0; j < rows; j++) 
            {
                boardarray[i][j] = "empty";
            }
        }

        
        g.setColor(Color.RED);
        g.drawRect(s_x, s_y, 100, 1);
        g.drawRect(s2_x, s2_y, 1, 100);
        myRobot.setLocation(x_axis[tmyrobot.getCol()][tmyrobot.getRow()]+20, y_axis[tmyrobot.getCol()][tmyrobot.getRow()]+20);
        pcRobot.setLocation(x_axis[tairobot.getCol()][tairobot.getRow()]+20, y_axis[tairobot.getCol()][tairobot.getRow()]+20);
        
    }
    
     public void intialisexy(int x, int y){
        boolean setxy=false; 
         for (int i = 0; i < cols; i++) 
        {
            for (int j = 0; j < rows; j++) 
            {
                if (x_axis[i][j]<0 && y_axis[i][j]<0)
                {
                x_axis[i][j] = x;
                y_axis[i][j] = y;
                setxy=true;
                break;
                }
            }
            if (setxy)
            break;
        } 
     }
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		
			case KeyEvent.VK_RIGHT: {
				myRobot.removeAll();
				myRobot.addIconRight();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = 900;s_y = 900;
				if(myRobot.getX()<=630){
					myRobot.setLocation(myRobot.getX() + 70, myRobot.getY() + 0);
				}
				else break;
			}break;
			case KeyEvent.VK_LEFT: {
				myRobot.removeAll();
				myRobot.addIconLeft();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = 900;s_y = 900;
				if(myRobot.getX()>=70){
					myRobot.setLocation(myRobot.getX() - 70, myRobot.getY() + 0);
				}
				else break;
			}break;
			case KeyEvent.VK_UP: {
				myRobot.removeAll();
				myRobot.addIconUp();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = 900;s_y = 900;
				if(myRobot.getY()>=70){
					myRobot.setLocation(myRobot.getX() + 0, myRobot.getY() - 70);
				}
				else break;
			}break;
			case KeyEvent.VK_DOWN: {
				myRobot.removeAll();
				myRobot.addIconDown();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = 900;s_y = 900;
				if(myRobot.getY()<=630){
					myRobot.setLocation(myRobot.getX() + 0, myRobot.getY() + 70);
				}
				else break;
			}break;
			case KeyEvent.VK_A: {
				myRobot.removeAll();
				myRobot.addIconLeft();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = myRobot.getX() - 105;
				s_y = myRobot.getY() + 14;
			}break;
			case KeyEvent.VK_D: {
				myRobot.removeAll();
				myRobot.addIconRight();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = myRobot.getX() + 35;
				s_y = myRobot.getY() + 13;
			}break;
			case KeyEvent.VK_W: {
				myRobot.removeAll();
				myRobot.addIconUp();
				myRobot.repaint();
				myRobot.revalidate();
				s_x = 900;s_y = 900;
				s2_y = myRobot.getY() - 105;
				s2_x = myRobot.getX() + 14;
			}break;
			case KeyEvent.VK_S: {
				myRobot.removeAll();
				myRobot.addIconDown();
				myRobot.repaint();
				myRobot.revalidate();
				s_x = 900;s_y = 900;
				s2_y = myRobot.getY() + 35;
				s2_x = myRobot.getX() + 15;
			}break;
			case KeyEvent.VK_ENTER: {
				this.remove(logoLabel);
				
			}
	
			default:
			break;
		}
		repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A: {
			s_x = 900;
			s_y = 900;
			repaint();
		}break;
		case KeyEvent.VK_D: {
			s_x = 900;
			s_y = 900;
			repaint();
		}break;
		case KeyEvent.VK_W: {
			s2_x = 900;
			s2_y = 900;
			repaint();
		}break;
		case KeyEvent.VK_S: {
			s2_x = 900;
			s2_y = 900;
			repaint();
		}break;
	
		default:
			break;
		}
	
	}
	
}
