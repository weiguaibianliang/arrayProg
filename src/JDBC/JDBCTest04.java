package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

//从属性资源文件中读取连接数据库信息
//将连接数据库的所有信息配置到配置文件中

/*
实际开发中不建议把连接数据库的信息写死到java程序中
 */
public class JDBCTest04 {
    public static void main(String[] args) {

        //使用资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver ");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn =null;
        Statement stmt = null;
        try {
            //1、注册驱动
           // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName(driver );
            //2、注册驱动的第二种方式
            //反射机制，类加载静态代码块,是常用的，因为参数是一个字符串，字符串可以写到xxx.properties(配置)文件中。
            //一下方法不需要接收返回值，因为我们只想用它的类加载动作。
            //Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn=DriverManager.getConnection(url,user,password);
            //3、获取数据库操作对象
            stmt = conn.createStatement();
            //4、执行SQL语句
            String sql = "delete from dept where deptno = 40";
            //String sql2 = "update dept det name ='销售部'，loc='天津' where deptno =20";
            //JDBC中的sql语句不需要提供分号结尾
            int count = stmt.executeUpdate(sql);
            System.out.println(count==1?"删除成功":"删除失败");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //6、释放资源
            try {
                if(stmt!=null){
                    stmt.close();
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            try {
                if(conn!=null){
                    conn.close();
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
