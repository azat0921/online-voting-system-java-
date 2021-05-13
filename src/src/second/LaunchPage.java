package second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {

    //JFrame - a GUI window to add components to
    // CREATION OF NEW "FRAMES"
    JFrame frame = new JFrame();//creates the frame


    //JButton - a button that performs an action when clicked on

    JButton myButton = new JButton("Admin");
    JButton myButton2 = new JButton("User");
    LaunchPage(){
        //settings of each buttons
        myButton.setBounds(100,160,200,40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        myButton2.setBounds(100,100,200,40);
        myButton2.setFocusable(false);
        myButton2.addActionListener(this);

        frame.add(myButton);
        frame.add(myButton2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out the application
        frame.setResizable(false); //prevent frame from being resized
        frame.setSize(400,400); //sets the x - dimension, and y - dimension of frame
        frame.setLayout(null);
        frame.setVisible(true); //make frame visible


        ImageIcon image = new ImageIcon("logo.jpg");  //create ImageIcon
        frame.setIconImage(image.getImage());  //change Icon of the frame
        frame.getContentPane().setBackground(new Color(3, 41, 64));

    }

    @Override


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myButton){
            AdWindow myWindow = new AdWindow();
        }else if(e.getSource()==myButton2){
            UserWindow us = new UserWindow();
        }
    }
}
