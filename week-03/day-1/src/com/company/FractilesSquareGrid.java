package com.company;

import java.awt.Graphics;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class FractilesSquareGrid {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        drawSquareGrid(graphics, 5, 400, 0, 0);
    }

    public static void drawSquareGrid(Graphics graphics, int deep, int size, int x, int y) {
        if (deep == 0) {
            return;
        }
        int third = size / 3;


        graphics.setColor(Color.red);
        graphics.drawRect(x + third,y + third,third,third);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                drawSquareGrid(graphics, deep - 1, third, x + row * third, y + col * third);
            }
        }
    }

    // Don't touch the code below
    static int WIDTH = 400;
    static int HEIGHT = 400;

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