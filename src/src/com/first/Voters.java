package com.first;

import second.ConnectionDb;
import second.List;
import second.SignIn;

import java.sql.*;
import java.util.Scanner;
import com.first.Login_Passwords;
import second.candTableModel;

import javax.swing.*;


public class Voters { // we need this class for editing table voters

    public String username;
    public Voters(){} // no param constructor
    Voters(String username){ // param constructor
        this.username = username;
    }

    protected final static String url = "jdbc:postgresql://localhost:5432/postgres";
    protected final static String user = "postgres";
    protected final static String password = "thff2015"; // for connecting with SQL DB

    public Connection connect() { // method which make connecting with SQL DB easier
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }



    public final void Insert(int voter_id, String first_name, String last_name, int candidate_id) { // this method insert values to table voters
        Connection con = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(Voters.url, Voters.user, Voters.password);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO voters (voter_id,first_name, last_name, candidate_id) VALUES(?,?,?,?)");

            stmt.setInt(1, voter_id);

            stmt.setString(2, first_name);
            stmt.setString(3, last_name);
            stmt.setInt(4, candidate_id);


            stmt.executeUpdate();
            System.out.println("Successful!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}



