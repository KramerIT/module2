package src;

import src.beans.ExpensesBean;
import src.beans.ReceiverBean;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        String dbURL = "jdbc:mysql://localhost:3306/ListExpenses";
        String username = "root";
        String password = "0000";
        SqlConnectSingleton SqlConnect = SqlConnectSingleton.setSqlConnect(dbURL, username, password);


        ReceiverBean Receiver = new ReceiverBean();
        Receiver.setNum(5);
        Receiver.setName("Кабельное телевидение \"Cosmos-TV\"");

        ExpensesBean Expenses = new ExpensesBean();
        Expenses.setNum(0);
        Expenses.setPayDate("2014-2-26");
        Expenses.setReceiver("5");
        Expenses.setValue(6300.40);

        SqlConnect.addReceiver(Receiver);
        SqlConnect.addExpense(Expenses);

        ReceiverBean TakeReceiver = SqlConnect.getReceiver(1);
        System.out.println(TakeReceiver);
        ExpensesBean TakeExpense = SqlConnect.getExpense(2);
        System.out.println(TakeExpense);

        ArrayList<ReceiverBean> ReceiversArray = SqlConnect.getReceivers();
        System.out.println(ReceiversArray);

        ArrayList<ExpensesBean> ExpensesArray = SqlConnect.getExpenses();
        System.out.println(ExpensesArray);


        String query = "delete from expenses where value = 6300.40 or value = 4200";
        SqlConnect.setQuery(query);

        System.out.println(SqlConnect.getExpenses());




/////////////////////////////////////////////////////////////////////////////////////////////////
        /*

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



        ReceiverBean Receiver = new ReceiverBean();
        Receiver.setName("Кабельное телевидение \"Cosmos-TV\"");
        Receiver.setNum(4);

        SqlConnectSingleton SqlConnect = SqlConnectSingleton.setSqlConnect(dbURL, username, password);
        SqlConnect.addReceiver(Receiver);




        try {
            myConnection = DriverManager.getConnection(dbURL, username, password);
            java.sql.Statement statement = myConnection.createStatement();
            String query = "insert into receivers (num, name) " +
                    "values" + "(" + Receiver.getNum() + ", " + "\'" + Receiver.getName() + "\'" + ")";
            //  String query2 = "Select count(*) FROM expenses";
            //  String query3 = "insert into expenses (num, paydate, receiver, value) values (1, '2013-5-10', 1, 4200.0)";

            statement.executeUpdate(query);
            username = query;
/*

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.println(resultSet.getDate(1) +
                        " " + resultSet.getDouble(2) + " " + resultSet.getString(3));
            }

           // statement.executeUpdate(query3);

           // ResultSet resultSet2 = statement.executeQuery(query2);

            // while (resultSet2.next()){
           // resultSet2.next();
          //  System.out.println(resultSet2.getInt(1));
            //  }

            System.out.println();

            myConnection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }












        try {
            myConnection = DriverManager.getConnection(dbURL, username, password);
            java.sql.Statement statement = myConnection.createStatement();
            String query = "Select paydate, value, name FROM expenses, receivers WHERE receiver=receivers.num";
            String query2 = "Select count(*) FROM expenses";
          //  String query3 = "insert into expenses (num, paydate, receiver, value) values (1, '2013-5-10', 1, 4200.0)";




            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.println(resultSet.getDate(1) +
                        " " + resultSet.getDouble(2) + " " + resultSet.getString(3));
            }

        //    statement.executeUpdate(query3);

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

*/




    }
}
