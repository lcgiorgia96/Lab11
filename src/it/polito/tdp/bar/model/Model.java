package it.polito.tdp.bar.model;

public class Model {
	Simulatore sim;
	
	public Model() {
		sim = new Simulatore();
	}
	
	public void simula() {
		
		sim.init();
		sim.run();
		
	}

}
