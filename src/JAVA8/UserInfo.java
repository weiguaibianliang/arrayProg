package JAVA8;

import org.junit.Test;


public class UserInfo {
    private String name;
    private String email;
    private Integer price;
    //定义一个无参构造器
    public UserInfo(){

    }
    //定义一个有参构造器
    public UserInfo(String name,String email,Integer price){
        this.name = name;
        this.email = email;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", price=" + price +
                '}';
    }
    @Test
    public void optionalTest(){
        //Optional--操作对象:filter

    }
}

