/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseApplication1.dao;

import EnterpriseApplication1.entity.Gruporescate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JuanM
 */
@Stateless
public class GruporescateFacade extends AbstractFacade<Gruporescate> {
    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GruporescateFacade() {
        super(Gruporescate.class);
    }
    
}
