package com.huzheng.company;

public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;
    public Employee(String name,double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }


    public double getSalary() {
        return salary;
    }
    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary += raise;
    }
    //进行与其他人的薪资进行比较
    @Override
    public int compareTo(Employee other) {
        return Double.compare(salary,other.salary);
    }
}
