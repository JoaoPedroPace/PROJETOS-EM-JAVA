package carrostrab;
import java.util.Scanner;
public class Carros {
	private String modelo;
	private int ano;
	private String marca;
 public String getModelo() {
	return modelo;
}
  public String getMarca() {
	  return marca;
  }
  public int getAno() {
	  return ano;
  }
  public void setModelo(String modelo) {
	  this.modelo= modelo; 
  }
  public void setMarca(String marca) {
	  this.marca=marca;
  }
  public void setAno(int ano) {
	  this.ano=ano;
  }
  public static void main(String [] args) {
	  Scanner scan = new Scanner(System.in);
	  int resp = 0;
	  int contador = 0;
	  Carros[] carros = new Carros[10];
	 
	  do {
	  System.out.println("Você deseja cadastrar um carro?  1 para sim/ 0 para não: ");
	  resp = scan.nextInt();
	  scan.nextLine();
	  
	  	if(resp == 1){
	  	Carros carro = new Carros();
	  System.out.println("Escreva o modelo do carro: ");
	  carro.setModelo(scan.nextLine());
	  
	  System.out.println("Escreva a marca do carro: ");
	  carro.setMarca(scan.nextLine());
	  
	  System.out.println("Escreva o ano do carro: ");
	  carro.setAno(scan.nextInt());
	  
	  carros[contador] = carro;
	  contador++;
	  }
	 }
	  	while (resp == 1 && contador < carros.length); 
	  System.out.println("Carros cadastrados: ");
	  for(int i = 0; i < contador; i++) {
		  System.out.printf("Carro %d: \n", i + 1);
		  System.out.println("Modelo: "+ carros[i].getModelo());
		  System.out.println("Marca: " + carros[i].getMarca());
		  System.out.println("Ano: " + carros[i].getAno());
		  System.out.println("\n");
	  }
	  scan.close();
	  System.out.println("Fim do programa!");
  }  
}