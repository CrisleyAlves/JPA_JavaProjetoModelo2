package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Paciente;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author crisley
 */
public class TestePersistirPaciente {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Paciente p = new Paciente();
        
        p.setAltura(1.73);
        p.setHistorico("Histórico");
        p.setNascimento(Calendar.getInstance());
        p.setNome("Nome Paciente");
        p.setPeso(77.7);
        p.setSexo("Masculino");
        p.setTelefone("telefone");
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        
    }
    
}
