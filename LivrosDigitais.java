package livros;

public class LivrosDigitais extends Livros {
    private double tamanhoMB;

    public LivrosDigitais(String autor, String titulo, int anoPublicacao, double tamanhoMB) {
        super(autor, titulo, anoPublicacao);
        this.tamanhoMB = tamanhoMB;
    }

    public double getTamanhoMB() {
        return tamanhoMB;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Tamanho do Livro em MB: " + tamanhoMB);
    }
}
