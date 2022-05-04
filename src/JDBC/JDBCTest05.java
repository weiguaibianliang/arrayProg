package JDBC;
/*
处理查询结果集
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest05 {
    public static void main(String[] args) {
        //在释放资源的时候先实行的后关闭
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode","root","123456");
            //3、获取数据库操作对象
            stmt = conn.createStatement();
            //4、执行sql
            String sql = "select empno,ename,sal from emp";
            //int executeUpdate(insert/delete/update)
            // ResultSet executeQuery(select)
            //处理查询语句
            rs = stmt.executeQuery(sql);
            //5、处理查询结果集
            /*
            boolean flag1 = rs.next();
            System.out.println(flag1);//true
            if(flag1){

             */
                //光标指向的行有数据
                //取数据
                //getString()方法的特点是：不管数据库中的数据类型是什么，都是以String的形式取出
                /*
                String empno = rs.getString(1);//JDBC所有的下标是从1开始的，而不是从0开始的
                String ename = rs.getString(2);
                String sal = rs.getString(3);
                System.out.println(empno+","+ename+","+sal);

                 */
                //这个不是以列的下标获取，以列的名字获取
                while (rs.next()){
                    //重点注意：列名称不是表中的列名称，是查询结果集的列名称。
                    //除了可以以String类型取出之外，还可以以特定的类型取出。
                String empno = rs.getString("empno");
                String ename = rs.getString("ename");
                //String sal = rs.getString("sal");
                    double sal = rs.getDouble("sal");
                System.out.println(empno+","+ename+","+(sal+100));
            }
        }
        catch (Exception e){
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
