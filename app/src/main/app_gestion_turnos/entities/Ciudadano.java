package main.app_gestion_turnos.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity  //Con esto indico que esta clase es una entidad JPA y se mapeara en una tabla
public class Ciudadano {

    @Id //Marca esto como la clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //La BD generá automáticamente el ID de cada Ciudadano.
    private Long id;
    @Column(unique = true) // Con esto se asegura que cada DNI va a ser unico en la BD.
    private String dni;
    private String nombre;
    private String apellido;

    //Relación One-to-many: Un ciudadano puede tener varios turnos.
    //Con mappedBy indicamos el campo en la entidad "Turno" que es dueño de la relación.
    //CascadeType.All significa que operaciones (persist, remove) en Ciudadano se propagarán a sus Turnos asociados.
    @OneToMany(mappedBy = "ciudadano", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> listaTurnos;

    //Constructores, getters y setters.
    public Ciudadano() {
    }

    public Ciudadano(Long id, String dni, String nombre, String apellido, List<Turno> listaTurnos) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaTurnos = listaTurnos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }
}
