package com.start;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Clock extends JComponent { //그리는 클래스
    double hour, minute, second;

    public void paintComponent(Graphics g) {
        double Hour, Minute, Second, radius;
        int pointX[] = new int[3];
        int pointY[] = new int[3];
        int endX, endY;

        //기본 설정

        g.setColor(Color.RED);
        g.fillOval(20, 20, 150, 150);
        g.setColor(Color.YELLOW);
        g.fillOval(40, 40, 110, 110);
        g.setColor(Color.BLACK);
        g.fillOval(92, 92, 6, 6);

        //시분침

        Hour = Math.PI * (hour / 6.0 + minute / 360.0);
        radius = 95 * 0.4;

        pointX[0] = (int) Math.round(95 - radius * 0.1 * Math.cos(Hour));
        pointY[0] = (int) Math.round(95 - radius * 0.1 * Math.sin(Hour));

        pointX[1] = (int) Math.round(95 + radius * Math.sin(Hour));
        pointY[1] = (int) Math.round(95 - radius * Math.cos(Hour));

        pointX[2] = (int) Math.round(95 + radius * 0.1 * Math.cos(Hour));
        pointY[2] = (int) Math.round(95 + radius * 0.1 * Math.sin(Hour));


        g.setColor(Color.BLUE);
        g.fillPolygon(pointX, pointY, 3);

        Minute = Math.PI * (minute / 30.0 + second / 1800.0);
        radius = 95 * 0.5;

        pointX[0] = (int) Math.round(95 - radius * 0.1 * Math.cos(Minute));
        pointY[0] = (int) Math.round(95 - radius * 0.1 * Math.sin(Minute));

        pointX[1] = (int) Math.round(95 + radius * Math.sin(Minute));
        pointY[1] = (int) Math.round(95 - radius * Math.cos(Minute));

        pointX[2] = (int) Math.round(95 + radius * 0.1 * Math.cos(Minute));
        pointY[2] = (int) Math.round(95 + radius * 0.1 * Math.sin(Minute));
        g.fillPolygon(pointX, pointY, 3);


        Second = Math.PI * second / 30.0;
        radius = 95 * 0.6;
        endX = (int) Math.round(95 + radius * Math.sin(Second));
        endY = (int) Math.round(95 - radius * Math.cos(Second));
        g.setColor(Color.RED);
        g.drawLine(95, 95, endX, endY);
    }
}

public class LastTest2 implements ActionListener {
    Clock c = new Clock();

    JFrame f = new JFrame("Clock");
    JButton b = new JButton("Set");
    JTextField hour = new JTextField(2);
    JTextField minute = new JTextField(2);
    JTextField second = new JTextField(2);

    JPanel p = new JPanel();

    public void start() {
        p.add(hour);
        p.add(new JLabel(":"));
        p.add(minute);
        p.add(new JLabel(":"));
        p.add(second);
        p.add(b);
        b.addActionListener(this);

        //frame 객체는 다 받을 수 있음
        f.setSize(200, 260);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(BorderLayout.CENTER, c);
        f.add(BorderLayout.SOUTH, p);

        f.setVisible(true);
    }

    public static void main(String[] args) {
        LastTest2 ex = new LastTest2();
        ex.start();
    }

    public void actionPerformed(ActionEvent e) {
        c.hour = Double.parseDouble(hour.getText());
        c.minute = Double.parseDouble(minute.getText());
        c.second = Double.parseDouble(second.getText());

        c.repaint(); //핵심
    }

}
