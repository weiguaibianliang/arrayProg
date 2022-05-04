package com.huzheng.company;


import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JavaLogin extends JFrame {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private final String URL = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=rm";
    private final String USER = "sa";
    private final String PASSWORD = "123456";

    public JavaLogin() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JavaLogin javalogin = new JavaLogin();
    }

    private void jbInit() throws Exception {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setLayout(null);
        jButton1.setBounds(new Rectangle(42, 167, 128, 45));
        jButton1.setText("登陆");
        jButton1.addActionListener(new JavaLogin_jButton1_actionAdapter(this));
        JUser.setBounds(new Rectangle(129, 36, 223, 25));
        jLabel2.setText("密码:");
        jLabel2.setBounds(new Rectangle(58, 78, 37, 51));
        jLabel1.setText("用户名:");
        jLabel1.setBounds(new Rectangle(48, 27, 46, 36));
// jLabel3.setFont(new java.awt.Font("黑体", Font.PLAIN, 12));
// jLabel3.setForeground(Color.red);
// jLabel3.setText("数据库用户登陆程序:用户名:sa 密码:123456 ");
// jLabel3.setBounds(new Rectangle(13, 229, 387, 40));
        JPass.setBounds(new Rectangle(128, 90, 223, 29));
        jButton2.addActionListener(new JavaLogin_jButton2_actionAdapter(this));
// this.getContentPane().add(jLabel3);
        this.getContentPane().add(jButton1);
        this.getContentPane().add(jButton2);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(JUser);
        this.getContentPane().add(JPass);
        jButton2.setBounds(new Rectangle(231, 168, 133, 44));
        jButton2.setText("退出");
        this.setBounds(300, 200, 430, 330);
        this.setVisible(true);
    }

    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JTextField JUser = new JTextField();
    JPasswordField JPass = new JPasswordField();

    // JLabel jLabel3 = new JLabel();
    public void jButton1_actionPerformed(ActionEvent actionEvent) {
        String jusername = JUser.getText().trim();
        char[] s = JPass.getPassword();
        String jpassword = new String(s);
        if (jusername.equals("") || jpassword.equals(""))// 如果没输用户名或密码,则提示对不起,请输入用户名或密码
        {
            JOptionPane.showMessageDialog(this, "对不起,请输入用户名或密码.", "错误!",
                    JOptionPane.ERROR_MESSAGE);
        } else// 如果都有数据了就开始连接数据库验证
        {
            try {
                Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);// 这里就是连接数据库了
                String sql = "select * from ygonInfo where 员工姓名='" + jusername
                        + "'";// 执行的sql语句,在数据库里查找我们输的用户名
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                if (rs.next())// 如果存在,就验证密码
                {
                    if (rs.getString("登陆密码").equals(jpassword))// 如果密码正确就提示,反之
                    {
                        JOptionPane.showMessageDialog(this, "登陆数据库成功", "恭喜你!",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "对不起,密码错误,请重新输入",
                                "登陆失败", JOptionPane.ERROR_MESSAGE);
                    }
                } else {// 如果没有查找到用户名就提示
                    JOptionPane.showMessageDialog(this, "用户名不存在,请重新输入", "错误!",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassNotFoundException ex) {// 这后面是抛出异常
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (rs != null)
                        rs.close();
                    if (stmt != null)
                        stmt.close();
                    if (conn != null)
                        conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    public void jButton2_actionPerformed(ActionEvent actionEvent) {
        System.exit(0);// 这是退出按纽
    }

}

class JavaLogin_jButton2_actionAdapter implements ActionListener {
    private JavaLogin adaptee;

    JavaLogin_jButton2_actionAdapter(JavaLogin adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jButton2_actionPerformed(actionEvent);
    }
}

class JavaLogin_jButton1_actionAdapter implements ActionListener {
    private JavaLogin adaptee;

    JavaLogin_jButton1_actionAdapter(JavaLogin adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jButton1_actionPerformed(actionEvent);
    }
}
