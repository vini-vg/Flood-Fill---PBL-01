package main;
import main.java.model.FloodFill;
import main.java.model.ImageProcessor;
import main.java.animation.FloodFillAnimation;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        try {
            String caminhoEntrada = "src/main/resources/entrada.png";
            String caminhoSaida = "saida_animada.png";
            ImageProcessor processor = new ImageProcessor(caminhoEntrada);
            FloodFillAnimation.initAnimation(processor.getImage());
            FloodFill floodFill = new FloodFill(processor.getImage());
            floodFill.setAnimationDelay(1);
            floodFill.preencherComAnimacao(0, 0, Color.RED.getRGB());
            processor.salvar(caminhoSaida);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}