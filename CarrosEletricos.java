package carrostrab;

public class CarrosEletricos extends Carros{
	private float tempoCarregando;
	
	public CarrosEletricos(String modelo, String marca, int ano, float tempoCarregando) {
		super(modelo,marca, ano);
		this.tempoCarregando=tempoCarregando;
	}
	
	public float getTempoBateria(){
		return tempoCarregando;
	}
	
	@Override
	public void exibirInformacoes() {
		super.exibirInformacoes();
		System.out.println("Tempo de bateria: "+tempoCarregando);
	}
}
