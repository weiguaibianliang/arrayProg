package JDBC;
//账户转账演示事务
//需要将自动提交机制转为手动提交机制

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * sql脚本：
 * drop table if exists t_act;
 * create table t_act(
 * actno bigint,balance double(7,2));
 * 注意：7表示有效数字的个数，2表示小数位的个数
 * insert into t_act(actno,balance) values(111,20000);
 * insert into t_act(actno,balance) values(222,0);
 * commit;
 * select * from t_act;
 *
 * 重点三行代码
 * conn.setAutoCommit(false);
 * conn.commit();
 * conn.rollback();
 *
 */
public class JDBCTest11 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;//这里使用PreparedStatement（预编译的数据库操作对象）
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123456");
            //将自动提交机制改为手动提交
            conn.setAutoCommit(false);//开启事务
            //3、获取预编译的数据库操作对象
           String sql1 = "update t_act set balance = ? where actno = ?";
           ps = conn.prepareStatement(sql1);
           //给?传值
            ps.setDouble(1,10000);
            ps.setInt(2,111);
            int count = ps.executeUpdate();
            //String s = null;
            //s.toString();

            //给?传值
            ps.setDouble(1,10000);
            ps.setInt(2,222);
            count+=ps.executeUpdate();
            System.out.println(count==2?"转账成功":"转账失败");

          //程序能够走到这里说明以上程序没有异常，事务结束，手动提交数据
          conn.commit(); //提交事务
          //回滚事务
          if(conn!=null){
              try {
                  conn.rollback();
              }
              catch (Exception e){
                  e.printStackTrace();
              }
          }
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
