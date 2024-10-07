
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public void inserirVenda(String nome_cliente,String nome_produto,int quantidade,float preco_produto){
        BDAdmin BDadm = new BDAdmin();
        BDadm.conectarSGBD();
        Connection conexao = BDadm.conexao; 
        
        String sql1 = "INSERT INTO VENDAS(NOME_CLIENTE,NOME_PRODUTO,QUANTIDADE,PRECO_PRODUTO) VALUES (?,?,?,?)";
        try{
            PreparedStatement prepararQuery = conexao.prepareStatement(sql1);
            prepararQuery.setString(1, nome_cliente);
            prepararQuery.setString(2, nome_produto);
            prepararQuery.setInt(3, quantidade);
            prepararQuery.setFloat(4, preco_produto);
            
            prepararQuery.executeUpdate();
            System.out.println("Venda adicionada com sucesso! ");
        }catch(SQLException e){
            System.out.println("Não foi possível adicionar a venda! Erro: " + e.getMessage());
        }finally{
         BDadm.desconectar();
        }
        
    }
    public void listarVendas(){
        BDAdmin BDadm = new BDAdmin();
        BDadm.conectarSGBD();
        Connection conexao = BDadm.getConexao();
        
        String sql2 = "SELECT * FROM VENDAS";
        try{
            PreparedStatement prepararQuery = conexao.prepareStatement(sql2);
            System.out.println("Lista de Vendas: ");
            ResultSet resultadoConsulta = prepararQuery.executeQuery();
            while(resultadoConsulta.next()){
                System.out.println("ID da venda: " + resultadoConsulta.getInt("ID_VENDA"));
                System.out.println("Nome do Cliente: " + resultadoConsulta.getString("NOME_CLIENTE"));
                System.out.println("Nome do Produto: " + resultadoConsulta.getString("NOME_PRODUTO"));
                System.out.println("Quantidade vendida: " + resultadoConsulta.getInt("QUANTIDADE"));
                System.out.printf("Preco do produto: %.2f%n", resultadoConsulta.getFloat("PRECO_PRODUTO"));
                System.out.printf("\n");
            }
        }catch(SQLException e){
            System.out.println("Não foi possível listar as vendas! Erro:" +  e.getMessage());
        }finally{
        BDadm.desconectar();
        }
    }
    public void atualizarVenda(String nome_cliente, String nome_cliente_atualizado,String nome_produto_atualizado,int quantidade_atualizada, float preco_produto_atualizado){
        BDAdmin BDadm = new BDAdmin();
        BDadm.conectarSGBD();
        Connection conexao = BDadm.getConexao();
        
        String sql4 = "UPDATE VENDAS SET NOME_CLIENTE = (?),NOME_PRODUTO = (?),QUANTIDADE = (?), PRECO_PRODUTO = (?) WHERE NOME_CLIENTE = (?)";
        try{
            PreparedStatement prepararQuery = conexao.prepareStatement(sql4);
            prepararQuery.setString(1,nome_cliente_atualizado);
            prepararQuery.setString(2,nome_produto_atualizado);
            prepararQuery.setInt(3,quantidade_atualizada);
            prepararQuery.setFloat(4,preco_produto_atualizado);
            prepararQuery.setString(5,nome_cliente);
            
            prepararQuery.executeUpdate();
            
            System.out.println("Cliente atualizado com sucesso! ");
            
            
        }catch(SQLException e){
            System.out.println("Erro ao atualizar cliente! Erro: " + e.getMessage());
        }
    }
    public void deletarVenda(String nome_cliente){
        BDAdmin BDadm = new BDAdmin();
        BDadm.conectarSGBD();
        Connection conexao = BDadm.getConexao();
        
        String sql3 = "DELETE FROM VENDAS WHERE NOME_CLIENTE = (?)";
        
        try{
            PreparedStatement prepararQuery = conexao.prepareStatement(sql3);
            prepararQuery.setString(1, nome_cliente);
            prepararQuery.executeUpdate();
            System.out.println("Cliente deletado com sucesso! ");
        }catch(SQLException e){
            System.out.println("Erro ao deletar cliente! Erro: " + e.getMessage());
        } finally{
            BDadm.desconectar();
        }
    }
   
}
