package carrostrab;
import java.util.Scanner;
import java.util.ArrayList;
public class Carros {
	private String modelo;
	private int ano;
	private String marca;
	public Carros(String modelo, String marca, int ano) {
		this.modelo=modelo;
		this.marca=marca;
		this.ano=ano;
	}
	public void exibirInformacoes() {
		System.out.println("Modelo: "+modelo);
		System.out.println("Marca: "+marca);
		System.out.println("Ano: "+ano);
	}

 public String getModelo() {
	return modelo;
}
  public String getMarca() {
	  return marca;
  }
  public int getAno() {
	  return ano;
  }
  public static void main(String [] args) {
	  Scanner scan = new Scanner(System.in);
	  int resp = 0;
	  ArrayList<Carros> carros = new ArrayList<>();
	  	do {
	  		System.out.println("Você quer cadastrar um carro? (1 ==  SIM / 0 == NAO)");
	  		resp = scan.nextInt();
	  		scan.nextLine();
	  		if(resp == 1) {
	  			System.out.println("É um carro eletrico ou  gasolina? (1 == Elétrico / 2 == Gasolina)");
	  			int tipo = scan.nextInt();
	  			scan.nextLine();
	  			
	  			System.out.println("Digite o modelo do carro: ");
	  			String modelo = scan.nextLine();
	  			
	  			
	  			System.out.println("Digite a marca do carro: ");
	  			String marca = scan.nextLine();
	  			
	  			System.out.println("Digite o ano do carro: ");
	  			int ano = scan.nextInt();
	  			scan.nextLine();
	  			if(tipo == 1) {
	  				System.out.println("Digite,em horas, o tempo que o carro fica carregando: ");
	  				float tempoCarregando = scan.nextFloat();
	  				carros.add(new CarrosEletricos(modelo,marca,ano, tempoCarregando));
	  			}
	  			else if (tipo == 2) {
	  				System.out.println("Digite, em litros, quanto de gasolina tem no seu tanque: ");
	  				float gasolinaColocada = scan.nextFloat();
	  				scan.nextLine();
	  				carros.add(new CarrosGasolina(modelo,marca,ano,gasolinaColocada));
	  			}
	  		}
	  	}while(resp == 1);
	  	for(Carros carro : carros) {
	  		carro.exibirInformacoes();
	  		scan.close();
	  	}
	  System.out.println("Fim do programa!");
	  }
	  
  }  
