package com.mycompany.controledevendascombancodedados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControleDeVendas {
    public void cadastrarVenda(Vendas venda){
         String sql1 = "INSERT INTO VENDAS(NOME_CLIENTE,NOME_PRODUTO,QUANTIDADE,PRECO_PRODUTO) VALUES (?,?,?,?)";
         PreparedStatement ps;
         try{
             
             ps = BDAdmin.getConexao().prepareStatement(sql1);
             ps.setString(1, venda.getNome_cliente());
             ps.setString(2, venda.getNome_produto());
             ps.setInt(3, venda.getQuantidade());
             ps.setFloat(4, venda.getPreco_produto());
             ps.executeUpdate();
         }catch(SQLException e){
             System.out.println("Erro ao inserir venda! Erro :" + e.getMessage());
         }
         
    }
}
