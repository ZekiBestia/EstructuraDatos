package fes.aragon.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class EncriptarController extends BaseController{

    @FXML
    private Button btnConvertir;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnSalir;

    @FXML
    private TextArea txtMensaje;

    @FXML
    private TextArea txtResultado;

    @FXML
    void convertir(ActionEvent event) {

    }

    @FXML
    void menu(ActionEvent event) {
    	this.nuevaVentana("Inicio");
    }

    @FXML
    void salir(ActionEvent event) {
    	Platform.exit();
    }

}