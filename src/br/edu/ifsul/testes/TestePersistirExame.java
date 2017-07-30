package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Exame;
import javax.persistence.EntityManager;

/**
 *
 * @author crisley
 */
public class TestePersistirExame {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Exame e = new Exame();
        e.setDescricao("Descrição exame");
        e.setNome("Nome exame");
        Consulta c = em.find(Consulta.class, 8);
        e.setConsulta(c);
        
        
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        
        
    }
    
}
