package com.cibertec.test;

import com.cibertec.dao.EmpleadoDAO;
import com.cibertec.dao.impl.EmpleadoDaoImpl;

public class ListarEmpleadoTest {

	public static void main(String[] args) {
		
		EmpleadoDAO dao= new EmpleadoDaoImpl();
		dao.listarEmpleado().stream().forEach(System.out::println);

	}

}