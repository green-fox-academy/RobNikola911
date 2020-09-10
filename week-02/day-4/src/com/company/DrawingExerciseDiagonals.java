package com.company;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DrawingExerciseDiagonals {
    public static void mainDraw(Graphics graphics) {

        for (int i = 0; i <= WIDTH; i += WIDTH / 5) {
            if (i == 0) {
                graphics.setColor(Color.green);
                graphics.drawLine(0 + i, 0, WIDTH - i, HEIGHT);
            } else if (i == WIDTH) {
                graphics.setColor(Color.red);
                graphics.drawLine(0 + i, 0, WIDTH - i, HEIGHT);
            } else {
                graphics.setColor(Color.blue);
                graphics.drawLine(0 + i, 0, WIDTH - i, HEIGHT);
            }
        }

//        int x1 = 0;
//        int y1 = 0;
//
//        graphics.setColor(Color.green);
//        graphics.setColor(Color.red);
//
//        if (x1 + y1 == 0) {
//
//            graphics.drawLine(0, 0, WIDTH, HEIGHT);
//        } else {
//
//            graphics.drawLine(WIDTH, 0, 0, HEIGHT);
//        };

        // Draw the canvas' diagonals.
        // If it starts from the upper-left corner it should be green, otherwise it should be red.
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