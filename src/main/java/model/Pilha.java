package main.java.model;
public class Pilha implements Estrutura<Pixel> {
    private Node topo;

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
        novoNode.proximo = topo;
        topo = novoNode;
    }

    @Override
    public Pixel remover() {
        if (topo == null) return null;
        Pixel pixel = topo.pixel;
        topo = topo.proximo;
        return pixel;
    }

    @Override
    public boolean estaVazia() {
        return topo == null;
    }
    public void push(Pixel p) { adicionar(p); }
    public Pixel pop() { return remover(); }
    public boolean isEmpty() { return estaVazia(); }
}