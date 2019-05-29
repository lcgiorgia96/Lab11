package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeMap;

import it.polito.tdp.bar.model.Evento;
//import it.polito.tdp.noleggio.model.Evento.TipoEvento;

public class Simulatore {
	private PriorityQueue<Evento> queue;
	
	//STATO DEL MONDO
	private Map<Integer, Tavolo> tavoli = new TreeMap<Integer,Tavolo>();
	
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
		
		tavoli.put(10,new Tavolo(10,false,null,null));
		tavoli.put(10,new Tavolo(10,false,null,null));
		
		tavoli.put(8,new Tavolo(8,false,null,null));
		tavoli.put(8,new Tavolo(8,false,null,null));
		tavoli.put(8,new Tavolo(8,false,null,null));
		tavoli.put(8,new Tavolo(8,false,null,null));

		tavoli.put(6,new Tavolo(6,false,null,null));
		tavoli.put(6,new Tavolo(6,false,null,null));
		tavoli.put(6,new Tavolo(6,false,null,null));
		tavoli.put(6,new Tavolo(6,false,null,null));

		tavoli.put(4,new Tavolo(4,false,null,null));
		tavoli.put(4,new Tavolo(4,false,null,null));
		tavoli.put(4,new Tavolo(4,false,null,null));
		tavoli.put(4,new Tavolo(4,false,null,null));
		tavoli.put(4,new Tavolo(4,false,null,null));
		


	}
	
	public void init() {
		
		queue= new PriorityQueue<Evento>();
		this.numero_clienti_insoddisfatti=0;
		this.numero_clienti_soddisfatti=0;
		this.numero_totale_clienti=0;
		
		
	for (LocalTime ora= oraInizio; ora.isBefore(oraFine);ora=ora.plus(intervalloArrivoCliente)) {
		int inte= rand.nextInt(intCliente.size());
		intervalloArrivoCliente = intCliente.get(inte);
			int n= rand.nextInt(NUMP.size());
			numP= NUMP.get(n);
			int d= rand.nextInt(dur.size());
			durata = dur.get(d);
			int t= rand.nextInt(toll.size());
			tolleranza = toll.get(t);
			queue.add(new Evento(ora,numP,durata,tolleranza));
		}
}

	
	public void run() {
		
		while (!queue.isEmpty()) {
			Evento ev = queue.poll();
			System.out.println(ev) ;
		
	//LIBERO I TAVOLI?
			
			for (Tavolo t : tavoli.values()) {
				if (ev.getTime().isAfter(t.getOraVia())) {
					t.setOccupato(false);
				}
			}
		int clienti = ev.getNum_persone();
		
		for (Tavolo temp: tavoli.values()) {
			/*
			 * TROVARE IL TAVOLO CON IL MINIMO DI POSTI CHE POSSA TENERE IL NUMERO
			 * DI CLIENTI
			 * ALTRIMENTI UNO DA OCCUPARNE ALMENO IL 50%
			 * ALTRIMENTI BANCONE-->MA CONTROLLARNE LA TOLLERANZA!
			 */
		}
			
			
		// prendo il numero di clienti, devo controllare se ci sono tavoli disponibili, 
/*
* devo trovare il tavolo con il minimo numero di posti e in modo da occuparne
* il 50 % di posti
* se non ci sono tavoli dispoinibili, indirizzarli verso il bancone 
* e quindi controllare la tolleranza
* controllare i tempi di attesa, e se a quell'ora si è liberato.
* 
* CONTROLLARE QUINDI SE I TAVOLI SONO OCCUPATI, CALCOLANDO I TEMPI E L'ATTESA
* DEL CLIENTE
*/
		
		
		
		
		
		}
	}
}
