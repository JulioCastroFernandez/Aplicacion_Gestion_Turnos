package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long identificadorProgresivo;
    private LocalDate fecha;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "ciudadano_id") //Nombre de la columna de la FK (Foreign Key) en la tabla Turno.
    private Ciudadano ciudadano;

    public Turno() {
    }

    public Turno(Long id, Long identificadorProgresivo, LocalDate fecha, String estado, Ciudadano ciudadano) {
        this.id = id;
        this.identificadorProgresivo = identificadorProgresivo;
        this.fecha = fecha;
        this.estado = estado;
        this.ciudadano = ciudadano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdentificadorProgresivo() {
        return identificadorProgresivo;
    }

    public void setIdentificadorProgresivo(Long identificadorProgresivo) {
        this.identificadorProgresivo = identificadorProgresivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }
}
