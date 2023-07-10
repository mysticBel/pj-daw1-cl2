package com.cibertec.dao.impl;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.cibertec.dao.EmpleadoDAO;
import com.cibertec.model.Empleado;


public class EmpleadoDaoImpl implements EmpleadoDAO {
	
	//agregamos variables globales para el crud y listados
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud");
	EntityManager manager =factory.createEntityManager();
	
	//mensajes
	private static final String REGISTRO_OK = "Se registro correctamente";
	private static final String REGISTRO_ERROR = "No se registro correctamente";
	
	private static final String ACTUALIZA_OK = "Se actualizo correctamente";
	private static final String ACTUALIZA_ERROR = "No se actualizo correctamente";
	
	private static final String ELIMINA_OK = "Se elimino correctamente";
	private static final String ELIMINA_ERROR = "No se elimino correctamente";

	public List<Empleado> listarEmpleado() {
		CriteriaBuilder criteriaBuilder  = manager.getCriteriaBuilder();
		CriteriaQuery<Empleado> CriteriaQuery = criteriaBuilder.createQuery(Empleado.class);
		Root<Empleado> registro = CriteriaQuery.from(Empleado.class);
		CriteriaQuery<Empleado> todos = CriteriaQuery.select(registro);
		TypedQuery<Empleado> lista = manager.createQuery(todos);
		//
		return lista.getResultList();
	}

	public Empleado buscarEmpleado(int id) {
		return manager.find(Empleado.class,id);
	}

	public String registrarEmpleado(Empleado empleado) {
		String mensaje = REGISTRO_ERROR;
		if(!Objects.isNull(empleado)) {         // if(empleado!= null)
			manager.getTransaction().begin();  // iniciamos transaccion
			manager.persist(empleado);// se inserta
			manager.getTransaction().commit(); //confirmamos registro
			//
			mensaje = REGISTRO_OK;
			manager.close();
			
		}
		return mensaje;
	}

	public String actualizarEmpleado(Empleado empleado) {
		String mensaje = ACTUALIZA_ERROR;
		Empleado emp = buscarEmpleado(empleado.getId());
		if(!Objects.isNull(emp)) {
			manager.getTransaction().begin(); //iniciamos transaccion
			//
			emp.setNombre(empleado.getNombre());
			emp.setApellidos(empleado.getApellidos());
			emp.setDni(empleado.getDni());
			//
			manager.getTransaction().commit();
			manager.close();
			//
			mensaje = ACTUALIZA_OK;
		}
		
		return mensaje;
	}

	public String eliminarEmpleado(int id) {
		String mensaje = ELIMINA_ERROR;
		Empleado emp = buscarEmpleado(id);
		if(!Objects.isNull(emp)) {
			manager.getTransaction().begin();  // iniciamos transacciom
			manager.remove(emp);
			manager.getTransaction().commit(); //confirmamos transaccion
			manager.clear();
			//
			mensaje = ELIMINA_OK;
		}	
		return mensaje;
	}
}