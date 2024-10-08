package com.mycompany.controledevendascombancodedados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendasDAO {

    public void cadastrarVenda(Vendas venda){
         String sql1 = "INSERT INTO VENDAS(NOME_CLIENTE,NOME_PRODUTO,QUANTIDADE,PRECO_PRODUTO) VALUES (?,?,?,?)";
         PreparedStatement prepararQuery;
         try{
             
             prepararQuery = BDAdmin.getConexao().prepareStatement(sql1);
             prepararQuery.setString(1, venda.getNome_cliente());
             prepararQuery.setString(2, venda.getNome_produto());
             prepararQuery.setInt(3, venda.getQuantidade());
             prepararQuery.setFloat(4, venda.getPreco_produto());
             int linhas_adicionadas = prepararQuery.executeUpdate();
             if(linhas_adicionadas > 0){
                 System.out.println("Venda adicionada com sucesso! \n");
                 System.out.println("-------------------------------------------------------------------------------------------------------------");
             }else{
                  System.out.println("Não foi possível adicionar a venda!");
                  System.out.println("-------------------------------------------------------------------------------------------------------------");
             }
         }catch(SQLException e){
             System.out.println("Erro ao inserir venda! Erro :" + e.getMessage());
             System.out.println("-------------------------------------------------------------------------------------------------------------");
         }    
    }
    
    public void listarVendas(){
        String sql2 = "SELECT * FROM VENDAS";
        
        PreparedStatement prepararQuery;
        try{
            prepararQuery = BDAdmin.getConexao().prepareStatement(sql2);
            System.out.println("Lista de Vendas: \n");
            ResultSet resultadoConsulta = prepararQuery.executeQuery();
            while(resultadoConsulta.next()){
                System.out.println("ID da venda: " + resultadoConsulta.getInt("ID_VENDA"));
                System.out.println("Nome do cliente: " + resultadoConsulta.getString("NOME_CLIENTE"));
                System.out.println("Nome do produto: " + resultadoConsulta.getString("NOME_PRODUTO"));
                System.out.println("Quantidade Vendida: " + resultadoConsulta.getInt("QUANTIDADE"));
                System.out.println("Preco do produto: " + resultadoConsulta.getFloat("PRECO_PRODUTO"));
                System.out.println("-------------------------------------------------------------------------------------------------------------");
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar os clientes! Erro: " + e.getMessage());
        }
    }
    public void deletarVendas(int id_venda){
        String sql3 = "DELETE FROM VENDAS WHERE ID_VENDA = (?)";
        
        PreparedStatement prepararQuery;
        try{
            prepararQuery = BDAdmin.getConexao().prepareStatement(sql3);
            prepararQuery.setInt(1,id_venda);
            int linhas_delete = prepararQuery.executeUpdate();
            if(linhas_delete > 0){
            System.out.println("Venda deletada com sucesso!");
            
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            }else{
                System.out.println("Não foi possível deletar a venda!");
                System.out.println("-------------------------------------------------------------------------------------------------------------");
            }
        }catch(SQLException e){
            System.out.println("Não foi possível deletar a venda! Erro: " + e.getMessage());
            System.out.println("-------------------------------------------------------------------------------------------------------------");
        }
    }
       public void atualizarVendas(Vendas venda){
           String sql4 = "UPDATE VENDAS SET NOME_CLIENTE = (?),NOME_PRODUTO = (?),QUANTIDADE = (?),PRECO_PRODUTO = (?) WHERE ID_VENDA = (?)";
           
           PreparedStatement prepararQuery;
           try{
               prepararQuery = BDAdmin.getConexao().prepareStatement(sql4);
               prepararQuery.setString(1,venda.getNome_cliente());
               prepararQuery.setString(2,venda.getNome_produto());
               prepararQuery.setInt(3,venda.getQuantidade());
               prepararQuery.setFloat(4,venda.getPreco_produto());
               prepararQuery.setInt(5,venda.getId_venda());
               
               int linhas_afetadas = prepararQuery.executeUpdate();
                if(linhas_afetadas > 0){
               System.out.println("Cliente atualizado com sucesso! ");
               System.out.println("-------------------------------------------------------------------------------------------------------------");
                } else{    
                       System.out.println("Não foi possível encontrar o cliente!");
                       System.out.println("-------------------------------------------------------------------------------------------------------------");
                       }
           } catch(SQLException e){
               
                       System.out.println("Não foi possível atualizar o cliente! Erro: "+ e.getMessage());
                       System.out.println("-------------------------------------------------------------------------------------------------------------");
           }
           
}
}

