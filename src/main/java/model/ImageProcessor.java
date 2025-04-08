package main.java.model;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageProcessor {
    private BufferedImage image;

    public ImageProcessor(String caminho) throws IOException {
        this.image = ImageIO.read(new File(caminho));
    }

    public BufferedImage getImage() {
        return image;
    }

    public void salvar(String caminho) throws IOException {
        ImageIO.write(image, "png", new File(caminho));
    }
}