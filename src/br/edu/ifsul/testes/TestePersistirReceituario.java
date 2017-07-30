package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Receituario;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author crisley
 */
public class TestePersistirReceituario {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Receituario r = new Receituario();
        Consulta c = new Consulta();
        
        c = em.find(Consulta.class, 8);
        
        r.setConsulta(c);
        r.setPosologia("Posologia");
        r.setValidade(Calendar.getInstance());
        
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
        
    }
    
}
