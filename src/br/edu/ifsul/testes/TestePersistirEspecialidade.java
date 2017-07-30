package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Especialidade;
import javax.persistence.EntityManager;

/**
 *
 * @author crisley
 */
public class TestePersistirEspecialidade {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Especialidade e = new Especialidade();
        e.setDescricao("Especialidade A");
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        
        
    }
    
}
