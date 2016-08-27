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

public class ButtonTest extends JFrame implements MouseListener{
    Icon whiteBtn = new ImageIcon("WhiteTile.png");
    Icon blueBtn = new ImageIcon("BlueTile.png");
    JButton gridButt = new JButton();
    private boolean mouseEntered = false;
    private boolean mousePressed = false;
        
    public ButtonTest(){
        
        super("ButtonFrame");
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
        //gridButt.setIcon(whiteBtn);
        gridButt.setBackground(Color.WHITE);
        //gridButt.setContentAreaFilled(false);
        jp.add(gridButt);
        //end of class 
    }
    @Override
    public void mouseClicked(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e){
        mouseEntered = true;
        gridButt.setBackground(Color.BLUE);
    }
    @Override
    public void mouseExited(MouseEvent e){
        mouseEntered = false;
        gridButt.setBackground(Color.WHITE);
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    public static void main(String[] a) {
        JFrame nframe = new ButtonTest();
        nframe.setVisible(true);
    }
}