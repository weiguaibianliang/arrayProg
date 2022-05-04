package com.huzheng.company;
import java.util.Arrays;
public class Test14 {
    public static void main(String[] args) {
        Emp1 emp0 = new Emp1(1,"百战牌鼠标","BZ_001",99.21,0.91);
        Emp1 emp1 = new Emp1(2,"键盘侠玩偶","WO_102",99.22,0.92);
        Emp1 emp2 = new Emp1(3,"实战java程序设计","BK_001",99.23,0.93);
        Emp1 emp3 = new Emp1(4,"胡正牌西装","BZ_002",99.24,0.94);
        Emp1 emp4 = new Emp1(5,"大米牌手机","BZ_003",99.25,0.95);
        Emp1[] emps = new Emp1[5];
        emps[0] = emp0;
        emps[1] = emp1;
        emps[2] = emp2;
        emps[3] = emp3;
        emps[4] = emp4;
        Overstake(emps,900);
    }
   public static void Overstake(Emp1[] emps,double a){
        for(int i = 0;i<emps.length;i++){
            if((emps[i].getAcount())*(emps[i].getMoney())<a){
                System.out.println(emps[i]);
            }
            System.out.println();
        }

   }
}
class Emp1{
    private int id;
    private String name;
    private String number;
    private double money;
    private double acount;
    public Emp1() {
    }

    public Emp1(int id, String name, String number, double money, double acount) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.money = money;
        this.acount = acount;
    }

    @Override
    public String toString() {
        return "Emp1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", money=" + money +
                ", acount=" + acount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getAcount() {
        return acount;
    }

    public void setAcount(double acount) {
        this.acount = acount;
    }
}