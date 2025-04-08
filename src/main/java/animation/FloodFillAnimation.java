package main.java.animation;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FloodFillAnimation {
    private static JFrame frame;
    private static JLabel label;
    private static BufferedImage currentImage;

    public static void initAnimation(BufferedImage initialImage) {
        frame = new JFrame("Flood Fill Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        currentImage = copyImage(initialImage);
        label = new JLabel(new ImageIcon(currentImage));
        frame.add(label);

        frame.pack();
        frame.setVisible(true);
    }

    public static void updateFrame(BufferedImage newImage) {
        SwingUtilities.invokeLater(() -> {
            currentImage = copyImage(newImage);
            label.setIcon(new ImageIcon(currentImage));
            frame.repaint();
        });
    }

    private static BufferedImage copyImage(BufferedImage source) {
        BufferedImage copy = new BufferedImage(
                source.getWidth(),
                source.getHeight(),
                source.getType()
        );
        Graphics g = copy.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return copy;
    }
}