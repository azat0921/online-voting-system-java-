package second;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdWindow extends JFrame implements ActionListener {
    JFrame frame = new JFrame();


    //Creation the buttons like : "Sign In"
    JButton signIn = new JButton("Sign In");


    AdWindow(){
        signIn.setBounds(100,100,200,40);
        signIn.setFocusable(false);
        signIn.addActionListener(this);


        //signUp.setBounds(100,160,200,40);
        //signUp.setFocusable(false);
        //signUp.addActionListener(this);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(signIn);
       // frame.add(signUp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==signIn){

            //Moving to another Window
            SignInAd ad = new SignInAd();
        }

    }
}
