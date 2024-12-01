package br.edu.unisep.gerenciamentobiblioteca.model;

public class emprestimo {
    private Livro livro;
    private usuario usuario;
    private boolean devolvido;

    public emprestimo (Livro livro, usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.devolvido = false;
        livro.emprestar();
    }

    public void devolver() {
        devolvido = true;
        livro.devolver();
    }

    public boolean isDevolvido() {
        return devolvido;
    }
}
