package com.cibertec.test;

import com.cibertec.dao.EmpleadoDAO;
import com.cibertec.dao.impl.EmpleadoDaoImpl;
import com.cibertec.model.Empleado;

public class ActualizarEmpleadoTest {

	public static void main(String[] args) {
		EmpleadoDAO dao= new EmpleadoDaoImpl();
		Empleado empModif = new Empleado(2,"Luisa","Rojas Diaz", "77284695");
		String mensaje = dao.actualizarEmpleado(empModif);
		System.out.println(mensaje);

	}

}