
package crudmvc;

import Controlador.ControlProduto;
import Modelo.ConsultasProduto;
import Modelo.Produto;
import View.frmProduto;


public class CRUDMVC {


    public static void main(String[] args) {
        
      Produto               mod  = new Produto();
      ConsultasProduto      modC = new ConsultasProduto();
      frmProduto            frm  = new frmProduto();
      
      ControlProduto ctrl = new ControlProduto(mod, modC, frm);
      ctrl.iniciar();
      frm.setVisible(true);
        
    }
    
}
