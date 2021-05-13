package com.first; // package

import second.*;
import second.List;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class Login_Passwords extends Component implements Registration { //we need this class for editing table loginpassword and work with frame


    protected final static String url = "jdbc:postgresql://localhost:5432/postgres";
    protected final static String user = "postgres";
    protected final static String password = "thff2015"; // for connecting with SQL DB


    public Connection connect() { // this method make connecting to SQL DB easier
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return conn;

    }

    @Override // we need override because this methods was taken from interface Registration
    public void Insert(int voter_id, String first_name, String last_name, String username, String password, String email) { // this methods is used for inserting values to table loginpassword
        Connection con = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(Login_Passwords.url, Login_Passwords.user, Login_Passwords.password);
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

    @Override// we need override because this methods was taken from interface Registration
    public void Select(String username, String password) { // this methods is used with frame and it check username and password in frame which we write

        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(Login_Passwords.url, Login_Passwords.user, Login_Passwords.password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from loginpassword where voter_id % 1 = 0");
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
                new List();
            } else {
                //PLAIN MESSAGE DISPLAY
                //JOptionPane.Plain_Message for display plain clear message
                JOptionPane.showMessageDialog(this, "Your Username or Password incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    int c = 0;
    int k = 0;

    @Override// we need override because this methods was taken from interface Registration
    public void SelectForReg(int id) { //this methods is used with frame and it help user to sign up

        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(Login_Passwords.url, Login_Passwords.user, Login_Passwords.password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from loginpassword where voter_id % 1 = 0");

            while (rs.next()) {

                if (id == rs.getInt("voter_id")) {


                    k = 0;


                    break;
                } else {
                    k = 1;


                }


            }
            if (k < 1) {
                //PLAIN MESSAGE DISPLAY
                //JOptionPane.Plain_Message for display plain clear message
                JOptionPane.showMessageDialog(this, "You've already have an account!", "Error", JOptionPane.ERROR_MESSAGE);
                SignIn ss = new SignIn();

            } else {
                //PLAIN MESSAGE DISPLAY
                //JOptionPane.Plain_Message for display plain clear message
                JOptionPane.showMessageDialog(this, "Successful!", " ", JOptionPane.INFORMATION_MESSAGE);
                SignIn ss = new SignIn();

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    //This method will check
    public boolean Check(String lName, int voter_id) { // this methods is used with frame and it check username and password in frame which we write

        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(Login_Passwords.url, Login_Passwords.user, Login_Passwords.password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from voters where voter_id % 1 = 0");
            int c = 0;
            int k = 0;

            while (rs.next()) {

                if (lName.equals(rs.getString("last_name")) && (voter_id == (rs.getInt("voter_id")))) {

                    k = 0;

                    break;


                    // break;
                } else {
                    k = 1;


                }


            }
            if (k < 1) {
                return false;
            } else {

                return true;


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return true;
        }

    }}





