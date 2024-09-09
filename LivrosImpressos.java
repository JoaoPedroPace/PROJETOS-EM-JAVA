package livros;

public class LivrosImpressos extends Livros {
    private int numPag;

    public LivrosImpressos(String autor, String titulo, int anoPublicacao, int numPag) {
        super(autor, titulo, anoPublicacao);
        this.numPag = numPag;
    }

    public int getNumPag() {
        return numPag;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Numero de paginas: " + numPag);
    }
}
