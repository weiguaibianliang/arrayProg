package JDBC;

//用户登录业务介绍

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
实现功能：
1、需求：模拟用户登录功能的实现
2、业务描述：
程序运行的时候，提供一个输入的入口，可以让用户输入用户名和密码
用户在输入用户名和密码之后，提交信息，java程序收集到用户信息
java程序连接数据库验证用户名和密码是否合法
合法：显示登录成功
不合法：显示登录失败
3、数据的准备：
在实际开发中，表的设计会使用专业的建模工具，我们这里只安装一个建模工具：PowerDesigner
使用PD工具来进行数据库表的设计。

4、当前程序存在的问题
用户名：fade
密码：’fade' or '1' ='1‘
登录成功
这种现象被称为SQL注入。（安全隐患）（黑客经常使用）

5、导致SQL注入的根本原因是什么？
用户输入的信息中含有sql语句关键字，并且这些关键字参与sql语句的编译过程，
导致sql语句的原意被扭曲，进而达到sql注入。

 */
public class JDBCTest06 {
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
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123456");
            //3、获取数据库操作对象
            stmt = conn.createStatement();
            //4、执行sql语句
            String sql = "select * from t_user where login = '"+loginName+"'and loginwd='"+loginPwd+"'";
            //以上正好完成了SQL语句的拼接，以下代码的含义是：发送SQL语句给DEMS，DEMS进行SQL编译。
            //正好将用户提供的非法信息编译进去，导致了原sql语句的含义被扭曲了。
           rs=  stmt.executeQuery(sql);
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
