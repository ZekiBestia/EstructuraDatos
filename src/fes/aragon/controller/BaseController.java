package fes.aragon.controller;

import java.awt.Desktop;
import java.io.IOException;
//import java.lang.System.Logger;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

import fes.aragon.utilerias.dinamicas.cola.Cola;
import fes.aragon.utilerias.dinamicas.pila.Pila;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BaseController {



	public void goToURL() {
		if (java.awt.Desktop.isDesktopSupported()) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
				try {
					java.net.URI uri = new java.net.URI("https://www.youtube.com/");
					desktop.browse(uri);
				} catch (URISyntaxException | IOException ex) {
					// Logger.getLogger(Acerca.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}

	}

	public void nuevaVentana(String archivo) {
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/" + archivo + ".fxml"));
			Scene scene = new Scene(root);
			Stage escenario = new Stage();
			escenario.setScene(scene);
			escenario.initStyle(StageStyle.UNDECORATED);
			escenario.initModality(Modality.APPLICATION_MODAL);
			escenario.show();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void enlace() {
		Desktop enlace = Desktop.getDesktop();
		try {
			enlace.browse(new URI("https://www.youtube.com/"));
		} catch (IOException | URISyntaxException e) {
			// JOptionPane.showInputDialog(this, e.getMessage(), "error",
			// JOptionPane.ERROR_MESSAGE);
		}

	}
	
		
}
