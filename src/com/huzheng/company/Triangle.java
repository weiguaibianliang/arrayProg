package com.huzheng.company;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.geom.*;

 public class Triangle extends JFrame {


    private static final Dimension minSize = new Dimension(300, 200);

    private static final Dimension maxSize = new Dimension(1024, 768);

    private static final Dimension preferredSize = new Dimension(600, 400);

    public Dimension getMaximumSize() {return maxSize;}

    public Dimension getMinimumSize() {return minSize;}

    public Dimension getPreferredSize() {return preferredSize;}

    public String getTitle() {return "实现三角形的平移、对称和旋转";}

    private AffineTransform af = new AffineTransform();

    private Stroke stroke = new BasicStroke(2.0f);
    //private Rectangle rct = new Rectangle(40,140,200,140);
    int[] x = {200, 250, 150};
    int[] y = {100, 200, 200};

    private JComponent canvas = new JComponent(){
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            g.setColor(Color.BLACK);

            g.fillRect(0,0,getWidth(),getHeight());

            Graphics2D g2d = (Graphics2D)g.create();

            g2d.setColor(Color.YELLOW);

            g2d.setTransform(af);

            g2d.setStroke(stroke);
            g2d.drawPolygon(x, y, 3);
            //g2d.draw(rct);

            g2d.dispose();

        }

    };

    Triangle() throws HeadlessException {
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

        init();

        doLay();

        attachListeners();

    }

    private void init() {

    }

    private void doLay() {

        Container container = getContentPane();

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,30,5));

        panel.add(new JButton( new AfAction("平移", AffineTransform.getTranslateInstance(100,100)) ));

        panel.add(new JButton( new AfAction("旋转", AffineTransform.getRotateInstance(Math.PI/3,40,120) ) ));

        panel.add(new JButton( new AfAction("放大", AffineTransform.getScaleInstance(2,2)) ));

        panel.add(new JButton( new AfAction("缩小", AffineTransform.getScaleInstance(.5d,.5d)) ));

        panel.add(new JButton( new AfAction("原置", new AffineTransform()) ) );

        container.add(panel,BorderLayout.NORTH);

        container.add(canvas,BorderLayout.CENTER);

        pack();

    }

    private void attachListeners() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private class AfAction extends AbstractAction {

        private AffineTransform aff;

        private AfAction(String n,AffineTransform af) {

            super(n);

            this.aff = af;

        }

        public void actionPerformed(ActionEvent e) {

            af.setTransform(aff);

            if(canvas.isVisible()) canvas.paintImmediately(0,0,getWidth(),getHeight());

        }

    }

    public static void main(String[] args) {

        new Triangle().setVisible(true);

    }

}