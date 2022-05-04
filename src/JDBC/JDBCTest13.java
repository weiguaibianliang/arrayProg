package JDBC;

import JDBC.utils.DBUtil;

import java.sql.*;

/**
 * 这个程序开启一个事务，这个事务专门进行查询，并用行级锁/悲观锁，锁住相关记录。
 */
public class JDBCTest13 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement  ps = null;
        ResultSet rs = null;
        //获取连接
        try {
            conn = DBUtil.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //获取数据库的预编译对象
            String sql= "select ename ,job,sal from emp where job = ? for update";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"MANAGER");
            //执行SQL
            rs=ps.executeQuery();
            //查询结果集
            while (rs.next()){
                System.out.println(rs.getString("ename")+","+rs.getString("job")+","+rs.getString("sal"));

            }
            //提交事务(事务结束)
            conn.commit();
        } catch (SQLException throwables) {
            if(conn!=null){
                try {
                    //回滚事务(事务结束)
                    conn.rollback();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();
        }
        finally {
            //释放资源
            DBUtil.close(conn,ps,rs);
        }
    }
}
