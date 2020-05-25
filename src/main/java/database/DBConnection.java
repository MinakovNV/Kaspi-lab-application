package database;

import logging.MessageLogger;
import logic.BlackListUsers;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    // JDBC URL, username and password of MySQL server
    // jdbc:mysql://localhost/kaspi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    private static final String url = "jdbc:mysql://localhost/kaspi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "admin";
    private static ArrayList<BlackListUsers> arr;

    public static MessageLogger lg;

    private static Connection con;
    private static Statement st;
    private static ResultSet rs;

    public static void dbConnector() throws ClassNotFoundException, SQLException {
        if(con == null){
            lg = new MessageLogger();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            lg.message("Connection success!");
        } else {
            lg.message("Already connected!");}
    }

    public static void uploadBlackList() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM blacklist";
        arr = new ArrayList<>();
        try {
            rs = st.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        while (rs.next())
        {
            BlackListUsers u = new BlackListUsers(rs.getInt("id"), rs.getString("FirstName"),
                    rs.getString("SecondName"), rs.getString("LastName"),
                    rs.getString("IIN"), rs.getString("cause"));

            arr.add(u);

        }
        st.close();
        con.close();
        lg.message("Data successfully uploaded!");
    }

    public static void showBlackList(){
        for (int i = 0; i< arr.size(); i++){
            arr.get(i).display();
        }
    }

    public static ArrayList<BlackListUsers> getArr() {
        return arr;
    }

}