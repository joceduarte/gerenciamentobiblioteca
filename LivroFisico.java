package br.edu.unisep.gerenciamentobiblioteca.model;

public class LivroFisico extends Livro {
    private int numeroPaginas;

    public LivroFisico(String titulo, autor autor, genero genero, int numeroPaginas) {
        super(titulo, autor, genero);
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Livro Físico emprestado:");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor().getNome());
        System.out.println("Gênero: " + getGenero().getNome());
        System.out.println("Número de páginas: " + numeroPaginas);
        System.out.println("Disponibilidade: " + (isDisponivel() ? "Disponível" : "Emprestado"));
    }
}