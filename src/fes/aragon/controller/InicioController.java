package fes.aragon.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController extends BaseController {

	@FXML
	private Button btnConversion;

	@FXML
	private Button btnDocumentacion;

	@FXML
	private Button btnEncriptarP;

	@FXML
	private Button btnEvaluarP;

	@FXML
	private Button btnGithub;

	@FXML
	private Button btnPalindromoP;
	@FXML
	private Button btnSalir;


	@FXML
	void abriConversion(ActionEvent event) {
		nuevaVentana("Convertir");
	}

	@FXML
	void abrirEncriptar(ActionEvent event) {
		this.nuevaVentana("Encriptar");
	}

	@FXML
	void abrirEvaluar(ActionEvent event) {
		nuevaVentana("Evaluar");
	}

	@FXML
	void abrirPalindromo(ActionEvent event) {
		nuevaVentana("Palindromo");
	}

	@FXML
	void documentacion(ActionEvent event) {
		enlace("https://www.youtube.com/");
	}
	  @FXML
	    void salir(ActionEvent event) {
		  Platform.exit();
	    }

	@FXML
	void github(ActionEvent event) throws IOException, URISyntaxException {
		enlace("https://github.com/ZekiBestia/EstructuraDatos");
	}

}
