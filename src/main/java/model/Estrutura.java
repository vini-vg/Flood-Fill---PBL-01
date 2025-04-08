package main.java.model;

public interface Estrutura<T> {
    void adicionar(T item);
    T remover();
    boolean estaVazia();
}
