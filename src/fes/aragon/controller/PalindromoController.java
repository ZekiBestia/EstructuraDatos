package fes.aragon.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import fes.aragon.modelos.Modelos;
import fes.aragon.problemas.Palindromo;

public class PalindromoController extends BaseController {

	@FXML
	private Button btnMenu;

	@FXML
	private Button btnProbar;

	@FXML
	private Button btnSalir;
	@FXML
	private TextArea txtExpresion;

	@FXML
	private TextArea txtResultado;
	@FXML
	private Button btnLimpiar;

	@FXML
	void menu(ActionEvent event) {
		nuevaVentana("Inicio");
	}

	@FXML
	void probar(ActionEvent event) {
		Palindromo p = new Palindromo();
		Modelos m = new Modelos();
		m.setPalindromo(this.txtExpresion.getText());
		String pali = p.palindromo(m.getPalindromo());
		String vacio = "";
		if (this.txtExpresion.getText().equals(vacio)) {

			this.mensaje("ERROR", "Sin contenido", "Por favor llenar la caja de texto con datos correctos");
			
		} else {

			this.txtResultado.setText(pali);
		}

	}

	@FXML
	void salir(ActionEvent event) {
		Platform.exit();
	}
	@FXML
	void limpiar(ActionEvent event) {
		this.txtExpresion.setText("");
		this.txtResultado.setText(null);
		
	}


}
