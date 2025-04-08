package main.java.model;

public class Fila implements Estrutura<Pixel> {
    private Node frente;
    private Node tras;

    private static class Node {
        Pixel pixel;
        Node proximo;

        Node(Pixel pixel) {
            this.pixel = pixel;
        }
    }

    @Override
    public void adicionar(Pixel pixel) {
        Node novoNode = new Node(pixel);
        if (tras == null) {
            frente = tras = novoNode;
        } else {
            tras.proximo = novoNode;
            tras = novoNode;
        }
    }

    @Override
    public Pixel remover() {
        if (frente == null) return null;
        Pixel pixel = frente.pixel;
        frente = frente.proximo;
        if (frente == null) {
            tras = null;
        }

        return pixel;
    }

    @Override
    public boolean estaVazia() {
        return frente == null;
    }
    public void enqueue(Pixel p) { adicionar(p); }
    public Pixel dequeue() { return remover(); }
    public boolean isEmpty() { return estaVazia(); }
}