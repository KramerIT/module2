package src.dao;

import src.beans.ExpensesBean;
import src.beans.ReceiverBean;

import java.util.ArrayList;

public interface ListExpensesDao {
    ReceiverBean getReceiver(int num);
    ArrayList <ReceiverBean> getReceivers();
    ExpensesBean getExpense(int num);
    ArrayList <ExpensesBean> getExpenses();
    void addReceiver(ReceiverBean receiverBean);
    void addExpense(ExpensesBean expensesBean);
    void setQuery(String query);
    String getQuery(String query);
}
