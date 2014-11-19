/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.db;

import dmv.model.AccountEntity;
import java.sql.ResultSet;
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
public class AccountEntityFacade extends AbstractFacade<AccountEntity> {

    @PersistenceContext(unitName = "WAADMVPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountEntityFacade() {
        super(AccountEntity.class);
    }

    public Long getAccountId(int ssn) {
        ArrayList<Integer> ids = new ArrayList();
        List results = em.createQuery(
                "SELECT a.id FROM AccountEntity a WHERE a.ssn = :ssn")
                .setParameter("ssn", ssn).getResultList();

        if (!results.isEmpty()) {
            return (Long) results.get(0);
        } else {
            return null;
        }
    }

    public AccountEntity getUser(String username, String password) {         
      
        List results = em.createQuery( "SELECT a FROM AccountEntity a WHERE a.password = :password AND a.userName = :username") .
                setParameter("password", password).setParameter("username", username).getResultList();

        if (!results.isEmpty()) {
            return (AccountEntity) results.get(0);
        } else {
            return null;
        }
    }

}
