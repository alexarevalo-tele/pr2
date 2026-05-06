package com.practica2.pr2;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "parking")
public class ParkingRecord_DTO_aaa00081 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;
    
    private boolean entrada; 
    
    @CreationTimestamp(source = SourceType.DB)
    private LocalDateTime hora;

    public ParkingRecord_DTO_aaa00081() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public boolean isEntrada() { return entrada; }
    public void setEntrada(boolean entrada) { this.entrada = entrada; }

    public LocalDateTime getHora() { return hora; }
    public void setHora(LocalDateTime hora) { this.hora = hora; }

}
