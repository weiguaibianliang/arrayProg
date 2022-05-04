package JDBC;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1、解决SQL注入问题？
 * 只要用户提供信息不参与SQL语句的编译过程，问题就解决了
 * 即便用户提供的信息中含有SQL语句的关键字，但是没有参与编译，不起作用。
 * 要想用户信息不参与SQL语句的编译，那么必须使用java.sql.PreparedStatement
 * PreparedStatement接口继承了java.sql.statement.
 * PreparedStatement是属于预编译数据库操作对象
 * PreparedStatement的原理是：预先对SQL语句的框架进行编译，然后再给SQL语句传值
 *
 * 2、对比一下Statement和PrepareStatement?
 * -Statement存在SQL注入问题，PrepareStatement解决了SQL注入问题
 * -Statement是编译一次执行一次，PrepareStatement是编译一次，可执行n次，PrepareStatement效率较高一点。
 * -PrepareStatement在编译阶段做类型安全的检查。
 *
 * 综上所述：PrepareStatement使用较多，只有极少数的情况下需要使用Statement
 *
 * 3、什么情况下必须使用Statement?
 * 业务方面要求必须支持SQL注入的时候
 * Statement支持SQL注入，凡是业务方面要求是需要进行SQL语句拼接的，必须使用Statement。
 */

public class JDBCTest07 {
    public static void main(String[] args) {
        //初始化一个界面
        Map<String,String> userLoginInfo = initUI();
        //验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);
        //最后输出结果
        System.out.println(loginSuccess?"登录成功":"登录失败");
    }

    /**
     * 用户登录
     * @param userLoginInfo 用户登录信息
     * @return false表示失败，true表示成功。
     */

    private static boolean login(Map<String, String> userLoginInfo) {
        //打标记的意识
        boolean loginSuccess = false;
        //单独进行定义变量
        String loginName = userLoginInfo.get("login");
        String loginPwd = userLoginInfo.get("loginwd");
        //JDBC代码
        Connection conn = null;
        PreparedStatement ps = null;//这里使用PreparedStatement（预编译的数据库操作对象）
        ResultSet rs = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123456");
            //3、获取预编译的数据库操作对象
            //SQL语句的框子，其中一个？表示一个占位符，一个？接收一个值，注意：占位符不能使用单引号括起来
            String sql = "select * from t_user where login = ? and loginwd=?";
            ps = conn.prepareStatement(sql);
            //给占位符传值，第一个问号下标是1，第二个问号下标是2，JDBC中所有下标都是从1开始
            ps.setString(1,loginName);
            ps.setString(2,loginPwd);
            //4、执行sql语句
            //以上正好完成了SQL语句的拼接，以下代码的含义是：发送SQL语句给DEMS，DEMS进行SQL编译。
            //正好将用户提供的非法信息编译进去，导致了原sql语句的含义被扭曲了。
            rs=  ps.executeQuery();
            //5、处理查询结果集
            if(rs.next()){
                loginSuccess = true;
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
        return loginSuccess;
    }

    /**
     * 初始化用户界面
     * @return 用户输入的用户名和密码等登录信息
     */

    private static Map<String, String> initUI() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("用户名：");
        String loginName = scanner.nextLine();

        System.out.println("密码：");
        String loginPwd = scanner.nextLine();

        Map<String,String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("login",loginName);
        userLoginInfo.put("loginwd",loginPwd);

        return userLoginInfo;
    }
}

