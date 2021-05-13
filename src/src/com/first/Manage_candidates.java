package com.first;

import java.sql.*;
import java.util.Scanner;

public class Manage_candidates {

    public void show() {
        System.out.println("What would you like?");
        System.out.println("(1) - Record");
        System.out.println("(2) - Delete");
        System.out.println("(3) - List of candidates");
        System.out.println("(4) - Search by Full Name");
        System.out.println("(0) - Back");
        System.out.println("Write down:");
        Scanner cin = new Scanner(System.in);
        int ch = cin.nextInt();
        System.out.println();


        switch (ch) {
            case 1:
                System.out.println("Write down");

                System.out.print("ID : ");
                int id = cin.nextInt();

                System.out.print("First Name : ");
                String fName = cin.next();


                System.out.print("Last Name : ");
                String lName = cin.next();

                System.out.print("Email : ");
                String email = cin.next();

                System.out.print("Gender : ");
                String gender = cin.next();

                Insert(id, fName, lName, email, gender);
                System.out.println("The records were added successfully!");
                show();
                break;

            case 2:
                System.out.println("Write the ID of candidate!");
                System.out.print("ID : ");
                int n = cin.nextInt();
                Delete(n);
                System.out.println("Candidate was deleted from the list!");
                show();
                break;

            case 3:
                // System.out.println("Enter the ID of candidate : ");
                // String req = cin.next();
                allCandidates();
                show();
                break;
            case 4:
                System.out.print("First name : ");
                String name = cin.next();
                System.out.print("Last name : ");
                String lname = cin.next();
                Select(name,lname);
                show();
                break;



            case 0:
                /*Info sh = new Info();
                sh.showInfoAd();
                break;*/




        }
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

    public final void Insert(int candidate_id, String first_name, String last_name, String email, String gender) {
        Connection con = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(Manage_candidates.url, Manage_candidates.user, Manage_candidates.password);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO candidates (candidate_id, first_name, last_name, email, gender) VALUES(?,?,?,?,?)");

            stmt.setInt(1, candidate_id);
            stmt.setString(2, first_name);
            stmt.setString(3, last_name);
            stmt.setString(4, email);
            stmt.setString(5, gender);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public final void Delete(int id) {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(Manage_candidates.url, Manage_candidates.user, Manage_candidates.password);
            stmt = con.createStatement();
            String pos = "DELETE FROM candidates WHERE candidate_id = " + id;
            stmt.executeQuery(pos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void allCandidates() {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(Manage_candidates.url, Manage_candidates.user, Manage_candidates.password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from candidates where candidate_id % 1 = 0");
            while (rs.next()) {
                System.out.println("ID : " + rs.getInt("candidate_id"));
                System.out.println("Full Name : " + rs.getString("first_name") + " " + rs.getString("last_name"));
                System.out.println("Email : " + rs.getString("email"));
                System.out.println("Gender : " + rs.getString("gender"));
                System.out.println("===============================================");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void Select(String name,String name2) {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(Manage_candidates.url, Manage_candidates.user, Manage_candidates.password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from candidates where candidate_id % 1 = 0");
            while (rs.next()) {
                if (name.equals(rs.getString("first_name")) && name2.equals(rs.getString("last_name")) ) {
                    System.out.println("ID : " + rs.getInt("candidate_id"));
                    System.out.println("Full Name : " + rs.getString("first_name") + " " + rs.getString("last_name"));
                    System.out.println("Email : " + rs.getString("email"));
                    System.out.println("Gender : " + rs.getString("gender"));
                    System.out.println("===============================================");
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }







}







