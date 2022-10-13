package fes.aragon.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EvaluarController extends BaseController {

    @FXML
    private Button btnEvaluar;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnSalir;

    @FXML
    void evaluar(ActionEvent event) {

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
