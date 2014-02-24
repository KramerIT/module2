package src;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Error loading drive:" + cnfe);
        }
        String dbURL = "jdbc:mysql://localhost:3306/ListExpenses";
        String username = "root";
        String password = "0000";
        Connection myConnection;
        try {
            myConnection = DriverManager.getConnection(dbURL, username, password);
            java.sql.Statement statement = myConnection.createStatement();
            String query = "Select paydate, value, name FROM expenses, receivers WHERE receiver=receivers.num";
            String query2 = "Select count(*) FROM expenses";
            String query3 = "insert into expenses (num, paydate, receiver, value) values (1, '2013-5-10', 1, 4200.0)";




            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.println(resultSet.getDate(1) +
                        " " + resultSet.getDouble(2) + " " + resultSet.getString(3));
            }

            statement.executeUpdate(query3);

            ResultSet resultSet2 = statement.executeQuery(query2);

           // while (resultSet2.next()){
            resultSet2.next();
                System.out.println(resultSet2.getInt(1));
          //  }

            System.out.println();




            myConnection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }
}
