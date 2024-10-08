
package com.mycompany.controledevendascombancodedados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SistemaControleDeVendas {
    public static void main(String[]args){
        Connection conexao = BDAdmin.getConexao();
        VendasDAO controleVendas = new VendasDAO();
        Scanner scan = new Scanner(System.in);
        int resp = 0;
        do{
        System.out.println("Selecione uma opção: ");
        System.out.println("1 - Criar venda. ");
        System.out.println("2 - Atualizar venda. ");
        System.out.println("3 - Listar venda. ");
        System.out.println("4- Deletar venda. ");
        System.out.println("0 - Sair do programa. ");
        
        resp = scan.nextInt();
        scan.nextLine();
        
        switch(resp){
            case 1:
                Vendas venda = new Vendas();
                
                System.out.println("Insira o nome do cliente: ");
                String nome_cliente = scan.nextLine();
                venda.setNome_cliente(nome_cliente);
                
                System.out.println("Insira o nome do produto vendido: ");
                String nome_produto = scan.nextLine();
                venda.setNome_produto(nome_produto);
                
                System.out.println("Insira a quantidade vendida: ");
                int quantidade = scan.nextInt();
                scan.nextLine();
                venda.setQuantidade(quantidade);
                
                System.out.println("Insira o preco do produto vendido: ");
                float preco_produto = scan.nextFloat();
                scan.nextLine();
                venda.setPreco_produto(preco_produto);
                
                controleVendas.cadastrarVenda(venda);
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                break;
            case 2:
                Vendas vendaUpdate = new Vendas();
                System.out.println("Insira os dados do cliente para substituí-los: \n"); 
                
                System.out.println("Insira o ID da venda a ser atualizada: ");
                int id_cliente = scan.nextInt();
                vendaUpdate.setId_venda(id_cliente);
                
                scan.nextLine();
                
                System.out.println("Insira o nome do cliente");
                String nome_cliente_update = scan.nextLine();
                vendaUpdate.setNome_cliente(nome_cliente_update);
                
                System.out.println("Insira o nome do produto: ");
                String nome_produto_update = scan.nextLine();
                vendaUpdate.setNome_produto(nome_produto_update);
                
                System.out.println("Insira a quantidade do produto: ");
                int quantidade_update = scan.nextInt();
                vendaUpdate.setQuantidade(quantidade_update);
                
                System.out.println("Insira o preco do produto: ");
                float preco_produto_update = scan.nextFloat();
                vendaUpdate.setPreco_produto(preco_produto_update);
                
                controleVendas.atualizarVendas(vendaUpdate);
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                break;
        
        case 3:
                
                controleVendas.listarVendas();
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                break;
        
        case 4:
            System.out.println("Insira o ID do cliente relacionado a venda que você quer apagar: ");
            int id_cliente_delete = scan.nextInt();
            controleVendas.deletarVendas(id_cliente_delete);
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            break;
        
        case 0:
            System.out.println("Saindo do programa..;");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            break;
        default :
            System.out.println("Insira uma opção válida! ");
        }
        }while (resp != 0);
        
    }
}
