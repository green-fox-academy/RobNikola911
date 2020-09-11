package com.company;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DrawingTriangles {
    public static void mainDraw(Graphics graphics) {
        int swiftPlus = 0;
        int triangleMinus = 0;
        int unitWidth = WIDTH / 20;
        int unitHeight = HEIGHT / 20;
        getTriangles(swiftPlus, triangleMinus, unitWidth, unitHeight, graphics);
    }

    private static void getTriangles(int swiftPlus, int triangleMinus, int unitWidth, int unitHeight, Graphics graphics) {

        for (int lines = 0; lines < WIDTH; lines += unitHeight) {
            for (int cols = 0; cols < HEIGHT - triangleMinus; cols += unitWidth) {
                int x1[] = {cols + swiftPlus, unitWidth / 2 + cols + swiftPlus, unitWidth + cols + swiftPlus};
                int y1[] = {HEIGHT - lines, unitHeight * 19 - lines, HEIGHT - lines};
                graphics.drawPolygon(x1, y1, 3);
            }
            triangleMinus += unitWidth;
            swiftPlus += unitWidth / 2;
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