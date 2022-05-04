package com.huzheng.company;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

  public class LoginFrame extends JFrame {
    private JPanel pnlMain;
    //标签控件
    private JLabel lblTitle;
    private JLabel lblUserName;
    private JLabel lblUserPwd;
    //输入用户名的文本框控件
    private JTextField txtUserName;
    //输入密码的密码框控件
    private JPasswordField pwdUserPwd;
    //登录和退出按钮控件
    private JButton btnLogin;
    private JButton btnQuit;

    public LoginFrame(){
        //实例化各种容器和控件
        pnlMain = new JPanel(null);
        lblTitle = new JLabel("用户登录");
        lblUserName = new JLabel("用户姓名");
        lblUserPwd = new JLabel("用户学号");
        txtUserName = new JTextField();
        pwdUserPwd = new JPasswordField();
        btnLogin = new JButton("登录");
        btnQuit = new JButton("退出");
        init();

    }
    //对文本框对象和密码框对象添加get方法
    public JTextField getTxtUserName(){
        return txtUserName;
    }
    public JPasswordField getPwdUserPwd(){
        return pwdUserPwd;
    }
    //该方法对窗口进行初始化
    public void init(){
        //设置窗口属性
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("microCAD登录界面");
        this.setBounds(200,200,300,220);
        this.setResizable(false);
        /*
        设置各个控件的位置和坐标
        SetBounds方法的前两个参数为控件的左上角坐标，后两个参数为控件的宽度和高度
         */
        lblTitle.setBounds(100,10,100,30);
        lblUserName.setBounds(20,60,75,25);
        lblUserPwd.setBounds(20,100,75,25);
        txtUserName.setBounds(100,60,120,25);
        pwdUserPwd.setBounds(100,100,120,25);
        btnLogin.setBounds(50,140,75,25);
        btnQuit.setBounds(150,140,75,25);
        /*
        在退出按钮上添加按钮按下时的监听对象，并在实例化监听对象中传入当前窗口对象本身

         */
        btnQuit.addActionListener(
                new LoginFrame_btnQuit_ActionListener(this));

        /*
        在d登录按钮上添加按钮按下时的监听对象，并在实例化监听对象中传入当前窗口对象本身

         */
        btnLogin.addActionListener(new LoginFrame_btnLogin_ActionListener(this));
        //在用户姓名的文本框中添加默认文本
        txtUserName.setText("请输入用户姓名");
        //在用户姓名的文本框上添加鼠标事件
        txtUserName.addMouseListener(new LoginFrame_txtUserName_MouseListener(this));
        //将所有控件压入容器中
        pnlMain.add(lblTitle);
        pnlMain.add(lblUserName);
        pnlMain.add(lblUserPwd);
        pnlMain.add(txtUserName);
        pnlMain.add(pwdUserPwd);
        pnlMain.add(btnLogin);
        pnlMain.add(btnQuit);
        this.add(pnlMain);
        this.setVisible(true);


    }

    public class LoginFrame_btnQuit_ActionListener implements ActionListener {
        private LoginFrame If;
        public LoginFrame_btnQuit_ActionListener(LoginFrame If) {
            this.If = If;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //关闭登录窗口
            If.dispose();
        }


    }

    public class LoginFrame_btnLogin_ActionListener implements ActionListener {
        private LoginFrame If;
        public LoginFrame_btnLogin_ActionListener(LoginFrame If) {
            this.If = If;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           //获得用户姓名的文本框对象的文本内容
            String userName = If.getTxtUserName().getText().trim();
            //获得用户密码的密码框对象的文本内容
            String userPwd = new String(If.getPwdUserPwd().getPassword()).trim();
            if(userName.equals("huzheng")&&userPwd.equals("212010108")){
                JOptionPane.showMessageDialog(null, "将进入三角形的平移、对称和旋转界面！");
                new Triangle();
                setVisible(false);
            }else {
                JOptionPane.showMessageDialog(null,"用户密码错误","错误",
                        JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

   public class LoginFrame_txtUserName_MouseListener implements MouseListener {
        private LoginFrame If;

        public LoginFrame_txtUserName_MouseListener(LoginFrame If) {
            this.If = If;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
           this.If.getTxtUserName().setText("");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
class Test {
    public static void main(String[] args) {
        new LoginFrame();
    }
}

