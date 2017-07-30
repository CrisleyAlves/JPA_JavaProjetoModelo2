package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Medico;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author crisley
 */
public class TestePersistirMedico {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Medico m = new Medico();
        
        m.setAltura(1.73);
        m.setHistorico("Histórico");
        m.setNascimento(Calendar.getInstance());
        m.setNome("Nome Médico");
        m.setPeso(77.7);
        m.setSexo("Masculino");
        m.setTelefone("telefone");
        m.setCrm("CRM");
        m.setEspecialidade(em.find(Especialidade.class, 2));
        
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        
        
    }
    
}
