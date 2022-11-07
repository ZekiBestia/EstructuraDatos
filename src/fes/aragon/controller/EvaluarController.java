package fes.aragon.controller;

import fes.aragon.problemas.Evaluador;
import fes.aragon.modelos.Modelos;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class EvaluarController extends BaseController {

	@FXML
	private Button btnEvaluar;
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
	private TextArea txtposfija;

	@FXML
	void evaluar(ActionEvent event) throws Exception {
		String vacio = "";
		Evaluador evaluar = new Evaluador();
		Modelos ev = new Modelos();
		ev.setConvertir(this.txtExpresion.getText());
		if(this.txtExpresion.getText().equals(vacio)) {
			this.mensaje("ERROR","Sin contenido", "Por favor llenar la caja de texto con datos correctos");
		}else {
			String pos = evaluar.toPosfijo(ev.getConvertir());
			ev.setEvaluar(this.txtExpresion.getText());
			evaluar.Evaluar(ev.getEvaluar());
			int ie = evaluar.Evaluar(ev.getEvaluar());
			this.txtposfija.setText(pos);
			this.txtResultado.setText(ie + "");
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

	@FXML
	void limpiar(ActionEvent event) {
		this.txtExpresion.setText("");
		this.txtResultado.setText("");
		this.txtposfija.setText("");
	}

}
