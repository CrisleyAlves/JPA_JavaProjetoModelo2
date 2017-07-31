package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Crisley Alves
 * @email crisleyalvesphx@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity(name = "Exame")
public class Exame implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_exame", sequenceName = "seq_exame_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_exame", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    private String nome;
    
    @Column(name = "descricao")
    @NotNull(message = "A descrição não pode ser nulo")
    @NotBlank(message = "A descrição não pode ser em branco")
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_consulta")
    private Consulta consulta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exame other = (Exame) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
