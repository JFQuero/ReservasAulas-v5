package org.iesalandalus.programacion.reservasaulas.modelo.mongodb.dao;


import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.mongodb.utilidades.MongoDB;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;


public class Profesores {

	private static final String COLECCION = "profesores";
	private MongoCollection<Document> coleccionProfesores;

	/* Constructores */
	public Profesores() {
		coleccionProfesores = MongoDB.getBD().getCollection(COLECCION);
	}

	/* Metodos */
	public List<Profesor> getProfesores() {
		List<Profesor> profesores = new ArrayList<>();
		for (Document documentoProfesor : coleccionProfesores.find()) {
			profesores.add(MongoDB.obtenerProfesorDesdeDocumento(documentoProfesor));
		}
		return profesores;
	}

	public int getNumProfesores() {
		return (int)coleccionProfesores.countDocuments();
	}

	public void insertar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor == null) {
			throw new IllegalArgumentException("No se puede insertar un profesor nulo.");
		}
		if (buscar(profesor) != null) {
			throw new OperationNotSupportedException("El profesor ya existe.");
		} else {
			coleccionProfesores.insertOne(MongoDB.obtenerDocumentoDesdeProfesor(profesor));
		}
	}

	public Profesor buscar(Profesor profesor) {
		Document documentoProfesor = coleccionProfesores.find().filter(eq(MongoDB.NOMBRE, profesor.getNombre())).first();
		return MongoDB.obtenerProfesorDesdeDocumento(documentoProfesor);
	}

	public void borrar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor == null) {
			throw new IllegalArgumentException("No se puede borrar un profesor nulo.");
		}
		if (buscar(profesor) != null) {
			coleccionProfesores.deleteOne(eq(MongoDB.NOMBRE, profesor.getNombre()));
		} else {
			throw new OperationNotSupportedException("El profesor a borrar no existe.");
		}
	}

	public List<String> representar() {
		List<String> representacion = new ArrayList<>();
		for (Profesor profesor : getProfesores()) {
			representacion.add(profesor.toString());
		}
		return representacion;
	}

}
