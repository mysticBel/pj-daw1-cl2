package com.cibertec.test;

import com.cibertec.dao.EmpleadoDAO;
import com.cibertec.dao.impl.EmpleadoDaoImpl;
import com.cibertec.model.Empleado;

public class RegistroEmpleadoTest {

	public static void main(String[] args) {
		EmpleadoDAO dao= new EmpleadoDaoImpl();
		Empleado empleado = new Empleado("Maribel", "Maza Auccatinco", "77044852");
		String mensaje = dao.registrarEmpleado(empleado);
		System.out.println(mensaje);

	}

}
