package src.beans;

public class ExpensesBean {
    public ExpensesBean(){}
    private int num;
    private String payDate;
    private String receiver;
    private double value;
    public void setNum (int num){this.num = num;}
    public int getNum(){return num;}
    public void setPayDate(String payDate){this.payDate = payDate;}
    public String getPayDate(){return payDate;}
    public void setReceiver(String receiver){this.receiver = receiver;}
    public String getReceiver(){return receiver;}
    public void setValue(double value){this.value = value;}
    public double getValue(){return value;}
    public String toString(){
        return getNum() + " " + getPayDate() + " " + getReceiver() + " " + getValue();
    }
}
