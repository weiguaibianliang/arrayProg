package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//类加载的方式注册驱动
public class JDBCTest03 {
    public static void main(String[] args) {
        try {
            //2、注册驱动的第二种方式
            //反射机制，类加载静态代码块,是常用的，因为参数是一个字符串，字符串可以写到xxx.properties(配置)文件中。
            //一下方法不需要接收返回值，因为我们只想用它的类加载动作。
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}