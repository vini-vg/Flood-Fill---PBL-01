import main.java.model.Fila;
import main.java.model.Pilha;

import java.awt.image.BufferedImage;

class FloodFill {
    private BufferedImage image;
    private int novaCor;
    private int corOriginal;

    public FloodFill(BufferedImage img) {
        this.image = img;
    }

    public void preencherComPilha(int x, int y, int novaCor) {
        this.novaCor = novaCor;
        this.corOriginal = image.getRGB(x, y);
        if (corOriginal == novaCor) return;

        Pilha pilha = new Pilha();
        pilha.push(new Pixel(x, y));

        while (!pilha.isEmpty()) {
            Pixel p = pilha.pop();
            if (isValido(p.x, p.y)) {
                image.setRGB(p.x, p.y, novaCor);
                pilha.push(new Pixel(p.x + 1, p.y));
                pilha.push(new Pixel(p.x - 1, p.y));
                pilha.push(new Pixel(p.x, p.y + 1));
                pilha.push(new Pixel(p.x, p.y - 1));
            }
        }
    }

    public void preencherComFila(int x, int y, int novaCor) {
        this.novaCor = novaCor;
        this.corOriginal = image.getRGB(x, y);
        if (corOriginal == novaCor) return;

        Fila fila = new Fila();
        fila.enqueue(new Pixel(x, y));

        while (!fila.isEmpty()) {
            Pixel p = fila.dequeue();
            if (isValido(p.x, p.y)) {
                image.setRGB(p.x, p.y, novaCor);
                fila.enqueue(new Pixel(p.x + 1, p.y));
                fila.enqueue(new Pixel(p.x - 1, p.y));
                fila.enqueue(new Pixel(p.x, p.y + 1));
                fila.enqueue(new Pixel(p.x, p.y - 1));
            }
        }
    }

    private boolean isValido(int x, int y) {
        return x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight() && image.getRGB(x, y) == corOriginal;
    }
}
