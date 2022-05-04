package com.huzheng.company;

import java.awt.*;

public class TestFrame1 {
    public static void main(String[] args) {

        Frame frame  = new Frame("microCAD");
        frame.setBounds(100,100,200,200);
        frame.setLayout(new GridLayout(2,1));

        Panel panel1 = new Panel(new BorderLayout());
        Panel panel2 = new Panel(new GridLayout(2,1));
        Panel panel3 = new Panel(new BorderLayout());
        Panel panel4 = new Panel(new GridLayout(2,2));
        //先进行上面面板的划分
        panel1.add(new Button("East-1"),BorderLayout.EAST);
        panel1.add(new Button("West-1"),BorderLayout.WEST);
        panel2.add(new Button("panel2-btn-1"));
        panel2.add(new Button("panel2-btn-2"));
        panel1.add(panel2,BorderLayout.CENTER);
        //再进行下面面板的划分
        panel3.add(new Button("East-2"),BorderLayout.EAST);
        panel3.add(new Button("West-2"),BorderLayout.WEST);
        //再对第二块大面板的中间面板进行划分
        for(int i =0;i<4;i++){
            panel4.add(new Button("panel4-btn-i"));
        }
        panel3.add(panel4,BorderLayout.CENTER);
        frame.add(panel1);
        frame.add(panel3);
        frame.setVisible(true);

    }
}
