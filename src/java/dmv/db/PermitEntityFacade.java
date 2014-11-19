/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmv.db;

import dmv.model.PermitEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SAMIPC
 */
@Stateless
public class PermitEntityFacade extends AbstractFacade<PermitEntity> {
    @PersistenceContext(unitName = "WAADMVPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermitEntityFacade() {
        super(PermitEntity.class);
    }
    
     public Long getPermitId(String dln) {
        ArrayList<Integer> ids = new ArrayList();
        List results = em.createQuery(
                "SELECT p.id FROM PermitEntity p WHERE p.drivingLiscenseNumber = :dln")
                .setParameter("dln", dln).getResultList();

        if (!results.isEmpty()) {
            return (Long) results.get(0);
        } else {
            return null;
        }
    }
    
}
