package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JDBC事务机制
 * 1、JDBC中的事务是自动提交的，什么是自动提交？
 * 只要执行任意一条DML语句，则自动提交一次，这是JDBC默认的行为。
 * 但是在实际的业务当中，通常都是N条DML语句共同联合才能完成的，必须保证他们这些DML语句
 * 在同一个事务中同时成功或同时失败。
 *
 * 2、以下程序先来验证以下JDBC事务是否是自动提交机制！
 * 测试结果：JDBC中只要执行任意一条DML语句，就提交一次。
 *
 */
public class JDBCTest10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;//这里使用PreparedStatement（预编译的数据库操作对象）
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123456");
            //3、获取预编译的数据库操作对象
            String sql1 = "update dept set dname = ? where deptno = ?";
            ps = conn.prepareStatement(sql1);
            ps.setString(1,"x部门");
            ps.setInt(2,30);
            //4、执行sql语句
            int count = ps.executeUpdate();
            System.out.println(count);
           // ps = conn.prepareStatement(sql1);
            ps.setString(1,"y部门");
            ps.setInt(2,20);
            //4、执行sql语句
            //int count = ps.executeUpdate();
            System.out.println(count);
            //以上正好完成了SQL语句的拼接，以下代码的含义是：发送SQL语句给DEMS，DEMS进行SQL编译。
            //正好将用户提供的非法信息编译进去，导致了原sql语句的含义被扭曲了。
            //5、处理查询结果集
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //6、释放资源
            if(ps!=null){
                try {
                    ps.close();
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
