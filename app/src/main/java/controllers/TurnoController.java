package controllers;

import entities.Ciudadano;
import entities.Turno;
import persistence.ControladorPersistencia;

import java.time.LocalDate;
import java.util.List;

public class TurnoController {
    ControladorPersistencia cp = new ControladorPersistencia();

    public void crearTurno(String estado, LocalDate fecha, Long id){
        Ciudadano ciudadano = cp.buscarCiudadanoPorID(id);
        if (ciudadano != null) {
            Long idProgresivo = generarIdProgresivo(ciudadano);
            Turno turno = new Turno();
            turno.setIdentificadorProgresivo(idProgresivo);
            turno.setFecha(fecha);
            turno.setEstado(estado);
            turno.setCiudadano(ciudadano);

            cp.crearTurno(turno);
            System.out.println("Turno creado exitosamente.");
        } else {
            System.err.println("Error: no se encontró al ciudadano con ID: " + id);
        }
    }

    public Long generarIdProgresivo(Ciudadano ciudadano){
        List<Turno> turnoList = ciudadano.getListaTurnos();
        if(turnoList != null){
            return (long) (turnoList.size() + 1000);
        }else{
            return 1000L;
        }
    }

    public List<Turno> listarTurnos(LocalDate fechaBuscada){
        List<Turno> lista = cp.buscarTodosLosTurno();
        List<Turno> listaFiltrada = lista.stream()
                .filter(t->t.getFecha().equals(fechaBuscada))
                .sorted((t1, t2)->Long.compare(t1.getIdentificadorProgresivo(), t2.getIdentificadorProgresivo()))
                .toList();
        System.out.println("Listado de turnos por fecha:" + fechaBuscada);
        listaFiltrada.forEach(System.out::println);
        return listaFiltrada;
    }

    public void actualizarEstadoTurno(Long id, String nuevoEstado){
        Turno turno = cp.buscarTurno(id);
        if(turno !=null){
            if ("En espera".equalsIgnoreCase(nuevoEstado) || "Ya atendido".equalsIgnoreCase(nuevoEstado)){
                turno.setEstado(nuevoEstado);
                cp.actualizarTurno(turno);
                System.out.println("El estado del turno ha cambiado a " + nuevoEstado);
            }else {
                System.out.println("Error. Solo se permiten: en espera o ya atendido");
            }
        }else {
            System.out.println("No se encontró el turno con el ID: " + id);
        }
    }
}