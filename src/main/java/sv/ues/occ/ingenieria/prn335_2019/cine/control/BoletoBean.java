/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.occ.ingenieria.prn335_2019.cine.control;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.ues.occ.ingenieria.prn335_2019.cine.DataAccessException;
import sv.ues.occ.ingenieria.prn335_2019.cine.entity.Boleto;

/**
 *
 * @author jcpenya
 */
@Stateless
@LocalBean
public class BoletoBean implements Serializable {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    @Inject
    SalaBean salaBean;

    public List<Boleto> findBoletosByIdFuncion(final Integer idFuncion, int first, int pageSize) throws DataAccessException {
        if (idFuncion != null && em != null) {
            try {
                Query q = em.createNamedQuery("Boleto.findByIdFuncion");
                q.setParameter("idFuncion", idFuncion);
                q.setFirstResult(first);
                q.setMaxResults(pageSize);
                return q.getResultList();

            } catch (Exception ex) {
                throw new DataAccessException(ex.getMessage(), ex);
            }
        }
        return Collections.EMPTY_LIST;
    }

    public Boleto findById(final Integer idBoleto) throws DataAccessException {
        if (idBoleto != null && em != null) {
            try {
                return em.find(Boleto.class, idBoleto);
            } catch (Exception ex) {
                throw new DataAccessException(ex.getMessage(), ex);
            }
        }
        throw new DataAccessException("Registro no encontrado", null);
    }

}
