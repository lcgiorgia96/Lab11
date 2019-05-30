package it.polito.tdp.bar;

import java.net.URL;

import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Model;
import it.polito.tdp.bar.model.Simulatore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {
	Model model;
	Simulatore sim;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSimula;

    @FXML
    private TextArea txtResult;

    @FXML
    void t(ActionEvent event) {
    	txtResult.clear();
    	sim= this.model.getSimulatore();
    	sim.init();
    	sim.run();
    	txtResult.appendText("N tot clienti: "+sim.getNumero_totale_clienti()+"\nN clienti soddisfatti: "+sim.getNumero_clienti_soddisfatti()+"\nN clienti insoddisfatti: "+sim.getNumero_clienti_insoddisfatti());
    }

    @FXML
    void initialize() {
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }

	public void setModel(Model model) {
	this.model=model;
	sim= new Simulatore();
	}
}

