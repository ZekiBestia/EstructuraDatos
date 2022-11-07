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
	    private Button btnLimpiar;
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
		String vacio = "";
		if (this.txtExpresion.getText().equals(vacio)) {
			this.mensaje("ERROR","Sin contenido", "Por favor llenar la caja de texto con datos correctos");
		} else {
			String pos = co.toPosfijo(c.getConvertir());
			this.txtResultado.setText(pos);
		}

	}
	@FXML
    void limpiar(ActionEvent event) {
		this.txtExpresion.setText("");
		this.txtResultado.setText(null);
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
