package main.app_gestion_turnos;

import main.app_gestion_turnos.persistencia.ControladorPersistencia;
import main.app_gestion_turnos.entities.Ciudadano;
import main.app_gestion_turnos.entities.Turno;

import java.time.LocalDate;

public class Clintes_De_Prueba {
    public static void main(String[] args) {
        ControladorPersistencia controlPersis = null;
        try {

            // Hibernate intentará actualizar la BD
            controlPersis = new ControladorPersistencia();

            // 1. Crear e insertar un Ciudadano
            Ciudadano ciudadano1 = new Ciudadano(null, "12345678A", "Laura", "Martínez", null);
            controlPersis.crearCiudadano(ciudadano1);

            Ciudadano ciudadano2 = new Ciudadano(null, "87654321B", "Pedro", "Gómez", null);
            controlPersis.crearCiudadano(ciudadano2);

            // 2. Crear e insertar Turnos asociados a los ciudadanos

            Turno turno1 = new Turno(null, "TUR001", LocalDate.now(), "En espera", ciudadano1);
            Turno turno2 = new Turno(null, "TUR002", LocalDate.now().plusDays(1), "En espera", ciudadano2);
            Turno turno3 = new Turno(null, "TUR003", LocalDate.now().plusDays(2), "Ya atendido", ciudadano1);

            controlPersis.crearTurno(turno1);
            controlPersis.crearTurno(turno2);
            controlPersis.crearTurno(turno3);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Proceso de prueba finalizado. Si no hubo errores, las tablas deberían estar en 'gestionturno'.");
        }
    }
}



