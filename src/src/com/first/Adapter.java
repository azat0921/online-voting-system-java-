package com.first;


public class Adapter extends Manage_candidates implements Database {


    @Override
    public void insert(int candidate_id, String first_name, String last_name, String email, String gender) {
        Insert(candidate_id, first_name, last_name, email, gender);
    }

    @Override
    public void remove(int id) {
        Delete(id);

    }


    @Override
    public void list() {
        allCandidates();
    }

    @Override
    public void select(String fName, String lNAme) {
        Select(fName, lNAme);
    }
}
