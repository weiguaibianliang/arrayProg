package com.huzheng.company;
import java.util.Arrays;
//使用javabean和一维数组保存表格信息,怎样利用遍历查找数据，其中还涉及到嵌套循环。
public class Test12 {

    public static void main(String[] args) {
        Emp emp0 = new Emp(1001,"高小一",18,"助理","2019-9-10");
        Emp emp1 = new Emp(1002,"高小二",19,"讲师","2019-9-11");
        Emp emp2 = new Emp(1003,"高小三",20,"班主任","2019-9-12");
        Emp[] emps = new Emp[3];
        emps[0] = emp0;
        emps[1] = emp1;
        emps[2] = emp2;
        Than(emps, 18);
        //System.out.println(Arrays.toString());
        //如何规定年龄，然后输出数据
        /*for(int i = 0;i<emps.length;i++){
            System.out.println(emps[i]);
        }

         */
    }
    //遍历数据，找出大于18岁的人的信息
    public static void Than(Emp[] emps,int a){
        for(int i = 0;i<emps.length;i++){
            if(emps[i].getAge()>a){
                System.out.println(emps[i]);
            }
        }
    }


}
class Emp{
    private int id;
    private String name;
    private int age;
    private String job;
    private String hiredate;
    public Emp(){

    }

    public Emp(int id, String name, int age, String job, String hiredate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return getId()+"\t"+getName()+"\t"+getAge()+"\t"+getJob()+"\t"+getHiredate()+"\t";
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }
}
