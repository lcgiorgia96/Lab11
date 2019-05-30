package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeMap;

import it.polito.tdp.bar.model.Evento;
import it.polito.tdp.bar.model.Evento.TipoEvento;
//import it.polito.tdp.noleggio.model.Evento.TipoEvento;

public class Simulatore {
	private PriorityQueue<Evento> queue;
	
	//STATO DEL MONDO
	private List<Tavolo> tavoli = new ArrayList<Tavolo>();
	
	//PARAMETRI DI SIMULAZIONE
	
	// valori che cambiano e in vase alle quali cambia la simulazione
	
	private LocalTime oraInizio = LocalTime.of(8, 0);
	private LocalTime oraFine = LocalTime.of(20, 0);
	private Duration intervalloArrivoCliente;
	private List<Duration> intCliente = new ArrayList<Duration>();
	private int numP;
	private List<Integer> NUMP = new ArrayList<Integer>();
	private Duration durata;
	private List<Duration> dur = new ArrayList<Duration>();
	private float tolleranza;
	private List<Float> toll= new ArrayList<Float>();
	
	
	
	//STATISTICHE-->VALORI IN OUTPUT
	
	private int numero_totale_clienti;
	private int numero_clienti_soddisfatti;
	private int numero_clienti_insoddisfatti;
	
	
	//VARIABILI INTERNE
	
	Random rand= new Random();

	private LocalTime ultimaOra;
	
	public Simulatore () {
		for (int i=1; i<=10; i++) {
			intCliente.add(Duration.ofMinutes(i));
		}
		
		for (int j=1; j<=10; j++) {
			NUMP.add(j);
		}
		
		for (int k=60; k<=120; k++) {
			dur.add(Duration.ofMinutes(k));
		}
		
		for (float m= (float)0.0; m<=0.9; m+=0.1 ) {
			toll.add(m);
		}
		
		tavoli.add(new Tavolo(10,false,null,null));
		tavoli.add(new Tavolo(10,false,null,null));
		
		tavoli.add(new Tavolo(8,false,null,null));
		tavoli.add(new Tavolo(8,false,null,null));
		tavoli.add(new Tavolo(8,false,null,null));
		tavoli.add(new Tavolo(8,false,null,null));

		tavoli.add(new Tavolo(6,false,null,null));
		tavoli.add(new Tavolo(6,false,null,null));
		tavoli.add(new Tavolo(6,false,null,null));
		tavoli.add(new Tavolo(6,false,null,null));

		tavoli.add(new Tavolo(4,false,null,null));
		tavoli.add(new Tavolo(4,false,null,null));
		tavoli.add(new Tavolo(4,false,null,null));
		tavoli.add(new Tavolo(4,false,null,null));
		tavoli.add(new Tavolo(4,false,null,null));
		
		Collections.sort(tavoli);
		
		

	}
	
	public void init() {
		
		queue= new PriorityQueue<Evento>();
		this.numero_clienti_insoddisfatti=0;
		this.numero_clienti_soddisfatti=0;
		this.numero_totale_clienti=0;
		LocalTime ora= null;
		ultimaOra = LocalTime.MIN;
		

		for (int E=0; E<2000; E++) {
		int inte= rand.nextInt(intCliente.size());
		intervalloArrivoCliente = intCliente.get(inte);
			int n= rand.nextInt(NUMP.size());
			numP= NUMP.get(n);
			int d= rand.nextInt(dur.size());
			durata = dur.get(d);
			int t= rand.nextInt(toll.size());
			tolleranza = toll.get(t);
			ora = ultimaOra.plusMinutes(intervalloArrivoCliente.toMinutes());
			ultimaOra=ora;
			queue.add(new Evento(ora,numP,durata,tolleranza,TipoEvento.ARRIVO_GRUPPO_CLIENTI));
}
	}
	
	public void run() {
		
		while (!queue.isEmpty()) {
			Evento ev = queue.poll();
			System.out.println(ev) ;
			switch(ev.getTipo()) {
			
			case ARRIVO_GRUPPO_CLIENTI :
				
				int clienti = ev.getNum_persone();
				Tavolo t= this.cercaTPosti(clienti);
				
				if (t!=null) {
				t.setOccupato(true);
				t.setOraArrivo(ev.getTime());
				t.setOraVia(ev.getTime().plusMinutes(ev.getDurata().toMinutes()));
				numero_totale_clienti+=clienti;
				numero_clienti_soddisfatti+=clienti;
				
				Evento e2 = new Evento (ev.getTime().plusMinutes(ev.getDurata().toMinutes()),clienti,ev.getDurata(),ev.getTolleranza(),TipoEvento.USCITA);
				queue.add(e2);
				
				System.out.println(ev.toString()+" si sono seduti al tavolo al con posti: "+t.getPosti());
				} else {
					
					if(ev.getTolleranza()>=0.5) {
					numero_totale_clienti+=clienti;
					numero_clienti_soddisfatti+=clienti;
					System.out.println(ev.toString()+" sono soddisfatti e si sono sedutial bancone");
				} else {
					numero_totale_clienti+=clienti;
					numero_clienti_insoddisfatti+=clienti;
					System.out.println(ev.toString()+" non sono soddisfatti e se ne sono andati via");
				}
				
				}
				
				break;
				
			
			case USCITA :
				
				Tavolo uscito= null;
				for (Tavolo t1: tavoli) {
					if (ev.getTime().equals(t1.getOraVia())) {
						uscito=t1;
					}
				}
				uscito.setOccupato(false);
				System.out.print("Si e' liberato un tavolo da N posti: "+uscito.getPosti()+"\n");
				break;
			}
				
		}
		System.out.println("N tot clienti: "+numero_totale_clienti+"\n"+" N clienti soddisfatti"
				+numero_clienti_soddisfatti+"\n"+" N clienti insoddisfatti: "+numero_clienti_insoddisfatti);
	}

	public int getNumero_totale_clienti() {
		return numero_totale_clienti;
	}

	public int getNumero_clienti_soddisfatti() {
		return numero_clienti_soddisfatti;
	}

	public int getNumero_clienti_insoddisfatti() {
		return numero_clienti_insoddisfatti;
	}
	
	public Tavolo cercaTPosti(int n){

		int postiTavoloMin = Integer.MAX_VALUE;
		Tavolo returnTable = null;

		// Itero su tutti i tavoli
		for (Tavolo table : tavoli) {
//table.getPosti()>= n && 
			// Controllo i requisiti minimi
			if (n>= table.getPosti()/2  &&table.getPosti()>= n  && table.getOccupato()==false) {

				// Cerco il tavolo con il minimo numero di posti a sedere.
				if (postiTavoloMin > table.getPosti()) {
					returnTable = table;
					postiTavoloMin = table.getPosti();
				}
			}
		}

		return returnTable;
	}
	
	public void aggiungiTavolo ( Tavolo t) {
		tavoli.add(t);
	}
	
	
}
