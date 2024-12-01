package br.edu.unisep.gerenciamentobiblioteca.view;


import br.edu.unisep.gerenciamentobiblioteca.model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Livro> livros = new ArrayList<>();
    private static List<autor> autores = new ArrayList<>();
    private static List<genero> generos = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String[] opcoes = {"Cadastrar Autor", "Cadastrar Gênero", "Cadastrar Livro", "Ver Livros Cadastrados", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção", "Biblioteca",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0 -> cadastrarAutor();
                case 1 -> cadastrarGenero();
                case 2 -> cadastrarLivro();
                case 3 -> verLivrosCadastrados();
                case 4 -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private static void cadastrarAutor() {
        String nome = JOptionPane.showInputDialog("Informe o nome do autor:");
        if (nome != null && !nome.isEmpty()) {
            autores.add(new autor(nome));
            JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso!");
        }
    }

    private static void cadastrarGenero() {
        String nome = JOptionPane.showInputDialog("Informe o nome do gênero:");
        if (nome != null && !nome.isEmpty()) {
            generos.add(new genero(nome));
            JOptionPane.showMessageDialog(null, "Gênero cadastrado com sucesso!");
        }
    }

    private static void cadastrarLivro() {
        if (autores.isEmpty() || generos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastre autores e gêneros antes de cadastrar livros.");
            return;
        }

        String titulo = JOptionPane.showInputDialog("Informe o título do livro:");
        autor autor = (autor) JOptionPane.showInputDialog(null, "Selecione o autor:", "Autor",
                JOptionPane.QUESTION_MESSAGE, null, autores.toArray(), null);
        genero genero = (genero) JOptionPane.showInputDialog(null, "Selecione o gênero:", "Gênero",
                JOptionPane.QUESTION_MESSAGE, null, generos.toArray(), null);

        String[] tipos = {"Livro Físico", "Livro Digital"};
        int tipo = JOptionPane.showOptionDialog(null, "Tipo de livro:", "Tipo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);

        if (tipo == 0) {
            int paginas = Integer.parseInt(JOptionPane.showInputDialog("Número de páginas:"));
            livros.add(new LivroFisico(titulo, autor, genero, paginas) {
                @Override
                public void exibirInfo() {
                }
            });
        } else if (tipo == 1) {
            double tamanho = Double.parseDouble(JOptionPane.showInputDialog("Tamanho do arquivo (MB):"));
            livros.add(new LivroDigital(titulo, autor, genero, tamanho));
        }

        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
    }

    private static void verLivrosCadastrados() {
        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado.");
            return;
        }

        StringBuilder listaLivros = new StringBuilder("Livros cadastrados:\n");
        for (int i = 0; i < livros.size(); i++) {
            listaLivros.append(i + 1).append(". ").append(livros.get(i).toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, listaLivros.toString());
    }
}