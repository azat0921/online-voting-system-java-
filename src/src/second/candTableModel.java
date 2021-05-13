package second;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;

public class candTableModel extends AbstractTableModel {
    private int columnCount = 5;
    private ArrayList<String []> dataArrayList;


    public candTableModel(){
        dataArrayList = new ArrayList<String []>();
        for(int i=0;i<dataArrayList.size();i++){
            dataArrayList.add(new String[getColumnCount()]);
        }
    }
    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0:
                return "candidate_id";
            case 1:
                return "first_name";
            case 2 :
                return "last_name";
            case 3:
                return "email";
            case 4:
                return "gender";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String []rows = dataArrayList.get(rowIndex);
        return rows[columnIndex];
    }
    public void addData(String []row){
        String []rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);
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
    public void addData(ConnectionDb connect)  {


        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(candTableModel.url, candTableModel.user, candTableModel.password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from candidates");
            while (rs.next()) {
                String []row = {
                        rs.getString("candidate_id"),
                        rs.getString("first_name") ,
                        rs.getString("last_name"),
                        rs.getString("email"),
                rs.getString("gender")
                };

                addData(row);



            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}
