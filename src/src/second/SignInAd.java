package second;

import com.first.Login_Passwords;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInAd extends JFrame implements ActionListener {
    //=========================================
    //LABELS
    JFrame frame = new JFrame();
    JLabel fName = new JLabel("First Name");
    JLabel lName = new JLabel("Last Name");
    JLabel username = new JLabel("Username");
    JLabel password = new JLabel("Password");

    //=========================================
    //FIELDS
    JTextField Fname = new JTextField();
    JTextField Lname = new JTextField();
    JTextField uName = new JTextField();
    JTextField pWord = new JTextField();


    JButton button = new JButton("Next");

    //==========================================
    public SignInAd(){
        button.setBounds(200,300,100,50);
        button.addActionListener(this);



        //================================================

        username.setBounds(0, 100, 500, 50);
        username.setFocusable(false);
        username.setFont(new Font(null, Font.PLAIN, 25));


        uName.setBounds(150, 110, 200, 40);
        uName.setPreferredSize(new Dimension(250, 40));


        //================================================


        password.setBounds(0, 150, 500, 50);
        password.setFocusable(false);
        password.setFont(new Font(null, Font.PLAIN, 25));

        pWord.setBounds(150, 160, 200, 40);
        pWord.setPreferredSize(new Dimension(250, 40));

        //====================================================


        // Adding the properties to the frame

        frame.add(username);
        frame.add(password);

        frame.add(uName);
        frame.add(pWord);

        frame.add(button);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500, 500);


        frame.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            AdminLogin log = new AdminLogin();
            log.Select(uName.getText(),pWord.getText());






        }
    }
}
