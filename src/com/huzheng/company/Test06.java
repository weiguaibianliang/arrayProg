package com.huzheng.company;

public class Test06 {
    public static void main(String[] args) {
        Man1 m = new Man1(10,"高小一");

        //静态初始化需要在声明后直接初始化
        Man1[] mans ={
                m,
                new Man1(20,"高小二"),
                new Man1(30,"高小三"),
                new Man1(40,"高小四"),
                new Man1(50,"高小五")
        };

        mans[0] = m;


        for(int i=0;i<mans.length;i++){
            Man1  man = mans[i];
            System.out.println(man);
        }
        //增强for循环(读取元素的值)读取mans中的所有man元素
        for(Man1 man:mans){
            System.out.println(man);
        }


    }

}

class Man1 {
    private int id;
    private String name;

    public Man1(){}

    public Man1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return  "id:"+id+",name:"+this.name;
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
}


