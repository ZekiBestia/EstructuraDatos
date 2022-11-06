package fes.aragon.problemas;

import java.util.ArrayList;
import java.util.StringTokenizer;

import fes.aragon.utilerias.dinamicas.cola.Cola;
import fes.aragon.utilerias.dinamicas.pila.Pila;

public class Evaluador {

	Pila<Character> pila = new Pila<>();
	Cola<Character> cola = new Cola<>();

	public String toPosfijo(String infijo) throws Exception {
		String salida = "";
		char[] cadena = infijo.toCharArray();

		for (int c = 0; c < cadena.length; c++) {
			char caracter = cadena[c];
			if (caracter == '(') {
				pila.insertar(caracter);
			} else if (caracter == ')') {
				while (true) {
					if (pila.estaVacia()) {

						System.out.println("Pila vacia");

						return null;
					}
					char temp = pila.extraer().charValue();
					if (temp == '(') {
						break;
					} else {
						salida += " " + temp;
					}
				}
			} else if (Character.isDigit(caracter)) {
				salida += " " + caracter;
				c++;
				busqueda: for (; c < cadena.length; c++) {
					if (Character.isDigit(cadena[c])) {
						salida += cadena[c];
					} else {
						c--;
						break busqueda;
					}
				}
			} else if (caracter == '+' || caracter == '-' || caracter == '/' || caracter == '*' || caracter == '^') {
				if (pila.estaVacia()) {
					pila.insertar(caracter);
				} else {
					while (true) {
						if (esDeMayorPresedencia(caracter)) {
							pila.insertar(caracter);
							break;
						} else {
							salida += " " + pila.extraer();
						}
					}
				}
			} else {

				System.out.println("Error caracter invalido");
				return null;
			}
		}
		if (!pila.estaVacia()) {
			do {
				char temp = pila.extraer().charValue();
				salida += " " + temp;
			} while (!pila.estaVacia());
		}

		return salida;
	}

	public boolean esDeMayorPresedencia(char caracter) throws Exception {
		if (pila.estaVacia()) {
			return true;
		}
		if (caracter == pila.elementoSuperior().charValue()) {
			return false;
		}
		if (caracter == '^') {
			return true;
		}
		if ((caracter == '*' && pila.elementoSuperior().charValue() == '/')
				|| (caracter == '/' && pila.elementoSuperior().charValue() == '*')) {
			return false;
		}
		if ((caracter == '+' && pila.elementoSuperior().charValue() == '-')
				|| (caracter == '-' && pila.elementoSuperior().charValue() == '+')) {
			return false;
		} else if (caracter == '-' || caracter == '+') {
			char temp = pila.elementoSuperior().charValue();
			if (temp == '*' || temp == '/') {
				return false;
			}
		}
		return true;
	}

	public int Evaluar(String infijo) throws Exception {
		String posfija = toPosfijo(infijo);
		int operacion = evaluarPosfijo(posfija);
		return operacion;

	}

	public int evaluarPosfijo(String posfijo) {
		ArrayList<String> token = new ArrayList<String>();

		StringTokenizer st = new StringTokenizer(posfijo, " ");
		while (st.hasMoreTokens()) {
			token.add(st.nextToken());
		}

		if (token.size() == 1) {
			//return Integer.parseInt(token.get(0));
		}
		int c = 0;
//		System.out.println(token.toString() + "\n");
		while (token.size() != 1) {

			String operador = token.get(c);
			if (operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/")
					|| operador.equals("^")) {
				String operando1 = token.get(c - 1);
				String operando2 = token.get(c - 2);

				token.remove(c);
				token.remove(c - 1);
				token.remove(c - 2);
				if (operador.equals("+")) {
					try {
						String suma = (Integer.parseInt(operando2) + Integer.parseInt(operando1)) + "";
						token.add(c - 2, suma);
						c = 0;
					} catch (Exception e) {
						System.out.println("Error al comvertir un operando\n" + e);
						return 0;
					}
				} else if (operador.equals("-")) {
					try {
						String resta = (Integer.parseInt(operando2) - Integer.parseInt(operando1)) + "";
						token.add(c - 2, resta);
						c = 0;
					} catch (Exception e) {
						System.out.println("Error al comvertir un operando\n" + e);
						return 0;
					}
				} else if (operador.equals("*")) {
					try {
						String multiplicacion = (Integer.parseInt(operando2) * Integer.parseInt(operando1)) + "";
						token.add(c - 2, multiplicacion);
						c = 0;
					} catch (Exception e) {
						System.out.println("Error al comvertir un operando\n" + e);
						return 0;
					}
				} else if (operador.equals("/")) {
					try {
						String divicion = (Integer.parseInt(operando2) / Integer.parseInt(operando1)) + "";
						token.add(c - 2, divicion);
						c = 0;
					} catch (Exception e) {
						System.out.println("Error al comvertir un operando\n" + e);
						return 0;
					}
				} else {
					try {
						String potencia = (Integer.parseInt(operando2) ^ Integer.parseInt(operando1)) + "";
						token.add(c - 2, potencia);
						c = 0;
					} catch (Exception e) {
						System.out.println("Error al comvertir un operando\n" + e);
						return 0;
					}
				}
				
			} else {
				c++;
			}
		}

		try {
			/*
			 * 
			 * Retorna el resultado
			 */
			return Integer.parseInt(token.get(0));
		} catch (Exception e) {
			System.out.println("Error al parsear el resultado\n" + e);
			return 0;

		}

	}

	@SuppressWarnings("unused")
	private static int prioridadEnExpresion(char operador) {
		if (operador == '^') {
			return 4;
		}
		if (operador == '*' || operador == '/') {
			return 2;
		}
		if (operador == '+' || operador == '-') {
			return 1;
		}
		if (operador == '(') {
			return 5;
		}
		return 0;
	}

	@SuppressWarnings("unused")
	private static int prioridadEnPila(char operador) {
		if (operador == '^') {
			return 3;
		}
		if (operador == '*' || operador == '/') {
			return 1;
		}
		if (operador == '+' || operador == '-') {
			return 2;
		}
		if (operador == '(') {
			return 0;
		}
		return 0;
	}

}
