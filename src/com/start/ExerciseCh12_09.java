package com.start;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class WhiteboardComponent extends JComponent implements ActionListener {
    JRadioButton rb1, rb2, rb3, rb4;
    Color curCol = Color.black;
    int x=0, y=0;

    WhiteboardComponent(JPanel p) { // ������
        setBackground(Color.white);


        rb1 = new JRadioButton("검정색", true);
        rb1.setBackground(Color.black);
        rb1.setForeground(Color.white);
        rb1.addActionListener(this);

        rb2 = new JRadioButton("빨강색", false);
        rb2.setBackground(Color.red);
        rb2.addActionListener(this);

        rb3 = new JRadioButton("보라색", false);
        rb3.setBackground(Color.magenta);
        rb3.addActionListener(this);

        rb4 = new JRadioButton("녹  색", false);
        rb4.setBackground(Color.green);
        rb4.addActionListener(this);
        ButtonGroup grp = new ButtonGroup();
        grp.add(rb1);
        grp.add(rb2);
        grp.add(rb3);
        grp.add(rb4);

        p.add(rb1);
        p.add(rb2);
        p.add(rb3);
        p.add(rb4);

        addMouseListener(new MouseEventHdl()); // 처리기 등록
        addMouseMotionListener(new MouseMotionHdl()); // 처리기 등록
    }

    public void actionPerformed(ActionEvent e) {
        JRadioButton rb = (JRadioButton) e.getSource();

        if (e.getActionCommand().equals("검정색"))
            curCol = Color.black;
        else if (e.getActionCommand().equals("빨강색"))
            curCol = Color.red;
        else if (e.getActionCommand().equals("보라색"))
            curCol = Color.magenta;
        else if (e.getActionCommand().equals("녹  색"))
            curCol = Color.green;
    }

    public class MouseMotionHdl extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            Graphics g = getGraphics();
            g.setColor(curCol);
            g.drawLine(x, y, e.getX(), e.getY());
            x = e.getX();
            y = e.getY();
        }
    }

    public class MouseEventHdl extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }
    }
}

public class ExerciseCh12_09 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Whiteboard");
        JPanel p = new JPanel();
        f.setSize(320, 240);
        f.setBackground(Color.white);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WhiteboardComponent wb = new WhiteboardComponent(p);
        f.add(BorderLayout.NORTH, p);
        f.add(BorderLayout.CENTER, wb);

        f.setVisible(true);
    }
}
