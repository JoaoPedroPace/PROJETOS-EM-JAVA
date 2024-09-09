package livros;
import java.util.Scanner;
public class Livros {
	private String autor;
	private String titulo;
	private int anoPublicacao;
	
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public String getAutor() {
		return autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public static void main(String[] args) {
		int resp = 0;
		int contador = 0;
		Scanner scan = new Scanner(System.in);
		Livros[] livros = new Livros[10];
		
		do {
			System.out.println("Você quer cadastrar um livro? 1 == SIM/ 0 == NAO: ");
			resp = scan.nextInt();
			scan.nextLine();
			if(resp == 1) {
				if(contador < livros.length) {
				Livros livro = new Livros();
				System.out.println("Escreva o Autor do Livro: ");
				livro.setAutor(scan.nextLine());
				
				System.out.println("Escreva o Titulo do Livro: ");
				livro.setTitulo(scan.nextLine());
				
				System.out.println("Escreva o ano da publicacao do Livro: ");
				livro.setAnoPublicacao(scan.nextInt());
				scan.nextLine();
				
				livros[contador] = livro;
				contador++;
				}
				else {
					System.out.println("O sistema não comporta mais livros! ");
				}
			}
		}
			while(resp == 1 && contador < livros.length);
		
		System.out.println("Lista dos Livros cadastrados: ");
		
		for(int i = 0; i < contador; i++) {
			System.out.println("Titulo: "+ livros[i].getTitulo());
			System.out.println("Autor: "+ livros[i].getAutor());
			System.out.println("Ano de Publicacao: " + livros[i].getAnoPublicacao());
			System.out.println("\n");
		}
		System.out.println("Fim do programa!");
		scan.close();
	}
	
}
