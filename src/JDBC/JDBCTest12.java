package JDBC;

import JDBC.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 这个程序有两个任务
 * 第一：测试DBUtils是否好用
 * 第二：模糊查询怎么写？
 */
public class JDBCTest12 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        try {
            //获取连接
            conn = DBUtil.getConnection();
            //获取预编译的数据库操作对象
            /*
            错误的写法
            String sql= "select ename from emp where ename like '_?%";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"_A%");
            rs = ps.executeQuery();

             */
            String sql= "select ename from emp where ename like ?";
            ps = conn.prepareStatement(sql);
            ps .setString(1,"_A%");
            //执行sql语句
            rs = ps.executeQuery();
            //查询结果集
            while (rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            //释放资源
            DBUtil.close(conn,ps,rs);
        }
    }
}
