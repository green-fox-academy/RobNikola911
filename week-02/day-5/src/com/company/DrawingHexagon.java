package com.company;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class DrawingHexagon {
    public static void mainDraw(Graphics graphics) {
        int middlePosX = WIDTH / 2;
        int middlePosY = HEIGHT / 2 - 50;


        hexagon(middlePosX, middlePosY, graphics);
    }

    private static void hexagon(int middlePosX, int middlePosY, Graphics graphics) {
        int size = 10;
        int slideY = 17;
        for (int cols = 0; cols <= 6; cols++) {
            Polygon hexagon = new Polygon();
            for (int rows = 0; rows < 13; rows++) {
                for (int i = 0; i < 6; i++)
                    hexagon.addPoint((int) (middlePosX + size * Math.cos(i * 2 * Math.PI / 6)),
                            (int) (middlePosY + size * Math.sin(i * 2 * Math.PI / 6)));
                graphics.drawPolygon(hexagon);
//                middlePosX += slideY;
//                middlePosY += slideY;
            }
            middlePosY += slideY;
        }
    }

//        int[] x1 = {WIDTH / 2 - 5, WIDTH / 2 + 5, HEIGHT / 10 + 5};
//        int[] y1 = {HEIGHT / 10, HEIGHT / 10, HEIGHT / 10 + 5};
//        graphics.drawPolygon(x1, y1, 6);

//        for (int i = 0; i < 13; i++)
//            for (int j = 0; j < 3; j++)


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
