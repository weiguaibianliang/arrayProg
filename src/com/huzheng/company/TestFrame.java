package com.huzheng.company;

import java.awt.*;

public class TestFrame {
    public static void main(String[] args) {
        //展示多个窗口new
        MyFrame myFrame1 = new MyFrame(100,100,200,200,Color.black);
        MyFrame myFrame2 = new MyFrame(300,100,200,200,Color.black);
        MyFrame myFrame3 = new MyFrame(100,300,200,200,Color.black);
        MyFrame myFrame4 = new MyFrame(300,300,200,200,Color.black);

    }
}
class MyFrame extends Frame {
    static int id = 0;//可能存在多个窗口，我们需要一个计数器
    //添加一个构造器
    public MyFrame(int x,int y,int w,int h,Color color){
        super("MyFrame+"+(++id));
        setBackground(color);
        setBounds(x,y,w,h);
        setVisible(true);//可视化
    }
}
