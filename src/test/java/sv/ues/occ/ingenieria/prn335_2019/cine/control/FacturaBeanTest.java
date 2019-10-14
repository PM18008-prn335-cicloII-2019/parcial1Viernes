/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.occ.ingenieria.prn335_2019.cine.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sv.ues.occ.ingenieria.prn335_2019.cine.DataAccessException;
import sv.ues.occ.ingenieria.prn335_2019.cine.entity.Boleto;
import sv.ues.occ.ingenieria.prn335_2019.cine.entity.Factura;

/**
 *
 * @author jcpenya
 */
@ExtendWith(MockitoExtension.class)
public class FacturaBeanTest {
    
   
    
    
    
    public FacturaBeanTest() {
        
    }
    
    public String getCarnet(){
        return "PM18008";
    }
    
    @Test
    public void testGenerarFactura() throws Exception{
    System.out.println("generarFactura");
    
    
    EntityManager mockEM =Mockito.mock(EntityManager.class);
    FacturaBean cut=new FacturaBean();
    Boleto mockB=Mockito.mock(Boleto.class);
    BoletoBean mockBB = Mockito.mock(BoletoBean.class);

    List<Integer> IdBoletoList = new ArrayList<>();
        IdBoletoList.add(1);
        IdBoletoList.add(2);
        IdBoletoList.add(3);
    
    Mockito.when(mockBB.findById(Mockito.any(Integer.class))).thenReturn(mockB);
      
       
        
        
        
        try{
            
            cut.generarFactura(null);
            
        }catch(Exception ex){    
    }

         try{
            
            cut.generarFactura(Collections.emptyList());
            
        }catch(Exception ex){
            
            
        
        }
        
        
        cut.em = null;
        
        try{
            
           cut.generarFactura(IdBoletoList);
            
        }catch(Exception ex){
            
            
        
        }
        
         cut.em = mockEM;
        cut.boletoBean = null;
        
        try{
            
            cut.generarFactura(IdBoletoList);
            
        }catch(Exception ex){
            
            
        
        }
        
         cut.em = mockEM;
        cut.boletoBean = mockBB;
        
        try{
            
            cut.generarFactura(IdBoletoList);
            
        }catch(Exception ex){
            
            
        
        }
        
        Mockito.when(mockBB.findById(Mockito.any(Integer.class))).thenReturn(null);
        
        try{
            
            cut.generarFactura(IdBoletoList);
            
        }catch(Exception ex){
            
            
        
        }
        
        Mockito.when(mockBB.findById(Mockito.any(Integer.class))).thenThrow(new DataAccessException("Paso algo",new Exception()));
        
        try{
            
          cut.generarFactura(IdBoletoList);
            
        }catch(Exception ex){
            
            
        
        }
        
        
    }
}
