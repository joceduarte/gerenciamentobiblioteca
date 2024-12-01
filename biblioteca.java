package br.edu.unisep.gerenciamentobiblioteca.model;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<usuario> usuarios = new ArrayList<>();
    private List<emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarUsuario(usuario usuario) {
        usuarios.add(usuario);
    }

    public void cadastrarEmprestimo(Livro livro, usuario usuario) {
        if (livro.isDisponivel()) {
            emprestimo emprestimo = new emprestimo(livro, usuario);
            emprestimos.add(emprestimo);
        } else {
            JOptionPane.showMessageDialog(null, "Livro não indisponivel no momento.");
        }
    }

    public void devolverLivro(Livro livro) {
        for (emprestimo emp : emprestimos) {
            if (emp.isDevolvido() == false) {
                emp.devolver();
                JOptionPane.showMessageDialog(null, "Livro devolvido.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Livro devolvido, obrigado.");
    }

    public List<Livro> consultarLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }
}

