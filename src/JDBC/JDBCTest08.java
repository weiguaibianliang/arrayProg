package JDBC;

import java.sql.*;
import java.util.Scanner;

//演示Statement的用途
public class JDBCTest08 {
    public static void main(String[] args) {
        //用户在控制台输入desc就是降序，输入asc就是升序
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入desc或asc,desc表示降序，asc表示升序");
        System.out.println("请输入：");
        String keywords = scanner.nextLine();
        //执行SQL
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123456");
            //3、获取预编译的数据库操作对象
            stmt = conn.createStatement();
            //4、执行SQL
            String sql = "select ename from emp order by ename "+keywords;
            rs = stmt.executeQuery(sql);
            //5、遍历结果集
            while(rs.next()){
                System.out.println(rs.getString("ename"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //6、释放资源
            if(rs!=null){
                try {
                    rs.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
