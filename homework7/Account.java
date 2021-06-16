package homework7_;
import java.util.ArrayList;

/**
*
* @author _britney_
* @date 2021/5/24
*/


public class Account {
    String na;
    int id;  // 账户名
    double ba; // 余额
    double an; // 利率
    java.util.Date date;  // 日期
    ArrayList<Object> tr = new ArrayList<Object>();
    public Account(String na){
        this.na = na;
    }
    public Account(){
    }
    public java.util.Date getda(){
        return date;
    }
    public Account(int id, double ba){
        this.id = id;
        this.ba = ba;
        this.date =  new java.util.Date();
    }
    public Account(String na,int id,double ba){
        this.na = na;
        this.id = id;
        this.ba = ba;
    }
    public void setid(int id){
        this.id = id;
    }
    public int getid(){
        return this.id;
    }
    public void setba(double ba){
        this.ba = ba;
    }
    public double getba(){
        return this.ba;
    }
    public void setan(double an){
        this.an = an;
    }
    public double getan(){
        return this.an;
    }
    public double getMo(){
        return an / 1200;
    }
    public double getMi(){
        return ba * an / 1200;
    }
    public void wD(double a){ //  ArrayList 列表以字符串储存数据
        this.ba -= a;
        date = new java.util.Date();
        String b = "" + this.date;
        Tr c = new Tr('D',a,this.ba,b);
        this.tr.add(c);
    }
    public void de(double a){
        this.ba += an;
        date = new java.util.Date();
        String b = "" + this.date;
        Tr c = new Tr('W',a,this.ba,b);
        this.tr.add(c);
    }
    public void jiao(){ // 输出列表
        for(int i = 0 ; i < this.tr.size(); i++)
            System.out.println(this.tr.get(i));
    }
}


class Tr {
    char ty;
    double am;
    double ba;
    String de;
    java.util.Date date;
    public Tr(char ty,double am,double ba,String de){
        this.ty = ty;
        this.am = am;
        this.ba = ba;
        this.de = de;
    }
    public String toString(){ // 记得覆写 toString,不然返回的回是地址
        return "ty = " + ty + ", am = " + am + ", ba " + ba + ",de " + de;
    }
}

class Test { // 测试部分

    public static void main(String[] args) {
       Account a = new Account(112,20000.0);
       a.setan(4.5);
       a.wD(2500.0);
       a.de(3000.0);
       System.out.println("余额 ：" + a.getba());
       System.out.println("月利息 ： " + a.getMi());
       System.out.println("开户日期 ： " + a.getda());
       a.jiao();
    }

}
