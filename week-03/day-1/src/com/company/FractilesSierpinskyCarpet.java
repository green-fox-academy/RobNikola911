package com.company;

import java.awt.Graphics;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class FractilesSierpinskyCarpet {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        drawSharpensky(graphics, 7, 400, 0, 0);
    }

    public static void drawSharpensky(Graphics graphics, int deep, int size, int x, int y) {
        if (deep == 0) {
            return;
        }
        int third = size / 3;

        graphics.fillRect(x + third, y + third, third, third);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                drawSharpensky(graphics, deep - 1, third, x + row * third, y + col * third);
            }
        }
    }
/*        int currentDeep = 10;
        int xi = WIDTH / 2;
        int yi = HEIGHT / 2;
        int width = WIDTH / 2;
        int height = HEIGHT / 2;

        printSquares(graphics, xi, yi, width, height, currentDeep);
    }

    private static int printSquares(Graphics graphics, int xi, int yi, int width, int height, int currentDeep) {
        //Quadrado central
        int newWidth = WIDTH / 3;
        int newHeight = HEIGHT / 3;
        int x = (WIDTH / 3) + xi;
        int y = (HEIGHT / 3) + yi;
        graphics.fillRect(x, y, newWidth, newHeight);

        int sX = 0;
        int sY = 0;
        if (currentDeep > 1) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    //This is the position of each of the small rectangles
                    sX = i * (WIDTH / 3) + xi;
                    sY = j * (HEIGHT / 3) + yi;

                    // Call the method recursively in order to draw the smaller rectangles
                    sum += printSquares(graphics, sX, sY, newWidth, newHeight, currentDeep - 1);
                }
            }
            return 1 + sum;
        } else
            return 1;
    }*/

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