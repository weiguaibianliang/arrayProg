package com.huzheng.company;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

 class MainFrame1 extends JFrame{

    private static final JDesktopPane DESKTOP_PANE = new JDesktopPane();

    public MainFrame1() {
        super("microCAD");
        setBounds(200, 200,640,480);

        //菜单设置
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu menu1 = new JMenu("文件");
        JMenu menu101 = new JMenu("打开");
        JMenuItem menu10101 = new JMenuItem("打开最近");
        JMenuItem menu102 = new JMenuItem("保存");
        menu101.add(menu10101);
        menu1.add(menu101);
        menu1.add(menu102);
        JMenu menu2 = new JMenu("帮助");
        menuBar.add(menu1);
        menuBar.add(menu2);

        this.getContentPane().add(DESKTOP_PANE);
        this.setVisible(true);
    }

    public static void addIFame(JInternalFrame iframe) { // 添加子窗体的方法
        DESKTOP_PANE.add(iframe);
    }

    public static void main(String[] args) {
        new MainFrame1();
    }
}
