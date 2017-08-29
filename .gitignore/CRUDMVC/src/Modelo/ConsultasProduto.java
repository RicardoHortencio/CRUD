
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasProduto extends Conexao{
    
    public boolean registro(Produto pro){
        
        PreparedStatement ps = null;
        Connection con = getConexao();
        
        
     String sql = "INSERT INTO produto ( codigo , nome , preco , quantidade) VALUES(?,?,?,?)";
     
     try{
         
         ps = con.prepareStatement(sql);
         ps.setString(1, pro.getCodigo());
         ps.setString(2, pro.getNome());
         ps.setDouble(3, pro.getPreco());
         ps.setInt(4, pro.getQuantidade());
         
         ps.execute();
         return true;         
         
     }catch(SQLException e){
         
         System.err.println(e);
         
         return false;
     } finally{
         try{
             
             con.close();
             
         }catch(SQLException e){
             
             System.err.println(e);
         } 
     }
    }
    
    public boolean modificar(Produto pro){
        
        PreparedStatement ps = null;
        Connection con = getConexao();
        
        
     String sql = "UPDATE produto SET codigo=? , nome=? , preco=? , quantidade=? WHERE id=?";
     
     try{
         
         ps = con.prepareStatement(sql);
         ps.setString(1, pro.getCodigo());
         ps.setString(2, pro.getNome());
         ps.setDouble(3, pro.getPreco());
         ps.setInt(4, pro.getQuantidade());
         ps.setInt(5, pro.getId());
         
         ps.execute();
         return true;         
         
     }catch(SQLException e){
         
         System.err.println(e);
         
         return false;
     } finally{
         try{
             
             con.close();
             
         }catch(SQLException e){
             
             System.err.println(e);
         } 
     }
    }
    
    public boolean deletar(Produto pro){
        
        PreparedStatement ps = null;
        Connection con = getConexao();
        
        
     String sql = "DELETE FROM produto WHERE id=? ";
     
     try{
         
         ps = con.prepareStatement(sql);        
         ps.setInt(1, pro.getId());
         
         ps.execute();
         return true;         
         
     }catch(SQLException e){
         
         System.err.println(e);
         
         return false;
     } finally{
         try{
             
             con.close();
             
         }catch(SQLException e){
             
             System.err.println(e);
         } 
     }
    }
    
     public boolean buscar(Produto pro){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexao();
        
        
     String sql = "SELECT * FROM produto WHERE codigo=? ";
     
     try{
         
         ps = con.prepareStatement(sql);           
         ps.setString(1, pro.getCodigo());         
         rs = ps.executeQuery();
         
         if(rs.next()){
           
           pro.setId(Integer.parseInt(rs.getString("id")));
           pro.setCodigo(rs.getString("codigo"));
           pro.setNome(rs.getString("nome"));
           pro.setPreco(Double.parseDouble(rs.getString("preco")));
           pro.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
           
           return true;           
             
         } 
         
         return false;         
         
     }catch(SQLException e){
         
         System.err.println(e);
         
         return false;
     } finally{
         try{
             
             con.close();
             
         }catch(SQLException e){
             
             System.err.println(e);
         } 
     }
     }
}
