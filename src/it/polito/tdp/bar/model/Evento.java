package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;

public class Evento implements Comparable<Evento>{

	private LocalTime time;
	private int num_persone;
	private Duration durata;
	private float tolleranza;
	
	
	public Evento(LocalTime time, int num_persone, Duration durata, float tolleranza) {
		super();
		this.time = time;
		this.num_persone = num_persone;
		this.durata = durata;
		this.tolleranza = tolleranza;
	}


	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}


	public int getNum_persone() {
		return num_persone;
	}


	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}


	public Duration getDurata() {
		return durata;
	}


	public void setDurata(Duration durata) {
		this.durata = durata;
	}


	public float getTolleranza() {
		return tolleranza;
	}


	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}


	@Override
	public String toString() {
		return time+" "+num_persone+" "+durata.toMinutes()+" "+tolleranza+"\n";
	}


	@Override
	public int compareTo(Evento o) {
		
		return this.time.compareTo(o.time);
	}
	

}
