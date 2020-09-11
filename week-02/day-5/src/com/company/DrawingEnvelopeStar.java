package com.company;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class DrawingEnvelopeStar {
    public static void mainDraw(Graphics graphics) {
        int middleHeight = HEIGHT / 2;
        int middleWidth = WIDTH / 2;
        for (int i = 1; i < WIDTH / 2; i += 15) {
            graphics.setColor(Color.GREEN);
            graphics.drawLine(i + 0, middleHeight, middleWidth, (middleHeight) + i + 15);
            graphics.drawLine(i + 0, middleHeight, middleWidth, (middleHeight) - i - 15);
            graphics.drawLine(WIDTH - i, middleHeight, middleWidth, (middleHeight) + i + 15);
            graphics.drawLine(WIDTH - i, middleHeight, middleWidth, (middleHeight) - i - 15);
            graphics.drawLine(middleWidth, 0, middleWidth, HEIGHT);
        }
    }

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}