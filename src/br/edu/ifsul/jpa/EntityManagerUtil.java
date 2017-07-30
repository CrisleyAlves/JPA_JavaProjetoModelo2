package br.edu.ifsul.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author crisley
 */
public class EntityManagerUtil {

    private static EntityManager em = null;
    private static EntityManagerFactory factory = null;
    
    public static EntityManager getEntityManager(){
        
        if(factory == null){
            factory = Persistence.createEntityManagerFactory("projeto-modelo-2-PU");
        }
        
        if(em == null){
            em = factory.createEntityManager();
        }
        
        return em;
    }
    
}
