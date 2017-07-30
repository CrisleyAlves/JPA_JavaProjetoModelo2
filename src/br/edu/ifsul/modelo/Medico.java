/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author crisley
 */
@Entity
@Table(name = "Medico")
public class Medico extends Paciente implements Serializable{
    
    @Column(name = "crm")
    @NotNull(message = "O CRM deve ser informado")
    @NotBlank(message = "O CRM deve ser informado")
    private String crm;
    
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_especialidade")
    private Especialidade especialidade;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    
    
    
    
    
}
