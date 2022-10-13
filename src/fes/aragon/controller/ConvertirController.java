package fes.aragon.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ConvertirController extends BaseController{

    @FXML
    private Button btnConvertir;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnSalir;

    @FXML
    void convertir(ActionEvent event) {

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
