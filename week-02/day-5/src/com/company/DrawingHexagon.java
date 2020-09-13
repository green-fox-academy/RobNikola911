package com.company;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class DrawingHexagon {
    static int WIDTH = 320;
    static int HEIGHT = 320;
    static int SIZE = 20;

    public static void mainDraw(Graphics graphics) {
        int middlePosX = WIDTH / 2;
        int middlePosY = HEIGHT / 2;
        int rows = 7, cols = 7;
        drawHexagons(middlePosX, middlePosY - cols * SIZE, rows, graphics);
    }

    /**
     * Draw a honeycomb pattern
     *
     * @param middlePosX
     * @param middlePosY
     * @param rows
     * @param graphics
     */
    public static void drawHexagons(int middlePosX, int middlePosY, int rows, Graphics graphics) {
        // a2 + b2 = c2
        int height = (int) Math.round(Math.sqrt(Math.pow(SIZE, 2) - Math.pow(SIZE / 2, 2))) * 2;
        int width = SIZE * 2;
        int posY = middlePosY;
        // Center
        for (int row = 0; row < rows; row++) {
            hexagon(middlePosX, posY += height, graphics);
        }
        // Draw sides
        for (int steps = 1; steps <= (rows - 1) / 2 + 1; steps++) {
            rows--;
            posY = middlePosY + (height / 2) * steps;
            int posLeftX = middlePosX - ((width / 4) * 3) * steps;
            int posRightX = middlePosX + ((width / 4) * 3) * steps;
            for (int row = 0; row < rows; row++) {
                posY += height; // Iterating height
                hexagon(posLeftX, posY, graphics); // Draw left
                hexagon(posRightX, posY, graphics); // Draw right
            }
        }
    }

    /**
     * Drawing a hexagon
     *
     * @param leftPos  Left coordinate (x) of the hexagon
     * @param topPos   Top coordinate (y) of the hexagon
     * @param graphics {@link Graphics} JWT graphics object
     */
    private static void hexagon(int leftPos, int topPos, Graphics graphics) {
        Polygon hexagon = new Polygon();
        for (int i = 0; i < 6; i++)
            hexagon.addPoint((int) (leftPos + SIZE * Math.cos(i * 2 * Math.PI / 6)),
                    (int) (topPos + SIZE * Math.sin(i * 2 * Math.PI / 6)));
        graphics.drawPolygon(hexagon);
    }

    // Don't touch the code below
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