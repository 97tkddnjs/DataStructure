package com.start;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Clock extends JComponent {
    double hour, minute, second;

    public void paintComponent(Graphics g) {
        double posHour, posMinute, posSecond, radius;
        int pointX[] = new int[3];
        int pointY[] = new int[3];
        int endX, endY;

        // 시계 바깥 원
        g.setColor(Color.RED);
        g.fillOval(20, 20, 150, 150);

        // 시계 안쪽 원
        g.setColor(Color.YELLOW);
        g.fillOval(40, 40, 110, 110);

        // 중심원
        g.setColor(Color.BLACK);
        g.fillOval(92, 92, 6, 6);

        // 시 침의 위치 계산 : 시침은 분침에 따라서 움직임
        posHour = Math.PI * (hour / 6.0 + minute / 360.0);
        radius = 95 * 0.4;

        // 시침 우측 좌표(12시 기준)
        pointX[0] = (int) Math.round(95 - radius * 0.1 * Math.cos(posHour));
        pointY[0] = (int) Math.round(95 - radius * 0.1 * Math.sin(posHour));

        // 시침 가운데 좌표
        pointX[1] = (int) Math.round(95 + radius * Math.sin(posHour));
        pointY[1] = (int) Math.round(95 - radius * Math.cos(posHour));

        // 시침 좌측 좌표
        pointX[2] = (int) Math.round(95 + radius * 0.1 * Math.cos(posHour));
        pointY[2] = (int) Math.round(95 + radius * 0.1 * Math.sin(posHour));
        g.setColor(Color.BLUE);
        g.fillPolygon(pointX, pointY, 3);

        // 분 침의 위치 계산 : 분침은 초침에 따라서 움직임
        posMinute = Math.PI * (minute / 30.0 + second / 1800.0);
        radius = 95 * 0.5;

        // 분침 우측 좌표(12시 기준)
        pointX[0] = (int) Math.round(95 - radius * 0.1 * Math.cos(posMinute));
        pointY[0] = (int) Math.round(95 - radius * 0.1 * Math.sin(posMinute));

        // 분침 가운데 좌표
        pointX[1] = (int) Math.round(95 + radius * Math.sin(posMinute));
        pointY[1] = (int) Math.round(95 - radius * Math.cos(posMinute));

        // 분침 좌측 좌표
        pointX[2] = (int) Math.round(95 + radius * 0.1 * Math.cos(posMinute));
        pointY[2] = (int) Math.round(95 + radius * 0.1 * Math.sin(posMinute));
        g.fillPolygon(pointX, pointY, 3);

        // 초 침의 위치 계산 : 초침은 단독으로 작동
        posSecond = Math.PI * second / 30.0;
        radius = 95 * 0.6;
        endX = (int) Math.round(95 + radius * Math.sin(posSecond));
        endY = (int) Math.round(95 - radius * Math.cos(posSecond));
        g.setColor(Color.RED);
        g.drawLine(95, 95, endX, endY);
    }
}

public class ExerciseCh12_11 implements ActionListener {
    Clock c = new Clock();

    JFrame f = new JFrame("Clock");
    JButton b = new JButton("Set");
    JTextField hour = new JTextField(2); // 시 입력
    JTextField minute = new JTextField(2); // 분 입력
    JTextField second = new JTextField(2); // 초 입력
    JPanel p = new JPanel();

    public void start() {
        p.add(hour);
        p.add(new JLabel(":"));
        p.add(minute);
        p.add(new JLabel(":"));
        p.add(second);
        p.add(b);
        b.addActionListener(this);

        f.setSize(200, 260);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(BorderLayout.CENTER, c);
        f.add(BorderLayout.SOUTH, p);

        f.setVisible(true);
    }

    public static void main(String[] args) {
        ExerciseCh12_11 ex = new ExerciseCh12_11();
        ex.start();
    }

    public void actionPerformed(ActionEvent e) {
        c.hour = Double.parseDouble(hour.getText());
        c.minute = Double.parseDouble(minute.getText());
        c.second = Double.parseDouble(second.getText());

        c.repaint();
    }
}