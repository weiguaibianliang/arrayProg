package com.huzheng.company;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DljmWindnow extends JFrame implements ActionListener {
    private Container container;
    private JLabel titleLabel;
    private JPanel panel1;
    private JMenuBar menuBar;
    private JMenu systemMenu, userMGRMenu, yuangongMGRMenu, bumenMGRMenu,
            keshiMGRMenu, kaopingMGRMenu;
    private JMenuItem userLoginMenuItem, userAddMenuItem, userModifyMenuItem,
            userListMenuItem, userDeleteMenuItem, exitMenuItem,
            yuangongAddMenuItem, yuangongModifyMenuItem,
            yuangongDeleteMenuItem, bumenAddMenuItem, bumenModifyMenuItem,
            bumenDeleteMenuItem, bumenListMenuItem, keshiModifyMenuItem,
            keshiAddMenuItem,keshiDeleteMenuItem, keshiListMenuItem,
            kaopingSearchMenuItem,kaopingScoreMenuItem,kaopingListMenuItem ;
    public DljmWindnow() {
        super("绩效管理系统1.0");
// 系统管理菜单
        menuBar = new JMenuBar();
        systemMenu = new JMenu("系统管理");
// 用户管理菜单
        userMGRMenu = new JMenu("用户管理");
// 用户登陆菜单
        userLoginMenuItem = new JMenuItem("用户登录");
// --添加用户菜单--
        userAddMenuItem = new JMenuItem("添加用户");
// --修改用户菜单--
        userModifyMenuItem = new JMenuItem("修改用户");
// 删除用户菜单
        userDeleteMenuItem = new JMenuItem("删除用户");
// 退出菜单
        exitMenuItem = new JMenuItem("退出");
// --将“用户登录”子菜单项加入到“系统菜单”中--
        systemMenu.add(userLoginMenuItem);
// --将“添加用户”子菜单项加入到“用户管理”菜单中--
        userMGRMenu.add(userAddMenuItem);
// --将“修改用户”子菜单项加入到“用户管理”菜单中--
        userMGRMenu.add(userModifyMenuItem);
// --将“删除用户”子菜单项加入到“用户管理”菜单中--
        userMGRMenu.add(userDeleteMenuItem);
// --将“用户管理”子菜单项加入到“系统管理”菜单中--
        systemMenu.add(userMGRMenu);
// --将“退出”子菜单项加入到“系统管理”菜单中--
        systemMenu.add(exitMenuItem);
// --为“用户登录”菜单项添加动作监听者--
        userLoginMenuItem.addActionListener(this);
// --为“添加用户”菜单项添加动作监听者--
        userAddMenuItem.addActionListener(this);
// --为“修改用户”菜单项添加动作监听者--
        userModifyMenuItem.addActionListener(this);
// --为“删除用户”菜单项添加动作监听者--
        userDeleteMenuItem.addActionListener(this);
// --为“退出”菜单项添加动作监听者--
        exitMenuItem.addActionListener(this);
// --将“系统管理”菜单项加入到菜单栏上--
        menuBar.add(systemMenu);
        yuangongMGRMenu = new JMenu("员工管理");
// --“添加员工”菜单--
        yuangongAddMenuItem = new JMenuItem("添加员工");
// --“修改员工”菜单--
        yuangongModifyMenuItem = new JMenuItem("修改员工");
// --“删除员工”菜单--
        yuangongDeleteMenuItem = new JMenuItem("删除员工");
// --将“添加员工”菜单加入到“员工管理”菜单项中--
        yuangongMGRMenu.add(yuangongAddMenuItem);
// --将“修改员工”菜单加入到“员工管理”菜单项中--
        yuangongMGRMenu.add(yuangongModifyMenuItem);
// --将“删除员工”菜单加入到“员工管理”菜单项中--
        yuangongMGRMenu.add(yuangongDeleteMenuItem);
// --将“添加员工”菜单添加事件监听者--
        yuangongAddMenuItem.addActionListener(this);
// --将“修改员工”菜单添加事件监听者--
        yuangongModifyMenuItem.addActionListener(this);
// --将“删除员工”菜单添加事件监听者--
        yuangongDeleteMenuItem.addActionListener(this);
// 将员工管理添加到菜单栏中
//部门管理
        menuBar.add(yuangongMGRMenu);
        bumenMGRMenu = new JMenu("部门管理");

        bumenAddMenuItem = new JMenuItem("添加部门");

        bumenModifyMenuItem = new JMenuItem("修改部门");

        bumenDeleteMenuItem = new JMenuItem("删除部门");

        bumenMGRMenu.add(bumenAddMenuItem);

        bumenMGRMenu.add(bumenModifyMenuItem);

        bumenMGRMenu.add(bumenDeleteMenuItem);

        bumenAddMenuItem.addActionListener(this);

        bumenModifyMenuItem.addActionListener(this);

        bumenDeleteMenuItem.addActionListener(this);
        menuBar.add(bumenMGRMenu);
//科室管理
        keshiMGRMenu = new JMenu("科室管理");
        keshiModifyMenuItem = new JMenuItem("修改科室");
        keshiDeleteMenuItem = new JMenuItem("删除科室");
        keshiAddMenuItem = new JMenuItem("添加科室");
        keshiMGRMenu.add(keshiAddMenuItem);
        keshiMGRMenu.add(keshiModifyMenuItem);
        keshiMGRMenu.add(keshiDeleteMenuItem);
        keshiAddMenuItem.addActionListener(this);
        keshiModifyMenuItem.addActionListener(this);
        keshiDeleteMenuItem.addActionListener(this);
        menuBar.add(keshiMGRMenu);
        kaopingMGRMenu = new JMenu("考评管理");
        kaopingSearchMenuItem = new JMenuItem("查询考评信息");
        kaopingScoreMenuItem = new JMenuItem("评分");
        kaopingMGRMenu.add(kaopingSearchMenuItem);
        kaopingMGRMenu.add(kaopingScoreMenuItem);
        kaopingSearchMenuItem.addActionListener(this);
        kaopingScoreMenuItem.addActionListener(this);
        menuBar.add(kaopingMGRMenu);
        bumenListMenuItem = new JMenuItem("部门列表");
        keshiListMenuItem = new JMenuItem("科室列表");
        userListMenuItem = new JMenuItem("用户列表");
        kaopingListMenuItem = new JMenuItem("考评列表");
        bumenListMenuItem.addActionListener(this);
        keshiListMenuItem.addActionListener(this);
        userListMenuItem.addActionListener(this);
        kaopingListMenuItem.addActionListener(this);

        setJMenuBar(menuBar);
        titleLabel = new JLabel(new ImageIcon("\\1.jpg"));
        container = getContentPane();
        container.setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(titleLabel, BorderLayout.CENTER);
        container.add(panel1, BorderLayout.CENTER);
        setBounds(300,200,430, 330);// 设置窗口大小
        show();
// --设置初始功能:--
//userMGRMenu.setEnabled(false);
//bumenMGRMenu.setEnabled(false);
//keshiMGRMenu.setEnabled(false);
//userMGRMenu.setEnabled(false);
//infoMenu.setEnabled(false);
    }
    public void actionPerformed(ActionEvent evnt) {
        if (evnt.getActionCommand().equals("用户登陆"))//此"用户登陆"非彼"用户登录"
            try {
                JavaLogin l=new JavaLogin();
            }catch(Exception e)
            { e.printStackTrace();
            }

    }
    public static void main(String args[]) {
        new DljmWindnow();
    }
}
