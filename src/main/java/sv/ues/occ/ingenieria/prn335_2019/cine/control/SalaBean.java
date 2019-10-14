/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.occ.ingenieria.prn335_2019.cine.control;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.ues.occ.ingenieria.prn335_2019.cine.DataAccessException;
import sv.ues.occ.ingenieria.prn335_2019.cine.entity.Sala;

/**
 *
 * @author jcpenya
 */
@Stateless
@LocalBean
public class SalaBean implements Serializable {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    public Sala findById(Integer id) throws DataAccessException {
        if (id != null) {
            try {
                return em.find(Sala.class, id);
            } catch (Exception ex) {
                throw new DataAccessException(ex.getMessage(), ex);
            }
        }
        throw new DataAccessException("No encontrado", null);
    }

}
