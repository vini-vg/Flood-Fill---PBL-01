class Pilha {
    private Node topo;

    private class Node {
        Pixel pixel;
        Node proximo;

        Node(Pixel p) {
            this.pixel = p;
            this.proximo = null;
        }
    }


    public void push(Pixel p) {
        Node novo = new Node(p);
        novo.proximo = topo;
        topo = novo;
    }

    public Pixel pop() {
        if (topo == null) return null;
        Pixel p = topo.pixel;
        topo = topo.proximo;
        return p;
    }

    public boolean isEmpty() {
        return topo == null;
    }
}
