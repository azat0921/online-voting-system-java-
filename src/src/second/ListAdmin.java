package second;

import com.first.Voters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ListAdmin extends JFrame implements ActionListener {

    JFrame frame = new JFrame("VOTING RESULTS");

    JButton voteButton = new JButton("Select");
    JTextField idField = new JTextField("YOUR ID");
    JTextField fName = new JTextField("FIRST NAME");
    JTextField lName = new JTextField("LAST NAME");
    JTextField IDCand = new JTextField("ID OF CANDIDATE");




    public ListAdmin() {
        voteButton.setBounds(200, 300, 100, 50);
        voteButton.addActionListener(this);

        ConnectionDb connect = new ConnectionDb("localhost", "postgres", "thff2015");
        // Establish the connection with our table "voters"

        connect.setNameDataBases("voters");//set the name
        connect.initProperties();//- set the properties like:
                                 // user , password , url


        connect.init(); // - access the properties


        frame.setSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());


        //JTable
        voterTable ctm = new voterTable();
        JTable vTable = new JTable(ctm);

        JScrollPane voterScrollPane = new JScrollPane(vTable);
        voterScrollPane.setPreferredSize(new Dimension(400, 400));
        ctm.addData(connect);


       frame.add(voterScrollPane, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));



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
            Voters log = new Voters();

            log.Insert(Integer.parseInt(idField.getText()),fName.getText(), lName.getText(),Integer.parseInt(IDCand.getText()));
            //PLAIN MESSAGE DISPLAY
            //JOptionPane.Plain_Message for display plain clear message
            JOptionPane.showMessageDialog(this,"Successful!"," ",JOptionPane.INFORMATION_MESSAGE);


        }
    }


}











