package fes.aragon.controller;

import fes.aragon.modelos.Modelos;
import fes.aragon.problemas.Convertir;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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

		Convertir co = new Convertir();
		Modelos c = new Modelos();
		c.setConvertir(this.txtExpresion.getText());
		String pos = co.toPosfijo(c.getConvertir());
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
