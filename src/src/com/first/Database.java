package com.first;

public interface Database {
    public void insert(int n, String fname, String lname, String email, String gender);

    public void remove(int m);

    public void list();

    public void select(String fname, String lname);



}
