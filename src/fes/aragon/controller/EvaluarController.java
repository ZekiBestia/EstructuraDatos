package fes.aragon.controller;

import fes.aragon.pruebas.Evaluador;
import fes.aragon.modelos.Modelos;
import fes.aragon.posfijo.Ejemplo;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class EvaluarController extends BaseController {

	@FXML
	private Button btnEvaluar;

	@FXML
	private Button btnMenu;

	@FXML
	private Button btnSalir;
	@FXML
	private TextArea txtExpresion;

	@FXML
	private TextArea txtResultado;

	@FXML
	void evaluar(ActionEvent event) throws Exception {
		Evaluador evaluar = new Evaluador();
		Modelos ev = new Modelos();
		ev.setEvaluar(this.txtExpresion.getText());
		System.out.println(ev.getEvaluar());
	    evaluar.Evaluar(ev.getEvaluar());
		System.out.println(ev.getEvaluar());
		int ie = evaluar.Evaluar(ev.getEvaluar());
		this.txtResultado.setText(ie+"");
		// String p1 = Integer.parseInt(pos);
		// this.txtResultado.setText(p1);
		// ev.setEvaluar(this.txtExpresion.getText());
//    	evaluar.Evaluar(ev.getEvaluar());
//    	System.out.println(ev.getEvaluar());

	}
//    int operacion = evaluarPosfijo(posfija);
//	// campoResultado.setText(operacion+"");
//	System.out.println("La evaluación es: " + operacion + "");
//    

	@FXML
	void menu(ActionEvent event) {
		nuevaVentana("Inicio");
	}

	@FXML
	void salir(ActionEvent event) {
		Platform.exit();
	}

}
