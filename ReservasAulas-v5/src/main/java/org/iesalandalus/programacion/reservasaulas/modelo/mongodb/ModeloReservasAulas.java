package org.iesalandalus.programacion.reservasaulas.modelo.mongodb;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.mongodb.dao.Aulas;
import org.iesalandalus.programacion.reservasaulas.modelo.mongodb.dao.Profesores;
import org.iesalandalus.programacion.reservasaulas.modelo.mongodb.dao.Reservas;
import org.iesalandalus.programacion.reservasaulas.modelo.mongodb.utilidades.MongoDB;

public class ModeloReservasAulas implements IModeloReservasAulas {

	private Reservas reservas;
	private Aulas aulas;
	private Profesores profesores;

	/* Constructores */
	public ModeloReservasAulas() {
		reservas = new Reservas();
		aulas = new Aulas();
		profesores = new Profesores();
	}

	/* Metodos para Aulas */
	@Override
	public List<Aula> getAulas() {
		return aulas.getAulas();
	}

	@Override
	public int getNumAulas() {
		return aulas.getNumAulas();
	}

	@Override
	public List<String> representarAulas() {
		return aulas.representar();
	}

	@Override
	public Aula buscarAula(Aula aula) {
		return aulas.buscar(aula);
	}

	@Override
	public void instertarAula(Aula aula) throws OperationNotSupportedException {
		aulas.insertar(aula);
	}

	@Override
	public void borrarAula(Aula aula) throws OperationNotSupportedException {
		aulas.borrar(aula);
	}

	/* Metodos para Profesores */
	@Override
	public List<Profesor> getProfesores() {
		return profesores.getProfesores();
	}

	@Override
	public int getNumProfesores() {
		return profesores.getNumProfesores();
	}

	@Override
	public List<String> representarProfesores() {
		return profesores.representar();
	}

	@Override
	public Profesor buscarProfesor(Profesor profesor) {
		return profesores.buscar(profesor);
	}

	@Override
	public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException {
		profesores.insertar(profesor);
	}

	@Override
	public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException {
		profesores.borrar(profesor);
	}

	/* Metodos para Reservas */
	@Override
	public List<Reserva> getReservas() {
		return reservas.getReservas();
	}

	@Override
	public int getNumReservas() {
		return reservas.getNumReservas();
	}

	@Override
	public List<String> representarReservas() {
		return reservas.representar();
	}

	@Override
	public Reserva buscarReserva(Reserva reserva) {
		return reservas.buscar(reserva);
	}

	@Override
	public void realizarReserva(Reserva reserva) throws OperationNotSupportedException {
		reservas.insertar(reserva);
	}

	@Override
	public void anularReserva(Reserva reserva) throws OperationNotSupportedException {
		reservas.borrar(reserva);
	}

	@Override
	public List<Reserva> getReservasAula(Aula aula) {
		return reservas.getReservasAula(aula);
	}

	@Override
	public List<Reserva> getReservasProfesor(Profesor profesor) {
		return reservas.getReservasProfesor(profesor);
	}

	@Override
	public List<Reserva> getReservasPermanencia(Permanencia permanencia) {
		return reservas.getReservasPermanencia(permanencia);
	}

	@Override
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		return reservas.consultarDisponibilidad(aula, permanencia);
	}

	@Override
	public void comenzar() {
		MongoDB.establecerConexion();
	}

	@Override
	public void terminar() {
		MongoDB.cerrarCliente();
	}


}
