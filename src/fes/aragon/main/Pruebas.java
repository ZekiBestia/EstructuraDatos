package fes.aragon.main;

import fes.aragon.modelos.Modelos;

public class Pruebas {

	public static void main(String[] args) {
		Modelos c = new Modelos();
		String conv = "hola";
		c.setConvertir("SI");
		System.out.println(c.getConvertir());

	}

}
