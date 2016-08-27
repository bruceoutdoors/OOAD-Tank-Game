/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Voon
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

public class ButtonTest extends JFrame implements MouseListener{
    Icon whiteBtn;
    Icon blueBtn;
    JButton gridButt = new JButton();
    private boolean mouseEntered = false;
    private boolean mousePressed = false;
        
    public ButtonTest() throws IOException{
        super("ButtonFrame");
        whiteBtn = new ImageIcon(ImageIO.read(Paths.get("WhiteTile.png").toFile()));
        blueBtn = new ImageIcon(ImageIO.read(Paths.get("BlueTile.png").toFile()));
        JPanel jp=new JPanel(new FlowLayout());
        //jp.setLayoutManager(new FlowLayout());
        add(jp);
        setSize(200,200);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        
        //enableInputMethods(true);
        gridButt.setPreferredSize(new Dimension (50,50));
        gridButt.addMouseListener(this);
        gridButt.setIcon(whiteBtn);
        gridButt.setBackground(Color.WHITE);
        gridButt.setEnabled(false);
        //gridButt.setContentAreaFilled(false);
        jp.add(gridButt);
        //end of class 
    }
    @Override
    public void mouseClicked(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e){
        mouseEntered = true;
//        gridButt.setBackground(Color.BLUE);
        gridButt.setIcon(blueBtn);
    }
    @Override
    public void mouseExited(MouseEvent e){
        mouseEntered = false;
//        gridButt.setBackground(Color.WHITE);
        gridButt.setIcon(whiteBtn);
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    public static void main(String[] a) throws IOException {
        JFrame nframe = new ButtonTest();
        nframe.setVisible(true);
    }
}