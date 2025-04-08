package main.java.model;
import main.java.animation.FloodFillAnimation;
import java.awt.image.BufferedImage;

public class FloodFill {
    private final BufferedImage image;
    private int delayMs = 30;

    public FloodFill(BufferedImage img) {
        this.image = img;
    }

    public void setAnimationDelay(int delayMs) {
        this.delayMs = delayMs;
    }

    public void preencherComAnimacao(int x, int y, int novaCor) {

        int corOriginal = image.getRGB(x, y);
        if (corOriginal == novaCor) return;

        Fila fila = new Fila();

        fila.enqueue(new Pixel(x, y));
        int contador = 0;

        while (!fila.isEmpty()) {
            Pixel p = fila.dequeue();
            if (isValido(p.getX(), p.getY(), corOriginal)) {

                image.setRGB(p.getX(), p.getY(), novaCor);
                if (contador++ % 10 == 0) {
                    FloodFillAnimation.updateFrame(image);
                    sleep(delayMs);
                }

                adicionarVizinhos(p, fila);
            }
        }

        FloodFillAnimation.updateFrame(image);
    }

    private void adicionarVizinhos(Pixel p, Fila fila) {
        int[][] direcoes = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : direcoes) {
            fila.enqueue(new Pixel(p.getX() + dir[0], p.getY() + dir[1]));
        }
    }

    private boolean isValido(int x, int y, int corOriginal) {
        return x >= 0 && x < image.getWidth() &&
                y >= 0 && y < image.getHeight() &&
                image.getRGB(x, y) == corOriginal;
    }



    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}