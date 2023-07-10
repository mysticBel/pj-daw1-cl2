package com.cibertec.test;

import com.cibertec.dao.EmpleadoDAO;
import com.cibertec.dao.impl.EmpleadoDaoImpl;

public class EliminarEmpleadoTest {

	public static void main(String[] args) {
		EmpleadoDAO dao = new EmpleadoDaoImpl();
		String mensaje = dao.eliminarEmpleado(2);
		System.out.println(mensaje);


	}

}