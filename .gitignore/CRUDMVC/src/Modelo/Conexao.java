
package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
    
    
   private final String base = "loja";
   private final String user = "root";
   private final String password = "assalamo";
   private final String url = "jdbc:mysql://localhost:3306/" + base +"?useSSL=false";
   
   private Connection con = null;
           
   public Connection getConexao(){
       
       try{
       Class.forName("com.mysql.jdbc.Driver");
       con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
       
   } catch(SQLException e){
           
           System.err.println(e);
    
           
           
           } catch (ClassNotFoundException ex) {
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
       }
       
      return con; 
   }
        
}
