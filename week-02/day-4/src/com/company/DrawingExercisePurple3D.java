package com.company;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DrawingExercisePurple3D {
    public static void mainDraw(Graphics graphics) {
        int x = 0;
        int y = 0;
        getSquares(x, y, graphics);
    }

    private static void getSquares(int x, int y, Graphics graphics) {
        int size = 10;
        int pos = 10;
        for (int i = 1; i < 7; i += 1) {
//            graphics.drawRect(i + x - 1, i + y - 1, 11, 11);
            graphics.setColor(new Color(172, 57, 172));
            graphics.fillRect(pos, pos, size, size);
            graphics.setColor(Color.black);
            graphics.drawRect(pos, pos, size, size);
            pos += size;
            size += 10;
        }
    }

    private static int getFactorial(int number) {
        int i, fact = 1;
        for (i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
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