/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.occ.ingenieria.prn335_2019.cine.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.ues.occ.ingenieria.prn335_2019.cine.DataAccessException;
import sv.ues.occ.ingenieria.prn335_2019.cine.entity.Boleto;
import sv.ues.occ.ingenieria.prn335_2019.cine.entity.Factura;

/**
 *
 * @author jcpenya
 */
@Stateless
@LocalBean
public class FacturaBean implements Serializable {

    @PersistenceContext(unitName = "AlgunaPU")
    protected EntityManager em;

    @Inject
    protected BoletoBean boletoBean;

    public Factura generarFactura(final List<Integer> idBoletoList) throws DataAccessException {
        if (idBoletoList != null && !idBoletoList.isEmpty() && em != null && boletoBean != null) {
            try {
                List<Boleto> boletoList = new ArrayList<>();
                for (Integer idBoleto : idBoletoList) {
                    Boleto boleto = boletoBean.findById(idBoleto);
                    if (boleto != null) {
                        boletoList.add(boleto);
                    }
                }
                Factura salida = new Factura();
                salida.setFecha(new Date());
                salida.setBoletoList(boletoList);
                salida.setOrdenList(new ArrayList<>());
                salida.setPagoList(new ArrayList<>());
                return salida;
            } catch (Exception ex) {
                throw new DataAccessException(ex.getMessage(), ex);
            }
        }
        throw new DataAccessException("No puede generarse la factura", null);
    }

}
