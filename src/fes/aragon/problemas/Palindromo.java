package fes.aragon.problemas;

import java.util.ArrayList;

import fes.aragon.utilerias.dinamicas.cola.Cola;
import fes.aragon.utilerias.dinamicas.pila.Pila;

public class Palindromo {
	public Palindromo() {
		// TODO Auto-generated constructor stub
	}
	Pila<Character> pila = new Pila<>();
	Cola<Character> cola = new Cola<>();
	ArrayList<Character> ch = new ArrayList<Character>();
	public String palindromo(String cadena) {
		int i = 0;
		while (i < cadena.length()) {
			ch.add(cadena.charAt(i));
			if (cadena.charAt(i) != ' ') {
				cola.insertar(ch.get(i));
				pila.insertar(ch.get(i));
			}
			i++;
		}
		if (isIgual(cola, pila)) {
			String P = "Es palindromo";
			return P;
		} else {
			String Pn = "No es palindromo";
			return Pn;
		}

	}

	public static boolean isIgual(Cola<Character> c, Pila<Character> p) {

		boolean igual = false;
		try {
			if ((!c.estaVacia()) && (!p.estaVacia())
					&& (c.toString(c.extraer()).compareToIgnoreCase(p.toString(p.extraer())) == 0))
				igual = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return igual;
	}

}
