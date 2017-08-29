
package Controlador;

import Modelo.ConsultasProduto;
import Modelo.Produto;
import View.frmProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.JOptionPane;


public class ControlProduto implements ActionListener{
    
    private Produto mod;
    private ConsultasProduto modC;
    private frmProduto frm; 
    
    
    public ControlProduto(Produto mod, ConsultasProduto modC, frmProduto frm){
        
        this.mod = mod;
        this.modC = modC;
        this.frm  = frm;
        this.frm.btGuardar.addActionListener(this);
        this.frm.btModificar.addActionListener(this);
        this.frm.btDeletar.addActionListener(this);
        this.frm.btLimpar.addActionListener(this);
        this.frm.btBuscar.addActionListener(this);
        
    }
    
    public void iniciar(){
        
        frm.setTitle("Produtos");
        frm.setLocationRelativeTo(null);
        frm.setVisible(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
      if(e.getSource() == frm.btGuardar){
          
        mod.setCodigo(frm.txtCodigo.getText());
        mod.setNome(frm.txtNome.getText());
        mod.setPreco(Double.parseDouble(frm.txtPreco.getText()));
        mod.setQuantidade(Integer.parseInt(frm.txtQuantidade.getText()));
        
        if(modC.registro(mod)){
            
            JOptionPane.showMessageDialog(null, "Registro Guardado");
             limpar();
                       
        }else {
            
            JOptionPane.showMessageDialog(null, "Erro  ao guardar");
            limpar();
            
        }          
          
      }
      
      if(e.getSource() == frm.btModificar){
          
        mod.setId(Integer.parseInt(frm.txtID.getText()));
        mod.setCodigo(frm.txtCodigo.getText());
        mod.setNome(frm.txtNome.getText());
        mod.setPreco(Double.parseDouble(frm.txtPreco.getText()));
        mod.setQuantidade(Integer.parseInt(frm.txtQuantidade.getText()));
        
        if(modC.modificar(mod)){
            
            JOptionPane.showMessageDialog(null, "Registro modificado");
             limpar();
                       
        }else { 
            
            JOptionPane.showMessageDialog(null, "Erro  ao ser modificado");
            limpar();
            
        }          
          
      }
        
      if(e.getSource() == frm.btDeletar){
          
        mod.setId(Integer.parseInt(frm.txtID.getText()));
        
        
        if(modC.deletar(mod)){
            
            JOptionPane.showMessageDialog(null, "Registro Deletado");
             limpar();
                       
        }else { 
            
            JOptionPane.showMessageDialog(null, "Erro  ao ser Deletado");
            limpar();
            
        }          
          
      }
      
      if(e.getSource() == frm.btBuscar){
          
        mod.setCodigo(frm.txtCodigo.getText());
        
        
        if(modC.buscar(mod)){
            
            frm.txtID.setText(String.valueOf(mod.getId()));
            frm.txtCodigo.setText(mod.getCodigo());
            frm.txtNome.setText(mod.getNome());
            frm.txtPreco.setText(String.valueOf(mod.getPreco()));
            frm.txtQuantidade.setText(String.valueOf(mod.getQuantidade()));
                   
                       
        }else { 
            
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar");
            limpar();
            
        }          
          
      }
      
       if(e.getSource() == frm.btLimpar){
           
              limpar();
       
       }
        
    }
    
    
    public void limpar(){
        
        frm.txtID.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNome.setText(null);
        frm.txtPreco.setText(null);
        frm.txtQuantidade.setText(null);
        
        
    }
    
}
