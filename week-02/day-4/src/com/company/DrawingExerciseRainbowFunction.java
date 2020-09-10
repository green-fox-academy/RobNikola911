package com.company;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DrawingExerciseRainbowFunction {
    public static void mainDraw(Graphics graphics) {
        int size = 300;
        String color = "Red";
        drawSquare(size, graphics);
        // Create a square drawing function that takes 3 parameters:
        // The square size, the fill color, graphics
        // and draws a square of that size and color to the center of the canvas.
        // Create a loop that fills the canvas with rainbow colored squares
        // (red, orange, yellow, green, blue, indigo, violet).
    }

    private static Color getColorByString(String color) {
        Color c;
        switch (color) {
            case "red":
                c = Color.red;
                break;
            case "orange":
                c = Color.orange;
                break;
            case "yellow":
                c = Color.yellow;
                break;
            case "green":
                c = Color.green;
                break;
            case "blue":
                c = Color.blue;
                break;
            case "indigo":
                c = new Color(31, 9, 84);
                break;
            default:
                c = new Color(170, 0, 255);
        }
        return c;
    }

    private static void drawSquare(int size, Graphics graphics) {
        String[] rainbowColors = new String[]{"red", "orange", "yellow", "green", "blue", "indigo", "violet"};
        int iteration = size / rainbowColors.length;
        for (int i = 0; i < rainbowColors.length; i++) {
            graphics.setColor(getColorByString(rainbowColors[i]));
            int pos = WIDTH / 2 - (iteration * (rainbowColors.length - i) / 2);
            size = (rainbowColors.length - i) * iteration;
//            graphics.drawRect(pos, pos, size, size);
            graphics.fillRect(pos, pos, size, size);
//            System.out.println(String.format("XY: [%d %d] size: %d", pos, pos, size));
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