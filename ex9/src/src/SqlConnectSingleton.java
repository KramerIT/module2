package src;

import src.beans.ExpensesBean;
import src.beans.ReceiverBean;
import src.dao.ListExpensesDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlConnectSingleton implements ListExpensesDao {
    private String dbURL;
    private String username;
    private String password;
    Connection myConnection;
    private static SqlConnectSingleton instance = null;
    private SqlConnectSingleton(String dbURL, String username, String password){
        this.dbURL = dbURL;
        this.username = username;
        this.password = password;
    }
    public static SqlConnectSingleton setSqlConnect(String dbURL, String username, String password){
        if (instance == null) instance = new SqlConnectSingleton(dbURL, username, password);
        return instance;
    }
    public void addReceiver(ReceiverBean receiverBean){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Error loading drive:" + cnfe);
        }
        try {
            myConnection = DriverManager.getConnection(dbURL, username, password);
            java.sql.Statement statement = myConnection.createStatement();
            String query = "insert into receivers (num, name) " +
                    "values" + "(" + receiverBean.getNum() + ", " +
                    "\'" + receiverBean.getName() + "\'" + ")";
            statement.executeUpdate(query);
            myConnection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void addExpense(ExpensesBean expensesBean){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Error loading drive:" + cnfe);
        }
        try {
            myConnection = DriverManager.getConnection(dbURL, username, password);
            java.sql.Statement statement = myConnection.createStatement();
            String query = "insert into expenses (num, paydate, receiver, value) " +
                    "values" + "(" + expensesBean.getNum() + ", " +
                    "\'" + expensesBean.getPayDate() + "\'" + ", "  +
                    expensesBean.getReceiver() +  ", " + expensesBean.getValue() +  ")";
            statement.executeUpdate(query);
            myConnection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ReceiverBean getReceiver(int num){
        ReceiverBean tempReceiver = new ReceiverBean();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Error loading drive:" + cnfe);
        }
        try {
            myConnection = DriverManager.getConnection(dbURL, username, password);
            java.sql.Statement statement = myConnection.createStatement();
            String query = "select num, name from receivers where num = " + num;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                tempReceiver.setNum(resultSet.getInt(1));
                tempReceiver.setName(resultSet.getString(2));
            }
            myConnection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return tempReceiver;
    }
    public ExpensesBean getExpense(int num){
        ExpensesBean tempExpense = new ExpensesBean();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Error loading drive:" + cnfe);
        }
        try {
            myConnection = DriverManager.getConnection(dbURL, username, password);
            java.sql.Statement statement = myConnection.createStatement();
            String query = "select num, paydate, receiver, value from expenses where num = " + num;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                tempExpense.setNum(resultSet.getInt(1));
                tempExpense.setPayDate(resultSet.getString(2));
                tempExpense.setReceiver(resultSet.getString(3));
                tempExpense.setValue(resultSet.getDouble(4));
            }
            myConnection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return tempExpense;
    }
    public ArrayList<ReceiverBean> getReceivers(){
        ArrayList<ReceiverBean> tempReceiverArray = new ArrayList<ReceiverBean>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Error loading drive:" + cnfe);
        }
        try {
            myConnection = DriverManager.getConnection(dbURL, username, password);
            java.sql.Statement statement = myConnection.createStatement();
            String query = "select * from receivers";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                ReceiverBean tempReceiver = new ReceiverBean();
                tempReceiver.setNum(resultSet.getInt(1));
                tempReceiver.setName(resultSet.getString(2));
                tempReceiverArray.add(tempReceiver);
            }
            myConnection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
      return tempReceiverArray;
    }
    public ArrayList<ExpensesBean> getExpenses(){
        ArrayList<ExpensesBean> tempExpensesArray = new ArrayList<ExpensesBean>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Error loading drive:" + cnfe);
        }
        try {
            myConnection = DriverManager.getConnection(dbURL, username, password);
            java.sql.Statement statement = myConnection.createStatement();
            String query = "select * from expenses";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                ExpensesBean tempExpenses = new ExpensesBean();
                tempExpenses.setNum(resultSet.getInt(1));
                tempExpenses.setPayDate(resultSet.getString(2));
                tempExpenses.setReceiver(resultSet.getString(3));
                tempExpenses.setValue(resultSet.getDouble(4));
                tempExpensesArray.add(tempExpenses);
            }
            myConnection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return tempExpensesArray;
    }
    public void setQuery(String query){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Error loading drive:" + cnfe);
        }
        try {
            myConnection = DriverManager.getConnection(dbURL, username, password);
            java.sql.Statement statement = myConnection.createStatement();
            statement.executeUpdate(query);
            myConnection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public String getQuery(String query){
        return null;
    }
}
