package demo1;

public class User {
    private String username;
    private double leftMoney;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, double leftMoney) {
        this.username = username;
        this.leftMoney = leftMoney;
    }

    //show user's information
    public void show(){
        System.out.println("User name: "+this.username+", Wallet balance: "+leftMoney+"￥");
    }

    //get and set
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getLeftMoney() {
        return leftMoney;
    }

    public void setLeftMoney(double leftMoney) {
        this.leftMoney = leftMoney;
    }

}
