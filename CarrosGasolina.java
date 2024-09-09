package carrostrab;

public class CarrosGasolina extends Carros {
	private float gasolinaColocada;
	
	public CarrosGasolina(String modelo, String marca, int ano, float gasolinaColocada) {
		super(modelo,marca, ano);
		this.gasolinaColocada=gasolinaColocada;
	}
	
	public float getGasolinaColocada() {
		return gasolinaColocada;
	}

	@Override
	public void exibirInformacoes() {
		super.exibirInformacoes();
		System.out.println("Gasolina que foi colocada: "+ gasolinaColocada);
	}
}
