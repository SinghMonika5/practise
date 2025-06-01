package practice;

import javax.swing.*;
import java.awt.*;

public class DrawingExample extends JFrame {
    public DrawingExample() {
        setTitle("Drawing Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Set the color for the line
        g.setColor(Color.RED);
        // Draw a color-filled line
        g.drawLine(50, 50, 300, 50);
        // Set the color for the rectangle
        g.setColor(Color.BLUE);
        // Draw a color-filled rectangle
        g.fillRect(50, 100, 200, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("running");
        SwingUtilities.invokeLater(DrawingExample::new);
    }
}
