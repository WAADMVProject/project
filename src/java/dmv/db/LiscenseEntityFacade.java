/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmv.db;

import dmv.model.LiscenseEntity;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SAMIPC
 */
@Stateless
public class LiscenseEntityFacade extends AbstractFacade<LiscenseEntity> {
    @PersistenceContext(unitName = "WAADMVPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LiscenseEntityFacade() {
        super(LiscenseEntity.class);
    }
    
}
