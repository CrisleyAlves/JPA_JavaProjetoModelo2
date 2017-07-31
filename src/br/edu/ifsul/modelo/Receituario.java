/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Crisley Alves
 * @email crisleyalvesphx@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Table(name = "Receituario")
public class Receituario implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_receituario", sequenceName = "seq_receituario_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_receituario", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "posologia")
    @NotNull(message = "A posologia deve ser informada")
    @NotBlank(message = "A posologia deve ser informada")
    private String posologia;
    
    @Temporal(TemporalType.DATE)
    @NotNull
    private Calendar validade;
    
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_consulta")
    private Consulta consulta;
    
    @ManyToMany
    @JoinTable(name = "medicamento_receituario",
            joinColumns = 
            @JoinColumn(name = "receituario", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "medicamento", referencedColumnName = "id", nullable = false))
    private List<Medicamento> medicamentos = new ArrayList<>();

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Receituario other = (Receituario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
