package second;
import java.sql.*;
import java.util.Properties;
import java.lang.Class;

public class ConnectionDb {
    private String host;
    private String dataDb;
    private String root;
    private String password;
    private String url;

    private Properties properties = new Properties();
    private Connection mysqlConnection;

    public ConnectionDb(String host,String root,String password){
        this.host = host;
        this.root = root;
        this.password = password;
    }

    public ConnectionDb(String url,Properties properties){
        this.url = url;
        this.properties = properties;
    }

    public void setNameDataBases (String dataDb){
        this.dataDb = dataDb;
    }

    public void initProperties(){
        this.url = "jdbc:mysql://" + this.host + "/" + this.dataDb;

        properties.setProperty("user",this.root);
        properties.setProperty("password",this.password);
        properties.setProperty("useUnicode","true");
        properties.setProperty("characterEncoding","UTF-8");
        System.out.println(url);
    }

    public int init(){
        if(mysqlConnection!=null){
            try{
                mysqlConnection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        try {

            Class.forName("com.mysql.jdbc.Driver");
            mysqlConnection = DriverManager.getConnection(url,properties);
        }
        catch (SQLException | ClassNotFoundException e){
            e.getMessage();
            return 1;
        }
        return 0;
    }

    public void finalize(){
        try{
            mysqlConnection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet resultSetQuery(String query){
        try{
            Statement stmt = mysqlConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void sqlQuery(String query){
        try{
            Statement stmt = mysqlConnection.createStatement();
            stmt.executeQuery(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
