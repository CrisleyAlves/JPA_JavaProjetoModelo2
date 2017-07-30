package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.iful.modelo.Consulta;
import br.edu.iful.modelo.Especialidade;
import br.edu.iful.modelo.Medico;
import br.edu.iful.modelo.Paciente;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author crisley
 */
public class TestePersistirConsulta {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Consulta c = new Consulta();
        
        c.setData(Calendar.getInstance());
        c.setHora(Calendar.getInstance());
        c.setMedico(em.find(Medico.class, 8));
        c.setPaciente(em.find(Paciente.class, 8));
        c.setPosConsulta("Pós consulta aqui");
        c.setPreConsulta("Pré consulta");
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
        
    }
    
}
