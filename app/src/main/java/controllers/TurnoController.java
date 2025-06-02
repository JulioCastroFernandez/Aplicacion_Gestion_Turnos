package controllers;

import entities.Ciudadano;
import entities.Turno;
import persistence.ControladorPersistencia;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class TurnoController {
    ControladorPersistencia cp = new ControladorPersistencia();

    // METODO para crear turnos
    public void crearTurno(String estado, LocalDate fecha, Long id) {
        Ciudadano ciudadano = cp.buscarCiudadanoPorID(id);
        if (ciudadano != null) {
            Long idProgresivo = generarIdProgresivo(ciudadano);
            Turno turno = new Turno();
            turno.setIdentificadorProgresivo(idProgresivo);
            turno.setFecha(fecha);
            turno.setEstado(estado);
            turno.setCiudadano(ciudadano);

            cp.crearTurno(turno);
            System.out.println("Turno creado exitosamente. Turno nº " + idProgresivo);
        } else {
            System.err.println("Error: no se encontró al ciudadano con ID: " + id);
        }
    }

    // METODO para generar un ID progresivo
    public Long generarIdProgresivo(Ciudadano ciudadano) {
        List<Turno> turnoList = ciudadano.getListaTurnos();
        if (turnoList != null) {
            return (long) (turnoList.size() + 1000);
        } else {
            return 1000L;
        }
    }

    // METODO para listar los turnos
    public List<Turno> listarTurnos(LocalDate fechaBuscada, String estado) {
        List<Turno> lista = cp.buscarTodosLosTurno();
        List<Turno> listaFiltrada = lista.stream()
                .filter(t -> t.getFecha().equals(fechaBuscada) &&
                        t.getEstado().equalsIgnoreCase(estado))
                .sorted(Comparator.comparingLong(Turno::getIdentificadorProgresivo))
                .toList();
        System.out.println("Listado de turnos por fecha:" + fechaBuscada + " y estado: " + estado);
        listaFiltrada.forEach(System.out::println);
        return listaFiltrada;
    }

    // METODO para actualizar el estado del turno
    public void actualizarEstadoTurno(Long id, String nuevoEstado) {
        Turno turno = cp.buscarTurno(id);
        if (turno != null) {
            if ("En espera".equalsIgnoreCase(nuevoEstado) || "Ya atendido".equalsIgnoreCase(nuevoEstado)) {
                turno.setEstado(nuevoEstado);
                cp.actualizarTurno(turno);
                System.out.println("El estado del turno ha cambiado a " + nuevoEstado);
            } else {
                System.out.println("Error. Solo se permiten: en espera o ya atendido");
            }
        } else {
            System.out.println("No se encontró el turno con el ID: " + id);
        }
    }
}