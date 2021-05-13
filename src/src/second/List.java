package second;




import com.first.Login_Passwords;
import com.first.Voters;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;





    public class List extends JFrame implements ActionListener {

        JFrame frame = new JFrame("LIST OF CANDIDATES");

        //Creation of buttons , fields
        JButton voteButton = new JButton("Select");
        JTextField idField = new JTextField("YOUR ID");
        JTextField fName = new JTextField("FIRST NAME");
        JTextField lName = new JTextField("LAST NAME");
        JTextField IDCand = new JTextField("ID OF CANDIDATE");




        public List() {

            //Setting of Buttons
            voteButton.setBounds(200, 300, 100, 50);
            voteButton.addActionListener(this);


            //Establish the connection
            ConnectionDb connect = new ConnectionDb("localhost", "postgres", "thff2015");
            connect.setNameDataBases("candidates");
            connect.initProperties();
            connect.init();


            //Setting of frame
            frame.setSize(new Dimension(600, 400));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new GridBagLayout());


            //JTable
            candTableModel ctm = new candTableModel();
            JTable candTable = new JTable(ctm);
            JScrollPane candScrollPane = new JScrollPane(candTable);
            candScrollPane.setPreferredSize(new Dimension(400, 400));
            ctm.addData(connect);


            //Adding the properties to the frame
            frame.add(candScrollPane, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
            frame.add(voteButton, new GridBagConstraints(1, 15, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
            frame.add(idField, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
            frame.add(fName, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
            frame.add(lName, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
            frame.add(IDCand, new GridBagConstraints(0, 15, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));





            frame.setVisible(true);
            frame.pack();
        }


        protected final static String url = "jdbc:postgresql://localhost:5432/postgres";
        protected final static String user = "postgres";
        protected final static String password = "thff2015";


        public Connection connect() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }
            return conn;

        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==voteButton){
                Login_Passwords ch = new Login_Passwords();
                Voters log = new Voters();
                //Checking the id of candidate(now we have 5 people in our list)
                if(Integer.parseInt(IDCand.getText())>5 || Integer.parseInt(IDCand.getText())<=0){
                    //PLAIN MESSAGE DISPLAY
                    //JOptionPane.Plain_Message for display plain clear message
                    JOptionPane.showMessageDialog(this, "This candidate is not available!", "Error", JOptionPane.PLAIN_MESSAGE);

                }
                else {
                    if (ch.Check(lName.getText(), Integer.parseInt(idField.getText())) == true) {
                        log.Insert(Integer.parseInt(idField.getText()), fName.getText(), lName.getText(), Integer.parseInt(IDCand.getText()));
                        //PLAIN MESSAGE DISPLAY
                        //JOptionPane.Plain_Message for display plain clear message
                        JOptionPane.showMessageDialog(this, "Successful!", " ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        //PLAIN MESSAGE DISPLAY
                        //JOptionPane.Plain_Message for display plain clear message
                        JOptionPane.showMessageDialog(this, "You've already voted!", "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                }





            }
        }



    }










