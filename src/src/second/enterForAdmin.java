package second;

import com.first.Login_Passwords;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class enterForAdmin extends JFrame implements ActionListener {
    JFrame frame = new JFrame();



    //JLabel - a GUI display area,
    //for a string of text, an image ,or both

    JLabel id = new JLabel("ID");
    JLabel fName = new JLabel("First Name");
    JLabel lName = new JLabel("Last Name");
    JLabel username = new JLabel("Username");
    JLabel password = new JLabel("Password");
    JLabel email = new JLabel("Email");


    //JTextField - a GUI textbox component that can be used to add,
    // set,or get text
    JTextField ID = new JTextField();
    JTextField Fname = new JTextField();
    JTextField Lname = new JTextField();
    JTextField uName = new JTextField();
    JTextField pWord = new JTextField();
    JTextField eMail = new JTextField();

    //Creation of Button --> "GO"

    JButton button = new JButton("GO");


    enterForAdmin() {

        button.setBounds(200,300,100,50);
        button.addActionListener(this);


        id.setBounds(0, 250, 500, 50);
        id.setFocusable(false);
        id.setFont(new Font(null, Font.PLAIN, 25));


        ID.setBounds(150, 260, 200, 40);
        ID.setPreferredSize(new Dimension(50, 40));


        //================================================
        fName.setBounds(0, 0, 500, 50);
        fName.setFocusable(false);
        fName.setFont(new Font(null, Font.PLAIN, 25));


        Fname.setBounds(150, 10, 200, 40);
        Fname.setPreferredSize(new Dimension(50, 40));


        //=================================================

        lName.setBounds(0, 50, 500, 50);
        lName.setFocusable(false);
        lName.setFont(new Font(null, Font.PLAIN, 25));

        Lname.setBounds(150, 60, 200, 40);
        Lname.setPreferredSize(new Dimension(250, 40));


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

        //================================================


        email.setBounds(0, 200, 500, 50);
        email.setFocusable(false);
        email.setFont(new Font(null, Font.PLAIN, 25));

        eMail.setBounds(150, 210, 200, 40);
        eMail.setPreferredSize(new Dimension(250, 40));

        //================================================

        //Add all to the frame


        frame.add(id);
        frame.add(ID);
        frame.add(fName);

        frame.add(lName);

        frame.add(username);
        frame.add(password);
        frame.add(email);

        frame.add(Fname);

        frame.add(Lname);

        frame.add(uName);
        frame.add(pWord);
        frame.add(eMail);



        frame.add(button);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500, 500);



        frame.setVisible(true);

    }





    @Override
    public void actionPerformed(ActionEvent e) {
        String mess = "You've already have an account!";
        if(e.getSource()==button){


           AdminLogin log = new AdminLogin();
           log.SelectForReg(Integer.parseInt(ID.getText()),uName.getText(),eMail.getText());




        }
    }

}
