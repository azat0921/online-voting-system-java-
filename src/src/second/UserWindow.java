package second;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserWindow implements ActionListener {
    JFrame frame = new JFrame();
    //Creation the buttons
    JButton signIn = new JButton("Sign In");
    JButton signUp = new JButton("Sign Up");

    UserWindow(){

        //settings for buttons
        signIn.setBounds(100,100,200,40);
        signIn.setFocusable(false);
        signIn.addActionListener(this);
        signUp.setBounds(100,160,200,40);
        signUp.setFocusable(false);
        signUp.addActionListener(this);


        //settings fot frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(signIn);
        frame.add(signUp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==signUp){
            Signup l = new Signup();
            //moving to window og "Sign Up"
        }
        if(e.getSource()==signIn){
            //moving to window to "Sign In"
            SignIn i = new SignIn();
        }
    }
}
