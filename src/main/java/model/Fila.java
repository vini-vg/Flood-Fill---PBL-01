class Fila {
    private Node frente, tras;

    private class Node {
        Pixel pixel;
        Node proximo;

        Node(Pixel p) {
            this.pixel = p;
            this.proximo = null;
        }
    }



    public void enqueue(Pixel p) {
        Node novo = new Node(p);
        if (tras != null) {
            tras.proximo = novo;
        }
        tras = novo;
        if (frente == null) {
            frente = novo;
        }
    }

    public Pixel dequeue() {
        if (frente == null) return null;
        Pixel p = frente.pixel;
        frente = frente.proximo ;
        if (frente == null) {
            tras = null;
        }
        return p;
    }


    public boolean isEmpty() {

        return frente == null ;
    }
}
