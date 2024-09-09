package livros;

import java.util.ArrayList;
import java.util.Scanner;

public class Livros {
    private String autor;
    private String titulo;
    private int anoPublicacao;

    public Livros(String autor, String titulo, int anoPublicacao) {
        this.autor = autor;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void exibirInformacoes() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de Publicacao: " + anoPublicacao);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int resp = 0;
        ArrayList<Livros> livros = new ArrayList<>();

        do {
            System.out.println("Quer cadastrar um livro? (1 == SIM/ 0 == NAO)");
            resp = scan.nextInt();
            scan.nextLine();
            if (resp == 1) {
                int tipo;
                System.out.println("O livro é impresso ou digital? (1 == Impresso/ 2 == Digital)");
                tipo = scan.nextInt();
                scan.nextLine();

                System.out.println("Digite o nome do autor: ");
                String autor = scan.nextLine();

                System.out.println("Digite o titulo do livro: ");
                String titulo = scan.nextLine();

                System.out.println("Digite o ano de publicacao: ");
                int anoPublicacao = scan.nextInt();
                scan.nextLine();

                if (tipo == 1) {
                    System.out.println("Digite quantas paginas tem o livro: ");
                    int numPag = scan.nextInt();
                    livros.add(new LivrosImpressos(autor, titulo, anoPublicacao, numPag));
                } else if (tipo == 2) {
                    System.out.println("Digite o tamanho do livro digital, em MBs: ");
                    double tamanhoMB = scan.nextDouble();
                    livros.add(new LivrosDigitais(autor, titulo, anoPublicacao, tamanhoMB));
                }
            }
        } while (resp == 1);

        System.out.println("Lista dos livros cadastrados: ");
        for (Livros livro : livros) {
            livro.exibirInformacoes();
            System.out.println();
        }

        System.out.println("Fim do programa!");
        scan.close();
    }
}
