package br.edu.unisep.gerenciamentobiblioteca.model;

public abstract class Livro {
    private String titulo;
    private autor autor;
    private genero genero;
    private boolean disponivel; // Indica se o livro está disponível para empréstimo

    public Livro(String titulo, autor autor, genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponivel = true; // Por padrão, o livro é disponibilizado ao ser criado
    }

    public String getTitulo() {
        return titulo;
    }

    public autor getAutor() {
        return autor;
    }

    public genero getGenero() {
        return genero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
        } else {
            throw new IllegalStateException("O livro esta disponivel.");
        }
    }

    public void devolver() {
        if (!disponivel) {
            disponivel = true;
        } else {
            throw new IllegalStateException("O livro esta disponivel.");
        }
    }

    @Override
    public String toString() {
        return titulo + " - " + autor.getNome() + " (" + genero.getNome() + ") - " +
                (disponivel ? "Disponível" : "Emprestado");
    }

    public abstract void exibirInfo();
}
