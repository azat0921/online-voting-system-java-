package second; // package

import com.first.Admin;
import com.first.Login_Passwords;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AdminLogin extends Component { //we need this class for work with admin's frame

    protected final static String url = "jdbc:postgresql://localhost:5432/postgres";
    protected final static String user = "postgres";
    protected final static String password1 = "thff2015"; // for connecting with SQL DB

    protected int voter_id;
    protected String first_name;
    protected String last_name;
    protected String username;
    protected String password;
    protected String email;

    AdminLogin(){}// no param constructor
    AdminLogin(int voter_id, String first_name, String last_name){ // param constructor
        this.voter_id = voter_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    AdminLogin(String username, String password, String email){ // param constructor
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public Connection connect() { // this method make connecting easier
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return conn;

    }

    public final void Insert(int voter_id, String first_name, String last_name, String username, String password, String email) { // this methods needs for inserting values to table loginpassword
        Connection con = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(AdminLogin.url, AdminLogin.user, AdminLogin.password1);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO loginPassword (voter_id,first_name, last_name, username, password,email) VALUES(?,?,?,?,?,?)");

            stmt.setInt(1, voter_id);
            stmt.setString(2, first_name);
            stmt.setString(3, last_name);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setString(6, email);


            stmt.executeUpdate();
            System.out.println("Successful!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void Select(String username, String password) { //this method for sing in admin's frame

        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(AdminLogin.url, AdminLogin.user, AdminLogin.password1);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from admins where admin_id % 1 = 0");
            int c = 0;
            int k = 0;

            while (rs.next()) {

                if (username.equals(rs.getString("username")) && (password.equals(rs.getString("password")))) {

                    k = 1;

                    break;


                    // break;
                } else {
                    k = 0;


                }


            }
            if (k > c) {
                JOptionPane.showMessageDialog(this, "You are in the System!", "", JOptionPane.INFORMATION_MESSAGE);
                new ListAdmin();

            } else {
                //PLAIN MESSAGE DISPLAY
                //JOptionPane.Plain_Message for display plain clear message
                JOptionPane.showMessageDialog(this, "Your Username or Password incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    int k = 0;
    int c = 0;

    public void SelectForReg(int id, String uName, String email) { //we need this method for sign up in frame

        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(AdminLogin.url, AdminLogin.user, AdminLogin.password1);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from admins where admin_id % 1 = 0");


            while (rs.next()) {

                if (id == rs.getInt("admin_id") && uName.equals(rs.getString("username")) && email.equals(rs.getString("email"))) {


                    k = 0;


                    // break;
                } else {
                    k = 1;
                    break;

                }


            }
            if (k > c) {

                JOptionPane.showMessageDialog(this, "Successful!", "", JOptionPane.PLAIN_MESSAGE);

                SignInAd ss = new SignInAd();
            } else {
                //PLAIN MESSAGE DISPLAY
                //JOptionPane.Plain_Message for display plain clear message
                JOptionPane.showMessageDialog(this, "You've already have an account!", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
