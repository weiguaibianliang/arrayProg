package com.huzheng.company;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



@SuppressWarnings("serial")
public class LineTest2 extends JPanel{

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1,2,0,0));
        frame.setBounds(230, 30, 900, 950);
        LineTest2 panel = new LineTest2();
        panel.setPreferredSize(new Dimension(900,900));
        frame.add(panel);
        frame.setResizable(false);//设置frame不可调
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D)g;
        drawLine(g2,50, 150, 100, 150);
        drawLine(g2,150, 150, 200, 150);
        drawArc(g2,100, 175, 50, 50, 0, -180);//画圆弧函数：前两个数字表示圆外切矩形的左上角坐标，中间两个数字表示外切矩形的宽和高度，后两个数字表示弧起始角和跨越角度

    }
    public void drawLine(Graphics2D g,double x1,double y1,double x2,double y2){
        BasicStroke bs_1=new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);
        g.setStroke(bs_1);
        g.setColor(Color.RED);
        AffineTransform transform = new AffineTransform();
        AffineTransform transform_1 = new AffineTransform();
        AffineTransform transform_2 = new AffineTransform();
        AffineTransform transform_3 = new AffineTransform();

        Line2D line = new Line2D.Double(x1, y1, x2, y2);
        g.draw(line);
        transrota(g,transform,line);

        transform_1.translate(0, 250);
        g.setTransform(transform_1);
        g.draw(line);
        transrota(g,transform_1,line);

        transform_2.translate(0, 500);
        g.setTransform(transform_2);
        g.draw(line);
        transrota(g,transform_2,line);

        transform_3.translate(0, 0);
        g.setTransform(transform_3);
    }

    public void drawArc(Graphics2D g,double x1,double y1,double w,double h,double x2,double y2){
        AffineTransform transform = new AffineTransform();
        AffineTransform transform_1 = new AffineTransform();
        AffineTransform transform_2 = new AffineTransform();
        AffineTransform transform_3 = new AffineTransform();

        Arc2D arc = new Arc2D.Double(x1, y1, w, h, x2, y2, Arc2D.OPEN);
        g.draw(arc);//画圆弧函数：前两个数字表示圆外切矩形的左上角坐标，中间两个数字表示外切矩形的宽和高度，后两个数字表示弧起始角和跨越角度,最后表示圆弧的闭合方式
        transrota(g,transform,arc);

        transform_1.translate(0, 250);
        g.setTransform(transform_1);
        g.draw(arc);
        transrota(g,transform_1,arc);

        transform_2.translate(0, 500);
        g.setTransform(transform_2);
        g.draw(arc);
        transrota(g,transform_2,arc);

        transform_3.translate(0, 0);
        g.setTransform(transform_3);
    }

    public void transrota(Graphics2D g2,AffineTransform transform,Shape line){
        for(int i=0;i<1;i++){
            transform.translate(300, 0);
            g2.setTransform(transform);
            g2.draw(line);
        }
        transform.rotate(Math.PI, 200, 187.5); // 围绕(200, 187.5)点旋转图形180度
        g2.setTransform(transform);
        g2.draw(line);
        for(int i=0;i<1;i++){
            transform.translate(300, 0);
            g2.setTransform(transform);
            g2.draw(line);
        }
    }
}
