package it.polito.tdp.bar.model;

public class TestModel {

	public static void main(String[] args) {
		
		Simulatore sim= new Simulatore();
		for (int E=0; E<2000;E++) {
			sim.init();
			
			
			
			
		}
sim.run();
System.out.println("TOT CLIENTI: "+sim.getNumero_totale_clienti()+"\n Numero clienti soddisfatti: "+sim.getNumero_clienti_soddisfatti()+"\nNumero clienti insoddisfatti: "+sim.getNumero_clienti_insoddisfatti());
	}

}
