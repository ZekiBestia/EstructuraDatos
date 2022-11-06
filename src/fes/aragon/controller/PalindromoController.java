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
    void menu(ActionEvent event) {
    	nuevaVentana("Inicio");
    }

    @FXML
    void probar(ActionEvent event) {
    	Palindromo p = new Palindromo();
    	Modelos m = new Modelos();
    	m.setPalindromo(this.txtExpresion.getText());
    	String pali = p.palindromo(m.getPalindromo());
    	this.txtResultado.setText(pali);
    }

    @FXML
    void salir(ActionEvent event) {
    	Platform.exit();
    }

}
