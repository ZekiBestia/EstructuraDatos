package fes.aragon.problemas;


import fes.aragon.utilerias.dinamicas.cola.Cola;
import fes.aragon.utilerias.dinamicas.pila.Pila;
public class Convertir {
	public static String expresion = null;
		Pila<Character> pila = new Pila<>();
		Cola<Character> cola = new Cola<>();

		public  String toPosfijo(String infijo) throws Exception {
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
		
			public String EvaluarP(String infijo) throws Exception {
				String posfija = toPosfijo(infijo);			
			return posfija;
				
		}
			
			
	
}
