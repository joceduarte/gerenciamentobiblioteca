package br.edu.unisep.gerenciamentobiblioteca.model;


public class LivroDigital extends Livro {
    private double tamanhoArquivo;

    public LivroDigital(String titulo, autor autor, genero genero, double tamanhoArquivo) {
        super(titulo, autor, genero);
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Livro Digital:");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor().getNome());
        System.out.println("Gênero: " + getGenero().getNome());
        System.out.println("Tamanho : " + tamanhoArquivo + " MB");
        System.out.println("Disponibilidade: " + (isDisponivel() ? "Disponível" : "Emprestado"));
    }
}
