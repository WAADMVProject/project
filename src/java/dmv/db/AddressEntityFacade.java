/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmv.db;

import dmv.model.AddressEntity;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SAMIPC
 */
@Stateless
public class AddressEntityFacade extends AbstractFacade<AddressEntity> {
    @PersistenceContext(unitName = "WAADMVPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressEntityFacade() {
        super(AddressEntity.class);
    }
    
    public Long addAddress(AddressEntity address){
    
        em.persist(address);
        return address.getId();
    }
    
}
