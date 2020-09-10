package com.company;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DrawingExerciseToTheCenter {
    public static void mainDraw(Graphics graphics) {
        int x1 = 0;
        int y1 = 0;
        int numOfLines = 3;

        for (int i = 1; i <= numOfLines; i++) {
            getCoordGraph(x1, y1, graphics);
            x1 += WIDTH / 2;
            y1 += 0;
        }
    }

    private static void getCoordGraph(int x1, int y1, Graphics graphics) {
        graphics.drawLine(x1, y1, WIDTH / 2, HEIGHT / 2);
    }
    // Create a function that draws a single line and takes 3 parameters:
    // The x and y coordinates of the line's starting point and the graphics
    // and draws a line from that point to the center of the canvas.
    // Draw at least 3 lines with that function using a loop.

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