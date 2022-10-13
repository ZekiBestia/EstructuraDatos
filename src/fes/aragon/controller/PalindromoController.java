package fes.aragon.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PalindromoController extends BaseController {

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnProbar;

    @FXML
    private Button btnSalir;

    @FXML
    void menu(ActionEvent event) {
    	nuevaVentana("Inicio");
    }

    @FXML
    void probar(ActionEvent event) {

    }

    @FXML
    void salir(ActionEvent event) {
    	Platform.exit();
    }

}
