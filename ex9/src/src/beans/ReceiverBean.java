package src.beans;

public class ReceiverBean {
    private int num;
    private String name;
    public ReceiverBean(){}
    public void setNum(int num){this.num = num;}
    public int getNum(){return num;}
    public void setName(String name){this.name = name;}
    public String getName(){return name;}
    public String toString(){
        return getNum() + " " + getName();
    }
}
