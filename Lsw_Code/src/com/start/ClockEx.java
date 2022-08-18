package com.start;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;



// 아날로그 시계
public class ClockEx extends JFrame implements Runnable {
    private int Hour = 0;
    private int Minute = 0;
    private int Second = 0;

    public void paint(Graphics gp) {
        double HourLine, MinuteLine, SecondLine, radius;
        int outLine[] = new int[3];
        int inLine[] = new int[3];
        int out, in;

        gp.setColor(Color.RED);
        gp.fillOval(20, 20, 150, 150);
        gp.setColor(Color.YELLOW);
        gp.fillOval(40, 40, 110, 110);
        gp.setColor(Color.BLACK);
        gp.fillOval(92, 92, 6, 6);

        HourLine = Math.PI * (Hour / 6.0 + Minute / 360.0);
        radius = 95 * 0.4;

        outLine[0] = (int) Math.round(95 - radius * 0.1 * Math.cos(HourLine));
        inLine[0] = (int) Math.round(95 - radius * 0.1 * Math.sin(HourLine));

        outLine[1] = (int) Math.round(95 + radius * Math.sin(HourLine));
        inLine[1] = (int) Math.round(95 - radius * Math.cos(HourLine));

        outLine[2] = (int) Math.round(95 + radius * 0.1 * Math.cos(HourLine));
        inLine[2] = (int) Math.round(95 + radius * 0.1 * Math.sin(HourLine));


        gp.setColor(Color.BLUE);
        gp.fillPolygon(outLine, inLine, 3);

        MinuteLine = Math.PI * (Minute / 30.0 + Second / 1800.0);
        radius = 95 * 0.5;

        outLine[0] = (int) Math.round(95 - radius * 0.1 * Math.cos(MinuteLine));
        inLine[0] = (int) Math.round(95 - radius * 0.1 * Math.sin(MinuteLine));

        outLine[1] = (int) Math.round(95 + radius * Math.sin(MinuteLine));
        inLine[1] = (int) Math.round(95 - radius * Math.cos(MinuteLine));

        outLine[2] = (int) Math.round(95 + radius * 0.1 * Math.cos(MinuteLine));
        inLine[2] = (int) Math.round(95 + radius * 0.1 * Math.sin(MinuteLine));
        gp.fillPolygon(outLine, inLine, 3);


        SecondLine = Math.PI * Second / 30.0;
        radius = 95 * 0.6;
        out = (int) Math.round(95 + radius * Math.sin(SecondLine));
        in = (int) Math.round(95 - radius * Math.cos(SecondLine));
        gp.setColor(Color.RED);
        gp.drawLine(95, 95, out, in);
        if (Second == 60) {
            Second = 0;
            Minute++;
        }
        if (Minute == 60) {
            Minute = 0;
            Hour++;
        }
        if (Minute == 60 && Hour == 12) {
            Hour = 0;
        }
    }



    // 생성자 선언
    public ClockEx() {
        init();
    }

    // frame을 그리기 위한 초기화 메서드
    public void init() {
        JButton button = new JButton("Set");
        JTextField hour = new JTextField(2);
        JTextField minute = new JTextField(2);
        JTextField second = new JTextField(2);
        JPanel panel = new JPanel();

        panel.add(hour);
        panel.add(new JLabel(":"));
        panel.add(minute);
        panel.add(new JLabel(":"));
        panel.add(second);
        panel.add(button);

        //button.addActionListener();

        this.setTitle("Form1");
        this.setSize(400, 250);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(BorderLayout.SOUTH, panel);
        this.setVisible(true);


    }


    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                Second = Second + 1;
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ClockEx h2 = new ClockEx();
        Thread th = new Thread(h2);
        th.start();
    }
}