package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author crisley
 */
@Entity(name = "Consulta")
@Inheritance(strategy = InheritanceType.JOINED)
public class Consulta implements Serializable{

    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @NotNull
    private Calendar data;
    
    @Temporal(TemporalType.DATE)
    @NotNull
    private Calendar hora;
    
    @Column(name = "preconsulta", columnDefinition = "text")
    @NotNull(message = "A pré consulta não pode ser nulo")
    @NotBlank(message = "A pré consulta não pode ficar em branco")
    private String preConsulta;
    
    @Column(name = "posconsulta", columnDefinition = "text")
    @NotNull(message = "A pós consulta não pode ser nulo")
    @NotBlank(message = "A pós consulta não pode ficar em branco")
    private String posConsulta;
    
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_medico")
    private Medico medico;
    
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_paciente")
    private Paciente paciente;
    
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Exame> listaExames  = new ArrayList<>();
    
    public Consulta() {
        
    }
    
    public void adicionarExame(Exame obj){
        obj.setConsulta(this);
        this.listaExames.add(obj);
    }
    
    public void removerExame(int index){
        this.listaExames.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public String getPreConsulta() {
        return preConsulta;
    }

    public void setPreConsulta(String preConsulta) {
        this.preConsulta = preConsulta;
    }

    public String getPosConsulta() {
        return posConsulta;
    }

    public void setPosConsulta(String posConsulta) {
        this.posConsulta = posConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
