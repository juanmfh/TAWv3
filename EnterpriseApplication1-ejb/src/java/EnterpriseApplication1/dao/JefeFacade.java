/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseApplication1.dao;

import EnterpriseApplication1.entity.Jefe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JuanM
 */
@Stateless
public class JefeFacade extends AbstractFacade<Jefe> {
    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JefeFacade() {
        super(Jefe.class);
    }
    
}
