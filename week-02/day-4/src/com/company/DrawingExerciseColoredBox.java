package com.company;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DrawingExerciseColoredBox {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.drawLine(WIDTH / 2, HEIGHT / 2, WIDTH / 6, HEIGHT / 2);

        graphics.setColor(Color.green);
        graphics.drawLine(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 4);

        graphics.setColor(Color.blue);
        graphics.drawLine(WIDTH / 2, HEIGHT / 4, WIDTH / 6, HEIGHT / 4);

        graphics.setColor(Color.yellow);
        graphics.drawLine(WIDTH / 6, HEIGHT / 2, WIDTH / 6, HEIGHT / 4);


        // Draw a box that has different colored lines on each edge.
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