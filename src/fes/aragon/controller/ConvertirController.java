package fes.aragon.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import fes.aragon.modelos.Modelos;
import fes.aragon.posfijo.Ejemplo;

public class ConvertirController extends BaseController {

	@FXML
	private Button btnConvertir;

	@FXML
	private Button btnMenu;

	@FXML
	private Button btnSalir;
	@FXML
	private TextArea txtExpresion;

	@FXML
	private TextArea txtResultado;

	@FXML
	void convertir(ActionEvent event) throws Exception {

		Ejemplo eje = new Ejemplo();
		Modelos c = new Modelos();
		c.setConvertir(this.txtExpresion.getText());
		String pos = eje.toPosfijo(c.getConvertir());
		if (this.txtExpresion.getText() == null) {
			System.out.println("Error");
		} else {

			this.txtResultado.setText(pos);
		}

	}

	@FXML
	void menu(ActionEvent event) {
		nuevaVentana("Inicio");
	}

	@FXML
	void salir(ActionEvent event) {
		Platform.exit();
	}

}
