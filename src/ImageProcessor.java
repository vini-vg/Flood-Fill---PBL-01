import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class ImagePanel extends JPanel {
    private BufferedImage imagem;

    public void setImagem(BufferedImage img){
        this.imagem = img;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagem != null) {
            g.drawImage(imagem,0,0, this.getWidth(), this.getHeight(), this);
        }
    }
}