package fes.aragon.pruebas;

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
//				
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
				} else {//Evalua su prioridad o jerarquia con la prioridad en la pila
                    int pe = prioridadEnExpresion(caracter);
                    int pp = prioridadEnPila((char)pila.elementoSuperior());
					while (true) {
						if (pe > pp) {
							pila.insertar(caracter);
							break;
						} else {
							salida +=   pila.extraer();
							//
							pila.insertar(caracter);
						}
					}
				}
			} else {
				System.out.println("Caracter no valido");
			}
		} // fin del for
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
		posfija = posfija.replaceAll("[()]", "");

		System.out.println("La expresion postfija es: ");
		System.out.println(" " + posfija + " ");

		// Evaluamos transformamos la exprecion a posfijo

		int operacion = evaluarPosfijo(posfija);
		// campoResultado.setText(operacion+"");
		System.out.println("La evaluación es: " + operacion + "");
		return operacion;

	}

	/*
	 * EVALUAR EXPRESION POSTIJA
	 * 
	 * 
	 */

	public int evaluarPosfijo(String posfijo) {
		ArrayList<String> token = new ArrayList<String>();

		StringTokenizer st = new StringTokenizer(posfijo, " ");
		while (st.hasMoreTokens()) {
			token.add(st.nextToken());
		}

		if (token.size() == 1) {
			return Integer.parseInt(token.get(0));
		}
		int c = 0;
		System.out.println(token.toString()+"\n");
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
						System.out.println("Error al comvertir un operando\n"+e);
						return 0;
					}
				} else if (operador.equals("-")) {
					try {
						String resta = (Integer.parseInt(operando2) - Integer.parseInt(operando1)) + "";
						token.add(c - 2, resta);
						c = 0;
					} catch (Exception e) {
						System.out.println("Error al comvertir un operando\n"+e);
						return 0;
					}
				} else if (operador.equals("*")) {
					try {
						String multiplicacion = (Integer.parseInt(operando2) * Integer.parseInt(operando1)) + "";
						token.add(c - 2, multiplicacion);
						c = 0;
					} catch (Exception e) {
						System.out.println("Error al comvertir un operando\n"+e);
						return 0;
					}
				} else if (operador.equals("/")) {
					try {
						String divicion = (Integer.parseInt(operando2) / Integer.parseInt(operando1)) + "";
						token.add(c - 2, divicion);
						c = 0;
					} catch (Exception e) {
						System.out.println("Error al comvertir un operando\n"+e);
						return 0;
					}
				} else {
					try {
						String potencia = (Integer.parseInt(operando2) ^ Integer.parseInt(operando1)) + "";
						token.add(c - 2, potencia);
						c = 0;
					} catch (Exception e) {
						System.out.println("Error al comvertir un operando\n"+e);
						return 0;
					}
				}
				// areaTexto.append(token.toString()+"\n");
				System.out.println(token.toString()+"\n");
			} else {
				c++;
			}
		}

		try {
			return Integer.parseInt(token.get(0));
		} catch (Exception e) {
			System.out.println("Error al parsear el resultado\n"+e);
			return 0;
			
		}

	}
	
	
	
	
	/// siisisis
	
	  //Metodo para evaluar la jerarquia de operaciones de la expresion
    private static int prioridadEnExpresion (char operador)
    {
         if (operador == '^') 
         {
             return 4;
         }
         if (operador == '*' || operador == '/') 
         {
             return 2;
         }
         if (operador == '+' || operador == '-') 
         {
             return 1;
         }
         if (operador == '(' ) 
         {
             return 5;
         }
         return 0;
    }
    
    //Metodo para evaluar la jerarquia de operaciones en la pila
    private static int prioridadEnPila (char operador)
    {
         if (operador == '^') 
         {
             return 3;
         }
         if (operador == '*' || operador == '/') 
         {
             return 1;
         }
         if (operador == '+' || operador == '-') 
         {
             return 2;
         }
         if (operador == '(' ) 
         {
             return 0;
         }
         return 0;
    }

}



